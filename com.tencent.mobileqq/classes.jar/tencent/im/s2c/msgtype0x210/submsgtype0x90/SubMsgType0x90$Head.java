package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x90$Head
  extends MessageMicro
{
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_cmd" }, new Object[] { Integer.valueOf(0) }, Head.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.Head
 * JD-Core Version:    0.7.0.1
 */