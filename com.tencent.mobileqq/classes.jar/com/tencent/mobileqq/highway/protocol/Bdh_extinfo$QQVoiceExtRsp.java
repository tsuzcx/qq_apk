package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Bdh_extinfo$QQVoiceExtRsp
  extends MessageMicro<QQVoiceExtRsp>
{
  public static final int BYTES_QID_FIELD_NUMBER = 1;
  public static final int INT32_RETCODE_FIELD_NUMBER = 2;
  public static final int MSG_RESULT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_retcode = PBField.initInt32(0);
  public final PBRepeatMessageField<Bdh_extinfo.QQVoiceResult> msg_result = PBField.initRepeatMessage(Bdh_extinfo.QQVoiceResult.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_qid", "int32_retcode", "msg_result" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, QQVoiceExtRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.QQVoiceExtRsp
 * JD-Core Version:    0.7.0.1
 */