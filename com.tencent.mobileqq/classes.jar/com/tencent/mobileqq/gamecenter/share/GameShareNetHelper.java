package com.tencent.mobileqq.gamecenter.share;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailReq;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public class GameShareNetHelper
{
  private static volatile GameShareNetHelper a;
  private Map<MessageRecord, Long> b = new HashMap();
  
  public static GameShareNetHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GameShareNetHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject1 = (Long)this.b.get(paramMessageRecord);
    long l1;
    if (localObject1 == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)localObject1).longValue();
    }
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (l2 - Long.valueOf(l1).longValue() <= 30000L) {
      return;
    }
    this.b.put(paramMessageRecord, Long.valueOf(l2));
    Object localObject2 = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQQAppInterface();
    if (localObject2 == null) {
      return;
    }
    localObject1 = new GetArkTailReq();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((GetArkTailReq)localObject1).appid = localStringBuilder.toString();
    ((GetArkTailReq)localObject1).tt = 1;
    ((GetArkTailReq)localObject1).sceneId = 1;
    ((GetArkTailReq)localObject1).qqVersion = DeviceInfoUtil.e();
    localObject2 = new WeakReference(localObject2);
    ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest((JceStruct)localObject1, new GameShareNetHelper.2(this, paramMessageRecord, (WeakReference)localObject2));
  }
  
  public void a(long paramLong, BusinessObserver paramBusinessObserver)
  {
    GetArkTailReq localGetArkTailReq = new GetArkTailReq();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localGetArkTailReq.appid = localStringBuilder.toString();
    localGetArkTailReq.tt = 1;
    localGetArkTailReq.sceneId = 3;
    localGetArkTailReq.qqVersion = DeviceInfoUtil.e();
    ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(localGetArkTailReq, paramBusinessObserver);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ReportTypeReq localReportTypeReq = new ReportTypeReq();
    localReportTypeReq.appid = paramString;
    localReportTypeReq.type = paramInt1;
    localReportTypeReq.subType = paramInt2;
    localReportTypeReq.tt = 1;
    ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(localReportTypeReq, new GameShareNetHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper
 * JD-Core Version:    0.7.0.1
 */