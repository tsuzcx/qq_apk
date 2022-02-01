package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class richtext$Voice
  extends MessageMicro<Voice>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBUInt32Field time = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField url_mp3 = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "url", "time", "size", "url_mp3" }, new Object[] { "", localInteger, localInteger, "" }, Voice.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.richtext.Voice
 * JD-Core Version:    0.7.0.1
 */