package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa28$Profile
  extends MessageMicro<Profile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_game_level = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_game_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_bg_url = PBField.initString("");
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "bytes_game_nick", "bytes_qq_nick", "uint32_gender", "bytes_game_level", "bytes_common_info", "str_bg_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, "" }, Profile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.Profile
 * JD-Core Version:    0.7.0.1
 */