package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserInfo$PersonalizedLabels
  extends MessageMicro<PersonalizedLabels>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "personal_labels", "same_personal_labels" }, new Object[] { "", "" }, PersonalizedLabels.class);
  public final PBRepeatField<String> personal_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> same_personal_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.PersonalizedLabels
 * JD-Core Version:    0.7.0.1
 */