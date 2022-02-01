package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$OCRInfo
  extends MessageMicro<OCRInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBFloatField mobiles_dependLevel = PBField.initFloat(0.0F);
  public final PBStringField name = PBField.initString("");
  public final PBFloatField name_dependLevel = PBField.initFloat(0.0F);
  public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBFloatField uins_dependLevel = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 37, 45, 53 }, new String[] { "name", "uins", "mobiles", "name_dependLevel", "uins_dependLevel", "mobiles_dependLevel" }, new Object[] { "", Long.valueOf(0L), "", localFloat, localFloat, localFloat }, OCRInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.OCRInfo
 * JD-Core Version:    0.7.0.1
 */