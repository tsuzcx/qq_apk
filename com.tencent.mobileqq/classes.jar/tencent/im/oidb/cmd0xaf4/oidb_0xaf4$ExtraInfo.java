package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xaf4$ExtraInfo
  extends MessageMicro<ExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tab_infos" }, new Object[] { null }, ExtraInfo.class);
  public final PBRepeatMessageField<oidb_0xaf4.TabInfo> tab_infos = PBField.initRepeatMessage(oidb_0xaf4.TabInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */