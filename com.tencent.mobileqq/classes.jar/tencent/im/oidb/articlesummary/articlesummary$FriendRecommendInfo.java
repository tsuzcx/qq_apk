package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$FriendRecommendInfo
  extends MessageMicro<FriendRecommendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "rpt_recommenders", "str_header_title", "rpt_jumps", "rpt_social_leader_info" }, new Object[] { Long.valueOf(0L), "", null, null }, FriendRecommendInfo.class);
  public final PBRepeatMessageField<articlesummary.PackJumpInfo> rpt_jumps = PBField.initRepeatMessage(articlesummary.PackJumpInfo.class);
  public final PBRepeatField<Long> rpt_recommenders = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<articlesummary.SocialLeaderInfoData> rpt_social_leader_info = PBField.initRepeatMessage(articlesummary.SocialLeaderInfoData.class);
  public final PBStringField str_header_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo
 * JD-Core Version:    0.7.0.1
 */