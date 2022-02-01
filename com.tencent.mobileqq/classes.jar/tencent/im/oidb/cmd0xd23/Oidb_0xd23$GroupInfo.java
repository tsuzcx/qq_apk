package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd23$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_code", "group_name" }, new Object[] { Long.valueOf(0L), "" }, GroupInfo.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBStringField group_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd23.Oidb_0xd23.GroupInfo
 * JD-Core Version:    0.7.0.1
 */