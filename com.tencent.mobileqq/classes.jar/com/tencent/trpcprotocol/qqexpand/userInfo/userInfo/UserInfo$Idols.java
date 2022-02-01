package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserInfo$Idols
  extends MessageMicro<Idols>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> alias = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field idol_id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField pic = PBField.initString("");
  public final PBUInt32Field rank = PBField.initUInt32(0);
  public final PBUInt64Field score = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64, 72 }, new String[] { "name", "alias", "avatar", "desc", "gender", "idol_id", "pic", "score", "rank" }, new Object[] { "", "", "", "", localInteger, localInteger, "", Long.valueOf(0L), localInteger }, Idols.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.Idols
 * JD-Core Version:    0.7.0.1
 */