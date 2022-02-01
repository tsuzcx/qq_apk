package tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mutualmark$ResourceInfo
  extends MessageMicro<ResourceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cartoon_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cartoon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_dynamic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_static_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_play_cartoon = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "bytes_dynamic_url", "bytes_static_url", "bytes_cartoon_url", "bytes_cartoon_md5", "uint32_play_cartoon", "bytes_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, ResourceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo
 * JD-Core Version:    0.7.0.1
 */