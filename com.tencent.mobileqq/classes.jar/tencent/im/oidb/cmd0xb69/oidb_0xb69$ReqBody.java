package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb69$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_id", "client_info", "app_info" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xb69.AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69.AppInfo.class);
  public oidb_0xb69.ClientInfo client_info = new oidb_0xb69.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb69.oidb_0xb69.ReqBody
 * JD-Core Version:    0.7.0.1
 */