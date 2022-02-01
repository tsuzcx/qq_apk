package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$OnlineDoc_MsgBody
  extends MessageMicro<OnlineDoc_MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_OnlineDocCmd", "msg_pushChangeTitleMessage", "msg_pushNewPadMessage", "msg_pushPreviewToEdit" }, new Object[] { Integer.valueOf(0), null, null, null }, OnlineDoc_MsgBody.class);
  public SubMsgType0xaa.OnlineDoc_PushChangeTitleMessage msg_pushChangeTitleMessage = new SubMsgType0xaa.OnlineDoc_PushChangeTitleMessage();
  public SubMsgType0xaa.OnlineDoc_PushNewPadMessage msg_pushNewPadMessage = new SubMsgType0xaa.OnlineDoc_PushNewPadMessage();
  public SubMsgType0xaa.OnlineDoc_PushPreviewToEditMessage msg_pushPreviewToEdit = new SubMsgType0xaa.OnlineDoc_PushPreviewToEditMessage();
  public final PBUInt32Field uint32_OnlineDocCmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.OnlineDoc_MsgBody
 * JD-Core Version:    0.7.0.1
 */