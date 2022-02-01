package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe61$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurd_cube_info" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xe61.BeancurdCubeInfo> rpt_beancurd_cube_info = PBField.initRepeatMessage(oidb_0xe61.BeancurdCubeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe61.oidb_0xe61.ReqBody
 * JD-Core Version:    0.7.0.1
 */