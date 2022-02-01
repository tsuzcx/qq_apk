package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;

public class SvEffectSdkInitor$QQGestureGameResource
  implements GestureGameResource
{
  public String getGameModelPath()
  {
    return GestureUtil.c();
  }
  
  public boolean isGestureGameEnable()
  {
    return GestureMgr.e().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQGestureGameResource
 * JD-Core Version:    0.7.0.1
 */