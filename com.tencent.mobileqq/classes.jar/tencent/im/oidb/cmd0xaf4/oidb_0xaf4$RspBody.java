package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xaf4$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_id", "infos", "extra_info" }, new Object[] { Long.valueOf(0L), null, null }, RspBody.class);
  public oidb_0xaf4.ExtraInfo extra_info = new oidb_0xaf4.ExtraInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField infos = PBField.initRepeatMessage(oidb_0xaf4.AppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody
 * JD-Core Version:    0.7.0.1
 */