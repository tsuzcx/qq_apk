package com.tencent.vbox.filter;

import com.tencent.filter.BaseFilter;

public class OesToRgbaFilter
  extends BaseFilter
{
  public OesToRgbaFilter()
  {
    super("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {\n  gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void initParams() {}
  
  public void apply()
  {
    initParams();
    super.apply();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    initParams();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.filter.OesToRgbaFilter
 * JD-Core Version:    0.7.0.1
 */