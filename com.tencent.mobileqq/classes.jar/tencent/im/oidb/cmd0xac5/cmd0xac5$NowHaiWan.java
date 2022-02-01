package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xac5$NowHaiWan
  extends MessageMicro<NowHaiWan>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_game_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_room_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58, 66 }, new String[] { "bytes_title", "bytes_url", "uint32_status", "bytes_icon", "uint32_type", "bytes_cover_url", "bytes_game_icon", "bytes_room_title" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, NowHaiWan.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NowHaiWan
 * JD-Core Version:    0.7.0.1
 */