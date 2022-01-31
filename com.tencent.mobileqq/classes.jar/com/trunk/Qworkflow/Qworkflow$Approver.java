package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$Approver
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.UserSource msg_approver_source = new Qworkflow.UserSource();
  public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
  public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uint64_uin", "msg_approver_source", "msg_approver_state", "bytes_userdef", "uint64_recv_time" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro, Long.valueOf(0L) }, Approver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.Approver
 * JD-Core Version:    0.7.0.1
 */