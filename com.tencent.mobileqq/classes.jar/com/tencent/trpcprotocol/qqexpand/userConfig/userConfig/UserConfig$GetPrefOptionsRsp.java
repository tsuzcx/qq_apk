package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserConfig$GetPrefOptionsRsp
  extends MessageMicro<GetPrefOptionsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField default_selected_id = PBField.initEnum(0);
  public final PBRepeatMessageField<UserConfig.PrefInfo> pref_info = PBField.initRepeatMessage(UserConfig.PrefInfo.class);
  public final PBUInt32Field tag_id = PBField.initUInt32(0);
  public final PBStringField tips_wording = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 8010 }, new String[] { "tag_id", "title", "tips_wording", "default_selected_id", "pref_info" }, new Object[] { localInteger, "", "", localInteger, null }, GetPrefOptionsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.GetPrefOptionsRsp
 * JD-Core Version:    0.7.0.1
 */