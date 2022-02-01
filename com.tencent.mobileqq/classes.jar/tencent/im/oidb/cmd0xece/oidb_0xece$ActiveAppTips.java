package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xece$ActiveAppTips
  extends MessageMicro<ActiveAppTips>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "apps" }, new Object[] { null }, ActiveAppTips.class);
  public final PBRepeatMessageField<oidb_0xece.App> apps = PBField.initRepeatMessage(oidb_0xece.App.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xece.oidb_0xece.ActiveAppTips
 * JD-Core Version:    0.7.0.1
 */