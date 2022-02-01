package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

public enum PlayParamConst$PlayType
{
  AUTO(1),  MANUAL(2);
  
  public final int value;
  
  private PlayParamConst$PlayType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst.PlayType
 * JD-Core Version:    0.7.0.1
 */