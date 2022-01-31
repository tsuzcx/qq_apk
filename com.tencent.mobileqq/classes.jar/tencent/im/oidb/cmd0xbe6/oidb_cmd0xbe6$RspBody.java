package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbe6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_channel_info_rsp", "string_channel_version" }, new Object[] { null, "" }, RspBody.class);
  public oidb_cmd0xbe6.MsgGetChannelInfoRsp msg_get_channel_info_rsp = new oidb_cmd0xbe6.MsgGetChannelInfoRsp();
  public final PBStringField string_channel_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.RspBody
 * JD-Core Version:    0.7.0.1
 */