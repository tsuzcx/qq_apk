package com.tencent.ttpic.openapi;

public class PTEmotionAttr
{
  public static final int EMOTION_TYPE_SMILE = 14;
  private boolean isSmile = false;
  private int value = 0;
  
  public int getValue()
  {
    return this.value;
  }
  
  public boolean isSmile()
  {
    return this.isSmile;
  }
  
  public void setSmile(boolean paramBoolean)
  {
    this.isSmile = paramBoolean;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTEmotionAttr
 * JD-Core Version:    0.7.0.1
 */