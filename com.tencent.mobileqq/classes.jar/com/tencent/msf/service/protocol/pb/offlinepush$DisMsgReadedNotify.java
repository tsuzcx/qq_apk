package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$DisMsgReadedNotify
  extends MessageMicro
{
  public static final int LDISMSGSEQ_FIELD_NUMBER = 4;
  public static final int LDISUIN_FIELD_NUMBER = 1;
  public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
  public static final int LOPTYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lDisUin", "lOpType", "lMemberSeq", "lDisMsgSeq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DisMsgReadedNotify.class);
  public final PBUInt64Field lDisMsgSeq = PBField.initUInt64(0L);
  public final PBUInt64Field lDisUin = PBField.initUInt64(0L);
  public final PBUInt64Field lMemberSeq = PBField.initUInt64(0L);
  public final PBUInt64Field lOpType = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.DisMsgReadedNotify
 * JD-Core Version:    0.7.0.1
 */