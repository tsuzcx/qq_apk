package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_recite_score$RspReciteScore
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "score_grade" }, new Object[] { Integer.valueOf(0) }, RspReciteScore.class);
  public final PBUInt32Field score_grade = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_recite_score.hw_recite_score.RspReciteScore
 * JD-Core Version:    0.7.0.1
 */