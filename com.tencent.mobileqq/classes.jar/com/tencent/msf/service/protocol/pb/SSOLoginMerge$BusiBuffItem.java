package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SSOLoginMerge$BusiBuffItem
  extends MessageMicro
{
  public static final int BUSIBUFFLEN_FIELD_NUMBER = 3;
  public static final int BUSIBUFF_FIELD_NUMBER = 4;
  public static final int NEEDRESP_FIELD_NUMBER = 5;
  public static final int SEQNO_FIELD_NUMBER = 1;
  public static final int SERVICECMD_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField BusiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field BusiBuffLen = PBField.initUInt32(0);
  public final PBBoolField NeedResp = PBField.initBool(false);
  public final PBUInt32Field SeqNo = PBField.initUInt32(0);
  public final PBStringField ServiceCmd = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "SeqNo", "ServiceCmd", "BusiBuffLen", "BusiBuff", "NeedResp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, BusiBuffItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem
 * JD-Core Version:    0.7.0.1
 */