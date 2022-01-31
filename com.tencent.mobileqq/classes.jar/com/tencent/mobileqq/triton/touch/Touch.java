package com.tencent.mobileqq.triton.touch;

import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;

@TTNativeModule(name="Touch")
public class Touch
{
  static final String NAME = "Touch";
  @TTNativeCall
  public int identifier;
  @TTNativeCall
  public float screenX;
  @TTNativeCall
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.Touch
 * JD-Core Version:    0.7.0.1
 */