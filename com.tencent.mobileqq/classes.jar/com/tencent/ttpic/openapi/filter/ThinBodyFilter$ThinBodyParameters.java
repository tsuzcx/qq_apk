package com.tencent.ttpic.openapi.filter;

class ThinBodyFilter$ThinBodyParameters
{
  public float middleLine;
  public float strength;
  public float waistWidth;
  public float y0;
  public float y1;
  public float y2;
  
  public ThinBodyFilter$ThinBodyParameters(ThinBodyFilter paramThinBodyFilter) {}
  
  public ThinBodyFilter$ThinBodyParameters(ThinBodyFilter paramThinBodyFilter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.waistWidth = paramFloat1;
    this.middleLine = paramFloat2;
    this.strength = paramFloat3;
    this.y0 = paramFloat4;
    this.y1 = paramFloat5;
    this.y2 = paramFloat6;
  }
  
  public ThinBodyParameters copy()
  {
    return new ThinBodyParameters(this.this$0, this.waistWidth, this.middleLine, this.strength, this.y0, this.y1, this.y2);
  }
  
  public void reset()
  {
    this.y0 = 0.0F;
    this.y1 = 0.0F;
    this.y2 = 0.0F;
    this.middleLine = 0.0F;
    this.waistWidth = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ThinBodyFilter.ThinBodyParameters
 * JD-Core Version:    0.7.0.1
 */