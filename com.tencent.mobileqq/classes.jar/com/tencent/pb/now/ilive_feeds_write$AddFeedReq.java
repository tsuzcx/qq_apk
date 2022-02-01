package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_write$AddFeedReq
  extends MessageMicro<AddFeedReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 64, 72, 82 }, new String[] { "feed_type", "feed_source", "feed_video", "feed_upload_status", "pic_info", "live_info", "chang_info", "nowid", "local_video_flag", "lbs_info" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1), null, null, null, Long.valueOf(0L), Integer.valueOf(0), null }, AddFeedReq.class);
  public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
  public final PBEnumField feed_source = PBField.initEnum(0);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public final PBEnumField feed_upload_status = PBField.initEnum(1);
  public ilive_feeds_tmem.VideoFeed feed_video = new ilive_feeds_tmem.VideoFeed();
  public ilive_feeds_write.LbsInfo lbs_info = new ilive_feeds_write.LbsInfo();
  public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
  public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
  public final PBUInt64Field nowid = PBField.initUInt64(0L);
  public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write.AddFeedReq
 * JD-Core Version:    0.7.0.1
 */