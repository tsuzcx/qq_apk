package tencent.im.oidb.cmd0xc15;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc15$Sender
  extends MessageMicro<Sender>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_avatar_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_avatar_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sender_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_author = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_avatar_url", "bytes_sender_name", "bytes_avatar_icon_url", "uint32_is_author" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, Sender.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc15.oidb_0xc15.Sender
 * JD-Core Version:    0.7.0.1
 */