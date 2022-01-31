package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ButtonInfo
  extends MessageMicro
{
  public static final int AUTH_NONE = 0;
  public static final int AUTH_SID = 1;
  public static final int AUTH_VKEY = 2;
  public static final int CLICK = 1;
  public static final int EVENT = 3;
  public static final int URL = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88, 98, 106, 112, 122, 130, 138 }, new String[] { "id", "name", "key", "url", "auth_type", "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id", "actionInfo", "media_id", "is_new_menu", "logo_url", "bg_colors", "texture_url" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0), null, "", Boolean.valueOf(false), "", "", "" }, ButtonInfo.class);
  public mobileqq_mp.ActionInfo actionInfo = new mobileqq_mp.ActionInfo();
  public final PBEnumField auth_type = PBField.initEnum(0);
  public final PBStringField bg_colors = PBField.initString("");
  public final PBEnumField event_id = PBField.initEnum(1);
  public final PBRepeatMessageField event_param = PBField.initRepeatMessage(mobileqq_mp.ButtonInfo_EventInfoParam.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBoolField is_need_lbs = PBField.initBool(false);
  public final PBBoolField is_new_menu = PBField.initBool(false);
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public final PBStringField key = PBField.initString("");
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField media_id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBRepeatMessageField sub_button = PBField.initRepeatMessage(ButtonInfo.class);
  public final PBStringField texture_url = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */