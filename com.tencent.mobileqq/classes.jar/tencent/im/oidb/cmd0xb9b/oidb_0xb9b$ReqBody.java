package tencent.im.oidb.cmd0xb9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb9b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_match_op", "uint64_match_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt32Field uint32_match_op = PBField.initUInt32(0);
  public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb9b.oidb_0xb9b.ReqBody
 * JD-Core Version:    0.7.0.1
 */