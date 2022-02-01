package tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark$MutualmarkInfo
  extends MessageMicro<MutualmarkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_duplicate_removal_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_grade_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wildcard_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_continue_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_graytip_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_icon_status = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_icon_status_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_change_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_level = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 106, 8002 }, new String[] { "uint64_last_action_time", "uint32_level", "uint64_last_change_time", "uint32_continue_days", "bytes_wildcard_wording", "uint64_notify_time", "uint64_icon_status", "uint64_icon_status_end_time", "uint32_close_flag", "bytes_resource_info", "uint32_graytip_type", "uint64_sub_level", "bytes_grade_resource_info", "bytes_duplicate_removal_key" }, new Object[] { localLong, localInteger, localLong, localInteger, localByteStringMicro1, localLong, localLong, localLong, localInteger, localByteStringMicro2, localInteger, localLong, localByteStringMicro3, localByteStringMicro4 }, MutualmarkInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo
 * JD-Core Version:    0.7.0.1
 */