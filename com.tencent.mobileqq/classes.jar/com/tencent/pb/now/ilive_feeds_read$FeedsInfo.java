package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
  public final PBInt32Field comment_num = PBField.initInt32(0);
  public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> comments = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBDoubleField distance = PBField.initDouble(0.0D);
  public ilive_feeds_tmem.VideoFeed feed_info = new ilive_feeds_tmem.VideoFeed();
  public final PBEnumField feed_source = PBField.initEnum(0);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
  public final PBInt32Field like = PBField.initInt32(0);
  public ilive_feeds_tmem.FeedsTmemLike like_info = new ilive_feeds_tmem.FeedsTmemLike();
  public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
  public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
  public ilive_feeds_read.FeedUserInfo publish_info = new ilive_feeds_read.FeedUserInfo();
  public final PBUInt64Field publish_uin = PBField.initUInt64(0L);
  public final PBEnumField status = PBField.initEnum(1);
  public ilive_feeds_tmem.TextFeed text_feed = new ilive_feeds_tmem.TextFeed();
  public final PBRepeatMessageField<ilive_feeds_read.TopicCfg> topic_cfg = PBField.initRepeatMessage(ilive_feeds_read.TopicCfg.class);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBUInt32Field view_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 50, 58, 64, 72, 82, 90, 98, 106, 114, 122, 154, 800, 810, 818, 824, 832, 841, 850 }, new String[] { "publish_uin", "create_time", "feed_type", "feed_source", "feeds_id", "feed_info", "view_times", "status", "pic_info", "live_info", "chang_info", "jump_url", "publish_info", "lbs_info", "text_feed", "like", "like_info", "comments", "comment_num", "type", "distance", "topic_cfg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(1), null, null, null, localByteStringMicro2, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), null }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */