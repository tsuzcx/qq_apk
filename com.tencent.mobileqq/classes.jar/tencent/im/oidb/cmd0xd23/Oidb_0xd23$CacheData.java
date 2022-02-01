package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0xd23$CacheData
  extends MessageMicro<CacheData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_app_info" }, new Object[] { null }, CacheData.class);
  public final PBRepeatMessageField<Oidb_0xd23.AppInfo> rpt_app_info = PBField.initRepeatMessage(Oidb_0xd23.AppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd23.Oidb_0xd23.CacheData
 * JD-Core Version:    0.7.0.1
 */