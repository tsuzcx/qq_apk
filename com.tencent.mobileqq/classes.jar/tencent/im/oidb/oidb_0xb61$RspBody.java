package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb61$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 82, 90 }, new String[] { "wording", "next_req_duration", "get_appinfo_rsp", "get_mqqapp_url_rsp" }, new Object[] { "", Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_0xb61.GetAppinfoRsp get_appinfo_rsp = new oidb_0xb61.GetAppinfoRsp();
  public oidb_0xb61.GetPkgUrlRsp get_mqqapp_url_rsp = new oidb_0xb61.GetPkgUrlRsp();
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.RspBody
 * JD-Core Version:    0.7.0.1
 */