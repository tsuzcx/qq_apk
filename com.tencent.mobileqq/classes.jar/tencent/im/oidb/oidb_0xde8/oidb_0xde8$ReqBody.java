package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32, 40, 48, 56, 64, 80 }, new String[] { "uint64_to_uin", "uint32_check_fri_type", "uint32_start_time", "uint32_end_time", "uint32_type", "uint32_start", "uint32_num", "uint32_comment_size" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_check_fri_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8.ReqBody
 * JD-Core Version:    0.7.0.1
 */