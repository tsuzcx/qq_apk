package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyProcessMonitor
  extends QRouteApi
{
  public static final int FLAG_HAS_UNREAD_MSG = 3;
  public static final int FLAG_ONLINE_PUSH = 4;
  public static final int FLAG_PRELOAD_COUNT = 3;
  public static final int FLAG_PRELOAD_FROM_GUIDE = 2;
  public static final int FLAG_PRELOAD_FROM_LEBA = 0;
  public static final int FLAG_PRELOAD_FROM_MSGBOX = 1;
  public static final String TOOL_PROCESS = "com.tencent.mobileqq:tool";
  
  public abstract void checkSchoolName(String paramString);
  
  public abstract void reportCheckNearbyUnreadFlag(String paramString, int paramInt);
  
  public abstract void reportSessionBegin(int paramInt);
  
  public abstract void reportSessionEnd(int paramInt);
  
  public abstract void reportSessionHit(int paramInt);
  
  public abstract void startNearbyProcess(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyProcessMonitor
 * JD-Core Version:    0.7.0.1
 */