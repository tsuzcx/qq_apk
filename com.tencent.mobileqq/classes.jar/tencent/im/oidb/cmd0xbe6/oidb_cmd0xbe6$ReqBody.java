package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbe6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_phone_info", "msg_get_channel_info_req", "string_channel_version" }, new Object[] { null, null, "" }, ReqBody.class);
  public oidb_cmd0xbe6.MsgGetChannelInfoReq msg_get_channel_info_req = new oidb_cmd0xbe6.MsgGetChannelInfoReq();
  public oidb_cmd0xbe6.PhoneInfo msg_phone_info = new oidb_cmd0xbe6.PhoneInfo();
  public final PBStringField string_channel_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.ReqBody
 * JD-Core Version:    0.7.0.1
 */