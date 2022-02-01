package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleReader$FuelListReq
  extends MessageMicro<FuelListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "userId", "reqFrom", "num", "ext" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "" }, FuelListReq.class);
  public final PBStringField ext = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field reqFrom = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleReader.FuelListReq
 * JD-Core Version:    0.7.0.1
 */