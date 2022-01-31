package com.tencent.plato.layout;

public abstract interface PMeasureFunction
{
  public abstract MeasureValue onMeasure(PlatoNode paramPlatoNode, float paramFloat1, PMeasureMode paramPMeasureMode1, float paramFloat2, PMeasureMode paramPMeasureMode2);
  
  public static class MeasureValue
  {
    public final float height;
    public final float width;
    
    public MeasureValue(float paramFloat1, float paramFloat2)
    {
      this.width = paramFloat1;
      this.height = paramFloat2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.layout.PMeasureFunction
 * JD-Core Version:    0.7.0.1
 */