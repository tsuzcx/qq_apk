package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StSimulateData
  extends MessageMicro<StSimulateData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "material_id", "filter_id", "simulate_name", "simulate_schema", "is_show_button" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StSimulateData.class);
  public final PBStringField filter_id = PBField.initString("");
  public final PBUInt32Field is_show_button = PBField.initUInt32(0);
  public final PBStringField material_id = PBField.initString("");
  public final PBStringField simulate_name = PBField.initString("");
  public final PBStringField simulate_schema = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StSimulateData
 * JD-Core Version:    0.7.0.1
 */