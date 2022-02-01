package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x4d4$GetWorkflowByIDRsp
  extends MessageMicro<GetWorkflowByIDRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x4d4.GetWorkflowResult msg_workflow_result = new oidb_0x4d4.GetWorkflowResult();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "msg_workflow_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, GetWorkflowByIDRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.GetWorkflowByIDRsp
 * JD-Core Version:    0.7.0.1
 */