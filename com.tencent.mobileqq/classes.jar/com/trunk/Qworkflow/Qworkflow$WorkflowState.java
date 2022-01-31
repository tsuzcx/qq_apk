package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Qworkflow$WorkflowState
  extends MessageMicro<WorkflowState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_state_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_state_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_state_num", "bytes_state_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, WorkflowState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.WorkflowState
 * JD-Core Version:    0.7.0.1
 */