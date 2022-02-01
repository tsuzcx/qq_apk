package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x28$RspTypeList
  extends MessageMicro<RspTypeList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_typelist" }, new Object[] { null }, RspTypeList.class);
  public final PBRepeatMessageField<SubMsgType0x28.TypeList> rpt_msg_typelist = PBField.initRepeatMessage(SubMsgType0x28.TypeList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList
 * JD-Core Version:    0.7.0.1
 */