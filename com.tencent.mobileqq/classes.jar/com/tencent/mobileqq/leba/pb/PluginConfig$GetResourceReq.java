package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$GetResourceReq
  extends MessageMicro<GetResourceReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<PluginConfig.GetResourceReqInfo> reqinfo_list = PBField.initRepeatMessage(PluginConfig.GetResourceReqInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqinfo_list", "plugin_type", "plugin_layout_seq" }, new Object[] { null, localInteger, localInteger }, GetResourceReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq
 * JD-Core Version:    0.7.0.1
 */