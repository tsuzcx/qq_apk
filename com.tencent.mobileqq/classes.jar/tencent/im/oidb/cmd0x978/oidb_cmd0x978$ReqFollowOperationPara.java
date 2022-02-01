package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x978$ReqFollowOperationPara
  extends MessageMicro<ReqFollowOperationPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField op_type = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_cmd0x978.OneFollowOperationInfo> rpt_follow_operation_info = PBField.initRepeatMessage(oidb_cmd0x978.OneFollowOperationInfo.class);
  public final PBUInt32Field uint32_force_use_op_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104 }, new String[] { "op_type", "bytes_cookie", "rpt_follow_operation_info", "uint32_force_use_op_type" }, new Object[] { Integer.valueOf(1), localByteStringMicro, null, Integer.valueOf(0) }, ReqFollowOperationPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqFollowOperationPara
 * JD-Core Version:    0.7.0.1
 */