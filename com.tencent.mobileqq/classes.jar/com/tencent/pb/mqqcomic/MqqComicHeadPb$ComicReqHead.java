package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqComicHeadPb$ComicReqHead
  extends MessageMicro<ComicReqHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122 }, new String[] { "optTs", "src", "os", "clientVer", "net", "uin", "cmd", "screenQuality", "etag", "skey", "unifiedImei", "biz_subid", "cs_id", "obj_pos", "page_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", "", "", "", "", "" }, ComicReqHead.class);
  public final PBStringField biz_subid = PBField.initString("");
  public final PBStringField clientVer = PBField.initString("");
  public final PBStringField cmd = PBField.initString("");
  public final PBStringField cs_id = PBField.initString("");
  public final PBStringField etag = PBField.initString("");
  public final PBInt32Field net = PBField.initInt32(0);
  public final PBStringField obj_pos = PBField.initString("");
  public final PBInt64Field optTs = PBField.initInt64(0L);
  public final PBInt32Field os = PBField.initInt32(0);
  public final PBStringField page_id = PBField.initString("");
  public final PBStringField screenQuality = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt32Field src = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField unifiedImei = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicReqHead
 * JD-Core Version:    0.7.0.1
 */