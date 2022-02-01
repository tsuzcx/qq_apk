package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeiyunPB$DiskFileDocDownloadAbsMsgRsp
  extends MessageMicro<DiskFileDocDownloadAbsMsgRsp>
{
  public static final int COOKIE_FIELD_NUMBER = 6;
  public static final int DOWNLOADDNS_FIELD_NUMBER = 2;
  public static final int DOWNLOADIP_FIELD_NUMBER = 1;
  public static final int DOWNLOADKEY_FIELD_NUMBER = 5;
  public static final int DOWNLOADPORT_FIELD_NUMBER = 3;
  public static final int DOWNLOAD_URL_FIELD_NUMBER = 7;
  public static final int FILESHA_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField download_url = PBField.initString("");
  public final PBStringField downloaddns = PBField.initString("");
  public final PBStringField downloadip = PBField.initString("");
  public final PBBytesField downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field downloadport = PBField.initUInt32(0);
  public final PBBytesField filesha = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58 }, new String[] { "downloadip", "downloaddns", "downloadport", "filesha", "downloadkey", "cookie", "download_url" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", "" }, DiskFileDocDownloadAbsMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDocDownloadAbsMsgRsp
 * JD-Core Version:    0.7.0.1
 */