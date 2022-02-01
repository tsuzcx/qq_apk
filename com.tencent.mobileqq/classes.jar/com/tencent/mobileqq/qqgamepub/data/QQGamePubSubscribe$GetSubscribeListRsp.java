package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQGamePubSubscribe$GetSubscribeListRsp
  extends MessageMicro<GetSubscribeListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "subscribeList", "playList", "rankList" }, new Object[] { null, null, null }, GetSubscribeListRsp.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> playList = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> rankList = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> subscribeList = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeListRsp
 * JD-Core Version:    0.7.0.1
 */