package tencent.im.oidb.general_group_notify;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class general_group_notify$ApplyAlliance
  extends MessageMicro<ApplyAlliance>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_apply_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_apply_group_owner_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_apply_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_apply_group_owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_group_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint64_apply_group_code", "bytes_apply_group_name", "uint64_apply_group_owner_uin", "bytes_apply_group_owner_name", "uint64_source_group_uin", "bytes_source_group_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3 }, ApplyAlliance.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.general_group_notify.general_group_notify.ApplyAlliance
 * JD-Core Version:    0.7.0.1
 */