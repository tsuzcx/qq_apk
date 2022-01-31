package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_putinfo$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_report_client_info_req_body" }, new Object[] { null, null }, ReqBody.class);
  public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
  public hd_video_putinfo.CmdReportClientInfoReqBody msg_report_client_info_req_body = new hd_video_putinfo.CmdReportClientInfoReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.ReqBody
 * JD-Core Version:    0.7.0.1
 */