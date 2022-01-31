package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xf9$MsgCommonData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 128, 136, 144, 154, 160, 168, 178 }, new String[] { "str_adId", "str_adPosId", "bool_bannerShow", "uint32_bannertype", "uint32_jumpType", "str_jumpUrl", "str_appId", "str_appName", "str_packagename", "str_androidDownloadUrl", "str_scheme", "str_iosDownloadUrl", "str_bannerImgUrl", "str_bannerText", "str_bannerButtonText", "bool_silentDownload", "uint32_audioSwitchType", "uint32_preDownloadType", "str_reportLink", "bool_horizontalVideo", "uint32_audioFadeinDuration", "str_openJumpUrlGuide" }, new Object[] { "", "", Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "", "", "", "", Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), "" }, MsgCommonData.class);
  public final PBBoolField bool_bannerShow = PBField.initBool(false);
  public final PBBoolField bool_horizontalVideo = PBField.initBool(false);
  public final PBBoolField bool_silentDownload = PBField.initBool(false);
  public final PBStringField str_adId = PBField.initString("");
  public final PBStringField str_adPosId = PBField.initString("");
  public final PBStringField str_androidDownloadUrl = PBField.initString("");
  public final PBStringField str_appId = PBField.initString("");
  public final PBStringField str_appName = PBField.initString("");
  public final PBStringField str_bannerButtonText = PBField.initString("");
  public final PBStringField str_bannerImgUrl = PBField.initString("");
  public final PBStringField str_bannerText = PBField.initString("");
  public final PBStringField str_iosDownloadUrl = PBField.initString("");
  public final PBStringField str_jumpUrl = PBField.initString("");
  public final PBStringField str_openJumpUrlGuide = PBField.initString("");
  public final PBStringField str_packagename = PBField.initString("");
  public final PBStringField str_reportLink = PBField.initString("");
  public final PBStringField str_scheme = PBField.initString("");
  public final PBUInt32Field uint32_audioFadeinDuration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_audioSwitchType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bannertype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jumpType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_preDownloadType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgCommonData
 * JD-Core Version:    0.7.0.1
 */