package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class C2CType0x211_SubC2CType0x8$IPAddrInfo
  extends MessageMicro<IPAddrInfo>
{
  public static final int INT32_GATEWAY_FIELD_NUMBER = 3;
  public static final int INT32_IP_FIELD_NUMBER = 1;
  public static final int INT32_MASK_FIELD_NUMBER = 2;
  public static final int INT32_PORT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_ip", "int32_mask", "int32_gateway", "int32_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IPAddrInfo.class);
  public final PBInt32Field int32_gateway = PBField.initInt32(0);
  public final PBInt32Field int32_ip = PBField.initInt32(0);
  public final PBInt32Field int32_mask = PBField.initInt32(0);
  public final PBInt32Field int32_port = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.IPAddrInfo
 * JD-Core Version:    0.7.0.1
 */