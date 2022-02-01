package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WordsSecurity$SecurityRsp
  extends MessageMicro<SecurityRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field credit_beat = PBField.initUInt32(0);
  public final PBUInt32Field dirty_word_beat = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> dirty_word_tips = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field real_auth = PBField.initUInt32(0);
  public final PBUInt32Field required_score = PBField.initUInt32(0);
  public final PBInt32Field ret_code = PBField.initInt32(0);
  public final PBBytesField ret_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sys_beat_level = PBField.initUInt32(0);
  public final PBUInt32Field user_score = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72 }, new String[] { "ret_code", "sys_beat_level", "dirty_word_beat", "ret_text", "dirty_word_tips", "credit_beat", "user_score", "required_score", "real_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SecurityRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.WordsSecurity.SecurityRsp
 * JD-Core Version:    0.7.0.1
 */