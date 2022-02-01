package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQGamePubSubscribe$GetSubscribeInfoRsp
  extends MessageMicro<GetSubscribeInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app_list" }, new Object[] { null }, GetSubscribeInfoRsp.class);
  public final PBRepeatMessageField<QQGamePubSubscribe.AppSubscribeInfo> app_list = PBField.initRepeatMessage(QQGamePubSubscribe.AppSubscribeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeInfoRsp
 * JD-Core Version:    0.7.0.1
 */