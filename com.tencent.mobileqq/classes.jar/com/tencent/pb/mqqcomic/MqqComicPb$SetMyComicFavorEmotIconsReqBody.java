package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MqqComicPb$SetMyComicFavorEmotIconsReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqs" }, new Object[] { null }, SetMyComicFavorEmotIconsReqBody.class);
  public final PBRepeatMessageField reqs = PBField.initRepeatMessage(MqqComicPb.ComicFavorEmotIcons.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsReqBody
 * JD-Core Version:    0.7.0.1
 */