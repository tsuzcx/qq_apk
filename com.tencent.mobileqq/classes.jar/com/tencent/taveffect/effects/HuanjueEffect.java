package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

public class HuanjueEffect
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
  private int beforeFrameHandle;
  private int[] cacheTexture = new int[1];
  private CacheTextureFilter cacheTextureFilter;
  private int colorMaskHandle;
  private int curTextureHandle;
  private int currFrameIndex = 0;
  private int[] frameBuffer = new int[1];
  
  private void cacheTexture(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.getTextureType() == 36197)
    {
      if (this.cacheTextureFilter == null) {
        this.cacheTextureFilter = new CacheTextureFilter();
      }
      this.cacheTextureFilter.setParams(this.xyMatrix, this.stMatrix, this.cropRect, this.alpha);
      this.cacheTextureFilter.setRendererWidth(this.rendererWidth);
      this.cacheTextureFilter.setRendererHeight(this.rendererHeight);
      this.cacheTextureFilter.renderTexture(paramTAVTextureInfo, this.cacheTexture[0]);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTAVTextureInfo.textureID, 0);
    GLES20.glBindTexture(3553, this.cacheTexture[0]);
    GLES20.glCopyTexImage2D(3553, 0, 6407, 0, 0, this.rendererWidth, this.rendererHeight, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
  }
  
  protected void afterDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    int i = this.currFrameIndex;
    if (i == 0) {
      cacheTexture(paramTAVTextureInfo);
    } else if (i == 1) {
      GLES20.glUniform4f(this.colorMaskHandle, 1.0F, 0.0F, 0.0F, 1.0F);
    } else if (i == 4) {
      GLES20.glUniform4f(this.colorMaskHandle, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    this.currFrameIndex += 1;
    if (this.currFrameIndex > 8) {
      this.currFrameIndex = 0;
    }
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.cacheTexture[0]);
    GLES20.glUniform1i(this.beforeFrameHandle, 1);
  }
  
  public HuanjueEffect clone()
  {
    return (HuanjueEffect)cloneFilter(new HuanjueEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
    }
    return "uniform sampler2D curTexture;\nprecision mediump float;\nuniform sampler2D beforeFrame;\nvarying vec2 vTextureCoord;\nuniform vec4 colorMask;\nfloat shadowScale = 3.0;\nfloat shadowContrast = 3.0;\nvoid main()\n{\n    vec4 shadow =  texture2D(beforeFrame, vTextureCoord);\n    vec4 videoColor = texture2D(curTexture, vTextureCoord);\n\n    float luminanceMain = 0.2125 * videoColor.r + 0.7154 * videoColor.g + 0.0721 * videoColor.b;\n    float luminanceShadow = 0.2125 * shadow.r + 0.7154 * shadow.g + 0.0721 * shadow.b;\n\n    float gray = max(1.0 - luminanceMain, 1.0 - luminanceShadow);\n\n    float scale = pow(gray, shadowContrast) * shadowScale;\n    vec4 mask = clamp(colorMask * scale, 0.0, 1.0);\n    mask.w = 0.0;\n\n    vec4 preColor = mask * videoColor + (vec4(1.0, 1.0, 1.0, 1.0) - mask) * shadow;\n    vec4 afterColor = (vec4(1.0, 1.0, 1.0, 1.0) - mask) * videoColor + mask * shadow;\n    gl_FragColor = colorMask.w * preColor + (1.0 - colorMask.w) * afterColor;\n}";
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.colorMaskHandle = GLES20.glGetUniformLocation(this.program, "colorMask");
    this.beforeFrameHandle = GLES20.glGetUniformLocation(this.program, "beforeFrame");
    this.curTextureHandle = GLES20.glGetUniformLocation(this.program, "curTexture");
    GLES20.glGenTextures(1, this.cacheTexture, 0);
    GLES20.glBindTexture(3553, this.cacheTexture[0]);
    TAVGLUtils.checkEglError("glBindTexture mTextureID");
    GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    TAVGLUtils.checkEglError("glTexParameter");
    GLES20.glBindTexture(3553, 0);
    GLES20.glGenFramebuffers(1, this.frameBuffer, 0);
  }
  
  public void release()
  {
    Object localObject = this.cacheTextureFilter;
    if (localObject != null) {
      ((CacheTextureFilter)localObject).release();
    }
    localObject = this.cacheTexture;
    if (localObject[0] != 0)
    {
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      this.cacheTexture[0] = 0;
    }
    localObject = this.frameBuffer;
    if (localObject[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      this.frameBuffer[0] = 0;
    }
    super.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.effects.HuanjueEffect
 * JD-Core Version:    0.7.0.1
 */