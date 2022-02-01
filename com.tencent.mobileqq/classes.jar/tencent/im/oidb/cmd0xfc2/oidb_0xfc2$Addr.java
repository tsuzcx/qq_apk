package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xfc2$Addr
  extends MessageMicro<Addr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_ip = PBField.initString("");
  public final PBUInt32Field uint32_http_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_https_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_ip", "uint32_http_port", "uint32_https_port" }, new Object[] { "", localInteger, localInteger }, Addr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr
 * JD-Core Version:    0.7.0.1
 */