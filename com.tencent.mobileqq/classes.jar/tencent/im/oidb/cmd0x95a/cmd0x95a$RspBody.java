package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "msg_update_ar_count_rsp", "msg_get_ar_activity_red_rsp" }, new Object[] { null, null }, RspBody.class);
  public cmd0x95a.GetArActivityRedRsp msg_get_ar_activity_red_rsp = new cmd0x95a.GetArActivityRedRsp();
  public cmd0x95a.UpdateArCountRsp msg_update_ar_count_rsp = new cmd0x95a.UpdateArCountRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.RspBody
 * JD-Core Version:    0.7.0.1
 */