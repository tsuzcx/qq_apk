package com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic;

public class GPUOESBaseFilter
  extends GPUBaseFilter
{
  public GPUOESBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
  }
  
  private GPUOESBaseFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.a = 36197;
    this.b = 102;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUOESBaseFilter
 * JD-Core Version:    0.7.0.1
 */