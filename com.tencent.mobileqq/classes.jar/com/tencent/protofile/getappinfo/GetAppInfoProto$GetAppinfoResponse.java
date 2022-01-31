package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetAppInfoProto$GetAppinfoResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90 }, new String[] { "ret", "msg", "appName", "appComment", "providerName", "appClass", "iconsURL", "androidInfo", "iosInfo", "client_id", "ads" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", null, null, null, Long.valueOf(0L), null }, GetAppinfoResponse.class);
  public GetAppInfoProto.Ads ads = new GetAppInfoProto.Ads();
  public GetAppInfoProto.AndroidInfo androidInfo = new GetAppInfoProto.AndroidInfo();
  public final PBStringField appClass = PBField.initString("");
  public final PBStringField appComment = PBField.initString("");
  public final PBStringField appName = PBField.initString("");
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBRepeatMessageField iconsURL = PBField.initRepeatMessage(GetAppInfoProto.MsgIconsurl.class);
  public GetAppInfoProto.IOSInfo iosInfo = new GetAppInfoProto.IOSInfo();
  public final PBStringField msg = PBField.initString("");
  public final PBStringField providerName = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse
 * JD-Core Version:    0.7.0.1
 */