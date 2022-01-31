package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd4b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_subscribe_video_column_req", "msg_checkuser_substatus_req", "msg_query_kd_video_column_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0xd4b.CheckUserSubStatusReq msg_checkuser_substatus_req = new oidb_0xd4b.CheckUserSubStatusReq();
  public oidb_0xd4b.QueryKdVideoColumnReq msg_query_kd_video_column_req = new oidb_0xd4b.QueryKdVideoColumnReq();
  public oidb_0xd4b.SubscribeVideoColumnReq msg_subscribe_video_column_req = new oidb_0xd4b.SubscribeVideoColumnReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody
 * JD-Core Version:    0.7.0.1
 */