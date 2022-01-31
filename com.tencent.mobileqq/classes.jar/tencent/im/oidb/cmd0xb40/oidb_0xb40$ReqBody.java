package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb40$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_check_favorite_req", "msg_get_favorite_list_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0xb40.CheckFavoriteReqBody msg_check_favorite_req = new oidb_0xb40.CheckFavoriteReqBody();
  public oidb_0xb40.GetFavoriteListReqBody msg_get_favorite_list_req = new oidb_0xb40.GetFavoriteListReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.ReqBody
 * JD-Core Version:    0.7.0.1
 */