package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0xc7$RelationalChainInfo
  extends MessageMicro<RelationalChainInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_intimate_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_switch = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mutualmark_alienation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField uint64_type = PBField.initEnum(1);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 8018, 728010, 808010 }, new String[] { "uint64_type", "bytes_attr", "bytes_intimate_info", "bytes_music_switch", "bytes_mutualmark_alienation" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RelationalChainInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo
 * JD-Core Version:    0.7.0.1
 */