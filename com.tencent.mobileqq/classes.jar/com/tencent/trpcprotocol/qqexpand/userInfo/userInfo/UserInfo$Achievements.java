package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserInfo$Achievements
  extends MessageMicro<Achievements>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42 }, new String[] { "id", "title", "icon", "content" }, new Object[] { "", "", "", "" }, Achievements.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.Achievements
 * JD-Core Version:    0.7.0.1
 */