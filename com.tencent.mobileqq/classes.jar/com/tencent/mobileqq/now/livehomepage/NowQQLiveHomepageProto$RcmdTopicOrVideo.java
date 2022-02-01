package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveHomepageProto$RcmdTopicOrVideo
  extends MessageMicro<RcmdTopicOrVideo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 34, 42, 48, 58, 66, 72, 80 }, new String[] { "topic_word", "topic_word_color", "pic", "url", "type", "native_url", "pic_samll", "color_a", "color_b" }, new Object[] { "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L) }, RcmdTopicOrVideo.class);
  public final PBUInt64Field color_a = PBField.initUInt64(0L);
  public final PBUInt64Field color_b = PBField.initUInt64(0L);
  public final PBStringField native_url = PBField.initString("");
  public final PBStringField pic = PBField.initString("");
  public final PBStringField pic_samll = PBField.initString("");
  public final PBStringField topic_word = PBField.initString("");
  public final PBUInt32Field topic_word_color = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdTopicOrVideo
 * JD-Core Version:    0.7.0.1
 */