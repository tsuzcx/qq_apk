package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyGetSpaceRspBody
  extends MessageMicro<ApplyGetSpaceRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_total_space", "uint64_used_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ApplyGetSpaceRspBody.class);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetSpaceRspBody
 * JD-Core Version:    0.7.0.1
 */