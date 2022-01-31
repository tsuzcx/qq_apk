package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class value$MultiMedia
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic", "voice", "video", "attach" }, new Object[] { null, null, null, null }, MultiMedia.class);
  public final PBRepeatMessageField attach = PBField.initRepeatMessage(value.Attach.class);
  public final PBRepeatMessageField pic = PBField.initRepeatMessage(value.Picture.class);
  public final PBRepeatMessageField video = PBField.initRepeatMessage(value.Video.class);
  public final PBRepeatMessageField voice = PBField.initRepeatMessage(value.Voice.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.MultiMedia
 * JD-Core Version:    0.7.0.1
 */