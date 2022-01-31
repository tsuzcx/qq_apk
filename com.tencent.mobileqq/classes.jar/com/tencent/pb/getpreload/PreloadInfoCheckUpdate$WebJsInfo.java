package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$WebJsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66 }, new String[] { "head", "err_page_url", "err_file", "err_line", "err_message", "err_timestamp", "err_level", "phone_model" }, new Object[] { null, "", "", "", "", Long.valueOf(0L), "", "" }, WebJsInfo.class);
  public final PBStringField err_file = PBField.initString("");
  public final PBStringField err_level = PBField.initString("");
  public final PBStringField err_line = PBField.initString("");
  public final PBStringField err_message = PBField.initString("");
  public final PBStringField err_page_url = PBField.initString("");
  public final PBInt64Field err_timestamp = PBField.initInt64(0L);
  public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
  public final PBStringField phone_model = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebJsInfo
 * JD-Core Version:    0.7.0.1
 */