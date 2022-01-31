package tencent.im.s2c.msgtype0x210.submsgtype0x89;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x89$NumRedBusiInfo
  extends MessageMicro<NumRedBusiInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66, 74, 82, 88, 96, 104, 112 }, new String[] { "str_client_ver_begin", "str_client_ver_end", "uint32_plat_id", "uint32_app_id", "uint32_android_app_id", "uint32_ios_app_id", "str_path", "str_android_path", "str_ios_path", "str_missionid", "uint64_msgid", "uint32_status", "uint32_expire_time", "int32_appset" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NumRedBusiInfo.class);
  public final PBInt32Field int32_appset = PBField.initInt32(0);
  public final PBStringField str_android_path = PBField.initString("");
  public final PBStringField str_client_ver_begin = PBField.initString("");
  public final PBStringField str_client_ver_end = PBField.initString("");
  public final PBStringField str_ios_path = PBField.initString("");
  public final PBStringField str_missionid = PBField.initString("");
  public final PBStringField str_path = PBField.initString("");
  public final PBUInt32Field uint32_android_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ios_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msgid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo
 * JD-Core Version:    0.7.0.1
 */