package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicNickModule
  extends MessageMicro<DynamicNickModule>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "style_type", "style_name", "style_description", "style_url", "style_id" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, DynamicNickModule.class);
  public final PBStringField style_description = PBField.initString("");
  public final PBUInt32Field style_id = PBField.initUInt32(0);
  public final PBStringField style_name = PBField.initString("");
  public final PBUInt64Field style_type = PBField.initUInt64(0L);
  public final PBStringField style_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.sweet.verification.judge.DynamicNickModule
 * JD-Core Version:    0.7.0.1
 */