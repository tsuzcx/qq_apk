package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;

public class CropFilter
  extends BaseFilter
{
  private float bottom = 0.0F;
  private float left = 0.0F;
  
  public CropFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void updatePosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f3 = (paramInt3 - paramInt1) / paramInt3;
    float f2 = (paramInt4 - paramInt2) / paramInt4;
    float f1 = f3 - 1.0F;
    f3 = 1.0F - f3;
    float f4 = -1.0F + f2;
    f2 = 1.0F - f2;
    setPositions(new float[] { f1, f4, f1, f2, f3, f2, f3, f4 });
  }
  
  private void updateTexCords(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = (paramInt3 - paramInt1) / 2.0F / paramInt3;
    float f2 = 1.0F - f1;
    float f3 = (paramInt4 - paramInt2) / 2.0F / paramInt4;
    float f4 = 1.0F - f3;
    if ((Float.compare(f1, this.left) == 0) && (Float.compare(f3, this.bottom) == 0)) {
      return;
    }
    this.left = f1;
    this.bottom = f3;
    setTexCords(new float[] { f1, f3, f1, f4, f2, f4, f2, f3 });
  }
  
  public void clearGLSLSelf()
  {
    this.left = 0.0F;
    this.bottom = 0.0F;
    super.clearGLSLSelf();
  }
  
  public void updateCorpRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateTexCords(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CropFilter
 * JD-Core Version:    0.7.0.1
 */