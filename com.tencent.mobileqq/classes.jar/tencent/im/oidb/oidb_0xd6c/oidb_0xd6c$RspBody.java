package tencent.im.oidb.oidb_0xd6c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xd6c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "str_gift_url", "str_custom_url", "str_desc", "str_send_times" }, new Object[] { "", "", "", Integer.valueOf(0) }, RspBody.class);
  public final PBStringField str_custom_url = PBField.initString("");
  public final PBStringField str_desc = PBField.initString("");
  public final PBRepeatField<String> str_gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field str_send_times = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd6c.oidb_0xd6c.RspBody
 * JD-Core Version:    0.7.0.1
 */