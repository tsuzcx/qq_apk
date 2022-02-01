package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xb69$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xb69.AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69.AppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb69.oidb_0xb69.RspBody
 * JD-Core Version:    0.7.0.1
 */