package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$AnonymousGroupMsg
  extends MessageMicro<AnonymousGroupMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_anon_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_anon_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_rank_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_portrait = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3 }, AnonymousGroupMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.AnonymousGroupMsg
 * JD-Core Version:    0.7.0.1
 */