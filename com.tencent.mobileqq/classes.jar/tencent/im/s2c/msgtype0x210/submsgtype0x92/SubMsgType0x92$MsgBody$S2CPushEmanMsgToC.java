package tencent.im.s2c.msgtype0x210.submsgtype0x92;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x92$MsgBody$S2CPushEmanMsgToC
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "str_xml" }, new Object[] { Long.valueOf(0L), "" }, S2CPushEmanMsgToC.class);
  public final PBStringField str_xml = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody.S2CPushEmanMsgToC
 * JD-Core Version:    0.7.0.1
 */