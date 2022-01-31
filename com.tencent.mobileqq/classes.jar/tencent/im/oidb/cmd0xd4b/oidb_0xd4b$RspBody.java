package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd4b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_subscribe_video_column_rsp", "query_kd_video_column_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xd4b.SubscribeVideoColumnRsp msg_subscribe_video_column_rsp = new oidb_0xd4b.SubscribeVideoColumnRsp();
  public oidb_0xd4b.QueryKdVideoColumnRsp query_kd_video_column_rsp = new oidb_0xd4b.QueryKdVideoColumnRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody
 * JD-Core Version:    0.7.0.1
 */