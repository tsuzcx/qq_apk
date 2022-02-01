package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmosmPb$SubCmd0x9BqAssocReq
  extends MessageMicro<SubCmd0x9BqAssocReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_key_word", "rpt_str_bq_item_id", "rpt_str_dead_bq_item_id" }, new Object[] { "", "", "" }, SubCmd0x9BqAssocReq.class);
  public final PBRepeatField<String> rpt_str_bq_item_id = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> rpt_str_dead_bq_item_id = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_key_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq
 * JD-Core Version:    0.7.0.1
 */