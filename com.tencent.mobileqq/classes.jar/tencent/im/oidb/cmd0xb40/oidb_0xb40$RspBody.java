package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb40$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_check_favorite_rsp", "msg_get_favorite_list_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xb40.CheckFavoriteRspBody msg_check_favorite_rsp = new oidb_0xb40.CheckFavoriteRspBody();
  public oidb_0xb40.GetFavoriteListRspBody msg_get_favorite_list_rsp = new oidb_0xb40.GetFavoriteListRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.RspBody
 * JD-Core Version:    0.7.0.1
 */