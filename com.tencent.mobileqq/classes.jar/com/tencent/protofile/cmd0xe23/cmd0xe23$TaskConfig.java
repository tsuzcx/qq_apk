package com.tencent.protofile.cmd0xe23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe23$TaskConfig
  extends MessageMicro<TaskConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "total_progress", "total_cycle", "article_max_time", "article_still_max_time", "rpt_record_article_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TaskConfig.class);
  public final PBUInt32Field article_max_time = PBField.initUInt32(0);
  public final PBUInt32Field article_still_max_time = PBField.initUInt32(0);
  public final PBRepeatField<Integer> rpt_record_article_type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBUInt32Field total_cycle = PBField.initUInt32(0);
  public final PBUInt32Field total_progress = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe23.cmd0xe23.TaskConfig
 * JD-Core Version:    0.7.0.1
 */