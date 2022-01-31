package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$FeedsTmem
  extends MessageMicro<FeedsTmem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bg_color = PBField.initUInt32(0);
  public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public ilive_feeds_tmem.VideoFeed feed_info = new ilive_feeds_tmem.VideoFeed();
  public final PBEnumField feed_source = PBField.initEnum(0);
  public final PBEnumField feed_status = PBField.initEnum(0);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public ilive_feeds_tmem.LbsInfoOld lbs_info = new ilive_feeds_tmem.LbsInfoOld();
  public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
  public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
  public final PBUInt64Field nowid = PBField.initUInt64(0L);
  public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
  public final PBUInt64Field publish_uin = PBField.initUInt64(0L);
  public final PBEnumField up_status = PBField.initEnum(1);
  public final PBUInt32Field view_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90, 98, 104, 112, 122, 128 }, new String[] { "publish_uin", "create_time", "feed_type", "feed_source", "feed_status", "feeds_id", "feed_info", "view_times", "up_status", "pic_info", "live_info", "chang_info", "nowid", "bg_color", "lbs_info", "local_video_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(1), null, null, null, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, FeedsTmem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.FeedsTmem
 * JD-Core Version:    0.7.0.1
 */