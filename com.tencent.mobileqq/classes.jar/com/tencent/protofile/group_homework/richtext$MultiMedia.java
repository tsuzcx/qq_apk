package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class richtext$MultiMedia
  extends MessageMicro<MultiMedia>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic", "voice", "video", "attach" }, new Object[] { null, null, null, null }, MultiMedia.class);
  public final PBRepeatMessageField<richtext.Attach> attach = PBField.initRepeatMessage(richtext.Attach.class);
  public final PBRepeatMessageField<richtext.Picture> pic = PBField.initRepeatMessage(richtext.Picture.class);
  public final PBRepeatMessageField<richtext.Video> video = PBField.initRepeatMessage(richtext.Video.class);
  public final PBRepeatMessageField<richtext.Voice> voice = PBField.initRepeatMessage(richtext.Voice.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.group_homework.richtext.MultiMedia
 * JD-Core Version:    0.7.0.1
 */