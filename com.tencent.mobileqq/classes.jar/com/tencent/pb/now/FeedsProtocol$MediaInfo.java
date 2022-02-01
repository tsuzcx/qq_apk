package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$MediaInfo
  extends MessageMicro<MediaInfo>
{
  public static final int LIVE_AGGREGATE = 1;
  public static final int LIVE_ANCHOR = 4;
  public static final int PIC_FEEDS = 5;
  public static final int SHORT_VIDEO = 3;
  public static final int TEXT_FEEDS = 6;
  public static final int VIDEO_LIST = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 810, 816, 826 }, new String[] { "type", "msg_live_anchor", "video", "short_video", "live_aggregate", "pic_info", "topic_cfg", "is_my_feeds", "text_feed" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), null }, MediaInfo.class);
  public final PBUInt32Field is_my_feeds = PBField.initUInt32(0);
  public FeedsProtocol.LiveAggregateInfo live_aggregate = new FeedsProtocol.LiveAggregateInfo();
  public FeedsProtocol.LiveAnchorItem msg_live_anchor = new FeedsProtocol.LiveAnchorItem();
  public FeedsProtocol.PicFeedsInfo pic_info = new FeedsProtocol.PicFeedsInfo();
  public FeedsProtocol.ShortVideoInfo short_video = new FeedsProtocol.ShortVideoInfo();
  public FeedsProtocol.TextFeed text_feed = new FeedsProtocol.TextFeed();
  public final PBRepeatMessageField<FeedsProtocol.TopicCfg> topic_cfg = PBField.initRepeatMessage(FeedsProtocol.TopicCfg.class);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public FeedsProtocol.VideoItem video = new FeedsProtocol.VideoItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.MediaInfo
 * JD-Core Version:    0.7.0.1
 */