package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserDynamicPlugin$ReqGetUserDynamicPlugin
  extends MessageMicro<ReqGetUserDynamicPlugin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "platform", "plugin_type" }, new Object[] { localInteger, localInteger }, ReqGetUserDynamicPlugin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserDynamicPlugin.ReqGetUserDynamicPlugin
 * JD-Core Version:    0.7.0.1
 */