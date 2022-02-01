package tencent.im.oidb.cmd0x814;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x814$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "total", "activity_list", "url" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x814.Activity> activity_list = PBField.initRepeatMessage(oidb_0x814.Activity.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x814.oidb_0x814.RspBody
 * JD-Core Version:    0.7.0.1
 */