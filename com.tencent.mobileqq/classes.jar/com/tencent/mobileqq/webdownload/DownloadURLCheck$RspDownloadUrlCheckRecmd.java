package com.tencent.mobileqq.webdownload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class DownloadURLCheck$RspDownloadUrlCheckRecmd
  extends MessageMicro<RspDownloadUrlCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "err_code", "err_msg", "is_white_url", "pkg_name", "extra_info" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), "", "" }, RspDownloadUrlCheckRecmd.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBStringField extra_info = PBField.initString("");
  public final PBBoolField is_white_url = PBField.initBool(false);
  public final PBStringField pkg_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webdownload.DownloadURLCheck.RspDownloadUrlCheckRecmd
 * JD-Core Version:    0.7.0.1
 */