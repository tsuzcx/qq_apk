package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGetGameConfReq
  extends MessageMicro<STGetGameConfReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "game_id_list", "from" }, new Object[] { Integer.valueOf(0), "" }, STGetGameConfReq.class);
  public final PBStringField from = PBField.initString("");
  public final PBRepeatField<Integer> game_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGetGameConfReq
 * JD-Core Version:    0.7.0.1
 */