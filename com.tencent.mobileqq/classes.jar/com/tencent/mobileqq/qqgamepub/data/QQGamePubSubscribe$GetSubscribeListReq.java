package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class QQGamePubSubscribe$GetSubscribeListReq
  extends MessageMicro<GetSubscribeListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "query" }, new Object[] { Integer.valueOf(0) }, GetSubscribeListReq.class);
  public final PBEnumField query = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeListReq
 * JD-Core Version:    0.7.0.1
 */