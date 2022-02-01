package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicPb$DelMyComicFavorEmotIconsReqBody
  extends MessageMicro<DelMyComicFavorEmotIconsReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "md5List" }, new Object[] { "" }, DelMyComicFavorEmotIconsReqBody.class);
  public final PBRepeatField<String> md5List = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb.DelMyComicFavorEmotIconsReqBody
 * JD-Core Version:    0.7.0.1
 */