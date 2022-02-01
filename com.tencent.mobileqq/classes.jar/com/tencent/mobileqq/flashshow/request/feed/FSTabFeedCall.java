package com.tencent.mobileqq.flashshow.request.feed;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSColdBootReqInterceptor;
import com.tencent.mobileqq.flashshow.sender.FSRequestSender;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSTabFeedCall
{
  private String a;
  
  public static FSTabFeedCall.Param a()
  {
    return new FSTabFeedCall.Param();
  }
  
  private void a(String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, FSTabFeedCall.Param paramParam)
  {
    QLog.d("FSTabFeedCall", 1, "hitSuccessHandler");
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    paramString = paramStGetFeedListRsp.vecFeed.get();
    this.a = paramStGetFeedListRsp.feedAttchInfo.get();
    FSThreadUtils.d(new FSTabFeedCall.1(this, paramString, bool, paramParam, paramStGetFeedListRsp));
    b(paramStGetFeedListRsp, paramParam);
  }
  
  private boolean a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, FSTabFeedCall.Param paramParam)
  {
    paramStGetFeedListRsp = paramStGetFeedListRsp.vecFeed.get();
    if ((paramStGetFeedListRsp != null) && (paramStGetFeedListRsp.size() != 0)) {
      return false;
    }
    QLog.d("FSTabFeedCall", 1, "hitEmptyHandler");
    FSTabFeedCall.Param.d(paramParam).a(UIStateData.a().b(FSTabFeedCall.Param.c(paramParam)).c(true));
    return true;
  }
  
  private boolean a(boolean paramBoolean, String paramString, FSTabFeedCall.Param paramParam)
  {
    if (!paramBoolean)
    {
      QLog.d("FSTabFeedCall", 1, "hitErrorHandler");
      FSTabFeedCall.Param.d(paramParam).a(UIStateData.a(paramString).b(FSTabFeedCall.Param.c(paramParam)));
      return true;
    }
    return false;
  }
  
  private void b(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, @NonNull FSTabFeedCall.Param paramParam)
  {
    if (paramStGetFeedListRsp != null)
    {
      if (!paramStGetFeedListRsp.busiRspData.has()) {
        return;
      }
      try
      {
        QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
        localStFeedListBusiRspData.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (localStFeedListBusiRspData.rspTimestamp.has())
        {
          if (FSTabFeedCall.Param.b(paramParam) == 1)
          {
            if (FSTabFeedCall.Param.a(paramParam) == null) {
              return;
            }
            if (FSTabFeedCall.Param.a(paramParam).a == null) {
              return;
            }
            FSEeveeRedPointHelper.getInstance().saveLastPreTabRedPointTimestamp(FSTabFeedCall.Param.a(paramParam).a.sourceType.get(), localStFeedListBusiRspData.rspTimestamp.get());
            paramStGetFeedListRsp = new StringBuilder();
            paramStGetFeedListRsp.append("[requestFeedsData] preload response: ");
            paramStGetFeedListRsp.append(", followTabFeedListLastPreRspTimestamp: ");
            paramStGetFeedListRsp.append(localStFeedListBusiRspData.rspTimestamp.get());
            paramStGetFeedListRsp.append(", followTabFeedListLastRspTimestamp: ");
            QLog.d("FSTabFeedCall", 1, new Object[] { paramStGetFeedListRsp });
            return;
          }
          FSEeveeRedPointHelper.getInstance().saveLastRspTabRedPointTimestamp(FSTabFeedCall.Param.a(paramParam).a.sourceType.get(), localStFeedListBusiRspData.rspTimestamp.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        paramStGetFeedListRsp.printStackTrace();
      }
    }
    else {}
  }
  
  public void a(@NonNull FSTabFeedCall.Param paramParam)
  {
    FSTabFeedRequest.Builder localBuilder = new FSTabFeedRequest.Builder(FSTabFeedCall.Param.a(paramParam), FSTabFeedCall.Param.b(paramParam));
    if (FSTabFeedCall.Param.c(paramParam))
    {
      String str = this.a;
      if (str != null) {
        localBuilder.a(str);
      } else {
        QLog.e("FSTabFeedCall", 1, "load more request feed input invalid attachInfo!");
      }
    }
    else
    {
      this.a = null;
    }
    FSTabFeedCall.Param.d(paramParam).a(UIStateData.b());
    FSRequestSender.a().b().a(new FSColdBootReqInterceptor()).a(new FSTabFeedCall.FSTabRequestRspInterceptor(this, paramParam)).a(localBuilder.a()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall
 * JD-Core Version:    0.7.0.1
 */