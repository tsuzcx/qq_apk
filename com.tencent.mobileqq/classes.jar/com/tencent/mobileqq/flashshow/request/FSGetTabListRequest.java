package com.tencent.mobileqq.flashshow.request;

import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoReqData;

public class FSGetTabListRequest
  extends FSBaseRequest
{
  public final FeedCloudRead.StGetBusiInfoReq mReq = new FeedCloudRead.StGetBusiInfoReq();
  
  public FSGetTabListRequest(FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean)
  {
    QQCircleFeedBase.StBusiInfoReqData localStBusiInfoReqData = new QQCircleFeedBase.StBusiInfoReqData();
    if (paramStGPSV2 != null) {
      localStBusiInfoReqData.gpsInfo.set(paramStGPSV2);
    }
    if ((paramFSFolderBean != null) && (paramFSFolderBean.getLastPageScheme() != null)) {
      localStBusiInfoReqData.entrySchema.set(paramFSFolderBean.getLastPageScheme());
    }
    this.mReq.busiReqData.set(ByteStringMicro.copyFrom(localStBusiInfoReqData.toByteArray()));
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetBusiInfoRsp localStGetBusiInfoRsp = new FeedCloudRead.StGetBusiInfoRsp();
    try
    {
      localStGetBusiInfoRsp.mergeFrom(paramArrayOfByte);
      return localStGetBusiInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetBusiInfoRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetHotBusiInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new FeedCloudRead.StGetBusiInfoReq().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.FSGetTabListRequest
 * JD-Core Version:    0.7.0.1
 */