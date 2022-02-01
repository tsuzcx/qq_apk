package com.tencent.protofile.cmd67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$ASRRecoRes
  extends MessageMicro<ASRRecoRes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 34, 42 }, new String[] { "text", "confidence", "similarity", "comment", "word" }, new Object[] { "", Float.valueOf(0.0F), Float.valueOf(0.0F), "", null }, ASRRecoRes.class);
  public final PBStringField comment = PBField.initString("");
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBFloatField similarity = PBField.initFloat(0.0F);
  public final PBStringField text = PBField.initString("");
  public final PBRepeatMessageField<cmd67.ASRWord> word = PBField.initRepeatMessage(cmd67.ASRWord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd67.cmd67.ASRRecoRes
 * JD-Core Version:    0.7.0.1
 */