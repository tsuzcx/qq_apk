package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x4d4$UpdateWorkflowsRsp
  extends MessageMicro<UpdateWorkflowsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_update_type = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_0x4d4.UpdateFailure> rpt_msg_udpate_failure_list = PBField.initRepeatMessage(oidb_0x4d4.UpdateFailure.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "enum_update_type", "uint32_result", "bytes_error_msg", "rpt_msg_udpate_failure_list" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro, null }, UpdateWorkflowsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.UpdateWorkflowsRsp
 * JD-Core Version:    0.7.0.1
 */