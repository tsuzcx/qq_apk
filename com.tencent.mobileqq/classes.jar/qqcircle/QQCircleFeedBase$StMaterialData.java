package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StMaterialData
  extends MessageMicro<StMaterialData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "material_id", "material_type", "interactive_type", "simulate_date", "kuolie_data" }, new Object[] { "", "", Integer.valueOf(0), null, null }, StMaterialData.class);
  public final PBUInt32Field interactive_type = PBField.initUInt32(0);
  public QQCircleFeedBase.StKuoliePasterData kuolie_data = new QQCircleFeedBase.StKuoliePasterData();
  public final PBStringField material_id = PBField.initString("");
  public final PBStringField material_type = PBField.initString("");
  public QQCircleFeedBase.StSimulateData simulate_date = new QQCircleFeedBase.StSimulateData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMaterialData
 * JD-Core Version:    0.7.0.1
 */