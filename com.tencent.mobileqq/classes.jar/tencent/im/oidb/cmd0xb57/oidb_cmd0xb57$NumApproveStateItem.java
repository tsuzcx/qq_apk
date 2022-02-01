package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb57$NumApproveStateItem
  extends MessageMicro<NumApproveStateItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_num_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xb57.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0xb57.MedalInfo.class);
  public final PBUInt32Field uint32_is_approve = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
  public final PBUInt64Field uint64_query_num = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_query_num", "uint32_is_approve", "bytes_num_summary", "uint32_is_star", "rpt_msg_medal_info" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro, localInteger, null }, NumApproveStateItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.NumApproveStateItem
 * JD-Core Version:    0.7.0.1
 */