package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$Intent
  extends MessageMicro<Intent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34 }, new String[] { "str_content", "confidence", "str_skill", "str_intent" }, new Object[] { "", Float.valueOf(0.0F), "", "" }, Intent.class);
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_intent = PBField.initString("");
  public final PBStringField str_skill = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.Intent
 * JD-Core Version:    0.7.0.1
 */