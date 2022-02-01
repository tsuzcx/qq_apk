package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class OlympicMedalEventHandler
  extends BusinessHandler
{
  public QQAppInterface a;
  
  protected OlympicMedalEventHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected OlympicMedalEventHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).updateOlympicMedalEventInfo(this.a, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
    QLog.e("OlympicMedalEventHandler", 1, "handleOnReceiveOlympicMedalEvent");
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return OnlineStatusObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicMedalEventHandler
 * JD-Core Version:    0.7.0.1
 */