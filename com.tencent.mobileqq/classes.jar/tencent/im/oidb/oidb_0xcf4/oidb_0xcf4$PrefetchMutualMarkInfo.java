package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xcf4$PrefetchMutualMarkInfo
  extends MessageMicro<PrefetchMutualMarkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_grade_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
  public final PBEnumField eMutualMarkType = PBField.initEnum(0);
  public final PBUInt32Field uint32_current_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sub_level = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "eMutualMarkType", "uint32_level", "uint32_days", "uint32_current_days", "eMutualMarkNewType", "uint64_sub_level", "bytes_grade_resource_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro }, PrefetchMutualMarkInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */