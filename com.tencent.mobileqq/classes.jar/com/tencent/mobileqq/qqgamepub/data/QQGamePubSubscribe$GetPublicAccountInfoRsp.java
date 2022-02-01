package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class QQGamePubSubscribe$GetPublicAccountInfoRsp
  extends MessageMicro<GetPublicAccountInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_followed" }, new Object[] { Boolean.valueOf(false) }, GetPublicAccountInfoRsp.class);
  public final PBBoolField is_followed = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetPublicAccountInfoRsp
 * JD-Core Version:    0.7.0.1
 */