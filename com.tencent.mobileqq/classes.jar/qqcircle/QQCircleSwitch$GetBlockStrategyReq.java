package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$GetBlockStrategyReq
  extends MessageMicro<GetBlockStrategyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "uid", "source", "userIp", "lbsData" }, new Object[] { "", Integer.valueOf(1), "", null }, GetBlockStrategyReq.class);
  public QQCircleSwitch.LBSData lbsData = new QQCircleSwitch.LBSData();
  public final PBEnumField source = PBField.initEnum(1);
  public final PBStringField uid = PBField.initString("");
  public final PBStringField userIp = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetBlockStrategyReq
 * JD-Core Version:    0.7.0.1
 */