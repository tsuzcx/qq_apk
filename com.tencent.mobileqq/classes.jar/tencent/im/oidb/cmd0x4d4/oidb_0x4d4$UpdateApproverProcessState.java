package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow.ApproverState;

public final class oidb_0x4d4$UpdateApproverProcessState
  extends MessageMicro<UpdateApproverProcessState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "uint32_data_version", "msg_approver_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, UpdateApproverProcessState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.UpdateApproverProcessState
 * JD-Core Version:    0.7.0.1
 */