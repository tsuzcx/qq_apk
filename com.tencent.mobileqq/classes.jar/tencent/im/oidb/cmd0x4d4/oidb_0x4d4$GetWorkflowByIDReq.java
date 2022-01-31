package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x4d4$GetWorkflowByIDReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.WorkflowBrief msg_workflow_brief = new Qworkflow.WorkflowBrief();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_workflow_brief" }, new Object[] { localByteStringMicro, null }, GetWorkflowByIDReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.GetWorkflowByIDReq
 * JD-Core Version:    0.7.0.1
 */