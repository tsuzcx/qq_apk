package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$PrivilegeBaseInfoRsp
  extends MessageMicro<PrivilegeBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField strJumpUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField strMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uIsGrayUsr = PBField.initUInt32(0);
  public final PBRepeatMessageField<VaProfileGate.PrivilegeInfo> vClosePriv = PBField.initRepeatMessage(VaProfileGate.PrivilegeInfo.class);
  public final PBRepeatMessageField<VaProfileGate.PrivilegeInfo> vOpenPriv = PBField.initRepeatMessage(VaProfileGate.PrivilegeInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "strMsg", "strJumpUrl", "vOpenPriv", "vClosePriv", "uIsGrayUsr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0) }, PrivilegeBaseInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */