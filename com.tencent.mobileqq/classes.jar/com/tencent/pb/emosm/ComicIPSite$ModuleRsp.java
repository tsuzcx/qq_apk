package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$ModuleRsp
  extends MessageMicro<ModuleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 74, 82, 90, 98, 106, 114, 120, 128, 138, 146, 152, 160 }, new String[] { "ipId", "ipName", "ipDesc", "ipUrl", "itemSize", "strType", "extId", "extStr", "gxzbList", "gameList", "goodsList", "bookList", "videoList", "comicList", "result", "sub_cmd", "ipLogo", "ipContent", "requestInterval", "goodSize" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, ModuleRsp.class);
  public final PBRepeatMessageField<ComicIPSite.Book> bookList = PBField.initRepeatMessage(ComicIPSite.Book.class);
  public final PBRepeatMessageField<ComicIPSite.Comic> comicList = PBField.initRepeatMessage(ComicIPSite.Comic.class);
  public final PBInt32Field extId = PBField.initInt32(0);
  public final PBStringField extStr = PBField.initString("");
  public final PBRepeatMessageField<ComicIPSite.Game> gameList = PBField.initRepeatMessage(ComicIPSite.Game.class);
  public final PBInt32Field goodSize = PBField.initInt32(0);
  public final PBRepeatMessageField<ComicIPSite.Goods> goodsList = PBField.initRepeatMessage(ComicIPSite.Goods.class);
  public final PBRepeatMessageField<ComicIPSite.Gxzb> gxzbList = PBField.initRepeatMessage(ComicIPSite.Gxzb.class);
  public final PBStringField ipContent = PBField.initString("");
  public final PBStringField ipDesc = PBField.initString("");
  public final PBInt32Field ipId = PBField.initInt32(0);
  public final PBStringField ipLogo = PBField.initString("");
  public final PBStringField ipName = PBField.initString("");
  public final PBStringField ipUrl = PBField.initString("");
  public final PBInt32Field itemSize = PBField.initInt32(0);
  public final PBInt32Field requestInterval = PBField.initInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBStringField strType = PBField.initString("");
  public final PBInt32Field sub_cmd = PBField.initInt32(0);
  public final PBRepeatMessageField<ComicIPSite.Video> videoList = PBField.initRepeatMessage(ComicIPSite.Video.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.ModuleRsp
 * JD-Core Version:    0.7.0.1
 */