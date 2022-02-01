package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Bdh_extinfo$CommFileExtRsp
  extends MessageMicro<CommFileExtRsp>
{
  public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 2;
  public static final int INT32_RETCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_retcode = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_retcode", "bytes_download_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CommFileExtRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp
 * JD-Core Version:    0.7.0.1
 */