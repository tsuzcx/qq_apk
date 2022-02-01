package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

public class CanyingEffect
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
  private int beforeFrame1Handle;
  private int beforeFrame2Handle;
  private int beforeFrame3Handle;
  private int beforeFrame4Handle;
  private int[] cacheTexture = new int[4];
  private CacheTextureFilter cacheTextureFilter;
  private int currFrameIndex = 0;
  private int[] frameBuffer = new int[1];
  
  private void cacheTexture(TAVTextureInfo paramTAVTextureInfo, int paramInt)
  {
    if (paramTAVTextureInfo.getTextureType() == 36197)
    {
      if (this.cacheTextureFilter == null) {
        this.cacheTextureFilter = new CacheTextureFilter();
      }
      this.cacheTextureFilter.setParams(this.xyMatrix, this.stMatrix, this.cropRect, this.alpha);
      this.cacheTextureFilter.setRendererWidth(this.rendererWidth);
      this.cacheTextureFilter.setRendererHeight(this.rendererHeight);
      this.cacheTextureFilter.renderTexture(paramTAVTextureInfo, this.cacheTexture[(paramInt - 1)]);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTAVTextureInfo.textureID, 0);
    GLES20.glBindTexture(3553, this.cacheTexture[(paramInt - 1)]);
    GLES20.glCopyTexImage2D(3553, 0, 6407, 0, 0, this.rendererWidth, this.rendererHeight, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
  }
  
  private void setBeforeTexture(int paramInt1, int paramInt2)
  {
    GLES20.glActiveTexture(33984 + paramInt2);
    GLES20.glBindTexture(3553, this.cacheTexture[(paramInt2 - 1)]);
    GLES20.glUniform1i(paramInt1, paramInt2);
  }
  
  protected void afterDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.currFrameIndex % 4 == 0) {
      cacheTexture(paramTAVTextureInfo, 4);
    }
    for (;;)
    {
      this.currFrameIndex += 1;
      if (this.currFrameIndex > 3) {
        this.currFrameIndex = 0;
      }
      return;
      if (this.currFrameIndex % 4 == 1) {
        cacheTexture(paramTAVTextureInfo, 3);
      } else if (this.currFrameIndex % 4 == 2) {
        cacheTexture(paramTAVTextureInfo, 2);
      } else {
        cacheTexture(paramTAVTextureInfo, 1);
      }
    }
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    setBeforeTexture(this.beforeFrame1Handle, 1);
    setBeforeTexture(this.beforeFrame2Handle, 2);
    setBeforeTexture(this.beforeFrame3Handle, 3);
    setBeforeTexture(this.beforeFrame4Handle, 4);
  }
  
  public CanyingEffect clone()
  {
    return (CanyingEffect)cloneFilter(new CanyingEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
    }
    return "uniform sampler2D curTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat currentFrameWeight = 0.35;\nuniform sampler2D beforeFrame1;\nfloat beforeFrame1Weight = 0.3;\nuniform sampler2D beforeFrame2;\nfloat beforeFrame2Weight = 0.2;\nuniform sampler2D beforeFrame3;\nfloat beforeFrame3Weight = 0.1;\nuniform sampler2D beforeFrame4;\nfloat beforeFrame4Weight = 0.05;\nvoid main()\n{\n    vec4 renderTex = texture2D(curTexture,vTextureCoord);\n    \t    \n    vec4 shadow1 = texture2D(beforeFrame1, vTextureCoord);\n    vec4 shadow2 = texture2D(beforeFrame2, vTextureCoord);\n    vec4 shadow3 = texture2D(beforeFrame3, vTextureCoord);\n    vec4 shadow4 = texture2D(beforeFrame4, vTextureCoord);\n    \n    vec4 shadow = beforeFrame1Weight * shadow1 + beforeFrame2Weight * shadow2 + beforeFrame3Weight * shadow3 + beforeFrame4Weight * shadow4;\n    gl_FragColor = currentFrameWeight * renderTex + shadow;\n}";
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.beforeFrame1Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame1");
    this.beforeFrame2Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame2");
    this.beforeFrame3Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame3");
    this.beforeFrame4Handle = GLES20.glGetUniformLocation(this.program, "beforeFrame4");
    GLES20.glGenTextures(4, this.cacheTexture, 0);
    int i = 0;
    while (i < 4)
    {
      GLES20.glBindTexture(3553, this.cacheTexture[i]);
      TAVGLUtils.checkEglError("glBindTexture mTextureID");
      GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      TAVGLUtils.checkEglError("glTexParameter");
      GLES20.glBindTexture(3553, 0);
      i += 1;
    }
    GLES20.glGenFramebuffers(1, this.frameBuffer, 0);
  }
  
  public void release()
  {
    if (this.cacheTextureFilter != null) {
      this.cacheTextureFilter.release();
    }
    if (this.cacheTexture[0] != 0) {
      GLES20.glDeleteTextures(this.cacheTexture.length, this.cacheTexture, 0);
    }
    if (this.frameBuffer[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, this.frameBuffer, 0);
      this.frameBuffer[0] = 0;
    }
    super.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.effects.CanyingEffect
 * JD-Core Version:    0.7.0.1
 */