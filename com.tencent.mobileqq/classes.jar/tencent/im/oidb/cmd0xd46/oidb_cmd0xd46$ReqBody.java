package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_oper_type", "msg_ks_clear_unread_req", "msg_ks_get_subscribed_list_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public oidb_cmd0xd46.KsClearUnreadReq msg_ks_clear_unread_req = new oidb_cmd0xd46.KsClearUnreadReq();
  public oidb_cmd0xd46.KsGetSubscribedListReq msg_ks_get_subscribed_list_req = new oidb_cmd0xd46.KsGetSubscribedListReq();
  public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.ReqBody
 * JD-Core Version:    0.7.0.1
 */