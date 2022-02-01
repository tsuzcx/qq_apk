package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.GdtDataReportReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.ReportUrl;
import com.tencent.mobileqq.qqgamepub.utils.SharePreferenceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameAdServiceImpl
  implements IQQGameAdService
{
  private static final String QQ_GAME_AD_TICKET_ID = "807825";
  private static final String SP_KEY_AD_RESP_INTERVAL_TIME = "ad_rsp_interval_time";
  private static final String SP_KEY_AD_RESP_TIME = "ad_rsp_time";
  private static final String TAG = "QQGamePub_QQGameAdServiceImpl";
  public static int mRequestInterval = 300000;
  private QQGamePaAdInfoListenerAdapter listenerAdapter = new QQGameAdServiceImpl.1(this);
  private Context mContext = MobileQQ.getContext();
  private boolean mHasReportLogin;
  private long mLastEmptyRequestTime;
  private long mUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  
  public QQGameAdServiceImpl()
  {
    ThreadManagerV2.excute(new QQGameAdServiceImpl.2(this), 16, null, false);
  }
  
  private String getSpKeyAdRespIntervalTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad_rsp_interval_time_");
    localStringBuilder.append(this.mUin);
    return localStringBuilder.toString();
  }
  
  private String getSpKeyRespTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad_rsp_time_");
    localStringBuilder.append(this.mUin);
    return localStringBuilder.toString();
  }
  
  private boolean isOverTimeReqInterval()
  {
    long l1 = System.currentTimeMillis();
    long l2 = SharePreferenceUtils.a(this.mContext, getSpKeyRespTime());
    long l3 = SharePreferenceUtils.a(this.mContext, getSpKeyAdRespIntervalTime());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currentTs: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" lastTs: ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" tsInterval: ");
      localStringBuilder.append(l3);
      QLog.i("QQGamePub_QQGameAdServiceImpl", 2, localStringBuilder.toString());
    }
    return l1 - l2 >= l3;
  }
  
  public void doOnRunningForeground()
  {
    if (!this.mHasReportLogin) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.mLastEmptyRequestTime > mRequestInterval)
    {
      this.mLastEmptyRequestTime = l;
      pullAd();
    }
  }
  
  public void pullAd()
  {
    if (!isOverTimeReqInterval())
    {
      QLog.i("QQGamePub_QQGameAdServiceImpl", 2, "<<<< pullAd time not over last req time!!!!!<<<<");
      return;
    }
    QLog.i("QQGamePub_QQGameAdServiceImpl", 2, "<<<<begin pullAd!!!!!<<<<");
    ThreadManagerV2.excute(new QQGameAdServiceImpl.3(this), 128, null, true);
  }
  
  public void reportGdt(QQGameMsgInfo paramQQGameMsgInfo, int paramInt)
  {
    int j = QQGameHelperImpl.getRedDotUnreadCount();
    long l = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    Object localObject1 = new QQGamePaAdInfo.GdtDataReportReq();
    ((QQGamePaAdInfo.GdtDataReportReq)localObject1).aciotn_id.set(paramInt);
    ((QQGamePaAdInfo.GdtDataReportReq)localObject1).uin.set(l);
    ((QQGamePaAdInfo.GdtDataReportReq)localObject1).red_cnt.set(j);
    try
    {
      localObject2 = new JSONObject(paramQQGameMsgInfo.adJson);
      localObject3 = ((JSONObject)localObject2).optJSONObject("trace_info");
      if (localObject3 == null) {
        break label387;
      }
      boolean bool = TextUtils.isEmpty(paramQQGameMsgInfo.advId);
      if (bool) {}
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      Object localObject2;
      Object localObject3;
      label107:
      paramQQGameMsgInfo.printStackTrace();
      return;
    }
    try
    {
      i = Integer.parseInt(paramQQGameMsgInfo.advId);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label107;
    }
    int i = 0;
    ((QQGamePaAdInfo.GdtDataReportReq)localObject1).adid.set(i);
    ((QQGamePaAdInfo.GdtDataReportReq)localObject1).view_id.set(((JSONObject)localObject3).optString("view_id", ""));
    for (;;)
    {
      localObject3 = new QQGamePaAdInfo.ReportUrl();
      ((QQGamePaAdInfo.ReportUrl)localObject3).click_url.set(((JSONObject)localObject2).optString("click_url", ""));
      ((QQGamePaAdInfo.ReportUrl)localObject3).exposure_url.set(((JSONObject)localObject2).optString("exposure_url", ""));
      ((QQGamePaAdInfo.ReportUrl)localObject3).original_exposure_url.set(((JSONObject)localObject2).optString("original_exposure_url", ""));
      ((QQGamePaAdInfo.GdtDataReportReq)localObject1).reportUrl.set((MessageMicro)localObject3);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportGdt actionId=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(",unreadCount=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(",adId=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",uin=");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(",msgInfo.adJson=");
        ((StringBuilder)localObject2).append(paramQQGameMsgInfo.adJson);
        QLog.d("QQGamePub_QQGameAdServiceImpl", 1, ((StringBuilder)localObject2).toString());
      }
      paramQQGameMsgInfo = (IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class);
      localObject1 = paramQQGameMsgInfo.createTrpcInvokeReq("/v1/64", false, ((QQGamePaAdInfo.GdtDataReportReq)localObject1).toByteArray());
      localObject2 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject2).list.add((MessageMicro)localObject1);
      paramQQGameMsgInfo.requestTrpc((TrpcProxy.TrpcListReq)localObject2, null);
      return;
      label387:
      i = 0;
    }
  }
  
  public void updatePullAdInfo(boolean paramBoolean, long paramLong)
  {
    this.mHasReportLogin = paramBoolean;
    this.mLastEmptyRequestTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl
 * JD-Core Version:    0.7.0.1
 */