package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe2a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_add_video_req", "msg_move_video_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0xe2a.AddVideoReq msg_add_video_req = new oidb_0xe2a.AddVideoReq();
  public oidb_0xe2a.MoveVideoReq msg_move_video_req = new oidb_0xe2a.MoveVideoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody
 * JD-Core Version:    0.7.0.1
 */