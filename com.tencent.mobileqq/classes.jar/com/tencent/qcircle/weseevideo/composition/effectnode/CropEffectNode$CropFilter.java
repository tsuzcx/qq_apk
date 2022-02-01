package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
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

class CropEffectNode$CropFilter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_END = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private final String TAG;
  private int aPositionHandle;
  private int outputFrameBufferId;
  private TextureInfo outputTextureInfo;
  protected int program;
  private int rendererHeight;
  private int rendererWidth;
  @NonNull
  private final int[] shaderIndexes;
  private int stMatrixHandle;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  public CropEffectNode$CropFilter(CropEffectNode paramCropEffectNode)
  {
    paramCropEffectNode = new StringBuilder();
    paramCropEffectNode.append("TextureFilter@");
    paramCropEffectNode.append(Integer.toHexString(hashCode()));
    this.TAG = paramCropEffectNode.toString();
    this.shaderIndexes = new int[2];
    this.outputTextureInfo = null;
    this.outputFrameBufferId = -1;
    Logger.d(this.TAG, "CropFilter() called");
  }
  
  private void checkAndInitFrameBuffer(@NonNull TextureInfo paramTextureInfo)
  {
    int j = paramTextureInfo.getFrameBuffer();
    int i = j;
    if (j == -1)
    {
      GLES20.glBindTexture(3553, paramTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, 6408, paramTextureInfo.width, paramTextureInfo.height, 0, 6408, 5121, null);
      Object localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      i = localObject[0];
      GLES20.glBindFramebuffer(36160, i);
      RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
      RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
      j = GLES20.glCheckFramebufferStatus(36160);
      if (j != 36053)
      {
        paramTextureInfo = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndInitFrameBuffer: status = ");
        ((StringBuilder)localObject).append(j);
        Log.e(paramTextureInfo, ((StringBuilder)localObject).toString(), new RuntimeException("EGL error encountered: FramebufferStatus is not complete."));
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
  
  private void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 36197)
    {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
      return;
    }
    initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
  }
  
  private void initShaders(String paramString1, String paramString2)
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
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    if (paramTextureInfo == null) {
      return null;
    }
    if (this.program == 0) {
      initShaderForTextureInfo(paramTextureInfo);
    }
    RenderContext.checkEglError("onDrawFrame start");
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
    paramCGRect = new int[4];
    GLES20.glGetIntegerv(2978, paramCGRect, 0);
    int i = this.outputFrameBufferId;
    if (i != -1)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glGetIntegerv(2978, paramCGRect, 0);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }
    GLES20.glUseProgram(this.program);
    RenderContext.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix2), 0);
    GLES20.glUniform1f(this.uAlphaHandle, paramFloat);
    GLES20.glEnable(3042);
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 771);
    prepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(paramMatrix1));
    GLES20.glClear(16384);
    GLES20.glDrawArrays(5, 0, 4);
    RenderContext.checkEglError("glDrawArrays");
    finishDraw(paramTextureInfo);
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(paramCGRect[0], paramCGRect[1], paramCGRect[2], paramCGRect[3]);
    }
    GLES20.glBlendFuncSeparate(770, 771, 1, 771);
    return this.outputTextureInfo;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    int i = this.outputFrameBufferId;
    if (i != -1)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glClearColor(((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, (paramInt & 0xFF) / 255.0F, 1.0F);
      GLES20.glClear(16384);
    }
  }
  
  public void release()
  {
    Object localObject = this.outputTextureInfo;
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
    Logger.d(this.TAG, "release: end");
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.CropEffectNode.CropFilter
 * JD-Core Version:    0.7.0.1
 */