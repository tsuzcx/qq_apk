package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe61$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurd_cube_info_result" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xe61.BeancurdCubeInfoResult> rpt_beancurd_cube_info_result = PBField.initRepeatMessage(oidb_0xe61.BeancurdCubeInfoResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe61.oidb_0xe61.RspBody
 * JD-Core Version:    0.7.0.1
 */