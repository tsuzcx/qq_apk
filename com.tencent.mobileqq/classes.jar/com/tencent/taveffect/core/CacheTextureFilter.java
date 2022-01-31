package com.tencent.taveffect.core;

import android.opengl.GLES20;
import com.tencent.taveffect.effects.BaseEffect;

public class CacheTextureFilter
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private int[] frameBuffer = new int[1];
  
  private void bindTexture(int paramInt)
  {
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    if (this.frameBuffer[0] == 0) {
      GLES20.glGenFramebuffers(1, this.frameBuffer, 0);
    }
    GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
  }
  
  public String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
    return "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  }
  
  public void release()
  {
    if (this.frameBuffer[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, this.frameBuffer, 0);
      this.frameBuffer[0] = 0;
    }
    super.release();
  }
  
  public void renderTexture(TAVTextureInfo paramTAVTextureInfo, int paramInt)
  {
    if ((paramTAVTextureInfo.textureType != this.textureType) || (this.program == 0)) {
      initShader(paramTAVTextureInfo);
    }
    bindTexture(paramInt);
    useProgram();
    onDraw(paramTAVTextureInfo);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.getTextureType(), 0);
    GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.taveffect.core.CacheTextureFilter
 * JD-Core Version:    0.7.0.1
 */