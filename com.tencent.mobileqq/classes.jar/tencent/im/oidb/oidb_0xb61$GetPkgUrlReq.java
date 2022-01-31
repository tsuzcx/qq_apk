package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb61$GetPkgUrlReq
  extends MessageMicro<GetPkgUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "appid", "app_type", "app_version", "platform", "sys_version", "qq_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, GetPkgUrlReq.class);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field app_version = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField qq_version = PBField.initString("");
  public final PBStringField sys_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.GetPkgUrlReq
 * JD-Core Version:    0.7.0.1
 */