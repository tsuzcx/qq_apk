package com.tencent.ttpic.model;

public class CharmRange
{
  public static final int HIT = 1;
  public static final int NOT_HIT = 2;
  public static final int PENDING = 0;
  public double max;
  public double min;
  private int status = 0;
  
  public void clearStatus()
  {
    this.status = 0;
  }
  
  public void hit(double paramDouble)
  {
    if ((paramDouble >= this.min) && ((paramDouble < this.max) || ((this.max == 1.0D) && (paramDouble <= this.max))))
    {
      this.status = 1;
      return;
    }
    this.status = 2;
  }
  
  public boolean isHit()
  {
    return this.status == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.CharmRange
 * JD-Core Version:    0.7.0.1
 */