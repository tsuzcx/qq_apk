package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NowQQLiveHomepageProto$RcmdHotTopic
  extends MessageMicro<RcmdHotTopic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "offical_topic", "hot_topics", "string_url_more" }, new Object[] { null, null, "" }, RcmdHotTopic.class);
  public final PBRepeatMessageField<NowQQLiveHomepageProto.TopicItem> hot_topics = PBField.initRepeatMessage(NowQQLiveHomepageProto.TopicItem.class);
  public NowQQLiveHomepageProto.TopicItem offical_topic = new NowQQLiveHomepageProto.TopicItem();
  public final PBStringField string_url_more = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdHotTopic
 * JD-Core Version:    0.7.0.1
 */