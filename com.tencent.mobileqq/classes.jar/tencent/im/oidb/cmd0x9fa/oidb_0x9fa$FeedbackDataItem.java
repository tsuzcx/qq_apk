package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9fa$FeedbackDataItem
  extends MessageMicro<FeedbackDataItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_feedback_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint64_feedback_time" }, new Object[] { localLong, localLong }, FeedbackDataItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa.FeedbackDataItem
 * JD-Core Version:    0.7.0.1
 */