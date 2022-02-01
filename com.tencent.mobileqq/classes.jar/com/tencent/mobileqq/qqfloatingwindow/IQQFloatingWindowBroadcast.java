package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQFloatingWindowBroadcast
  extends QRouteApi
{
  @Deprecated
  public abstract void sendWindowClosedBroadcast(Context paramContext);
  
  public abstract void sendWindowClosedBroadcast(Context paramContext, int paramInt);
  
  public abstract void sendWindowClosedBroadcast(Context paramContext, int paramInt1, int paramInt2);
  
  @Deprecated
  public abstract void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean);
  
  public abstract void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean, int paramInt);
  
  public abstract void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
 * JD-Core Version:    0.7.0.1
 */