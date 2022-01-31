package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "msg_update_ar_count_req", "msg_get_ar_activity_red_req" }, new Object[] { null, null }, ReqBody.class);
  public cmd0x95a.GetArActivityRedReq msg_get_ar_activity_red_req = new cmd0x95a.GetArActivityRedReq();
  public cmd0x95a.UpdateArCountReq msg_update_ar_count_req = new cmd0x95a.UpdateArCountReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.ReqBody
 * JD-Core Version:    0.7.0.1
 */