package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserConfig$BatchGetPrefOptionsRsp
  extends MessageMicro<BatchGetPrefOptionsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pref_infos" }, new Object[] { null }, BatchGetPrefOptionsRsp.class);
  public final PBRepeatMessageField<UserConfig.GetPrefOptionsRsp> pref_infos = PBField.initRepeatMessage(UserConfig.GetPrefOptionsRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.BatchGetPrefOptionsRsp
 * JD-Core Version:    0.7.0.1
 */