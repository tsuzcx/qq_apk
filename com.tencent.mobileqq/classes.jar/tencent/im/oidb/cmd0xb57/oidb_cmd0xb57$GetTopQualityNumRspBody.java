package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb57$GetTopQualityNumRspBody
  extends MessageMicro<GetTopQualityNumRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_quality_num_items" }, new Object[] { null }, GetTopQualityNumRspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xb57.QualityNumItem> rpt_msg_quality_num_items = PBField.initRepeatMessage(oidb_cmd0xb57.QualityNumItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetTopQualityNumRspBody
 * JD-Core Version:    0.7.0.1
 */