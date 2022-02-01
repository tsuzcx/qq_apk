package com.tencent.mobileqq.flashshow.personal.request;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import java.util.Locale;
import qqcircle.QQCircleFeedBase.StMainPageBusiReqData;

public class FSGetMainPageRequest$Builder
  extends FSBaseRequest.Builder<FSGetMainPageRequest>
{
  private final FeedCloudRead.StGetMainPageReq a = new FeedCloudRead.StGetMainPageReq();
  private final QQCircleFeedBase.StMainPageBusiReqData b = new QQCircleFeedBase.StMainPageBusiReqData();
  
  public FSGetMainPageRequest$Builder(String paramString)
  {
    this.a.userId.set(paramString);
  }
  
  public Builder a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    paramString1 = String.format(Locale.getDefault(), "uin=%s&feedid=%s&createtime=%d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    this.b.reqType.set(paramInt);
    this.b.entrySchema.set(paramString1);
    return this;
  }
  
  public FSGetMainPageRequest a()
  {
    this.a.busiReqData.set(ByteStringMicro.copyFrom(this.b.toByteArray()));
    this.mRealRequest = new FSGetMainPageRequest(this.a, null);
    return (FSGetMainPageRequest)this.mRealRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest.Builder
 * JD-Core Version:    0.7.0.1
 */