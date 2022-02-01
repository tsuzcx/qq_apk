package com.tencent.mobileqq.triton.touch;

import com.tencent.mobileqq.triton.utils.TritonKeep;

@TritonKeep
public class Touch
{
  static final String NAME = "Touch";
  @TritonKeep
  public int identifier;
  @TritonKeep
  public float screenX;
  @TritonKeep
  public float screenY;
  
  public Touch(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.identifier = paramInt;
    this.screenX = paramFloat1;
    this.screenY = paramFloat2;
  }
  
  public int getIdentifier()
  {
    return this.identifier;
  }
  
  public void setLocation(float paramFloat1, float paramFloat2)
  {
    this.screenX = paramFloat1;
    this.screenY = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.Touch
 * JD-Core Version:    0.7.0.1
 */