package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x85f$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 794 }, new String[] { "msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open" }, new Object[] { null, null, null, null, null }, RspBody.class);
  public oidb_0x85f.CommParamRsp msg_comm_param = new oidb_0x85f.CommParamRsp();
  public oidb_0x85f.GrayOpenRsp msg_gray_open = new oidb_0x85f.GrayOpenRsp();
  public oidb_0x85f.MatchCheckRsp msg_match_check = new oidb_0x85f.MatchCheckRsp();
  public oidb_0x85f.ReadScoreListRsp msg_read_list = new oidb_0x85f.ReadScoreListRsp();
  public oidb_0x85f.ReadFaceScoreBatchRsp msg_read_score = new oidb_0x85f.ReadFaceScoreBatchRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.RspBody
 * JD-Core Version:    0.7.0.1
 */