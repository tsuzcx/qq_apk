package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

public class ShanbaiEffect
  extends BaseEffect
{
  private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float brightness;\nuniform float contrast;\nfloat saturation = 1.0;\nvec4 addEnd = vec4(0.0, 0.0, 0.0, 0.0);\nvec4 multiplier = vec4(1.0, 1.0, 1.0, 1.0);\nvoid main()\n{\n    vec4 renderTex = texture2D(sTexture, vTextureCoord);\n\n    vec4 finalColor = renderTex;\n\n    float gray = 0.2125 * renderTex.r + 0.7154 * renderTex.g + 0.0721 * renderTex.b;\n    vec4 grayColor = vec4(gray, gray, gray, 1.0);\n\n    finalColor = mix(grayColor, finalColor, saturation);\n\n    vec4 avgColor = vec4(0.5, 0.5, 0.5, 1.0);\n\n    finalColor = mix(avgColor, finalColor, contrast);\n\n    finalColor = finalColor + addEnd;\n    finalColor = abs(finalColor);\n\n    finalColor = finalColor * multiplier;\n    finalColor = finalColor * brightness;\n\n    gl_FragColor = finalColor;\n}";
  private int brightnessHandle;
  private float brightnessMax = 3.0F;
  private float brightnessNormal = 1.0F;
  private int contrastHandle;
  private float contrastMax = 1.3F;
  private float contrastNormal = 1.0F;
  private float delayTime = 0.0F;
  private boolean flashDown = false;
  private boolean flashUp = true;
  public float progress = 0.0F;
  
  private void update()
  {
    if (this.flashUp)
    {
      this.progress += this.deltaTime * 7.0F;
      if (this.progress > 1.0F)
      {
        this.flashUp = false;
        this.flashDown = true;
        this.progress = 1.0F;
      }
      GLES20.glUniform1f(this.brightnessHandle, TAVGLUtils.lerp(this.brightnessNormal, this.brightnessMax, this.progress));
      GLES20.glUniform1f(this.contrastHandle, TAVGLUtils.lerp(this.contrastNormal, this.contrastMax, this.progress));
    }
    do
    {
      return;
      if (this.flashDown)
      {
        this.progress -= this.deltaTime * 7.0F;
        if (this.progress <= 0.0F)
        {
          this.flashUp = false;
          this.flashDown = false;
          this.progress = 0.0F;
        }
        GLES20.glUniform1f(this.brightnessHandle, TAVGLUtils.lerp(this.brightnessNormal, this.brightnessMax, this.progress));
        GLES20.glUniform1f(this.contrastHandle, TAVGLUtils.lerp(this.contrastNormal, this.contrastMax, this.progress));
        return;
      }
      this.delayTime += this.deltaTime;
    } while (this.delayTime <= 0.1F);
    this.delayTime = 0.0F;
    this.progress = 0.0F;
    this.flashUp = true;
    this.flashDown = false;
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    update();
  }
  
  public ShanbaiEffect clone()
  {
    return (ShanbaiEffect)cloneFilter(new ShanbaiEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
    }
    return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.brightnessHandle = GLES20.glGetUniformLocation(this.program, "brightness");
    TAVGLUtils.checkEglError("glGetAttribLocation brightness");
    this.contrastHandle = GLES20.glGetUniformLocation(this.program, "contrast");
    TAVGLUtils.checkEglError("glGetAttribLocation contrast");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.taveffect.effects.ShanbaiEffect
 * JD-Core Version:    0.7.0.1
 */