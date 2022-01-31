package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$WebviewWhiteListResponse
  extends MessageMicro<WebviewWhiteListResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField data = PBField.initString("");
  public final PBBytesField gziped_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_mp.WebviewWhiteListResponse.RetInfo ret_info = new mobileqq_mp.WebviewWhiteListResponse.RetInfo();
  public final PBStringField version = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ret_info", "version", "data", "gziped_data" }, new Object[] { null, "", "", localByteStringMicro }, WebviewWhiteListResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse
 * JD-Core Version:    0.7.0.1
 */