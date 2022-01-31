package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xee$ControlInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_comment_length", "uint32_show_line", "uint32_font_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ControlInfo.class);
  public final PBUInt32Field uint32_comment_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_line = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ControlInfo
 * JD-Core Version:    0.7.0.1
 */