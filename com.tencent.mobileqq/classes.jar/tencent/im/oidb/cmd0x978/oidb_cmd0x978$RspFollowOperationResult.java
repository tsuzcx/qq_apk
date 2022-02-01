package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x978$RspFollowOperationResult
  extends MessageMicro<RspFollowOperationResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField op_type = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_cmd0x978.OneFollowOperationResult> rpt_follow_operation_result = PBField.initRepeatMessage(oidb_cmd0x978.OneFollowOperationResult.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "op_type", "bytes_cookie", "rpt_follow_operation_result" }, new Object[] { Integer.valueOf(1), localByteStringMicro, null }, RspFollowOperationResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult
 * JD-Core Version:    0.7.0.1
 */