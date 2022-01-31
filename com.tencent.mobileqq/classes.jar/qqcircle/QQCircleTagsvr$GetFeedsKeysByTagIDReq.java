package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleTagsvr$GetFeedsKeysByTagIDReq
  extends MessageMicro<GetFeedsKeysByTagIDReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "id", "feedsTime", "num" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L) }, GetFeedsKeysByTagIDReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field feedsTime = PBField.initInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBInt64Field num = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleTagsvr.GetFeedsKeysByTagIDReq
 * JD-Core Version:    0.7.0.1
 */