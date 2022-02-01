package com.tencent.mobileqq.onlinestatus.auto;

import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class OnlineStatusSmartDisplayInfo$2
{
  OnlineStatusSmartDisplayInfo$2(OnlineStatusSmartDisplayInfo paramOnlineStatusSmartDisplayInfo) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    OnlineStatusSmartDisplayInfo localOnlineStatusSmartDisplayInfo = this.a;
    localOnlineStatusSmartDisplayInfo.a(OnlineStatusSmartDisplayInfo.e(localOnlineStatusSmartDisplayInfo));
  }
  
  @QQPermissionGrant(1)
  public void grant() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo.2
 * JD-Core Version:    0.7.0.1
 */