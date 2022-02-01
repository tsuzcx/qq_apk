package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xcf4$MutualMarkInfo
  extends MessageMicro<MutualMarkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_grade_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_max_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_min_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
  public final PBEnumField eMutualMarkType = PBField.initEnum(0);
  public oidb_0xcf4.SpecialWordInfo msg_special_word_info = new oidb_0xcf4.SpecialWordInfo();
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sub_level = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 1602, 1610 }, new String[] { "eMutualMarkType", "uint32_level", "uint32_days", "eMutualMarkNewType", "msg_special_word_info", "uint64_sub_level", "bytes_grade_resource_info", "bytes_min_ver", "bytes_max_ver" }, new Object[] { localInteger, localInteger, localInteger, Integer.valueOf(1), null, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, MutualMarkInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */