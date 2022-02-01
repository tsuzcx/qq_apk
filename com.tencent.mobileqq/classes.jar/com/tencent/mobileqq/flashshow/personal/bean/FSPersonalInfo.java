package com.tencent.mobileqq.flashshow.personal.bean;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSJsUrlUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class FSPersonalInfo
{
  public FeedCloudMeta.StUser a;
  public QQCircleBase.StUserBusiData b;
  public String c = "";
  public int d = 0;
  public int e;
  public int f;
  public int g = 0;
  public int h;
  public String i = "";
  public String j = "";
  public boolean k = false;
  
  private FSPersonalInfo(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    a(paramStGetMainPageRsp.user);
    this.e = paramStGetMainPageRsp.fansCount.get();
    this.f = paramStGetMainPageRsp.followCount.get();
    this.h = paramStGetMainPageRsp.likedFeedCount.get();
    QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
    try
    {
      localStMainPageBusiRspData.mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
      a(localStMainPageBusiRspData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStGetMainPageRsp)
    {
      QLog.e("FSPersonalInfo", 1, "mergeFrom StMainPageBusiRspData error");
      paramStGetMainPageRsp.printStackTrace();
    }
  }
  
  public static FSPersonalInfo a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    return new FSPersonalInfo(paramStGetMainPageRsp);
  }
  
  private void a()
  {
    if (FSCommonUtil.d())
    {
      if (!RFApplication.isDebug())
      {
        QLog.w("FSPersonalInfo", 1, "StUser mergeFrom StUserBusiData in MainThread");
        return;
      }
      throw new RuntimeException("StUser mergeFrom StUserBusiData in MainThread");
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null) {
      return;
    }
    this.a = paramStUser;
    this.c = this.a.id.get();
    this.d = this.a.followState.get();
    if ((this.a.busiData.has()) && (this.a.busiData.get() != null))
    {
      paramStUser = new QQCircleBase.StUserBusiData();
      try
      {
        a();
        paramStUser.mergeFrom(this.a.busiData.get().toByteArray());
        this.b = paramStUser;
        this.g = this.b.feedNum.get();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramStUser)
      {
        QLog.e("FSPersonalInfo", 1, "mergeFrom StUserBusiData error");
        paramStUser.printStackTrace();
      }
    }
  }
  
  private void a(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    paramStMainPageBusiRspData = paramStMainPageBusiRspData.urlInfo.get();
    this.i = FSJsUrlUtils.a(paramStMainPageBusiRspData, "followListUrl");
    this.j = FSJsUrlUtils.a(paramStMainPageBusiRspData, "fansListUrl");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (FSPersonalInfo)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo
 * JD-Core Version:    0.7.0.1
 */