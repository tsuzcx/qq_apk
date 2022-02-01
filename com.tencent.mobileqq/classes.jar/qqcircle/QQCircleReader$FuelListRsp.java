package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleReader$FuelListRsp
  extends MessageMicro<FuelListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "fuelRecords", "isFinish", "ext" }, new Object[] { null, null, Integer.valueOf(0), "" }, FuelListRsp.class);
  public final PBStringField ext = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleReader.FuelListRecord> fuelRecords = PBField.initRepeatMessage(QQCircleReader.FuelListRecord.class);
  public final PBInt32Field isFinish = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleReader.FuelListRsp
 * JD-Core Version:    0.7.0.1
 */