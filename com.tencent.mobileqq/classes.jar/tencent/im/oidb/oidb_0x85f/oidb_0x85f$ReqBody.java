package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x85f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 794 }, new String[] { "msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open" }, new Object[] { null, null, null, null, null }, ReqBody.class);
  public oidb_0x85f.CommParamReq msg_comm_param = new oidb_0x85f.CommParamReq();
  public oidb_0x85f.GrayOpenReq msg_gray_open = new oidb_0x85f.GrayOpenReq();
  public oidb_0x85f.MatchCheckReq msg_match_check = new oidb_0x85f.MatchCheckReq();
  public oidb_0x85f.ReadScoreListReq msg_read_list = new oidb_0x85f.ReadScoreListReq();
  public oidb_0x85f.ReadFaceScoreBatchReq msg_read_score = new oidb_0x85f.ReadFaceScoreBatchReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReqBody
 * JD-Core Version:    0.7.0.1
 */