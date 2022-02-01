package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb14$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "id", "course", "name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, UserInfo.class);
  public final PBStringField course = PBField.initString("");
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb14.oidb_0xb14.UserInfo
 * JD-Core Version:    0.7.0.1
 */