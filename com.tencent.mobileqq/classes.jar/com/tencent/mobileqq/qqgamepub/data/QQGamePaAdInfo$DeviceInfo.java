package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQGamePaAdInfo$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField aidTicket = PBField.initString("");
  public final PBStringField androidId = PBField.initString("");
  public final PBUInt32Field appVersionId = PBField.initUInt32(0);
  public final PBStringField brand = PBField.initString("");
  public final PBUInt32Field carrierCode = PBField.initUInt32(0);
  public final PBStringField clientIp = PBField.initString("");
  public final PBStringField clientIpv4 = PBField.initString("");
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBStringField deviceBrandAndModel = PBField.initString("");
  public final PBStringField deviceExt = PBField.initString("");
  public final PBUInt32Field deviceOrientation = PBField.initUInt32(0);
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBStringField iosQidfa = PBField.initString("");
  public final PBBoolField isGoogleplayVersion = PBField.initBool(false);
  public final PBBoolField isIosReviewState = PBField.initBool(false);
  public final PBBoolField isWkWebview = PBField.initBool(false);
  public QQGamePaAdInfo.Location location = new QQGamePaAdInfo.Location();
  public final PBStringField mac = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField md5AndroidId = PBField.initString("");
  public final PBStringField md5Mac = PBField.initString("");
  public final PBStringField muid = PBField.initString("");
  public final PBUInt32Field muidType = PBField.initUInt32(0);
  public final PBStringField oaid = PBField.initString("");
  public final PBUInt32Field originNetworkType = PBField.initUInt32(0);
  public final PBUInt32Field osType = PBField.initUInt32(0);
  public final PBStringField osVer = PBField.initString("");
  public final PBStringField qadid = PBField.initString("");
  public final PBStringField qqVer = PBField.initString("");
  public final PBStringField taidTicket = PBField.initString("");
  public final PBUInt64Field wxApiVer = PBField.initUInt64(0L);
  public final PBBoolField wxInstalled = PBField.initBool(false);
  public final PBBoolField wxUl = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 130, 138, 146, 154, 160, 168, 176, 186, 194, 202, 210, 218, 226, 232, 240, 248, 256, 266, 274 }, new String[] { "muid", "muidType", "conn", "carrierCode", "osVer", "qqVer", "osType", "clientIp", "iosQidfa", "location", "isWkWebview", "manufacturer", "deviceBrandAndModel", "qadid", "appVersionId", "imei", "idfa", "androidId", "mac", "isGoogleplayVersion", "deviceOrientation", "isIosReviewState", "oaid", "taidTicket", "md5Mac", "md5AndroidId", "clientIpv4", "aidTicket", "wxApiVer", "wxInstalled", "wxUl", "originNetworkType", "brand", "deviceExt" }, new Object[] { "", localInteger, localInteger, localInteger, "", "", localInteger, "", "", null, localBoolean, "", "", "", localInteger, "", "", "", "", localBoolean, localInteger, localBoolean, "", "", "", "", "", "", Long.valueOf(0L), localBoolean, localBoolean, localInteger, "", "" }, DeviceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */