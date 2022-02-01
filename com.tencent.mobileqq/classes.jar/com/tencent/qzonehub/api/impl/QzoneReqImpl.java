package com.tencent.qzonehub.api.impl;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.servlet.QZoneAlbumListNumServlet;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.mobileqq.servlet.QZoneGetGroupCountServlet;
import com.tencent.mobileqq.servlet.QZoneOnLineServlet;
import com.tencent.mobileqq.servlet.QZonePushAckServlet;
import com.tencent.mobileqq.servlet.QzonePublicMsgServlet;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.contentbox.model.QZoneLikeReq;
import cooperation.qzone.contentbox.model.QZoneMsgReq;
import cooperation.qzone.report.QzoneOnlineTimeServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class QzoneReqImpl
  implements IQzoneReq
{
  public NewIntent getLikeIntent(Context paramContext, BusinessObserver paramBusinessObserver, long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    paramBusinessObserver = new QZoneLikeReq(Long.valueOf(paramLong), paramString, paramString, paramBoolean ^ true, paramInt);
    paramBusinessObserver.setType(100);
    paramContext = new QzoneCommonIntent(paramContext, QZoneCommonServlet.class);
    paramContext.setRequest(paramBusinessObserver);
    return paramContext;
  }
  
  public NewIntent getMsgIntent(Context paramContext, BusinessObserver paramBusinessObserver, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(paramLong, "", paramInt1, paramInt2);
    localQZoneMsgReq.setType(paramInt3);
    paramContext = new QzoneCommonIntent(paramContext, QZoneCommonServlet.class);
    paramContext.setRequest(localQZoneMsgReq);
    paramContext.setObserver(paramBusinessObserver);
    return paramContext;
  }
  
  public void sentGetAlbumListNumServlet(BusinessObserver paramBusinessObserver, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), QZoneAlbumListNumServlet.class);
    localNewIntent.putExtra("selfuin", paramLong);
    BaseApplicationImpl.getApplication().getRuntime().registObserver(paramBusinessObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void sentGetGroupCountServlet(BusinessObserver paramBusinessObserver, long paramLong1, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QZoneGetGroupCountServlet.class);
    localNewIntent.putExtra("key_uin", paramLong1);
    localNewIntent.putExtra("key_troop_uin", paramLong2);
    BaseApplicationImpl.getApplication().getRuntime().registObserver(paramBusinessObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void sentGetPublicMsgServlet(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver, long paramLong, String paramString)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QzonePublicMsgServlet.class);
    localNewIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localNewIntent.putExtra("has_photo", paramString);
    paramAppRuntime.registObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void sentNewestFeedServlet(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplicationContext(), QZoneFeedsServlet.class);
    localNewIntent.putExtra("selfuin", paramLong1);
    localNewIntent.putExtra("hostuin", paramArrayOfLong);
    localNewIntent.putExtra("lasttime", paramLong2);
    localNewIntent.putExtra("src", paramInt);
    paramAppRuntime.registObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void sentOnlineServlet(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), QZoneOnLineServlet.class);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("lastPushMsgTime", paramLong);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void sentOnlineTimeServlet(ArrayList<mobile_online_report_item> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), QzoneOnlineTimeServlet.class);
    localNewIntent.putExtra("list", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public void sentPushAckServlet(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), QZonePushAckServlet.class);
    localNewIntent.putExtra("timestamp", paramLong1);
    localNewIntent.putExtra("hostuin", paramLong2);
    localNewIntent.putExtra("mark", paramString);
    localNewIntent.putExtra("flag", paramLong3);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneReqImpl
 * JD-Core Version:    0.7.0.1
 */