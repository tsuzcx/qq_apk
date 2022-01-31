package com.tencent.pb.websafe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSafe$CheckURLReq
  extends MessageMicro<CheckURLReq>
{
  public static final int GDT_DATA_FIELD_NUMBER = 2;
  public static final int URL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url", "gdt_data" }, new Object[] { "", "" }, CheckURLReq.class);
  public final PBStringField gdt_data = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.websafe.WebSafe.CheckURLReq
 * JD-Core Version:    0.7.0.1
 */