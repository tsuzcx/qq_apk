package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_0x20c_0x20$Convert2Group
  extends MessageMicro<Convert2Group>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "u64_operator", "u64_discuss_code", "u64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, Convert2Group.class);
  public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
  public final PBUInt64Field u64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field u64_operator = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.conf.sysmsg_0x20c_0x20.Convert2Group
 * JD-Core Version:    0.7.0.1
 */