package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$GetResourceResp
  extends MessageMicro<GetResourceResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "plugin_type", "respinfo_list", "plugin_layout" }, new Object[] { Integer.valueOf(0), null, null }, GetResourceResp.class);
  public PluginConfig.PluginLayout plugin_layout = new PluginConfig.PluginLayout();
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<PluginConfig.GetResourceRespInfo> respinfo_list = PBField.initRepeatMessage(PluginConfig.GetResourceRespInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp
 * JD-Core Version:    0.7.0.1
 */