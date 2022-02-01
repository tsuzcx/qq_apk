package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserConfig$GetOptionsRsp
  extends MessageMicro<GetOptionsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "options", "next_pull_time" }, new Object[] { null, Integer.valueOf(0) }, GetOptionsRsp.class);
  public final PBUInt32Field next_pull_time = PBField.initUInt32(0);
  public UserConfig.Options options = new UserConfig.Options();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.GetOptionsRsp
 * JD-Core Version:    0.7.0.1
 */