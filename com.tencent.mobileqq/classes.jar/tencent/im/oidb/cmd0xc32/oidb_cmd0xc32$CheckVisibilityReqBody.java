package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xc32$CheckVisibilityReqBody
  extends MessageMicro<CheckVisibilityReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_triads" }, new Object[] { null }, CheckVisibilityReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xc32.CheckTriad> rpt_triads = PBField.initRepeatMessage(oidb_cmd0xc32.CheckTriad.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.CheckVisibilityReqBody
 * JD-Core Version:    0.7.0.1
 */