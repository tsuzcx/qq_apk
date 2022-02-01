package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
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

class Renderer
{
  private int aPositionHandle;
  private final GLBlendStateCache glBlendStateCache;
  private final String mTAG;
  private int outputFrameBufferId;
  private TextureInfo outputTextureInfo;
  protected int program;
  private int rendererHeight;
  private int rendererWidth;
  private final int[] shaderIndexes;
  private int stMatrixHandle;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  Renderer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureFilter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mTAG = localStringBuilder.toString();
    this.glBlendStateCache = new GLBlendStateCache();
    this.shaderIndexes = new int[2];
    this.outputTextureInfo = null;
    this.outputFrameBufferId = -1;
    Logger.d(this.mTAG, "TextureFilter() called");
  }
  
  private int[] cacheViewport()
  {
    int[] arrayOfInt = new int[4];
    GLES20.glGetIntegerv(2978, arrayOfInt, 0);
    int i = this.outputFrameBufferId;
    if (i != -1)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glGetIntegerv(2978, arrayOfInt, 0);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }
    return arrayOfInt;
  }
  
  private void checkAndInitFrameBuffer(@NonNull TextureInfo paramTextureInfo)
  {
    int j = paramTextureInfo.getFrameBuffer();
    int i = j;
    if (j == -1)
    {
      i = createFrameBuffer(paramTextureInfo);
      j = GLES20.glCheckFramebufferStatus(36160);
      if (j != 36053)
      {
        paramTextureInfo = this.mTAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndInitFrameBuffer: status = ");
        localStringBuilder.append(j);
        Logger.e(paramTextureInfo, localStringBuilder.toString(), new RuntimeException("EGL error encountered: FramebufferStatus is not complete."));
        return;
      }
      GLES20.glBindFramebuffer(36160, 0);
    }
    this.outputFrameBufferId = i;
    paramTextureInfo.setFrameBuffer(i);
    this.outputTextureInfo = paramTextureInfo;
  }
  
  private int createFrameBuffer(@NonNull TextureInfo paramTextureInfo)
  {
    GLES20.glBindTexture(3553, paramTextureInfo.textureID);
    GLES20.glTexImage2D(3553, 0, paramTextureInfo.getFormat(), paramTextureInfo.width, paramTextureInfo.height, 0, paramTextureInfo.getFormat(), 5121, null);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, i);
    RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
    RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
    return i;
  }
  
  private void createProgram(TextureInfo paramTextureInfo)
  {
    if (this.program == 0)
    {
      if (paramTextureInfo.textureType == 36197) {
        initShader("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
      } else {
        initShader("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
      }
      RenderContext.checkEglError("createProgram");
    }
  }
  
  private float[] getVerticesDataFromRect(TextureInfo paramTextureInfo, CGRect paramCGRect)
  {
    if (paramCGRect == null)
    {
      paramCGRect = new CGRect(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
    }
    else
    {
      paramCGRect.size.width = Math.min(paramTextureInfo.width, paramCGRect.size.width);
      paramCGRect.size.height = Math.min(paramTextureInfo.height, paramCGRect.size.height);
    }
    float f2 = paramCGRect.origin.x + paramCGRect.size.width;
    float f1 = f2;
    if (f2 > paramTextureInfo.width)
    {
      f1 = paramTextureInfo.width;
      Logger.e(this.mTAG, "applyFilter: crop right pixel exceed texture width");
    }
    float f3 = paramCGRect.origin.y + paramCGRect.size.height;
    f2 = f3;
    if (f3 > paramTextureInfo.height)
    {
      f2 = paramTextureInfo.height;
      Logger.e(this.mTAG, "applyFilter: crop bottom pixel exceed texture height");
    }
    return new float[] { paramCGRect.origin.x, f2, paramCGRect.origin.x, paramCGRect.origin.y, f1, f2, f1, paramCGRect.origin.y };
  }
  
  private void initShader(String paramString1, String paramString2)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.program = Program.createProgram(paramString1, paramString2, this.shaderIndexes);
    int i = this.program;
    if (i == 0)
    {
      new RuntimeException("failed creating program").printStackTrace();
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(i, "aPosition");
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
    if (this.uTextureSizeHandle == -1) {
      new RuntimeException("Could not get uniform location for uTextureSize").printStackTrace();
    }
  }
  
  private boolean isEqualsCurrentOutputTexture(@NonNull TextureInfo paramTextureInfo)
  {
    TextureInfo localTextureInfo = this.outputTextureInfo;
    boolean bool2 = false;
    if (localTextureInfo == null) {
      return false;
    }
    if (localTextureInfo.equals(paramTextureInfo)) {
      return true;
    }
    boolean bool1 = bool2;
    if (this.outputTextureInfo.textureID == paramTextureInfo.textureID)
    {
      bool1 = bool2;
      if (this.outputTextureInfo.width == paramTextureInfo.width)
      {
        bool1 = bool2;
        if (this.outputTextureInfo.height == paramTextureInfo.height) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void onFinishDraw(TextureInfo paramTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, 0);
  }
  
  private void onPrepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
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
  
  private void restoreViewport(int[] paramArrayOfInt)
  {
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2], paramArrayOfInt[3]);
    }
  }
  
  private void updateBlendParams(TextureInfo paramTextureInfo)
  {
    GLES20.glEnable(3042);
    if (!paramTextureInfo.isMixAlpha())
    {
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(1, 771, 1, 771);
      return;
    }
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(770, 771, 1, 771);
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    clearBufferBuffer(paramInt, 0.0F);
  }
  
  public void clearBufferBuffer(int paramInt, float paramFloat)
  {
    int i = this.outputFrameBufferId;
    if (i != -1)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glClearColor(((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, (paramInt & 0xFF) / 255.0F, paramFloat);
      GLES20.glClear(16384);
    }
  }
  
  public void release()
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: start, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(", egl = ");
    localStringBuilder.append(EGL14.eglGetCurrentContext());
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.outputTextureInfo;
    if (localObject != null)
    {
      GLES20.glDeleteTextures(1, new int[] { ((TextureInfo)localObject).textureID }, 0);
      this.outputTextureInfo = null;
    }
    int i = this.outputFrameBufferId;
    if (i != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.outputFrameBufferId = -1;
    }
    i = this.program;
    if (i > 0)
    {
      GLES20.glDeleteProgram(i);
      this.program = 0;
    }
    i = 0;
    for (;;)
    {
      localObject = this.shaderIndexes;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] > 0)
      {
        GLES20.glDeleteShader(localObject[i]);
        this.shaderIndexes[i] = 0;
      }
      i += 1;
    }
    Logger.d(this.mTAG, "release: end");
  }
  
  public TextureInfo render(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    if (paramTextureInfo == null) {
      return null;
    }
    RenderContext.checkEglError("onDrawFrame start");
    this.glBlendStateCache.cache();
    createProgram(paramTextureInfo);
    paramCGRect = getVerticesDataFromRect(paramTextureInfo, paramCGRect);
    this.triangleVertices.rewind();
    this.triangleVertices.put(paramCGRect);
    paramCGRect = cacheViewport();
    GLES20.glUseProgram(this.program);
    RenderContext.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix2), 0);
    GLES20.glUniform1f(this.uAlphaHandle, paramFloat);
    updateBlendParams(paramTextureInfo);
    onPrepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(paramMatrix1));
    GLES20.glDrawArrays(5, 0, 4);
    RenderContext.checkEglError("glDrawArrays");
    onFinishDraw(paramTextureInfo);
    restoreViewport(paramCGRect);
    this.glBlendStateCache.restore();
    return this.outputTextureInfo;
  }
  
  void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo != null)
    {
      if (!paramTextureInfo.isReleased())
      {
        if (paramTextureInfo.textureType == 3553)
        {
          this.rendererWidth = paramTextureInfo.width;
          this.rendererHeight = paramTextureInfo.height;
          if (!isEqualsCurrentOutputTexture(paramTextureInfo)) {
            checkAndInitFrameBuffer(paramTextureInfo);
          }
          return;
        }
        throw new RuntimeException("目标纹理类型需要GLES20.GL_TEXTURE_2D");
      }
      throw new RuntimeException("outputTextureInfo 已经被释放了");
    }
    throw new RuntimeException("outputTextureInfo 为空");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureFilter{program=");
    localStringBuilder.append(this.program);
    localStringBuilder.append(", rendererWidth=");
    localStringBuilder.append(this.rendererWidth);
    localStringBuilder.append(", rendererHeight=");
    localStringBuilder.append(this.rendererHeight);
    localStringBuilder.append(", outputTextureInfo=");
    localStringBuilder.append(this.outputTextureInfo);
    localStringBuilder.append(", outputFrameBufferId=");
    localStringBuilder.append(this.outputFrameBufferId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.Renderer
 * JD-Core Version:    0.7.0.1
 */