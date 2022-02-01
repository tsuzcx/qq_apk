package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserSetDynamicPlugin$SetListRequest
  extends MessageMicro<SetListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field platform_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<UserSetDynamicPlugin.PluginData> plugin_data = PBField.initRepeatMessage(UserSetDynamicPlugin.PluginData.class);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "platform_type", "plugin_type", "plugin_data" }, new Object[] { localInteger, localInteger, null }, SetListRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.SetListRequest
 * JD-Core Version:    0.7.0.1
 */