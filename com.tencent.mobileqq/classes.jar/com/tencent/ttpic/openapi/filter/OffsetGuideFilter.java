package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class OffsetGuideFilter
  extends BaseFilter
{
  private float xOffset = 0.0F;
  
  public OffsetGuideFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void updatePosition()
  {
    float f1 = 0.0F - this.xOffset;
    float f2 = 0.5F - this.xOffset / 2.0F;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    setTexCords(new float[] { f2, 1.0F, f2, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    updatePosition();
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void setxOffset(float paramFloat)
  {
    this.xOffset = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.OffsetGuideFilter
 * JD-Core Version:    0.7.0.1
 */