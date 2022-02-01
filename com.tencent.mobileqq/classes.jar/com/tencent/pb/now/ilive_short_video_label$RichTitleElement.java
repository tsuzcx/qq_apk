package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_short_video_label$RichTitleElement
  extends MessageMicro<RichTitleElement>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "string_text", "string_url" }, new Object[] { Integer.valueOf(0), "", "" }, RichTitleElement.class);
  public final PBStringField string_text = PBField.initString("");
  public final PBStringField string_url = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.RichTitleElement
 * JD-Core Version:    0.7.0.1
 */