package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$GetAppinfoRequest
  extends MessageMicro<GetAppinfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98 }, new String[] { "client_id", "sdkp", "icons", "qqv", "os", "md5time", "signature", "need_ads", "app_type", "channel_source", "referer", "appUniqueIdentifier" }, new Object[] { Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(1), "" }, GetAppinfoRequest.class);
  public final PBStringField appUniqueIdentifier = PBField.initString("");
  public final PBEnumField app_type = PBField.initEnum(0);
  public final PBInt64Field channel_source = PBField.initInt64(0L);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt64Field md5time = PBField.initInt64(0L);
  public final PBSInt32Field need_ads = PBField.initSInt32(0);
  public final PBStringField os = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBEnumField referer = PBField.initEnum(1);
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest
 * JD-Core Version:    0.7.0.1
 */