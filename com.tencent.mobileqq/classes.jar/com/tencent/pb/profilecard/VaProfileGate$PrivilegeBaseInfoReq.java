package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VaProfileGate$PrivilegeBaseInfoReq
  extends MessageMicro<PrivilegeBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uReqUin" }, new Object[] { Long.valueOf(0L) }, PrivilegeBaseInfoReq.class);
  public final PBUInt64Field uReqUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */