package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STGameLogin$STGetGameConfRsp
  extends MessageMicro<STGetGameConfRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "game_conf_info" }, new Object[] { null }, STGetGameConfRsp.class);
  public final PBRepeatMessageField<STGameLogin.STGameConfInfo> game_conf_info = PBField.initRepeatMessage(STGameLogin.STGameConfInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGetGameConfRsp
 * JD-Core Version:    0.7.0.1
 */