package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class UserConfig$ExpandWallOptions
  extends MessageMicro<ExpandWallOptions>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "IsAllowEntryExpandWall" }, new Object[] { Boolean.valueOf(false) }, ExpandWallOptions.class);
  public final PBBoolField IsAllowEntryExpandWall = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.ExpandWallOptions
 * JD-Core Version:    0.7.0.1
 */