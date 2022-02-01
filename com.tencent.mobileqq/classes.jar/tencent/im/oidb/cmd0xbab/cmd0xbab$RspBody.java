package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0xbab$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user_get_rsp", "user_set_rsp", "group_get_rsp", "group_set_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
  public cmd0xbab.GroupGetRsp group_get_rsp = new cmd0xbab.GroupGetRsp();
  public cmd0xbab.GroupSetRsp group_set_rsp = new cmd0xbab.GroupSetRsp();
  public cmd0xbab.UserGetRsp user_get_rsp = new cmd0xbab.UserGetRsp();
  public cmd0xbab.UserSetRsp user_set_rsp = new cmd0xbab.UserSetRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbab.cmd0xbab.RspBody
 * JD-Core Version:    0.7.0.1
 */