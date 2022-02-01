package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserConfig$TimeLimitInfo
  extends MessageMicro<TimeLimitInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "limit_wording", "jump_wording", "jump_url" }, new Object[] { "", "", "" }, TimeLimitInfo.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField jump_wording = PBField.initString("");
  public final PBStringField limit_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.TimeLimitInfo
 * JD-Core Version:    0.7.0.1
 */