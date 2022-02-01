package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x86f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_seq", "uint32_total" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x86f.oidb_0x86f.ReqBody
 * JD-Core Version:    0.7.0.1
 */