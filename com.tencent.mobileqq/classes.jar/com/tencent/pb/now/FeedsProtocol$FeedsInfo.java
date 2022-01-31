package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  public static final int LIVE_AGGREGATE = 1;
  public static final int LIVE_ANCHOR = 4;
  public static final int MINE_FEED = 5;
  public static final int SHORT_VIDEO = 3;
  public static final int VIDEO_LIST = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedsProtocol.UserInfo anchor_info = new FeedsProtocol.UserInfo();
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedsProtocol.FeedPreLoadInfo feed_preload = new FeedsProtocol.FeedPreLoadInfo();
  public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_new = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField native_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedsProtocol.UserInfo publish_info = new FeedsProtocol.UserInfo();
  public final PBBytesField room_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field short_video_num = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBUInt32Field view_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 58, 64, 74, 80, 90, 98, 106, 114, 122 }, new String[] { "id", "type", "user_info", "view_times", "room_img_url", "update_time", "content", "short_video_num", "jump_url", "is_new", "feed_id", "publish_info", "anchor_info", "feed_preload", "native_jump_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, null, null, null, localByteStringMicro6 }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */