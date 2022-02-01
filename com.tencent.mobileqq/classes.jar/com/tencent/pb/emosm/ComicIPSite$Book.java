package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$Book
  extends MessageMicro<Book>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "authorName" }, new Object[] { "", "", "", "", "", "", "" }, Book.class);
  public final PBStringField authorName = PBField.initString("");
  public final PBStringField cover = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField recommDesc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.Book
 * JD-Core Version:    0.7.0.1
 */