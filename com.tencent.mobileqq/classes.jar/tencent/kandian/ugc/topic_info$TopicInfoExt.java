package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicInfoExt
  extends MessageMicro<TopicInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field algorithm_id = PBField.initInt64(0L);
  public final PBUInt32Field auditing_video_cnt = PBField.initUInt32(0);
  public final PBUInt32Field comment_num = PBField.initUInt32(0);
  public final PBUInt32Field content_count = PBField.initUInt32(0);
  public final PBUInt32Field cooperator_cnt = PBField.initUInt32(0);
  public final PBStringField creator_avatar_url = PBField.initString("");
  public final PBStringField creator_nickname = PBField.initString("");
  public final PBStringField feed_up_time_text = PBField.initString("");
  public final PBUInt32Field feeds_up_time = PBField.initUInt32(0);
  public final PBBoolField has_subscribe = PBField.initBool(false);
  public final PBBoolField is_top = PBField.initBool(false);
  public final PBRepeatMessageField<topic_info.CooperatorUser> lastest_cooperator_user = PBField.initRepeatMessage(topic_info.CooperatorUser.class);
  public final PBRepeatMessageField<topic_info.ModuleInfo> modules = PBField.initRepeatMessage(topic_info.ModuleInfo.class);
  public final PBBoolField my_topic_flag = PBField.initBool(false);
  public final PBUInt32Field new_num = PBField.initUInt32(0);
  public final PBStringField share_url = PBField.initString("");
  public final PBUInt32Field subscribe_num = PBField.initUInt32(0);
  public final PBUInt32Field topic_feed_audit_status = PBField.initUInt32(0);
  public final PBUInt32Field topic_view = PBField.initUInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 106, 114, 120, 128, 136, 144, 154 }, new String[] { "has_subscribe", "modules", "content_count", "subscribe_num", "share_url", "algorithm_id", "is_top", "topic_view", "feeds_up_time", "feed_up_time_text", "topic_feed_audit_status", "comment_num", "creator_nickname", "creator_avatar_url", "new_num", "my_topic_flag", "auditing_video_cnt", "cooperator_cnt", "lastest_cooperator_user" }, new Object[] { localBoolean, null, localInteger, localInteger, "", Long.valueOf(0L), localBoolean, localInteger, localInteger, "", localInteger, localInteger, "", "", localInteger, localBoolean, localInteger, localInteger, null }, TopicInfoExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicInfoExt
 * JD-Core Version:    0.7.0.1
 */