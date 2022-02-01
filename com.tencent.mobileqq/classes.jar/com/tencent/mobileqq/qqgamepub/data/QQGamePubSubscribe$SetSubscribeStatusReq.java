package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePubSubscribe$SetSubscribeStatusReq
  extends MessageMicro<SetSubscribeStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> appidList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBEnumField operation = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "operation", "appidList" }, new Object[] { localInteger, localInteger }, SetSubscribeStatusReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.SetSubscribeStatusReq
 * JD-Core Version:    0.7.0.1
 */