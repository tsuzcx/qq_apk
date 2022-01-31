package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import azep;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class Game3DNativeEvent
  implements azep
{
  public void a(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    try
    {
      gestureEventNative(paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VideoEnvironment.a("GameplayEngine.GameEvent", " gestureRegistered:", localUnsatisfiedLinkError);
    }
  }
  
  public void a(long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    try
    {
      touchEventNative(paramLong, paramInt1, paramFloat1, paramFloat2, paramInt2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VideoEnvironment.a("GameplayEngine.GameEvent", " touchEventInternal:", localUnsatisfiedLinkError);
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    try
    {
      boolean bool = gestureRegisteredNative(paramLong, paramInt);
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VideoEnvironment.a("GameplayEngine.GameEvent", " gestureRegistered:", localUnsatisfiedLinkError);
    }
    return true;
  }
  
  public native void gestureEventNative(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native boolean gestureRegisteredNative(long paramLong, int paramInt);
  
  public native boolean getEnableMultiTouchNative(long paramLong);
  
  public native void touchEventNative(long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.Game3DNativeEvent
 * JD-Core Version:    0.7.0.1
 */