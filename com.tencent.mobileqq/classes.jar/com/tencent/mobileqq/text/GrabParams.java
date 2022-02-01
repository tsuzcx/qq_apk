package com.tencent.mobileqq.text;

public class GrabParams
{
  public int emoSize = 32;
  public int end;
  public int flag;
  public Object message;
  public int start;
  public String text;
  public int uinType = -1;
  
  public GrabParams(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.text = paramString;
    this.flag = paramInt1;
    this.start = paramInt2;
    this.end = paramInt3;
  }
  
  public void setEmoSize(int paramInt)
  {
    this.emoSize = paramInt;
  }
  
  public void setMessage(Object paramObject)
  {
    this.message = paramObject;
  }
  
  public void setUinType(int paramInt)
  {
    this.uinType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.GrabParams
 * JD-Core Version:    0.7.0.1
 */