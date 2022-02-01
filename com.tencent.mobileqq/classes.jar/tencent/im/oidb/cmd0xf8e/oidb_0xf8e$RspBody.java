package tencent.im.oidb.cmd0xf8e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf8e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "info", "rpt_group_list", "exp_time" }, new Object[] { null, null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field exp_time = PBField.initUInt32(0);
  public oidb_0xf8e.InfoValue info = new oidb_0xf8e.InfoValue();
  public final PBRepeatMessageField<oidb_0xf8e.UserNode> rpt_group_list = PBField.initRepeatMessage(oidb_0xf8e.UserNode.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8e.oidb_0xf8e.RspBody
 * JD-Core Version:    0.7.0.1
 */