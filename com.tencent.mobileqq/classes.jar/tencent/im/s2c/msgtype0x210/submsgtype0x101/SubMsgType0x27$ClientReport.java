package tencent.im.s2c.msgtype0x210.submsgtype0x101;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$ClientReport
  extends MessageMicro<ClientReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_service_id", "str_content_id" }, new Object[] { Integer.valueOf(0), "" }, ClientReport.class);
  public final PBStringField str_content_id = PBField.initString("");
  public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.ClientReport
 * JD-Core Version:    0.7.0.1
 */