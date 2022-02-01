package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQGamePubSubscribe$GetSubscribeListRsp
  extends MessageMicro<GetSubscribeListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "subscribe_list", "play_list", "rank_list" }, new Object[] { null, null, null }, GetSubscribeListRsp.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> play_list = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> rank_list = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> subscribe_list = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeListRsp
 * JD-Core Version:    0.7.0.1
 */