package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$FriendRecommendInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "rpt_recommenders", "str_header_title", "rpt_jumps", "rpt_social_leader_info" }, new Object[] { Long.valueOf(0L), "", null, null }, FriendRecommendInfo.class);
  public final PBRepeatMessageField rpt_jumps = PBField.initRepeatMessage(oidb_cmd0x68b.PackJumpInfo.class);
  public final PBRepeatField rpt_recommenders = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_social_leader_info = PBField.initRepeatMessage(oidb_cmd0x68b.SocialLeaderInfoData.class);
  public final PBStringField str_header_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo
 * JD-Core Version:    0.7.0.1
 */