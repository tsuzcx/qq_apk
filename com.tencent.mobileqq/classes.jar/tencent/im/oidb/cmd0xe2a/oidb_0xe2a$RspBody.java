package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe2a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 66, 74 }, new String[] { "msg_add_video_rsp", "msg_move_video_rsp", "msg_judge_topic_video_num_rsp", "msg_judge_user_status_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
  public oidb_0xe2a.AddVideoRsp msg_add_video_rsp = new oidb_0xe2a.AddVideoRsp();
  public oidb_0xe2a.JudgeTopicVideoNumRsp msg_judge_topic_video_num_rsp = new oidb_0xe2a.JudgeTopicVideoNumRsp();
  public oidb_0xe2a.JudgeUserStatusRsp msg_judge_user_status_rsp = new oidb_0xe2a.JudgeUserStatusRsp();
  public oidb_0xe2a.MoveVideoRsp msg_move_video_rsp = new oidb_0xe2a.MoveVideoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody
 * JD-Core Version:    0.7.0.1
 */