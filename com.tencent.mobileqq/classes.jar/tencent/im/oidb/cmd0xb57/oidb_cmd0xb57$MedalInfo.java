package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb57$MedalInfo
  extends MessageMicro<MedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_jump = PBField.initUInt32(0);
  public final PBUInt32Field uint32_medal_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_medal_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64 }, new String[] { "uint64_medal_id", "bytes_medal_name", "bytes_medal_url", "uint32_medal_type", "uint32_is_jump", "bytes_jump_url", "uint32_pic_width", "uint32_pic_height" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, localInteger, localInteger }, MedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo
 * JD-Core Version:    0.7.0.1
 */