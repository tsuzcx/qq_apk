package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGameLoginRsp
  extends MessageMicro<STGameLoginRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "game_list", "game_conf_info", "game_tag_info", "svr_ts" }, new Object[] { null, null, null, Integer.valueOf(0) }, STGameLoginRsp.class);
  public final PBRepeatMessageField<STGameLogin.STGameConfInfo> game_conf_info = PBField.initRepeatMessage(STGameLogin.STGameConfInfo.class);
  public final PBRepeatMessageField<STGameLogin.STGameList> game_list = PBField.initRepeatMessage(STGameLogin.STGameList.class);
  public final PBRepeatMessageField<STGameLogin.STGameTagInfo> game_tag_info = PBField.initRepeatMessage(STGameLogin.STGameTagInfo.class);
  public final PBUInt32Field svr_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGameLoginRsp
 * JD-Core Version:    0.7.0.1
 */