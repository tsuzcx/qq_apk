package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xa6e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topicinfo" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xa6e.TopicInfo> rpt_topicinfo = PBField.initRepeatMessage(oidb_cmd0xa6e.TopicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.RspBody
 * JD-Core Version:    0.7.0.1
 */