package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb61$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "get_appinfo_req", "get_mqqapp_url_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0xb61.GetAppinfoReq get_appinfo_req = new oidb_0xb61.GetAppinfoReq();
  public oidb_0xb61.GetPkgUrlReq get_mqqapp_url_req = new oidb_0xb61.GetPkgUrlReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.ReqBody
 * JD-Core Version:    0.7.0.1
 */