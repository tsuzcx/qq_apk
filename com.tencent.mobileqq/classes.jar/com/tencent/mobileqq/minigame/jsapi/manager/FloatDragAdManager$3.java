package com.tencent.mobileqq.minigame.jsapi.manager;

import blbw;
import cooperation.vip.pb.TianShuAccess.AdItem;

class FloatDragAdManager$3
  implements Runnable
{
  FloatDragAdManager$3(FloatDragAdManager paramFloatDragAdManager, TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    blbw.a().a(FloatDragAdManager.access$300(this.val$adItem, this.val$type, this.val$reportActionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdManager.3
 * JD-Core Version:    0.7.0.1
 */