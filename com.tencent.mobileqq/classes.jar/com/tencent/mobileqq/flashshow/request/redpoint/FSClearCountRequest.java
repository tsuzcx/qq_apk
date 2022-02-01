package com.tencent.mobileqq.flashshow.request.redpoint;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.List;
import qflash.QFlashBadge.BadgeTypeInfo;
import qflash.QFlashBadge.ClearBadgeReq;
import qflash.QFlashBadge.ClearBadgeReqInfo;
import qflash.QFlashBadge.ClearBadgeRsp;

public class FSClearCountRequest
  extends FSBaseRequest
{
  private QFlashBadge.ClearBadgeReq mRequest;
  
  public FSClearCountRequest(QFlashBadge.BadgeTypeInfo paramBadgeTypeInfo, int paramInt, long paramLong)
  {
    if (paramBadgeTypeInfo == null) {
      return;
    }
    this.mRequest = new QFlashBadge.ClearBadgeReq();
    QFlashBadge.ClearBadgeReqInfo localClearBadgeReqInfo = new QFlashBadge.ClearBadgeReqInfo();
    localClearBadgeReqInfo.typeInfo.set(paramBadgeTypeInfo);
    localClearBadgeReqInfo.clearType.set(paramInt);
    localClearBadgeReqInfo.rewriteClearTime.set(paramLong);
    paramBadgeTypeInfo = new ArrayList(1);
    paramBadgeTypeInfo.add(localClearBadgeReqInfo);
    this.mRequest.clearReqInfo.set(paramBadgeTypeInfo);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QFlashBadge.ClearBadgeRsp localClearBadgeRsp = new QFlashBadge.ClearBadgeRsp();
    try
    {
      localClearBadgeRsp.mergeFrom(paramArrayOfByte);
      return localClearBadgeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localClearBadgeRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.ClearBadge";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.redpoint.FSClearCountRequest
 * JD-Core Version:    0.7.0.1
 */