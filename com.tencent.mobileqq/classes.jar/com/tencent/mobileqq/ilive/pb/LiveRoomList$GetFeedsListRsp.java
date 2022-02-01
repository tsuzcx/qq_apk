package com.tencent.mobileqq.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class LiveRoomList$GetFeedsListRsp
  extends MessageMicro<GetFeedsListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "feeds", "is_finished", "penetrate_info" }, new Object[] { null, Integer.valueOf(0), null }, GetFeedsListRsp.class);
  public final PBRepeatMessageField<LiveRoomList.GetFeedsListRsp.Feeds> feeds = PBField.initRepeatMessage(LiveRoomList.GetFeedsListRsp.Feeds.class);
  public final PBInt32Field is_finished = PBField.initInt32(0);
  public final PBRepeatMessageField<LiveRoomList.KV> penetrate_info = PBField.initRepeatMessage(LiveRoomList.KV.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListRsp
 * JD-Core Version:    0.7.0.1
 */