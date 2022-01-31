package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqconnect$Appinfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48 }, new String[] { "appid", "app_type", "platform", "app_name", "app_key", "app_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, Appinfo.class);
  public final PBStringField app_key = PBField.initString("");
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt32Field app_state = PBField.initUInt32(0);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.Appinfo
 * JD-Core Version:    0.7.0.1
 */