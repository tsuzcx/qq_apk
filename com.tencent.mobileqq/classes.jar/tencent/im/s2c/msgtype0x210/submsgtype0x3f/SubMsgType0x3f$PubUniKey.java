package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x3f$PubUniKey
  extends MessageMicro<PubUniKey>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_fromPubUin", "uint64_qwMsgId" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PubUniKey.class);
  public final PBUInt64Field uint64_fromPubUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qwMsgId = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3f.SubMsgType0x3f.PubUniKey
 * JD-Core Version:    0.7.0.1
 */