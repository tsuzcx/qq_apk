package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$Game
  extends MessageMicro<Game>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "rich" }, new Object[] { "", "", "", "", "", "", null }, Game.class);
  public final PBStringField cover = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField recommDesc = PBField.initString("");
  public final PBRepeatMessageField<ComicIPSite.GameRich> rich = PBField.initRepeatMessage(ComicIPSite.GameRich.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.Game
 * JD-Core Version:    0.7.0.1
 */