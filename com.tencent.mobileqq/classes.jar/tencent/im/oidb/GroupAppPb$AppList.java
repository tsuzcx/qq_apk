package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GroupAppPb$AppList
  extends MessageMicro<AppList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "hash", "infos" }, new Object[] { "", null }, AppList.class);
  public final PBStringField hash = PBField.initString("");
  public final PBRepeatMessageField<GroupAppPb.AppInfo> infos = PBField.initRepeatMessage(GroupAppPb.AppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.GroupAppPb.AppList
 * JD-Core Version:    0.7.0.1
 */