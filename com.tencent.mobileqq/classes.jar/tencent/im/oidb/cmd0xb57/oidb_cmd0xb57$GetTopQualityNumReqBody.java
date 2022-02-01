package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb57$GetTopQualityNumReqBody
  extends MessageMicro<GetTopQualityNumReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_quality_num" }, new Object[] { Long.valueOf(0L) }, GetTopQualityNumReqBody.class);
  public final PBRepeatField<Long> rpt_uint64_quality_num = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetTopQualityNumReqBody
 * JD-Core Version:    0.7.0.1
 */