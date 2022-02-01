package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xdc0$LocationList
  extends MessageMicro<LocationList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_group_list" }, new Object[] { null }, LocationList.class);
  public final PBRepeatMessageField<oidb_0xdc0.GroupInfo> rpt_group_list = PBField.initRepeatMessage(oidb_0xdc0.GroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationList
 * JD-Core Version:    0.7.0.1
 */