package com.tencent.pb.apolloqquserimg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ApolloQQUsrImg$QQUsrImgRsp
  extends MessageMicro<QQUsrImgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "acts", "jump_more", "jump_mall", "icon_nums", "jump_open_page" }, new Object[] { null, "", "", Integer.valueOf(0), "" }, QQUsrImgRsp.class);
  public final PBRepeatMessageField<ApolloQQUsrImg.Action> acts = PBField.initRepeatMessage(ApolloQQUsrImg.Action.class);
  public final PBInt32Field icon_nums = PBField.initInt32(0);
  public final PBStringField jump_mall = PBField.initString("");
  public final PBStringField jump_more = PBField.initString("");
  public final PBStringField jump_open_page = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgRsp
 * JD-Core Version:    0.7.0.1
 */