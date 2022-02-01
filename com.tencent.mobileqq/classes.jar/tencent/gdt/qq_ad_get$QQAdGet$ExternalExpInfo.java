package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGet$ExternalExpInfo
  extends MessageMicro<ExternalExpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "traffic_type", "exp_id" }, new Object[] { Integer.valueOf(0), "" }, ExternalExpInfo.class);
  public final PBRepeatField<String> exp_id = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field traffic_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.ExternalExpInfo
 * JD-Core Version:    0.7.0.1
 */