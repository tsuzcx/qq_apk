package com.tencent.open.pcpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MessageContent$MsgContent
  extends MessageMicro<MsgContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90 }, new String[] { "appid", "via", "pkgname", "versioncode", "appname", "appurl", "iconurl", "appsize", "filetype", "source", "srciconurl" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "" }, MsgContent.class);
  public final PBInt64Field appid = PBField.initInt64(0L);
  public final PBStringField appname = PBField.initString("");
  public final PBStringField appsize = PBField.initString("");
  public final PBStringField appurl = PBField.initString("");
  public final PBInt32Field filetype = PBField.initInt32(0);
  public final PBStringField iconurl = PBField.initString("");
  public final PBStringField pkgname = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBStringField srciconurl = PBField.initString("");
  public final PBInt32Field versioncode = PBField.initInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.pcpush.MessageContent.MsgContent
 * JD-Core Version:    0.7.0.1
 */