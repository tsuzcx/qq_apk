package com.tencent.trackrecordlib.enums;

public enum UiAction
{
  private int seq;
  
  static
  {
    KEY = new UiAction("KEY", 3, 4);
    SCREEN_ROTATION = new UiAction("SCREEN_ROTATION", 4, 5);
    ZOOM = new UiAction("ZOOM", 5, 6);
    INPUT = new UiAction("INPUT", 6, 7);
    REFRESH = new UiAction("REFRESH", 7, 8);
  }
  
  private UiAction(int paramInt)
  {
    this.seq = paramInt;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.enums.UiAction
 * JD-Core Version:    0.7.0.1
 */