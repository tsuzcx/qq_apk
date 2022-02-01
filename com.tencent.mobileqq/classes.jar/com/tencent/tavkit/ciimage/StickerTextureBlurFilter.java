package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class StickerTextureBlurFilter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER_END = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  protected static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D ";
  protected static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  protected static String VERTEX_SHADER_CODE = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private String FRAGMENT_SHADER = "uTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform int uRadius;\nuniform float uWidthOffset;\nuniform float uHeightOffset;\nmediump float getGaussWeight(mediump float currentPos, mediump float sigma) {\n    return 1.0 / sigma * exp(-(currentPos * currentPos) / (2.0 * sigma * sigma));\n}\nvoid main() {\n" + getGaussianSampleCode() + "}";
  private final String TAG = "TextureFilter@" + Integer.toHexString(hashCode());
  private int aPositionHandle;
  private CGRect cropRect;
  private int[] defaultViewport = new int[4];
  private int[] fbo = new int[1];
  protected String fragmentShaderCode;
  private GLBlendStateCache glBlendStateCache;
  private int heightOffsetHandle;
  private int outputFrameBufferId = -1;
  private TextureInfo outputTextureInfo = null;
  protected int program;
  private int radius;
  private int radiusHandle;
  private int rendererHeight;
  private int rendererWidth;
  @NonNull
  private final int[] shaderIndexes = new int[2];
  private int stMatrixHandle;
  protected int[] textureID = new int[1];
  private int textureType;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  protected String vertexShaderCode;
  private int widthOffsetHandle;
  
  public StickerTextureBlurFilter()
  {
    Logger.d(this.TAG, "TextureFilter() called");
  }
  
  private void beforeDraw(TextureInfo paramTextureInfo)
  {
    GLES20.glUniform1i(this.radiusHandle, this.radius);
    GLES20.glUniform1f(this.widthOffsetHandle, 0.0F);
    GLES20.glUniform1f(this.heightOffsetHandle, 1.0F);
  }
  
  private void bindFramebuffer()
  {
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    if (this.fbo[0] == 0)
    {
      GLES20.glGenTextures(1, this.textureID, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.textureID[0]);
      GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glBindTexture(3553, 0);
      GLES20.glGenFramebuffers(1, this.fbo, 0);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureID[0], 0);
      GLES20.glClear(16384);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glClear(16384);
    GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
  }
  
  private void checkAndInitFrameBuffer(@NonNull TextureInfo paramTextureInfo)
  {
    int j = paramTextureInfo.getFrameBuffer();
    int i = j;
    if (j == -1)
    {
      GLES20.glBindTexture(3553, paramTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, paramTextureInfo.getFormat(), paramTextureInfo.width, paramTextureInfo.height, 0, paramTextureInfo.getFormat(), 5121, null);
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
      GLES20.glBindFramebuffer(36160, i);
      RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
      RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
      j = GLES20.glCheckFramebufferStatus(36160);
      if (j != 36053)
      {
        Log.e(this.TAG, "checkAndInitFrameBuffer: status = " + j, new RuntimeException("EGL error encountered: FramebufferStatus is not complete."));
        return;
      }
      GLES20.glBindFramebuffer(36160, 0);
    }
    this.outputFrameBufferId = i;
    paramTextureInfo.setFrameBuffer(i);
    this.outputTextureInfo = paramTextureInfo;
  }
  
  private void finishDraw(TextureInfo paramTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, 0);
  }
  
  private String getGaussianSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("   int diameter = 2 * uRadius + 1;  \n").append("   vec4 sampleTex;\n").append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n").append("   float weightSum = 0.0; \n").append("   for(int i = 0; i < diameter; i++) {\n").append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n").append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n").append("       float index = float(i); \n").append("       float gaussWeight = getGaussWeight(index - float(diameter - 1)/2.0,").append("           (float(diameter - 1)/2.0 + 1.0) / 2.0); \n").append("       col += sampleTex.rgb * gaussWeight; \n").append("       weightSum += gaussWeight;\n").append("   }   \n").append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  private void initShaders(String paramString1, String paramString2)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.program = Program.createProgram(paramString1, paramString2, this.shaderIndexes);
    if (this.program == 0) {
      new RuntimeException("failed creating program").printStackTrace();
    }
    do
    {
      return;
      this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
      RenderContext.checkEglError("glGetAttribLocation aPosition");
      if (this.aPositionHandle == -1)
      {
        new RuntimeException("Could not get attribute location for aPosition").printStackTrace();
        return;
      }
      this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
      RenderContext.checkEglError("glGetUniformLocation uMatrix");
      if (this.uMatrixHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uMatrix").printStackTrace();
        return;
      }
      this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
      RenderContext.checkEglError("glGetUniformLocation uAlpha");
      if (this.uAlphaHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uAlpha").printStackTrace();
        return;
      }
      this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
      RenderContext.checkEglError("glGetUniformLocation stMatrix");
      if (this.stMatrixHandle == -1)
      {
        new RuntimeException("Could not get uniform location for stMatrix").printStackTrace();
        return;
      }
      this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
      RenderContext.checkEglError("glGetUniformLocation uScreenSize");
      if (this.uScreenSizeHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uScreenSize").printStackTrace();
        return;
      }
      this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
      RenderContext.checkEglError("glGetUniformLocation uTextureSize");
    } while (this.uTextureSizeHandle != -1);
    new RuntimeException("Could not get uniform location for uTextureSize").printStackTrace();
  }
  
  private boolean isEqualsCurrentOutputTexture(@NonNull TextureInfo paramTextureInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.outputTextureInfo == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.outputTextureInfo.equals(paramTextureInfo));
      if ((this.outputTextureInfo.textureID != paramTextureInfo.textureID) || (this.outputTextureInfo.width != paramTextureInfo.width)) {
        break;
      }
      bool1 = bool2;
    } while (this.outputTextureInfo.height == paramTextureInfo.height);
    return false;
  }
  
  private void prepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, paramTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    RenderContext.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    RenderContext.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTextureInfo.width, paramTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public static float[] toOpenGL2DMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    if (paramMatrix == null)
    {
      int i = 0;
      if (i < 9)
      {
        if (i % 4 == 0) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          arrayOfFloat[i] = f;
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramMatrix.getValues(arrayOfFloat);
      swap(arrayOfFloat, 1, 3);
      swap(arrayOfFloat, 2, 6);
      swap(arrayOfFloat, 5, 7);
    }
    return arrayOfFloat;
  }
  
  private void useProgram(Matrix paramMatrix)
  {
    GLES20.glUseProgram(this.program);
    RenderContext.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix), 0);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return applyNewTexture(paramTextureInfo, paramMatrix1, paramMatrix2);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    if (paramTextureInfo == null) {
      return null;
    }
    if (this.glBlendStateCache == null) {
      this.glBlendStateCache = new GLBlendStateCache();
    }
    this.glBlendStateCache.cache();
    if (this.program == 0) {
      initShaderForTextureInfo(paramTextureInfo);
    }
    RenderContext.checkEglError("onDrawFrame start");
    if (paramCGRect == null)
    {
      paramCGRect = new CGRect(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
      float f2 = paramCGRect.origin.x + paramCGRect.size.width;
      float f1 = f2;
      if (f2 > paramTextureInfo.width)
      {
        f1 = paramTextureInfo.width;
        Logger.e(this.TAG, "applyFilter: crop right pixel exceed texture width");
      }
      float f3 = paramCGRect.origin.y + paramCGRect.size.height;
      f2 = f3;
      if (f3 > paramTextureInfo.height)
      {
        f2 = paramTextureInfo.height;
        Logger.e(this.TAG, "applyFilter: crop bottom pixel exceed texture height");
      }
      f3 = paramCGRect.origin.x;
      float f4 = paramCGRect.origin.x;
      float f5 = paramCGRect.origin.y;
      float f6 = paramCGRect.origin.y;
      this.triangleVertices.rewind();
      this.triangleVertices.put(new float[] { f3, f2, f4, f5, f1, f2, f1, f6 });
      GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
      if (this.outputFrameBufferId != -1)
      {
        GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
      }
      useProgram(paramMatrix2);
      GLES20.glUniform1i(this.radiusHandle, this.radius);
      GLES20.glUniform1f(this.widthOffsetHandle, 0.0F);
      GLES20.glUniform1f(this.heightOffsetHandle, 0.0F);
      GLES20.glUniform1f(this.uAlphaHandle, paramFloat);
      GLES20.glEnable(3042);
      if (paramTextureInfo.isMixAlpha()) {
        break label544;
      }
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(1, 771, 1, 771);
    }
    for (;;)
    {
      prepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(paramMatrix2));
      onDraw(paramTextureInfo, paramMatrix1);
      finishDraw(paramTextureInfo);
      setOutputTextureInfo(paramTextureInfo);
      if (this.outputFrameBufferId != -1)
      {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
      }
      this.glBlendStateCache.restore();
      return this.outputTextureInfo;
      this.cropRect = paramCGRect;
      this.cropRect.size.width = Math.min(paramTextureInfo.width, paramCGRect.size.width);
      this.cropRect.size.height = Math.min(paramTextureInfo.height, paramCGRect.size.height);
      break;
      label544:
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(770, 771, 1, 771);
    }
  }
  
  TextureInfo applyNewTexture(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    if ((this.rendererWidth == 0) || (this.rendererHeight == 0)) {
      Log.w(this.TAG, "rendererWidth = " + this.rendererWidth + ", rendererHeight = " + this.rendererHeight);
    }
    if ((paramTextureInfo.textureType != this.textureType) || (this.program == 0)) {
      initShader(paramTextureInfo);
    }
    bindFramebuffer();
    useProgram(paramMatrix2);
    beforeDraw(paramTextureInfo);
    onDraw(paramTextureInfo, paramMatrix1);
    finishDraw(paramTextureInfo);
    return getOutputTextureInfo(paramTextureInfo);
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    clearBufferBuffer(paramInt, 0.0F);
  }
  
  public void clearBufferBuffer(int paramInt, float paramFloat)
  {
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
      GLES20.glClearColor(((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, (paramInt & 0xFF) / 255.0F, paramFloat);
      GLES20.glClear(16384);
    }
  }
  
  protected String getFragmentShaderCode(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + this.FRAGMENT_SHADER;
    }
    return "uniform sampler2D " + this.FRAGMENT_SHADER;
  }
  
  protected TextureInfo getOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    this.outputTextureInfo = new TextureInfo(this.textureID[0], 3553, this.rendererWidth, this.rendererHeight, paramTextureInfo.preferRotation);
    return this.outputTextureInfo;
  }
  
  protected void initShader(TextureInfo paramTextureInfo)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    String str = getFragmentShaderCode(paramTextureInfo);
    this.vertexShaderCode = VERTEX_SHADER_CODE;
    this.fragmentShaderCode = str;
    this.program = Program.createProgram(VERTEX_SHADER_CODE, str);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program").printStackTrace();
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    this.textureType = paramTextureInfo.textureType;
  }
  
  protected void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 36197) {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
    }
    for (;;)
    {
      this.textureType = paramTextureInfo.textureType;
      return;
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", this.FRAGMENT_SHADER);
    }
  }
  
  protected void onDraw(TextureInfo paramTextureInfo, Matrix paramMatrix)
  {
    this.cropRect = new CGRect(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
    float f1 = this.cropRect.origin.x;
    float f2 = this.cropRect.origin.y;
    float f3 = this.cropRect.size.height;
    float f4 = this.cropRect.origin.x;
    float f5 = this.cropRect.origin.y;
    float f6 = this.cropRect.origin.x;
    float f7 = this.cropRect.size.width;
    float f8 = this.cropRect.origin.y;
    float f9 = this.cropRect.size.height;
    float f10 = this.cropRect.origin.x;
    float f11 = this.cropRect.size.width;
    float f12 = this.cropRect.origin.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f1, f2 + f3, f4, f5, f6 + f7, f8 + f9, f10 + f11, f12 });
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, paramTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, toOpenGL2DMatrix(paramMatrix), 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTextureInfo.width, paramTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    GLES20.glDrawArrays(5, 0, 4);
  }
  
  public void release()
  {
    Logger.d(this.TAG, "release: start, thread = " + Thread.currentThread().getName() + ", egl = " + EGL14.eglGetCurrentContext());
    if (this.outputTextureInfo != null)
    {
      GLES20.glDeleteTextures(1, new int[] { this.outputTextureInfo.textureID }, 0);
      this.outputTextureInfo = null;
    }
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.outputFrameBufferId }, 0);
      this.outputFrameBufferId = -1;
    }
    if (this.program > 0)
    {
      GLES20.glDeleteProgram(this.program);
      this.program = 0;
    }
    int i = 0;
    while (i < this.shaderIndexes.length)
    {
      if (this.shaderIndexes[i] > 0)
      {
        GLES20.glDeleteShader(this.shaderIndexes[i]);
        this.shaderIndexes[i] = 0;
      }
      i += 1;
    }
    Logger.d(this.TAG, "release: end");
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo == null) {
      throw new RuntimeException("outputTextureInfo 为空");
    }
    if (paramTextureInfo.isReleased()) {
      throw new RuntimeException("outputTextureInfo 已经被释放了");
    }
    this.rendererWidth = paramTextureInfo.width;
    this.rendererHeight = paramTextureInfo.height;
    if (!isEqualsCurrentOutputTexture(paramTextureInfo)) {
      checkAndInitFrameBuffer(paramTextureInfo);
    }
  }
  
  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }
  
  public String toString()
  {
    return "TextureFilter{program=" + this.program + ", rendererWidth=" + this.rendererWidth + ", rendererHeight=" + this.rendererHeight + ", outputTextureInfo=" + this.outputTextureInfo + ", outputFrameBufferId=" + this.outputFrameBufferId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.StickerTextureBlurFilter
 * JD-Core Version:    0.7.0.1
 */