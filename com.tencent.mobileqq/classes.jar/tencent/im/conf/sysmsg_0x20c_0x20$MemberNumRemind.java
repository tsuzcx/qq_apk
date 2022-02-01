package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_0x20c_0x20$MemberNumRemind
  extends MessageMicro<MemberNumRemind>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u64_discuss_code", "u32_mem_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MemberNumRemind.class);
  public final PBUInt32Field u32_mem_num = PBField.initUInt32(0);
  public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.conf.sysmsg_0x20c_0x20.MemberNumRemind
 * JD-Core Version:    0.7.0.1
 */