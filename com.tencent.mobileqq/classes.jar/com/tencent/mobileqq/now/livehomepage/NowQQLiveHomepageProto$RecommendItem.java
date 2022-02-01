package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$RecommendItem
  extends MessageMicro<RecommendItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 72, 80 }, new String[] { "uint32_type", "msg_anchor", "msg_tag", "msg_hot_topic", "msg_banner", "msg_topicorvideo", "string_key", "need_row_insert", "row_insert_position" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, "", Boolean.valueOf(false), Integer.valueOf(0) }, RecommendItem.class);
  public NowQQLiveHomepageProto.RcmdAnchor msg_anchor = new NowQQLiveHomepageProto.RcmdAnchor();
  public NowQQLiveHomepageProto.Banner msg_banner = new NowQQLiveHomepageProto.Banner();
  public NowQQLiveHomepageProto.RcmdHotTopic msg_hot_topic = new NowQQLiveHomepageProto.RcmdHotTopic();
  public NowQQLiveHomepageProto.RcmdTag msg_tag = new NowQQLiveHomepageProto.RcmdTag();
  public NowQQLiveHomepageProto.RcmdTopicOrVideoList msg_topicorvideo = new NowQQLiveHomepageProto.RcmdTopicOrVideoList();
  public final PBBoolField need_row_insert = PBField.initBool(false);
  public final PBUInt32Field row_insert_position = PBField.initUInt32(0);
  public final PBStringField string_key = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendItem
 * JD-Core Version:    0.7.0.1
 */