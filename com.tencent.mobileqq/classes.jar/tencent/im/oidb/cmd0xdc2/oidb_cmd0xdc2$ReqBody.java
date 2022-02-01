package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public final class oidb_cmd0xdc2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_body", "batch_send_req" }, new Object[] { null, null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xdc2.BatchSendReq> batch_send_req = PBField.initRepeatMessage(oidb_cmd0xdc2.BatchSendReq.class);
  public oidb_cmd0xb77.ReqBody msg_body = new oidb_cmd0xb77.ReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.ReqBody
 * JD-Core Version:    0.7.0.1
 */