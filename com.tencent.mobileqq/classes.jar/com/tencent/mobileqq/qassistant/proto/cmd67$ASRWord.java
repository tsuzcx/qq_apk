package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$ASRWord
  extends MessageMicro<ASRWord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBInt32Field mbtm = PBField.initInt32(0);
  public final PBInt32Field metm = PBField.initInt32(0);
  public final PBStringField word = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 24, 32 }, new String[] { "word", "confidence", "mbtm", "metm" }, new Object[] { "", Float.valueOf(0.0F), localInteger, localInteger }, ASRWord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.ASRWord
 * JD-Core Version:    0.7.0.1
 */