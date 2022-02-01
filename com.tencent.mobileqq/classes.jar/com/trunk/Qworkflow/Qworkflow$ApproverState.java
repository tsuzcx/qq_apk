package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$ApproverState
  extends MessageMicro<ApproverState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bepushed_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_bepushed_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_state = PBField.initUInt32(0);
  public final PBUInt64Field uint64_approve_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_state", "uint32_bepushed_times", "bytes_comment", "uint32_last_bepushed_time", "uint64_approve_time" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger, Long.valueOf(0L) }, ApproverState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.ApproverState
 * JD-Core Version:    0.7.0.1
 */