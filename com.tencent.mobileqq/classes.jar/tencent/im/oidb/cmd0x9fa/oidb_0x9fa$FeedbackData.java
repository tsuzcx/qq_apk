package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x9fa$FeedbackData
  extends MessageMicro<FeedbackData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_feedback" }, new Object[] { null }, FeedbackData.class);
  public final PBRepeatMessageField<oidb_0x9fa.FeedbackDataItem> msg_feedback = PBField.initRepeatMessage(oidb_0x9fa.FeedbackDataItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa.FeedbackData
 * JD-Core Version:    0.7.0.1
 */