package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class richtext$Picture
  extends MessageMicro<Picture>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "url", "size" }, new Object[] { "", Integer.valueOf(0) }, Picture.class);
  public final PBRepeatField<Integer> size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.group_homework.richtext.Picture
 * JD-Core Version:    0.7.0.1
 */