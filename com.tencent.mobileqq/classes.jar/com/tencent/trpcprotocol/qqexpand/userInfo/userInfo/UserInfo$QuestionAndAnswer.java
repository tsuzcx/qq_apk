package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserInfo$QuestionAndAnswer
  extends MessageMicro<QuestionAndAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "id", "question", "answer" }, new Object[] { "", "", "" }, QuestionAndAnswer.class);
  public final PBStringField answer = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField question = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.QuestionAndAnswer
 * JD-Core Version:    0.7.0.1
 */