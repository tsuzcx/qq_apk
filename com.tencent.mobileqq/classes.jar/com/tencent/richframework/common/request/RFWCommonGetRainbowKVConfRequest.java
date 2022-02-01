package com.tencent.richframework.common.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleConfig.GetRainbowKVConfReq;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

public class RFWCommonGetRainbowKVConfRequest
  extends QCircleBaseRequest
{
  private QQCircleConfig.GetRainbowKVConfReq mRequest = new QQCircleConfig.GetRainbowKVConfReq();
  
  public RFWCommonGetRainbowKVConfRequest(String paramString1, String paramString2, String paramString3)
  {
    this.mRequest.appId.set(paramString1);
    this.mRequest.group.set(paramString2);
    this.mRequest.key.set(paramString3);
    this.mRequest.cookie.set("");
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleConfig.GetRainbowKVConfRsp localGetRainbowKVConfRsp = new QQCircleConfig.GetRainbowKVConfRsp();
    try
    {
      localGetRainbowKVConfRsp.mergeFrom(paramArrayOfByte);
      return localGetRainbowKVConfRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetRainbowKVConfRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleconfig.CircleConfigService.GetRainbowKVConfig";
  }
  
  public QQCircleConfig.GetRainbowKVConfReq getReq()
  {
    return this.mRequest;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.request.RFWCommonGetRainbowKVConfRequest
 * JD-Core Version:    0.7.0.1
 */