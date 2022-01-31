package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$ShortVideoInfo
  extends MessageMicro<ShortVideoInfo>
{
  public static final int FEED_SOURCE_ANDROID = 2;
  public static final int FEED_SOURCE_IOS = 1;
  public static final int FEED_STATUS_DELETE = 1;
  public static final int FEED_STATUS_INVALID = 2;
  public static final int FEED_STATUS_VALID = 0;
  public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
  public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
  public static final int TYPE_RECORD_VIDEO_FEED = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedsProtocol.UserInfo anchor_info = new FeedsProtocol.UserInfo();
  public final PBUInt32Field bg_color = PBField.initUInt32(0);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField feed_source = PBField.initEnum(1);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
  public final PBUInt32Field is_like = PBField.initUInt32(0);
  public final PBUInt32Field is_listen = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
  public final PBUInt32Field like_num = PBField.initUInt32(0);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
  public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field up_status = PBField.initUInt32(0);
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_hight = PBField.initUInt32(0);
  public final PBUInt32Field video_time = PBField.initUInt32(0);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_width = PBField.initUInt32(0);
  public final PBUInt32Field view_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74, 80, 90, 96, 104, 112, 122, 128, 136, 144, 154, 160, 170, 176, 186, 192, 202 }, new String[] { "user_info", "pic_url", "video_url", "anchor_info", "create_time", "feed_type", "feed_source", "feeds_id", "file_id", "video_time", "rpt_msg_rich_title", "view_times", "video_width", "video_hight", "doodle_pic_url", "is_listen", "is_like", "like_num", "share_url", "follow_uid", "jump_url", "up_status", "lbs_info", "bg_color", "vid" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, null, Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(1), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), localByteStringMicro7, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro8 }, ShortVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.ShortVideoInfo
 * JD-Core Version:    0.7.0.1
 */