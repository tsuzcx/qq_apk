package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class ilive_feeds_write$ModFeedReq
  extends MessageMicro<ModFeedReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "feed_type", "feed_source", "feed_video", "pic_info", "live_info", "chang_info" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, null, null, null }, ModFeedReq.class);
  public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
  public final PBEnumField feed_source = PBField.initEnum(0);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public ilive_feeds_tmem.VideoFeed feed_video = new ilive_feeds_tmem.VideoFeed();
  public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
  public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write.ModFeedReq
 * JD-Core Version:    0.7.0.1
 */