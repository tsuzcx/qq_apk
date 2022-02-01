package com.tencent.mobileqq.education.request.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SearchAnswer$SearchAnswerRsp
  extends MessageMicro<SearchAnswerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "questionUrl", "answerData", "ret" }, new Object[] { "", "", null }, SearchAnswerRsp.class);
  public final PBStringField answerData = PBField.initString("");
  public final PBStringField questionUrl = PBField.initString("");
  public SearchAnswer.RspErr ret = new SearchAnswer.RspErr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.pb.SearchAnswer.SearchAnswerRsp
 * JD-Core Version:    0.7.0.1
 */