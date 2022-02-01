package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe2a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_add_video_rsp", "msg_move_video_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xe2a.AddVideoRsp msg_add_video_rsp = new oidb_0xe2a.AddVideoRsp();
  public oidb_0xe2a.MoveVideoRsp msg_move_video_rsp = new oidb_0xe2a.MoveVideoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody
 * JD-Core Version:    0.7.0.1
 */