package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe2a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 66, 74 }, new String[] { "msg_add_video_req", "msg_move_video_req", "msg_judge_topic_video_num_req", "msg_judge_user_status_req" }, new Object[] { null, null, null, null }, ReqBody.class);
  public oidb_0xe2a.AddVideoReq msg_add_video_req = new oidb_0xe2a.AddVideoReq();
  public oidb_0xe2a.JudgeTopicVideoNumReq msg_judge_topic_video_num_req = new oidb_0xe2a.JudgeTopicVideoNumReq();
  public oidb_0xe2a.JudgeUserStatusReq msg_judge_user_status_req = new oidb_0xe2a.JudgeUserStatusReq();
  public oidb_0xe2a.MoveVideoReq msg_move_video_req = new oidb_0xe2a.MoveVideoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody
 * JD-Core Version:    0.7.0.1
 */