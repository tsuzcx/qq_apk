package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MqqComicPb$SetMyComicFavorEmotIconsReqBody
  extends MessageMicro<SetMyComicFavorEmotIconsReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqs" }, new Object[] { null }, SetMyComicFavorEmotIconsReqBody.class);
  public final PBRepeatMessageField<MqqComicPb.ComicFavorEmotIcons> reqs = PBField.initRepeatMessage(MqqComicPb.ComicFavorEmotIcons.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsReqBody
 * JD-Core Version:    0.7.0.1
 */