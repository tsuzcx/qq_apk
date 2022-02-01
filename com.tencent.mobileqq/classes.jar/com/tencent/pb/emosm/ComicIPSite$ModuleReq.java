package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite$ModuleReq
  extends MessageMicro<ModuleReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ComicIPSite.ModuleInfo moduleInfo = new ComicIPSite.ModuleInfo();
  public final PBStringField mqqver = PBField.initString("");
  public final PBInt64Field platform = PBField.initInt64(0L);
  public final PBInt32Field sub_cmd = PBField.initInt32(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "platform", "mqqver", "uin", "moduleInfo", "sub_cmd" }, new Object[] { localLong, "", localLong, null, Integer.valueOf(0) }, ModuleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite.ModuleReq
 * JD-Core Version:    0.7.0.1
 */