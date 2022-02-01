package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$GetCircleTabBucketReq
  extends MessageMicro<GetCircleTabBucketReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "userIp", "lbsData" }, new Object[] { "", null }, GetCircleTabBucketReq.class);
  public QQCircleSwitch.LBSData lbsData = new QQCircleSwitch.LBSData();
  public final PBStringField userIp = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetCircleTabBucketReq
 * JD-Core Version:    0.7.0.1
 */