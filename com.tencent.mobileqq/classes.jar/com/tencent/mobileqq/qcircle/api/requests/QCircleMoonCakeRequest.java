package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleConfig.GetMooncakeReq;
import qqcircle.QQCircleConfig.GetMooncakeRsp;

public class QCircleMoonCakeRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCircleMoonCakeRequest";
  QQCircleConfig.GetMooncakeReq mReq = new QQCircleConfig.GetMooncakeReq();
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleConfig.GetMooncakeRsp localGetMooncakeRsp = new QQCircleConfig.GetMooncakeRsp();
    try
    {
      localGetMooncakeRsp.mergeFrom(paramArrayOfByte);
      return localGetMooncakeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetMooncakeRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleconfig.CircleConfigService.GetMooncake";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleMoonCakeRequest
 * JD-Core Version:    0.7.0.1
 */