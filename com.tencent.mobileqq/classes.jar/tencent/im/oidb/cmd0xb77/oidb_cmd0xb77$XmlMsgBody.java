package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb77$XmlMsgBody
  extends MessageMicro<XmlMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98 }, new String[] { "service_id", "xml" }, new Object[] { Integer.valueOf(0), "" }, XmlMsgBody.class);
  public final PBUInt32Field service_id = PBField.initUInt32(0);
  public final PBStringField xml = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.XmlMsgBody
 * JD-Core Version:    0.7.0.1
 */