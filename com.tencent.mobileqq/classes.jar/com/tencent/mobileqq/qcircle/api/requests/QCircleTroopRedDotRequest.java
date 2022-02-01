package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import qqcircle.QQCircleCounter.CountInfoReq;
import qqcircle.QQCircleCounter.CountInfoRsp;

public class QCircleTroopRedDotRequest
  extends QCircleBaseRequest
{
  private QQCircleCounter.CountInfoReq mReq = new QQCircleCounter.CountInfoReq();
  
  public QCircleTroopRedDotRequest(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {
      return;
    }
    Object localObject1 = new StringBuilder(1024);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localObject2 = (String)paramSet.next();
      ((StringBuilder)localObject1).append(',');
      ((StringBuilder)localObject1).append((String)localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((StringBuilder)localObject1).delete(0, 1);
    }
    paramSet = ((StringBuilder)localObject1).toString();
    this.mReq.reqType.set(5);
    localObject1 = new FeedCloudCommon.StCommonExt();
    Object localObject2 = new FeedCloudCommon.Entry();
    ((FeedCloudCommon.Entry)localObject2).key.set("group_uins");
    ((FeedCloudCommon.Entry)localObject2).value.set(paramSet);
    ((FeedCloudCommon.StCommonExt)localObject1).mapInfo.get().add(localObject2);
    this.mReq.extInfo.set((MessageMicro)localObject1);
    this.mReq.reqType.set(5);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleCounter.CountInfoRsp localCountInfoRsp = new QQCircleCounter.CountInfoRsp();
    try
    {
      localCountInfoRsp.mergeFrom(paramArrayOfByte);
      return localCountInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localCountInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlecounter.CircleCounter.GetSimpleCountInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleTroopRedDotRequest
 * JD-Core Version:    0.7.0.1
 */