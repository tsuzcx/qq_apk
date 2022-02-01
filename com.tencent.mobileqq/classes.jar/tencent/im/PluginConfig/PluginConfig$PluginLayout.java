package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$PluginLayout
  extends MessageMicro<PluginLayout>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "plugin_layout_seq", "group_list", "layout_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, PluginLayout.class);
  public final PBRepeatMessageField<PluginConfig.PluginGroup> group_list = PBField.initRepeatMessage(PluginConfig.PluginGroup.class);
  public final PBUInt32Field layout_type = PBField.initUInt32(0);
  public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig.PluginLayout
 * JD-Core Version:    0.7.0.1
 */