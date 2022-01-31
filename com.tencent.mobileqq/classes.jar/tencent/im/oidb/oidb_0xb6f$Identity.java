package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xb6f$Identity
  extends MessageMicro<Identity>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 80, 162 }, new String[] { "apiName", "appid", "apptype", "bizid", "int_ext1", "str_ext1" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, Identity.class);
  public final PBStringField apiName = PBField.initString("");
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBInt32Field apptype = PBField.initInt32(0);
  public final PBInt32Field bizid = PBField.initInt32(0);
  public final PBInt64Field int_ext1 = PBField.initInt64(0L);
  public final PBStringField str_ext1 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.Identity
 * JD-Core Version:    0.7.0.1
 */