package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x26$AppTip
  extends MessageMicro<AppTip>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tooltip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_icon_time_stamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reportid_click = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reportid_show = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tip_info_seq = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint32_tip_info_seq", "bytes_icon", "uint32_icon_time_stamp", "bytes_tooltip", "uint32_reportid_click", "uint32_reportid_show" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, AppTip.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTip
 * JD-Core Version:    0.7.0.1
 */