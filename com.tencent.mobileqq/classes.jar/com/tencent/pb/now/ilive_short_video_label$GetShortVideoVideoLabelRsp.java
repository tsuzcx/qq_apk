package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_short_video_label$GetShortVideoVideoLabelRsp
  extends MessageMicro<GetShortVideoVideoLabelRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "video_status", "feed_info", "video_info" }, new Object[] { Integer.valueOf(0), null, null, null }, GetShortVideoVideoLabelRsp.class);
  public ilive_short_video_label.FeedInfo feed_info = new ilive_short_video_label.FeedInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public ilive_short_video_label.VideoInfo video_info = new ilive_short_video_label.VideoInfo();
  public ilive_short_video_label.VideoStatus video_status = new ilive_short_video_label.VideoStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp
 * JD-Core Version:    0.7.0.1
 */