package tencent.im.oidb.cmd0xdc7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdc7$TagInfo
  extends MessageMicro<TagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
  public final PBRepeatField<Long> uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_tag_id", "bytes_tag", "uint32_count", "uint64_uin_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, TagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc7.oidb_0xdc7.TagInfo
 * JD-Core Version:    0.7.0.1
 */