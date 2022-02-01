package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserConfig$ExpandEntranceOptions
  extends MessageMicro<ExpandEntranceOptions>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "IsAllowDisplayEntrance", "entrance_des" }, new Object[] { Boolean.valueOf(false), "" }, ExpandEntranceOptions.class);
  public final PBBoolField IsAllowDisplayEntrance = PBField.initBool(false);
  public final PBStringField entrance_des = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.ExpandEntranceOptions
 * JD-Core Version:    0.7.0.1
 */