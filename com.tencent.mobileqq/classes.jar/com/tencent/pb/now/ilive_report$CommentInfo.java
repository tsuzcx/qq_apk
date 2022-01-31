package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_report$CommentInfo
  extends MessageMicro<CommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "time", "content" }, new Object[] { Long.valueOf(0L), "" }, CommentInfo.class);
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_report.CommentInfo
 * JD-Core Version:    0.7.0.1
 */