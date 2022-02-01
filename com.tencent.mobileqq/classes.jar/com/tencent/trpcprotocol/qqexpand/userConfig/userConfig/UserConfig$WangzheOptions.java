package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class UserConfig$WangzheOptions
  extends MessageMicro<WangzheOptions>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField IsAllowDisplayRecord = PBField.initBool(false);
  public final PBBoolField IsShowWangzheDD = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "IsAllowDisplayRecord", "IsShowWangzheDD" }, new Object[] { localBoolean, localBoolean }, WangzheOptions.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.WangzheOptions
 * JD-Core Version:    0.7.0.1
 */