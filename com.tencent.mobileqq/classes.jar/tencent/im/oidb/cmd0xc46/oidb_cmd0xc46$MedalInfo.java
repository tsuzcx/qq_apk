package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc46$MedalInfo
  extends MessageMicro<MedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_jump = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field medal_id = PBField.initUInt64(0L);
  public final PBBytesField medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_type = PBField.initUInt32(0);
  public final PBBytesField medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64 }, new String[] { "medal_id", "medal_name", "medal_url", "medal_type", "is_jump", "jump_url", "pic_width", "pic_height" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, MedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo
 * JD-Core Version:    0.7.0.1
 */