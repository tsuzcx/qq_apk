package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xb74$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_like_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<cmd0xb74.LikeInfo> rpt_like_info = PBField.initRepeatMessage(cmd0xb74.LikeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb74.cmd0xb74.RspBody
 * JD-Core Version:    0.7.0.1
 */