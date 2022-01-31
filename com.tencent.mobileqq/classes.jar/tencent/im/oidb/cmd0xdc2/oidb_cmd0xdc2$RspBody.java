package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xdc2$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "batch_send_rsp" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xdc2.BatchSendRsp> batch_send_rsp = PBField.initRepeatMessage(oidb_cmd0xdc2.BatchSendRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.RspBody
 * JD-Core Version:    0.7.0.1
 */