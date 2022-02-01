package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyControl$TabConfig
  extends MessageMicro<TabConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "tab_id", "tab_type", "tab_name", "tab_web_url", "tab_hippy_module", "tab_icon_selected_png", "tab_icon_normal_png", "tab_icon_selected_webp", "tab_icon_normal_webp", "ext" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", "", "", "", "" }, TabConfig.class);
  public final PBStringField ext = PBField.initString("");
  public final PBStringField tab_hippy_module = PBField.initString("");
  public final PBStringField tab_icon_normal_png = PBField.initString("");
  public final PBStringField tab_icon_normal_webp = PBField.initString("");
  public final PBStringField tab_icon_selected_png = PBField.initString("");
  public final PBStringField tab_icon_selected_webp = PBField.initString("");
  public final PBUInt64Field tab_id = PBField.initUInt64(0L);
  public final PBStringField tab_name = PBField.initString("");
  public final PBUInt32Field tab_type = PBField.initUInt32(0);
  public final PBStringField tab_web_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.TabConfig
 * JD-Core Version:    0.7.0.1
 */