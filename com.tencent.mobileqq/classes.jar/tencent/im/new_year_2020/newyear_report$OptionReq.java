package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class newyear_report$OptionReq
  extends MessageMicro<OptionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82 }, new String[] { "fingerprint", "model", "manufacturer", "brand", "device", "product", "id", "level", "cpu_abi", "cpu_abi2" }, new Object[] { "", "", "", "", "", "", "", Integer.valueOf(0), "", "" }, OptionReq.class);
  public final PBStringField brand = PBField.initString("");
  public final PBStringField cpu_abi = PBField.initString("");
  public final PBStringField cpu_abi2 = PBField.initString("");
  public final PBStringField device = PBField.initString("");
  public final PBStringField fingerprint = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBStringField product = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report.OptionReq
 * JD-Core Version:    0.7.0.1
 */