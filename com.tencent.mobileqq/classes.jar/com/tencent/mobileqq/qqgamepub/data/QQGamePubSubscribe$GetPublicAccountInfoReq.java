package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQGamePubSubscribe$GetPublicAccountInfoReq
  extends MessageMicro<GetPublicAccountInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "puin" }, new Object[] { Long.valueOf(0L) }, GetPublicAccountInfoReq.class);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetPublicAccountInfoReq
 * JD-Core Version:    0.7.0.1
 */