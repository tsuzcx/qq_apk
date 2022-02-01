package tencent.im.oidb.cmd0x614;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0x614$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_DM_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_MDN_REQ_BODY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_dm_head", "msg_mdn_req_body" }, new Object[] { null, null }, ReqBody.class);
  public Oidb_0x614.DeviceManageHead msg_dm_head = new Oidb_0x614.DeviceManageHead();
  public Oidb_0x614.ReNameDeviceNameReqBody msg_mdn_req_body = new Oidb_0x614.ReNameDeviceNameReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody
 * JD-Core Version:    0.7.0.1
 */