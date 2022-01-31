package com.tencent.mobileqq.webdownload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DownloadURLCheck$ReqDownloadUrlCheckRecmd
  extends MessageMicro<ReqDownloadUrlCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uin", "mime_type", "host_url", "download_url", "extra_info" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, ReqDownloadUrlCheckRecmd.class);
  public final PBStringField download_url = PBField.initString("");
  public final PBStringField extra_info = PBField.initString("");
  public final PBStringField host_url = PBField.initString("");
  public final PBStringField mime_type = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webdownload.DownloadURLCheck.ReqDownloadUrlCheckRecmd
 * JD-Core Version:    0.7.0.1
 */