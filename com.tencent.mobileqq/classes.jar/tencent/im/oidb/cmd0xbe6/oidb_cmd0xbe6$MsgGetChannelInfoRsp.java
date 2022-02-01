package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbe6$MsgGetChannelInfoRsp
  extends MessageMicro<MsgGetChannelInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_channel_info" }, new Object[] { null }, MsgGetChannelInfoRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xbe6.MsgChannelInfo> rpt_msg_channel_info = PBField.initRepeatMessage(oidb_cmd0xbe6.MsgChannelInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgGetChannelInfoRsp
 * JD-Core Version:    0.7.0.1
 */