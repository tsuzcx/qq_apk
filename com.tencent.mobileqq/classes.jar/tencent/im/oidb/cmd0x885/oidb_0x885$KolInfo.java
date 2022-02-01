package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x885$KolInfo
  extends MessageMicro<KolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_is_kol", "string_koldid" }, new Object[] { Integer.valueOf(0), "" }, KolInfo.class);
  public final PBInt32Field int32_is_kol = PBField.initInt32(0);
  public final PBStringField string_koldid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.KolInfo
 * JD-Core Version:    0.7.0.1
 */