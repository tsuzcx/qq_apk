package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x4d4$UpdateFailure
  extends MessageMicro<UpdateFailure>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "bytes_error_msg", "bytes_workflow_id", "msg_workflow" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, UpdateFailure.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.UpdateFailure
 * JD-Core Version:    0.7.0.1
 */