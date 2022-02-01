package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x823$PlayerDeviceInfo
  extends MessageMicro<PlayerDeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_client_type", "uint32_portal" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PlayerDeviceInfo.class);
  public final PBInt32Field int32_client_type = PBField.initInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x823.PlayerDeviceInfo
 * JD-Core Version:    0.7.0.1
 */