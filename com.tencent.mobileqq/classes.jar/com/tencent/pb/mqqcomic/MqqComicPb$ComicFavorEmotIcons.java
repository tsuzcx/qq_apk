package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicPb$ComicFavorEmotIcons
  extends MessageMicro<ComicFavorEmotIcons>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "md5", "info" }, new Object[] { "", "" }, ComicFavorEmotIcons.class);
  public final PBStringField info = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons
 * JD-Core Version:    0.7.0.1
 */