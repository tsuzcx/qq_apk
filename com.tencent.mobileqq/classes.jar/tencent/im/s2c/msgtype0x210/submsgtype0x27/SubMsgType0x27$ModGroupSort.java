package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x27$ModGroupSort
  extends MessageMicro<ModGroupSort>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_groupsort" }, new Object[] { null }, ModGroupSort.class);
  public final PBRepeatMessageField<SubMsgType0x27.GroupSort> rpt_msg_groupsort = PBField.initRepeatMessage(SubMsgType0x27.GroupSort.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort
 * JD-Core Version:    0.7.0.1
 */