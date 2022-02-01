package com.tencent.mobileqq.oidb.tofuCommon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TofuCommon$Content
  extends MessageMicro<Content>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title", "color" }, new Object[] { "", "" }, Content.class);
  public final PBStringField color = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.oidb.tofuCommon.TofuCommon.Content
 * JD-Core Version:    0.7.0.1
 */