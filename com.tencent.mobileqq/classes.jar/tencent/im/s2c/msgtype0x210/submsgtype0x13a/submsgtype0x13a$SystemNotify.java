package tencent.im.s2c.msgtype0x210.submsgtype0x13a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x13a$SystemNotify
  extends MessageMicro<SystemNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_custom_sound = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_extend_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_admn_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_version_upperlimit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_version_upperlimit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignore_pc_active = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignore_without_content = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64, 74, 80, 88, 98 }, new String[] { "bytes_msg_summary", "uint32_filter_flag", "bytes_extend_content", "uint32_ignore_pc_active", "uint32_filter_version", "uint32_count_flag", "uint32_filter_version_upperlimit_flag", "uint32_filter_version_upperlimit", "bytes_custom_sound", "uint32_admn_flag", "uint32_ignore_without_content", "bytes_msg_title" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, SystemNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.SystemNotify
 * JD-Core Version:    0.7.0.1
 */