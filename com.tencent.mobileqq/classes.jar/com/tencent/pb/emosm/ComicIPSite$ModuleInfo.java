package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$ModuleInfo
  extends MessageMicro<ModuleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "appId", "itemId", "isRetSummary" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false) }, ModuleInfo.class);
  public final PBInt32Field appId = PBField.initInt32(0);
  public final PBBoolField isRetSummary = PBField.initBool(false);
  public final PBStringField itemId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.ModuleInfo
 * JD-Core Version:    0.7.0.1
 */