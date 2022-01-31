package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$MobRouteSSOListInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "string_ip", "uint32_port" }, new Object[] { "", Integer.valueOf(0) }, MobRouteSSOListInfo.class);
  public final PBStringField string_ip = PBField.initString("");
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.mobileqq.mobroute.DomainIp.MobRouteSSOListInfo
 * JD-Core Version:    0.7.0.1
 */