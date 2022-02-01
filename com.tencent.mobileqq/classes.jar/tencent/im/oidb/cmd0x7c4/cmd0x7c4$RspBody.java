package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x7c4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_get_recommend_sn_frd_list_rsp", "msg_get_sn_frd_list_rsp", "rpt_msg_recommend_reason", "msg_box" }, new Object[] { null, null, null, null }, RspBody.class);
  public cmd0x7c4.MsgBox msg_box = new cmd0x7c4.MsgBox();
  public cmd0x7c4.GetRecommendSNFrdListRsp msg_get_recommend_sn_frd_list_rsp = new cmd0x7c4.GetRecommendSNFrdListRsp();
  public cmd0x7c4.GetSNFrdListRsp msg_get_sn_frd_list_rsp = new cmd0x7c4.GetSNFrdListRsp();
  public final PBRepeatMessageField<cmd0x7c4.RecommendReason> rpt_msg_recommend_reason = PBField.initRepeatMessage(cmd0x7c4.RecommendReason.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody
 * JD-Core Version:    0.7.0.1
 */