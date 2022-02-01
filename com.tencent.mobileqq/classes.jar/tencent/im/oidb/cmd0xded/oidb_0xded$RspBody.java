package tencent.im.oidb.cmd0xded;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xded$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_classify_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xded.ClassifyInfo> rpt_classify_info = PBField.initRepeatMessage(oidb_0xded.ClassifyInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xded.oidb_0xded.RspBody
 * JD-Core Version:    0.7.0.1
 */