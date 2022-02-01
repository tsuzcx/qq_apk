package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserConfig$PrefInfo
  extends MessageMicro<PrefInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "describe", "icon_url", "pref_wording", "time_limit_info", "selected_wording", "selected_status", "pref_id" }, new Object[] { "", "", "", null, "", Boolean.valueOf(false), Integer.valueOf(0) }, PrefInfo.class);
  public final PBStringField describe = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBEnumField pref_id = PBField.initEnum(0);
  public final PBStringField pref_wording = PBField.initString("");
  public final PBBoolField selected_status = PBField.initBool(false);
  public final PBStringField selected_wording = PBField.initString("");
  public UserConfig.TimeLimitInfo time_limit_info = new UserConfig.TimeLimitInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.PrefInfo
 * JD-Core Version:    0.7.0.1
 */