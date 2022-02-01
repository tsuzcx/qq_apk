package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$Ipv6Info
  extends MessageMicro<Ipv6Info>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ip_v6_addr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ip_v6_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_ip_v6_addr", "uint32_ip_v6_port", "uint32_is_https_addr" }, new Object[] { localByteStringMicro, localInteger, localInteger }, Ipv6Info.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.Ipv6Info
 * JD-Core Version:    0.7.0.1
 */