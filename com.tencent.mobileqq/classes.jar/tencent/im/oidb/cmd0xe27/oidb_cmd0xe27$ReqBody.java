package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xe27$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_in_out_qq" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xe27.InOutQQ> rpt_msg_in_out_qq = PBField.initRepeatMessage(oidb_cmd0xe27.InOutQQ.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.ReqBody
 * JD-Core Version:    0.7.0.1
 */