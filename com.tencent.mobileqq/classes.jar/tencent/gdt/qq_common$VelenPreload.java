package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$VelenPreload
  extends MessageMicro<VelenPreload>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "preload_page", "preload_landing_page", "preload_json_url", "preload_json_key" }, new Object[] { "", "", "", "" }, VelenPreload.class);
  public final PBStringField preload_json_key = PBField.initString("");
  public final PBStringField preload_json_url = PBField.initString("");
  public final PBStringField preload_landing_page = PBField.initString("");
  public final PBRepeatField<String> preload_page = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.VelenPreload
 * JD-Core Version:    0.7.0.1
 */