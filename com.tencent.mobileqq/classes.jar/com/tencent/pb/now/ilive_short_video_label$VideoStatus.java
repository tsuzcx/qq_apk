package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_short_video_label$VideoStatus
  extends MessageMicro<VideoStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBRepeatField<Long> co_play_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field live_type = PBField.initUInt32(0);
  public final PBUInt64Field master_uin = PBField.initUInt64(0L);
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  public final PBUInt32Field root_room_id = PBField.initUInt32(0);
  public final PBUInt32Field sdk_type = PBField.initUInt32(0);
  public final PBUInt32Field stat = PBField.initUInt32(0);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBFixed32Field video_begin_timestamp = PBField.initFixed32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 69, 72, 80, 88 }, new String[] { "room_id", "root_room_id", "stat", "live_type", "timestamp", "client_type", "uin", "video_begin_timestamp", "sdk_type", "master_uin", "co_play_uin" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localLong, localInteger, localInteger, localLong, localLong }, VideoStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.VideoStatus
 * JD-Core Version:    0.7.0.1
 */