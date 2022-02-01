package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$Ipv4Info
  extends MessageMicro<Ipv4Info>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_ip_v4_addr", "uint32_ip_v4_port", "uint32_is_https_addr" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Ipv4Info.class);
  public final PBUInt32Field uint32_ip_v4_addr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ip_v4_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.Ipv4Info
 * JD-Core Version:    0.7.0.1
 */