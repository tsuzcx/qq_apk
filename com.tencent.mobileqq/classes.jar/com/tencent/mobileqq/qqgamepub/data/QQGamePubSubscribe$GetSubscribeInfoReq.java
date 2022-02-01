package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePubSubscribe$GetSubscribeInfoReq
  extends MessageMicro<GetSubscribeInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "appidList" }, new Object[] { Integer.valueOf(0) }, GetSubscribeInfoReq.class);
  public final PBRepeatField<Integer> appidList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeInfoReq
 * JD-Core Version:    0.7.0.1
 */