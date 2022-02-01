package tencent.im.oidb.cmd0xbaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbaa$GetNewUserGuideRsp
  extends MessageMicro<GetNewUserGuideRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_need_recommend", "rpt_msg_recommend_account_info" }, new Object[] { Integer.valueOf(0), null }, GetNewUserGuideRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xbaa.RecommendAccountInfo> rpt_msg_recommend_account_info = PBField.initRepeatMessage(oidb_cmd0xbaa.RecommendAccountInfo.class);
  public final PBUInt32Field uint32_need_recommend = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbaa.oidb_cmd0xbaa.GetNewUserGuideRsp
 * JD-Core Version:    0.7.0.1
 */