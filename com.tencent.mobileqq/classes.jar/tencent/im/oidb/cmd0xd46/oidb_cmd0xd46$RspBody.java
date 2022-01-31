package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xd46$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "msg_ks_clear_unread_rsp", "msg_ks_get_subscribed_list_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_cmd0xd46.KsClearUnreadRsp msg_ks_clear_unread_rsp = new oidb_cmd0xd46.KsClearUnreadRsp();
  public oidb_cmd0xd46.KsGetSubscribedListRsp msg_ks_get_subscribed_list_rsp = new oidb_cmd0xd46.KsGetSubscribedListRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.RspBody
 * JD-Core Version:    0.7.0.1
 */