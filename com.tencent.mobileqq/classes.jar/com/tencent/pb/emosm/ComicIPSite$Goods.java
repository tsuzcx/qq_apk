package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$Goods
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "cover", "goodsTags", "id", "name", "price", "saleTags", "svipPrice", "url", "moreUrl", "saleNum" }, new Object[] { "", "", "", "", "", "", "", "", "", "" }, Goods.class);
  public final PBStringField cover = PBField.initString("");
  public final PBStringField goodsTags = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField moreUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField price = PBField.initString("");
  public final PBStringField saleNum = PBField.initString("");
  public final PBStringField saleTags = PBField.initString("");
  public final PBStringField svipPrice = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.Goods
 * JD-Core Version:    0.7.0.1
 */