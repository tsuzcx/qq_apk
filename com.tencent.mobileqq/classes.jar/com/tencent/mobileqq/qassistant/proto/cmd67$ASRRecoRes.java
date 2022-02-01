package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$ASRRecoRes
  extends MessageMicro<ASRRecoRes>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField comment = PBField.initString("");
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBFloatField similarity = PBField.initFloat(0.0F);
  public final PBStringField text = PBField.initString("");
  public final PBRepeatMessageField<cmd67.ASRWord> word = PBField.initRepeatMessage(cmd67.ASRWord.class);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 34, 42 }, new String[] { "text", "confidence", "similarity", "comment", "word" }, new Object[] { "", localFloat, localFloat, "", null }, ASRRecoRes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.ASRRecoRes
 * JD-Core Version:    0.7.0.1
 */