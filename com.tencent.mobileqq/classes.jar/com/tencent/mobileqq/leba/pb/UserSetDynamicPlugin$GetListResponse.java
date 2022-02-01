package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserSetDynamicPlugin$GetListResponse
  extends MessageMicro<GetListResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field max_dynamic_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<UserSetDynamicPlugin.PluginData> plugin_data = PBField.initRepeatMessage(UserSetDynamicPlugin.PluginData.class);
  public final PBUInt32Field reson_code = PBField.initUInt32(0);
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "plugin_data", "max_dynamic_num", "sequence", "reson_code" }, new Object[] { null, localInteger, Long.valueOf(0L), localInteger }, GetListResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.GetListResponse
 * JD-Core Version:    0.7.0.1
 */