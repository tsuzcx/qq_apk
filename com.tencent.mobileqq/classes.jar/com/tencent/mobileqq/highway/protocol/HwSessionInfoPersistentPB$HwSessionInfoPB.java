package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class HwSessionInfoPersistentPB$HwSessionInfoPB
  extends MessageMicro<HwSessionInfoPB>
{
  public static final int BYTES_HTTPCONN_SIG_SESSION_FIELD_NUMBER = 1;
  public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, HwSessionInfoPB.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB.HwSessionInfoPB
 * JD-Core Version:    0.7.0.1
 */