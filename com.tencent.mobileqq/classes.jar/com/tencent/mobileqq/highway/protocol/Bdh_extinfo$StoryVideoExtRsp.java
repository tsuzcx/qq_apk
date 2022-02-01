package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Bdh_extinfo$StoryVideoExtRsp
  extends MessageMicro<StoryVideoExtRsp>
{
  public static final int BYTES_CDN_URL_FIELD_NUMBER = 3;
  public static final int BYTES_FILE_ID_FIELD_NUMBER = 5;
  public static final int BYTES_FILE_KEY_FIELD_NUMBER = 4;
  public static final int BYTES_MSG_FIELD_NUMBER = 2;
  public static final int INT32_RETCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cdn_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_retcode = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_retcode", "bytes_msg", "bytes_cdn_url", "bytes_file_key", "bytes_file_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, StoryVideoExtRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.StoryVideoExtRsp
 * JD-Core Version:    0.7.0.1
 */