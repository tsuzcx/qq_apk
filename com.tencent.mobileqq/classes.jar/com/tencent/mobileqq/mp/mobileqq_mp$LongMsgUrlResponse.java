package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$LongMsgUrlResponse
  extends MessageMicro<LongMsgUrlResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret_info", "str_url", "str_file_md5" }, new Object[] { null, "", "" }, LongMsgUrlResponse.class);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBStringField str_file_md5 = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse
 * JD-Core Version:    0.7.0.1
 */