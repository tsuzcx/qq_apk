package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NowQQLiveHomepageProto$RcmdTopicOrVideoList
  extends MessageMicro<RcmdTopicOrVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "topic_list", "more_url" }, new Object[] { null, "" }, RcmdTopicOrVideoList.class);
  public final PBStringField more_url = PBField.initString("");
  public final PBRepeatMessageField<NowQQLiveHomepageProto.RcmdTopicOrVideo> topic_list = PBField.initRepeatMessage(NowQQLiveHomepageProto.RcmdTopicOrVideo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdTopicOrVideoList
 * JD-Core Version:    0.7.0.1
 */