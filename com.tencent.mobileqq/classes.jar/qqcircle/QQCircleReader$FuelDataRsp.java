package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleReader$FuelDataRsp
  extends MessageMicro<FuelDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "fuelData" }, new Object[] { null, null }, FuelDataRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleReader.FuelInfo> fuelData = PBField.initRepeatMessage(QQCircleReader.FuelInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleReader.FuelDataRsp
 * JD-Core Version:    0.7.0.1
 */