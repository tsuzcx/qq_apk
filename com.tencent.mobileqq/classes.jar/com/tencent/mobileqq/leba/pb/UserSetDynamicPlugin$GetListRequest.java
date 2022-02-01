package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserSetDynamicPlugin$GetListRequest
  extends MessageMicro<GetListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field platform_type = PBField.initUInt32(0);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "platform_type", "plugin_type", "sequence" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, GetListRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.GetListRequest
 * JD-Core Version:    0.7.0.1
 */