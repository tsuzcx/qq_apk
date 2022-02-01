package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class Bdh_extinfo$UploadPicExtInfo
  extends MessageMicro<UploadPicExtInfo>
{
  public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 2;
  public static final int BYTES_FILE_RESID_FIELD_NUMBER = 1;
  public static final int BYTES_THUMB_DOWNLOAD_URL_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_file_resid", "bytes_download_url", "bytes_thumb_download_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, UploadPicExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo
 * JD-Core Version:    0.7.0.1
 */