package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$Video
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 98, 106 }, new String[] { "id", "buttonDesc", "content", "cover", "desc", "name", "endTime", "isShow", "newStartTime", "newEndTime", "redirectUrl", "videoSource", "showDate" }, new Object[] { "", "", "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", "", "" }, Video.class);
  public final PBStringField buttonDesc = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBStringField cover = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField endTime = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field isShow = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBInt64Field newEndTime = PBField.initInt64(0L);
  public final PBInt64Field newStartTime = PBField.initInt64(0L);
  public final PBStringField redirectUrl = PBField.initString("");
  public final PBStringField showDate = PBField.initString("");
  public final PBStringField videoSource = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.Video
 * JD-Core Version:    0.7.0.1
 */