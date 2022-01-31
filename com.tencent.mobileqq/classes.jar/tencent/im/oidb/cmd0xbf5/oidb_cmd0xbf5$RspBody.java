package tencent.im.oidb.cmd0xbf5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_notification", "str_avatar" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_avatar = PBField.initString("");
  public final PBUInt32Field uint32_notification = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbf5.oidb_cmd0xbf5.RspBody
 * JD-Core Version:    0.7.0.1
 */