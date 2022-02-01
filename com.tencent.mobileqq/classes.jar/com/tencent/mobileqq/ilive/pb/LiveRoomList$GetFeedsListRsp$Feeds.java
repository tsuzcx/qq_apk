package com.tencent.mobileqq.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class LiveRoomList$GetFeedsListRsp$Feeds
  extends MessageMicro<Feeds>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room", "stream" }, new Object[] { null, null }, Feeds.class);
  public LiveRoomList.Room room = new LiveRoomList.Room();
  public LiveRoomList.Stream stream = new LiveRoomList.Stream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListRsp.Feeds
 * JD-Core Version:    0.7.0.1
 */