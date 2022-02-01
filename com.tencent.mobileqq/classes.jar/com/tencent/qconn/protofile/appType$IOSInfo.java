package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appType$IOSInfo
  extends MessageMicro<IOSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "schema", "bundleid", "appstore_id", "source_url", "offical_website", "message_tail", "a_bundleid" }, new Object[] { "", "", "", "", "", "", "" }, IOSInfo.class);
  public final PBStringField a_bundleid = PBField.initString("");
  public final PBStringField appstore_id = PBField.initString("");
  public final PBStringField bundleid = PBField.initString("");
  public final PBStringField message_tail = PBField.initString("");
  public final PBStringField offical_website = PBField.initString("");
  public final PBStringField schema = PBField.initString("");
  public final PBStringField source_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.appType.IOSInfo
 * JD-Core Version:    0.7.0.1
 */