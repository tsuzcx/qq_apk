package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$PicFeedsInfo
  extends MessageMicro<PicFeedsInfo>
{
  public static final int FEED_SOURCE_ANDROID = 2;
  public static final int FEED_SOURCE_IOS = 1;
  public static final int TYPE_CHANG = 6;
  public static final int TYPE_CHANG_REPLAY = 7;
  public static final int TYPE_LIVE = 5;
  public static final int TYPE_PIC = 4;
  public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
  public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
  public static final int TYPE_RECORD_VIDEO_FEED = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt32Field feed_source = PBField.initUInt32(0);
  public final PBUInt32Field feed_type = PBField.initUInt32(0);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_like = PBField.initUInt32(0);
  public final PBUInt32Field is_listen = PBField.initUInt32(0);
  public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
  public final PBUInt32Field like_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedsProtocol.PicInfo> pic_infos = PBField.initRepeatMessage(FeedsProtocol.PicInfo.class);
  public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
  public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBUInt32Field view_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 80, 88, 96, 104, 114, 122 }, new String[] { "user_info", "pic_infos", "create_time", "feed_type", "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", "like_num", "share_url", "lbs_info" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, PicFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.PicFeedsInfo
 * JD-Core Version:    0.7.0.1
 */