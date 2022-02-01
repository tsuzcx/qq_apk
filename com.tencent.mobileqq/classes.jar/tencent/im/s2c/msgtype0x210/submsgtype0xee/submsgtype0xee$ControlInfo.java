package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xee$ControlInfo
  extends MessageMicro<ControlInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_comment_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_font_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_line = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_comment_length", "uint32_show_line", "uint32_font_size" }, new Object[] { localInteger, localInteger, localInteger }, ControlInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ControlInfo
 * JD-Core Version:    0.7.0.1
 */