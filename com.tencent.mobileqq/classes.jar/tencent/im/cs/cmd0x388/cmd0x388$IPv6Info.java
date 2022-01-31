package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$IPv6Info
  extends MessageMicro<IPv6Info>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_ip6", "uint32_port" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, IPv6Info.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.IPv6Info
 * JD-Core Version:    0.7.0.1
 */