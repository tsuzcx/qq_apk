package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_putinfo$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_putinfo_head", "msg_to_client_config_info_rsq_body" }, new Object[] { null, null }, RspBody.class);
  public hd_video_putinfo.PutinfoHead msg_putinfo_head = new hd_video_putinfo.PutinfoHead();
  public hd_video_putinfo.CmdToClientConfigInfoRspBody msg_to_client_config_info_rsq_body = new hd_video_putinfo.CmdToClientConfigInfoRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody
 * JD-Core Version:    0.7.0.1
 */