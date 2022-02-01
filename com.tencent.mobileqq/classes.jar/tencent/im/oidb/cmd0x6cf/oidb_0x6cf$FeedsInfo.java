package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x6cf$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "feeds_type", "msg_pos_ad_info", "rpt_msg_neg_feedback" }, new Object[] { Integer.valueOf(0), null, null }, FeedsInfo.class);
  public final PBEnumField feeds_type = PBField.initEnum(0);
  public oidb_0x6cf.PosAdInfo msg_pos_ad_info = new oidb_0x6cf.PosAdInfo();
  public final PBRepeatMessageField<oidb_0x6cf.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x6cf.NegFeedback.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */