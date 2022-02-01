package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$RichMsg
  extends MessageMicro<RichMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "service_id", "xml", "long_msg_resid" }, new Object[] { Integer.valueOf(0), "", "" }, RichMsg.class);
  public final PBStringField long_msg_resid = PBField.initString("");
  public final PBUInt32Field service_id = PBField.initUInt32(0);
  public final PBStringField xml = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.RichMsg
 * JD-Core Version:    0.7.0.1
 */