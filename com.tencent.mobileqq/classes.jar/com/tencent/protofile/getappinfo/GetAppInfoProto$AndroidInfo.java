package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$AndroidInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apkDownUrl", "packName", "className", "sourceUrl", "officalwebsite", "messagetail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
  public final PBStringField apkDownUrl = PBField.initString("");
  public final PBStringField bundleid = PBField.initString("");
  public final PBStringField className = PBField.initString("");
  public final PBStringField messagetail = PBField.initString("");
  public final PBStringField officalwebsite = PBField.initString("");
  public final PBStringField packName = PBField.initString("");
  public final PBStringField sourceUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo
 * JD-Core Version:    0.7.0.1
 */