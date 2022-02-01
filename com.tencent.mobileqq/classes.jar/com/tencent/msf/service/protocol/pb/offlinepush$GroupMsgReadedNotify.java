package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$GroupMsgReadedNotify
  extends MessageMicro
{
  public static final int LGROUPCODE_FIELD_NUMBER = 1;
  public static final int LGROUPMSGSEQ_FIELD_NUMBER = 4;
  public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
  public static final int LOPTYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field lGroupCode = PBField.initUInt64(0L);
  public final PBUInt64Field lGroupMsgSeq = PBField.initUInt64(0L);
  public final PBUInt64Field lMemberSeq = PBField.initUInt64(0L);
  public final PBUInt64Field lOpType = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lGroupCode", "lOpType", "lMemberSeq", "lGroupMsgSeq" }, new Object[] { localLong, localLong, localLong, localLong }, GroupMsgReadedNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.GroupMsgReadedNotify
 * JD-Core Version:    0.7.0.1
 */