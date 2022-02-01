package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$PluginLayout
  extends MessageMicro<PluginLayout>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<PluginConfig.PluginGroup> group_list = PBField.initRepeatMessage(PluginConfig.PluginGroup.class);
  public final PBUInt32Field layout_type = PBField.initUInt32(0);
  public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "plugin_layout_seq", "group_list", "layout_type" }, new Object[] { localInteger, null, localInteger }, PluginLayout.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.PluginConfig.PluginLayout
 * JD-Core Version:    0.7.0.1
 */