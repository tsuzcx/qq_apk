package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PackInfo
  extends MessageMicro<PackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_pack_id", "pack_type", "msg_friend_recommend_info", "msg_special_topic_info", "uint32_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), null, null, Integer.valueOf(0) }, PackInfo.class);
  public articlesummary.FriendRecommendInfo msg_friend_recommend_info = new articlesummary.FriendRecommendInfo();
  public articlesummary.SpecialTopicInfo msg_special_topic_info = new articlesummary.SpecialTopicInfo();
  public final PBEnumField pack_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pack_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackInfo
 * JD-Core Version:    0.7.0.1
 */