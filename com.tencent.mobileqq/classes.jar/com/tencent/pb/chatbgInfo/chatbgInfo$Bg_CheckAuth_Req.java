package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class chatbgInfo$Bg_CheckAuth_Req
  extends MessageMicro<Bg_CheckAuth_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "IdList", "BgEffectList" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_CheckAuth_Req.class);
  public final PBRepeatField<Integer> BgEffectList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> IdList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Req
 * JD-Core Version:    0.7.0.1
 */