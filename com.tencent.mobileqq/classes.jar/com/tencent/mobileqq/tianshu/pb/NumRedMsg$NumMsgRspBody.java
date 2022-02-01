package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedMsg$NumMsgRspBody
  extends MessageMicro<NumMsgRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "i_retcode", "str_errmsg", "ui64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, NumMsgRspBody.class);
  public final PBInt32Field i_retcode = PBField.initInt32(0);
  public final PBRepeatMessageField<NumRedMsg.NumMsgBusi> rpt_num_red = PBField.initRepeatMessage(NumRedMsg.NumMsgBusi.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt64Field ui64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgRspBody
 * JD-Core Version:    0.7.0.1
 */