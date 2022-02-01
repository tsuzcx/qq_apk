package com.tencent.protofile.cmd0xe19;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe19$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58, 66 }, new String[] { "money", "detail_wording", "has_task", "task", "button_wording", "ret", "outcome_wording", "toast" }, new Object[] { Long.valueOf(0L), "", Boolean.valueOf(false), null, "", Integer.valueOf(0), "", "" }, RspBody.class);
  public final PBStringField button_wording = PBField.initString("");
  public final PBStringField detail_wording = PBField.initString("");
  public final PBBoolField has_task = PBField.initBool(false);
  public final PBUInt64Field money = PBField.initUInt64(0L);
  public final PBStringField outcome_wording = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public cmd0xe19.TaskRedPacket task = new cmd0xe19.TaskRedPacket();
  public final PBStringField toast = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe19.cmd0xe19.RspBody
 * JD-Core Version:    0.7.0.1
 */