package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Qworkflow$WorkflowExtendState
  extends MessageMicro<WorkflowExtendState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_delete_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
  public final PBUInt32Field uint32_delete_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_state = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_read_state", "uint32_delete_state", "rpt_msg_delete_timespan" }, new Object[] { localInteger, localInteger, null }, WorkflowExtendState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.WorkflowExtendState
 * JD-Core Version:    0.7.0.1
 */