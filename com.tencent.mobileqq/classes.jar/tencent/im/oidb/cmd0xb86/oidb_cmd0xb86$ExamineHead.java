package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$ExamineHead
  extends MessageMicro<ExamineHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "head", "uint64_timestamp" }, new Object[] { null, Long.valueOf(0L) }, ExamineHead.class);
  public oidb_cmd0xb86.HeadInfo head = new oidb_cmd0xb86.HeadInfo();
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ExamineHead
 * JD-Core Version:    0.7.0.1
 */