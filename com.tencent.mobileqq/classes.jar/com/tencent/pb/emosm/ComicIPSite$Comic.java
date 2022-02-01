package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$Comic
  extends MessageMicro<Comic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "comicType", "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "typeName", "rich" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "", null }, Comic.class);
  public final PBInt32Field comicType = PBField.initInt32(0);
  public final PBStringField cover = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField recommDesc = PBField.initString("");
  public final PBRepeatMessageField<ComicIPSite.ComicRich> rich = PBField.initRepeatMessage(ComicIPSite.ComicRich.class);
  public final PBStringField typeName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.Comic
 * JD-Core Version:    0.7.0.1
 */