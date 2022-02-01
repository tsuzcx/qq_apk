package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePubSubscribe$AppSubscribeInfo
  extends MessageMicro<AppSubscribeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appIcon = PBField.initString("");
  public final PBStringField appName = PBField.initString("");
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBEnumField subscribe = PBField.initEnum(0);
  public final PBInt64Field subscribeCount = PBField.initInt64(0L);
  public final PBInt64Field subscribeTime = PBField.initInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "appid", "subscribe", "appName", "appIcon", "subscribeCount", "subscribeTime" }, new Object[] { localInteger, localInteger, "", "", localLong, localLong }, AppSubscribeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo
 * JD-Core Version:    0.7.0.1
 */