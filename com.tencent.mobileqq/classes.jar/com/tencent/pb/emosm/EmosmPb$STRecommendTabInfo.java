package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$STRecommendTabInfo
  extends MessageMicro<STRecommendTabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66, 74, 80, 88 }, new String[] { "u32_tab_id", "str_tab_name", "i32_tab_type", "i32_feetype", "i32_price", "str_button_url", "str_thumb_nail_url", "str_bg_color", "str_title_color", "i32_recommend_mode", "int32_red_point_flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, STRecommendTabInfo.class);
  public final PBInt32Field i32_feetype = PBField.initInt32(0);
  public final PBInt32Field i32_price = PBField.initInt32(0);
  public final PBInt32Field i32_recommend_mode = PBField.initInt32(0);
  public final PBInt32Field i32_tab_type = PBField.initInt32(0);
  public final PBInt32Field int32_red_point_flag = PBField.initInt32(0);
  public final PBStringField str_bg_color = PBField.initString("");
  public final PBStringField str_button_url = PBField.initString("");
  public final PBStringField str_tab_name = PBField.initString("");
  public final PBStringField str_thumb_nail_url = PBField.initString("");
  public final PBStringField str_title_color = PBField.initString("");
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo
 * JD-Core Version:    0.7.0.1
 */