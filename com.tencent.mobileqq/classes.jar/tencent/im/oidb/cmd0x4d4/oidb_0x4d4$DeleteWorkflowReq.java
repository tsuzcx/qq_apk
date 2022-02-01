package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x4d4$DeleteWorkflowReq
  extends MessageMicro<DeleteWorkflowReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, DeleteWorkflowReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.DeleteWorkflowReq
 * JD-Core Version:    0.7.0.1
 */