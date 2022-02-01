package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class preAuth$PreAuthResponse
  extends MessageMicro<PreAuthResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 50, 122, 130, 162, 170, 322, 328 }, new String[] { "ret", "msg", "appid", "app_name", "icons_url", "android_info", "ios_info", "auth_items", "authorized_union_text", "profiles", "vid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", null, null, null, null, "", null, Long.valueOf(0L) }, PreAuthResponse.class);
  public appType.AndroidInfo android_info = new appType.AndroidInfo();
  public final PBStringField app_name = PBField.initString("");
  public final PBInt64Field appid = PBField.initInt64(0L);
  public final PBRepeatMessageField<appType.AuthItem> auth_items = PBField.initRepeatMessage(appType.AuthItem.class);
  public final PBStringField authorized_union_text = PBField.initString("");
  public final PBRepeatMessageField<appType.MsgIconsurl> icons_url = PBField.initRepeatMessage(appType.MsgIconsurl.class);
  public appType.IOSInfo ios_info = new appType.IOSInfo();
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField<preAuth.VirtualProfile> profiles = PBField.initRepeatMessage(preAuth.VirtualProfile.class);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt64Field vid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.preAuth.PreAuthResponse
 * JD-Core Version:    0.7.0.1
 */