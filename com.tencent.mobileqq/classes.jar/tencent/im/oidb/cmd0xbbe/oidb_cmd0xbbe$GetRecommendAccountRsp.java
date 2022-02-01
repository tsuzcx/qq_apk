package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbbe$GetRecommendAccountRsp
  extends MessageMicro<GetRecommendAccountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_recommend_account_info" }, new Object[] { null }, GetRecommendAccountRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xbbe.RecommendAccountInfo> rpt_msg_recommend_account_info = PBField.initRepeatMessage(oidb_cmd0xbbe.RecommendAccountInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.GetRecommendAccountRsp
 * JD-Core Version:    0.7.0.1
 */