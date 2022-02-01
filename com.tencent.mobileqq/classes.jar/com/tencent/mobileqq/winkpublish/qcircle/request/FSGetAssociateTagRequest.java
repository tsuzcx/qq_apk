package com.tencent.mobileqq.winkpublish.qcircle.request;

import circlesearch.CircleSearchExhibition.StMoreDataReq;
import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudCommon.StCommonExt;

public class FSGetAssociateTagRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCircleGetAssociateTagRequest";
  private CircleSearchExhibition.StMoreDataReq mReq = new CircleSearchExhibition.StMoreDataReq();
  
  public FSGetAssociateTagRequest(FeedCloudCommon.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.mReq.ext_info.set(paramStCommonExt);
    }
    this.mReq.query.set(paramString);
    this.mReq.type.set(9);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CircleSearchExhibition.StMoreDataRsp localStMoreDataRsp = new CircleSearchExhibition.StMoreDataRsp();
    try
    {
      localStMoreDataRsp.mergeFrom(paramArrayOfByte);
      return localStMoreDataRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStMoreDataRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.ExhibitionMoreData";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public CircleSearchExhibition.StMoreDataReq getmReq()
  {
    return this.mReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.qcircle.request.FSGetAssociateTagRequest
 * JD-Core Version:    0.7.0.1
 */