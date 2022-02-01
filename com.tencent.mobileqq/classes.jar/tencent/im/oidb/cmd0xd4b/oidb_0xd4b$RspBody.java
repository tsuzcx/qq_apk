package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd4b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "msg_subscribe_video_column_rsp", "query_kd_video_column_rsp", "msg_check_user_sub_status_rsp", "msg_query_sub_list_rsp", "msg_query_user_sub_count", "msg_query_sub_user_list_rsp", "msg_query_sub_visibility_rsp" }, new Object[] { null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0xd4b.CheckUserSubStatusRsp msg_check_user_sub_status_rsp = new oidb_0xd4b.CheckUserSubStatusRsp();
  public oidb_0xd4b.QuerySubListRsp msg_query_sub_list_rsp = new oidb_0xd4b.QuerySubListRsp();
  public oidb_0xd4b.QuerySubUserListRsp msg_query_sub_user_list_rsp = new oidb_0xd4b.QuerySubUserListRsp();
  public oidb_0xd4b.QuerySubVisibilityRsp msg_query_sub_visibility_rsp = new oidb_0xd4b.QuerySubVisibilityRsp();
  public oidb_0xd4b.QueryUserSubCountRsp msg_query_user_sub_count = new oidb_0xd4b.QueryUserSubCountRsp();
  public oidb_0xd4b.SubscribeVideoColumnRsp msg_subscribe_video_column_rsp = new oidb_0xd4b.SubscribeVideoColumnRsp();
  public oidb_0xd4b.QueryKdVideoColumnRsp query_kd_video_column_rsp = new oidb_0xd4b.QueryKdVideoColumnRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody
 * JD-Core Version:    0.7.0.1
 */