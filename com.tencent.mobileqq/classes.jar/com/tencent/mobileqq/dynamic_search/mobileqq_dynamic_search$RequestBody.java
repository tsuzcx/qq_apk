package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_dynamic_search$RequestBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public mobileqq_dynamic_search.ExtensionRequestInfo extension_request_info = new mobileqq_dynamic_search.ExtensionRequestInfo();
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_dynamic_search.RootSearcherRequest search_request = new mobileqq_dynamic_search.RootSearcherRequest();
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "cmd", "key_word", "search_request", "extension_request_info", "result_id", "version", "bytes_cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RequestBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody
 * JD-Core Version:    0.7.0.1
 */