package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ConfigInfo
  extends MessageMicro
{
  public static final int LOCAL_EVENT = 3;
  public static final int NEED_UIN = 1;
  public static final int NO_AUTH = 0;
  public static final int PACF_FLOD_IN_ASSISTANT = 5;
  public static final int PACF_MSG_SETTING = 6;
  public static final int PACF_RECV_EMAIL_NOTIF = 2;
  public static final int PACF_RECV_LBS_MSG = 3;
  public static final int PACF_RECV_MSG = 1;
  public static final int PACF_RECV_MSG_NOTIF = 4;
  public static final int RICH_PIC_TEXT = 5;
  public static final int RICH_TEXT = 4;
  public static final int STATE_CHANGE = 2;
  public static final int WEBVIEW = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 74, 80 }, new String[] { "type", "title", "content", "event_id", "url", "auth_type", "state", "confirm_flag", "confirm_tips", "state_id" }, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(1) }, ConfigInfo.class);
  public final PBEnumField auth_type = PBField.initEnum(0);
  public final PBUInt32Field confirm_flag = PBField.initUInt32(0);
  public final PBStringField confirm_tips = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBEnumField event_id = PBField.initEnum(1);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBEnumField state_id = PBField.initEnum(1);
  public final PBStringField title = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */