package com.tencent.qzonehub.api;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

@QAPI(process={"all"})
public abstract interface IQzoneReq
  extends QRouteApi
{
  public abstract NewIntent getLikeIntent(Context paramContext, BusinessObserver paramBusinessObserver, long paramLong, String paramString, boolean paramBoolean, int paramInt);
  
  public abstract NewIntent getMsgIntent(Context paramContext, BusinessObserver paramBusinessObserver, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void sentGetAlbumListNumServlet(BusinessObserver paramBusinessObserver, long paramLong);
  
  public abstract void sentGetGroupCountServlet(BusinessObserver paramBusinessObserver, long paramLong1, long paramLong2);
  
  public abstract void sentGetPublicMsgServlet(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver, long paramLong, String paramString);
  
  public abstract void sentNewestFeedServlet(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt);
  
  public abstract void sentOnlineServlet(AppRuntime paramAppRuntime, String paramString, long paramLong);
  
  public abstract void sentOnlineTimeServlet(ArrayList<mobile_online_report_item> paramArrayList);
  
  public abstract void sentPushAckServlet(long paramLong1, long paramLong2, String paramString, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneReq
 * JD-Core Version:    0.7.0.1
 */