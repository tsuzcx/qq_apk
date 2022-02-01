package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserInfo$BaseInfo
  extends MessageMicro<BaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField age_group = PBField.initString("");
  public UserInfo.Birthday birthday = new UserInfo.Birthday();
  public final PBStringField city = PBField.initString("");
  public final PBStringField constellation = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public UserInfo.LocationInfo location = new UserInfo.LocationInfo();
  public final PBStringField nick = PBField.initString("");
  public UserInfo.Birthday self_birthday = new UserInfo.Birthday();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58, 66, 74 }, new String[] { "nick", "age", "constellation", "gender", "birthday", "self_birthday", "age_group", "city", "location" }, new Object[] { "", localInteger, "", localInteger, null, null, "", "", null }, BaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.BaseInfo
 * JD-Core Version:    0.7.0.1
 */