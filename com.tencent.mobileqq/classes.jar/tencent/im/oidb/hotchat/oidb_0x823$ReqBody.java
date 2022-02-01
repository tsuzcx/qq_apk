package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x823$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_req_info", "uint64_group_uin", "uint64_group_code", "msg_kick_visitor" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0x823.KickPublicGroupVisitorReqBody msg_kick_visitor = new oidb_0x823.KickPublicGroupVisitorReqBody();
  public oidb_0x823.PlayerDeviceInfo msg_req_info = new oidb_0x823.PlayerDeviceInfo();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x823.ReqBody
 * JD-Core Version:    0.7.0.1
 */