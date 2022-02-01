package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;

public class SpaceFilter
  extends BaseFilter
{
  private float mRatio = 0.0F;
  
  public SpaceFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void setSpaceRatio(float paramFloat)
  {
    if (Float.compare(this.mRatio, paramFloat) == 0) {
      return;
    }
    this.mRatio = paramFloat;
    paramFloat = 1.0F - this.mRatio;
    setPositions(new float[] { -paramFloat, -paramFloat, -paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, -paramFloat });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SpaceFilter
 * JD-Core Version:    0.7.0.1
 */