package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleSwitch.SetCircleSwitchReq;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

public class QCircleSetCircleSwitchRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.SetCircleSwitchReq mReq = new QQCircleSwitch.SetCircleSwitchReq();
  
  public QCircleSetCircleSwitchRequest(String paramString1, String paramString2, String paramString3)
  {
    QQCircleSwitch.StSwitch localStSwitch = new QQCircleSwitch.StSwitch();
    PBStringField localPBStringField = localStSwitch.key;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localPBStringField.set(localStringBuilder.toString());
    localStSwitch.value.set(paramString3);
    this.mReq.sw.set(localStSwitch);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.SetCircleSwitchRsp localSetCircleSwitchRsp = new QQCircleSwitch.SetCircleSwitchRsp();
    try
    {
      localSetCircleSwitchRsp.mergeFrom(paramArrayOfByte);
      return localSetCircleSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetCircleSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetCircleSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest
 * JD-Core Version:    0.7.0.1
 */