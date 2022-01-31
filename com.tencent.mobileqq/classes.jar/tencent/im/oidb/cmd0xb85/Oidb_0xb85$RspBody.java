package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Oidb_0xb85$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "report_score_rsp", "get_ranklist_rsp" }, new Object[] { null, null }, RspBody.class);
  public Oidb_0xb85.GetRankListRspBody get_ranklist_rsp = new Oidb_0xb85.GetRankListRspBody();
  public Oidb_0xb85.ReportScoreRspBody report_score_rsp = new Oidb_0xb85.ReportScoreRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb85.Oidb_0xb85.RspBody
 * JD-Core Version:    0.7.0.1
 */