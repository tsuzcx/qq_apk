package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STCheckGame$STGameConfInfo
  extends MessageMicro<STGameConfInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 90, 98, 104, 112, 120, 128 }, new String[] { "game_id", "action_id", "appid", "ep_name", "g_start_ver", "g_end_ver", "game_name", "has_own_ark", "isfeatured", "is_show_onpanel", "list_cover_url", "logo_url", "need_open_key", "puin", "screen_mode", "view_mode" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, STGameConfInfo.class);
  public final PBUInt32Field action_id = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField ep_name = PBField.initString("");
  public final PBStringField g_end_ver = PBField.initString("");
  public final PBStringField g_start_ver = PBField.initString("");
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBStringField game_name = PBField.initString("");
  public final PBInt32Field has_own_ark = PBField.initInt32(0);
  public final PBInt32Field is_show_onpanel = PBField.initInt32(0);
  public final PBInt32Field isfeatured = PBField.initInt32(0);
  public final PBStringField list_cover_url = PBField.initString("");
  public final PBStringField logo_url = PBField.initString("");
  public final PBInt32Field need_open_key = PBField.initInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBInt32Field screen_mode = PBField.initInt32(0);
  public final PBInt32Field view_mode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STCheckGame.STGameConfInfo
 * JD-Core Version:    0.7.0.1
 */