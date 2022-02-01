package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xef0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_detail" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xef0.RspDetail> rpt_msg_rsp_detail = PBField.initRepeatMessage(oidb_0xef0.RspDetail.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef0.oidb_0xef0.RspBody
 * JD-Core Version:    0.7.0.1
 */