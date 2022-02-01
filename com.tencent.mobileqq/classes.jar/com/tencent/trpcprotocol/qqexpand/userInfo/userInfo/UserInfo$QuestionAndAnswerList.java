package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserInfo$QuestionAndAnswerList
  extends MessageMicro<QuestionAndAnswerList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "question_and_answer" }, new Object[] { null }, QuestionAndAnswerList.class);
  public final PBRepeatMessageField<UserInfo.QuestionAndAnswer> question_and_answer = PBField.initRepeatMessage(UserInfo.QuestionAndAnswer.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.QuestionAndAnswerList
 * JD-Core Version:    0.7.0.1
 */