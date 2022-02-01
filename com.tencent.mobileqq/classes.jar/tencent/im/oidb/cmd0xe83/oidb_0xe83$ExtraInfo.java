package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe83$ExtraInfo
  extends MessageMicro<ExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tab_infos" }, new Object[] { null }, ExtraInfo.class);
  public final PBRepeatMessageField<oidb_0xe83.TabInfo> tab_infos = PBField.initRepeatMessage(oidb_0xe83.TabInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */