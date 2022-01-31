package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0xbab$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user_get_req", "user_set_req", "group_get_req", "group_set_req" }, new Object[] { null, null, null, null }, ReqBody.class);
  public cmd0xbab.GroupGetReq group_get_req = new cmd0xbab.GroupGetReq();
  public cmd0xbab.GroupSetReq group_set_req = new cmd0xbab.GroupSetReq();
  public cmd0xbab.UserGetReq user_get_req = new cmd0xbab.UserGetReq();
  public cmd0xbab.UserSetReq user_set_req = new cmd0xbab.UserSetReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbab.cmd0xbab.ReqBody
 * JD-Core Version:    0.7.0.1
 */