package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class KidModePassword$LoginSig
  extends MessageMicro<LoginSig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sig_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "sig_type", "sig", "appid" }, new Object[] { localInteger, localByteStringMicro, localInteger }, LoginSig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.LoginSig
 * JD-Core Version:    0.7.0.1
 */