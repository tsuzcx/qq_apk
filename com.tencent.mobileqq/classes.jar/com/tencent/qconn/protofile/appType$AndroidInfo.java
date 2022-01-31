package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appType$AndroidInfo
  extends MessageMicro<AndroidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apk_download_url", "pack_name", "class_name", "source_url", "offical_website", "message_tail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
  public final PBStringField apk_download_url = PBField.initString("");
  public final PBStringField bundleid = PBField.initString("");
  public final PBStringField class_name = PBField.initString("");
  public final PBStringField message_tail = PBField.initString("");
  public final PBStringField offical_website = PBField.initString("");
  public final PBStringField pack_name = PBField.initString("");
  public final PBStringField source_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qconn.protofile.appType.AndroidInfo
 * JD-Core Version:    0.7.0.1
 */