package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleSwitch.GetCircleSwitchReq;
import qqcircle.QQCircleSwitch.GetCircleSwitchRsp;

public class QCircleGetCircleSwitchRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.GetCircleSwitchReq mReq = new QQCircleSwitch.GetCircleSwitchReq();
  
  public QCircleGetCircleSwitchRequest(String paramString1, String paramString2)
  {
    PBStringField localPBStringField = this.mReq.switchKey;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localPBStringField.set(localStringBuilder.toString());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.GetCircleSwitchRsp localGetCircleSwitchRsp = new QQCircleSwitch.GetCircleSwitchRsp();
    try
    {
      localGetCircleSwitchRsp.mergeFrom(paramArrayOfByte);
      return localGetCircleSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetCircleSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.GetCircleSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleGetCircleSwitchRequest
 * JD-Core Version:    0.7.0.1
 */