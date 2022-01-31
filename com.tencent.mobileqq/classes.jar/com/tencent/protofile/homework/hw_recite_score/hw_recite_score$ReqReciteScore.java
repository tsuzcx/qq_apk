package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_recite_score$ReqReciteScore
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "error_times", "remind_times", "total_time", "total_word" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqReciteScore.class);
  public final PBUInt32Field error_times = PBField.initUInt32(0);
  public final PBUInt32Field remind_times = PBField.initUInt32(0);
  public final PBUInt32Field total_time = PBField.initUInt32(0);
  public final PBUInt32Field total_word = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore
 * JD-Core Version:    0.7.0.1
 */