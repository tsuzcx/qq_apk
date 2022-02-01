package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x51$MsgBody
  extends MessageMicro
{
  public static final int BYTES_APPNAME_FIELD_NUMBER = 4;
  public static final int BYTES_HINT1_FIELD_NUMBER = 2;
  public static final int BYTES_HINT2_FIELD_NUMBER = 3;
  public static final int BYTES_LOGINCITY_FIELD_NUMBER = 5;
  public static final int BYTES_LOGIN_CONF_FIELD_NUMBER = 8;
  public static final int BYTES_QRSIG_URL_FIELD_NUMBER = 1;
  public static final int UINT32_ALLOW_TMP_AUTH_FIELD_NUMBER = 7;
  public static final int UINT32_LOGINTIME_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hint1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hint2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_login_conf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_logincity = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qrsig_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_allow_tmp_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_logintime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66 }, new String[] { "bytes_qrsig_url", "bytes_hint1", "bytes_hint2", "bytes_appname", "bytes_logincity", "uint32_logintime", "uint32_allow_tmp_auth", "bytes_login_conf" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localInteger, localInteger, localByteStringMicro6 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody
 * JD-Core Version:    0.7.0.1
 */