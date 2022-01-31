package com.tencent.pb.getnumredmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedMsg$NumMsgReqBody
  extends MessageMicro<NumMsgReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "i_proto_ver", "ui_plat_id", "str_client_ver", "ui64_uin", "rpt_num_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, NumMsgReqBody.class);
  public final PBInt32Field i_proto_ver = PBField.initInt32(0);
  public final PBRepeatMessageField<NumRedMsg.NumMsgBusi> rpt_num_msg = PBField.initRepeatMessage(NumRedMsg.NumMsgBusi.class);
  public final PBStringField str_client_ver = PBField.initString("");
  public final PBUInt64Field ui64_uin = PBField.initUInt64(0L);
  public final PBUInt32Field ui_plat_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgReqBody
 * JD-Core Version:    0.7.0.1
 */