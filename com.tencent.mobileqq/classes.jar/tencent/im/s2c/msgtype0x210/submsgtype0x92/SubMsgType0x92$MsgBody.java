package tencent.im.s2c.msgtype0x210.submsgtype0x92;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x92$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 802 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_Push_Eman_Msg" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public SubMsgType0x92.MsgBody.S2CPushEmanMsgToC msg_Push_Eman_Msg = new SubMsgType0x92.MsgBody.S2CPushEmanMsgToC();
  public SubMsgType0x92.CrmS2CMsgHead msg_crm_common_head = new SubMsgType0x92.CrmS2CMsgHead();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody
 * JD-Core Version:    0.7.0.1
 */