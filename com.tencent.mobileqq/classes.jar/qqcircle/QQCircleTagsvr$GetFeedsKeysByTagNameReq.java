package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleTagsvr$GetFeedsKeysByTagNameReq
  extends MessageMicro<GetFeedsKeysByTagNameReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field feedsTime = PBField.initInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBInt64Field num = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "name", "feedsTime", "num" }, new Object[] { null, "", localLong, localLong }, GetFeedsKeysByTagNameReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleTagsvr.GetFeedsKeysByTagNameReq
 * JD-Core Version:    0.7.0.1
 */