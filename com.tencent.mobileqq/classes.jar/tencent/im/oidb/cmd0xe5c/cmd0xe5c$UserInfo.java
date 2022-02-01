package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe5c$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "username", "uin" }, new Object[] { "", Long.valueOf(0L) }, UserInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField username = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.UserInfo
 * JD-Core Version:    0.7.0.1
 */