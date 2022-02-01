package com.tencent.pb.apolloqquserimg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ApolloQQUsrImg$QQUsrImgMoreRsp
  extends MessageMicro<QQUsrImgMoreRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "attach_info", "acts", "is_end" }, new Object[] { "", null, Integer.valueOf(0) }, QQUsrImgMoreRsp.class);
  public final PBRepeatMessageField<ApolloQQUsrImg.Action> acts = PBField.initRepeatMessage(ApolloQQUsrImg.Action.class);
  public final PBStringField attach_info = PBField.initString("");
  public final PBInt32Field is_end = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgMoreRsp
 * JD-Core Version:    0.7.0.1
 */