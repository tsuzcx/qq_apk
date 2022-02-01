package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$DPBiz
  extends MessageMicro<DPBiz>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField avg_price = PBField.initString("");
  public final PBStringField biz_zone = PBField.initString("");
  public final PBStringField category = PBField.initString("");
  public final PBUInt32Field has_quan = PBField.initUInt32(0);
  public final PBUInt32Field has_tuan = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field rate = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "biz_zone", "category", "rate", "avg_price", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", localInteger, "", localInteger, localInteger }, DPBiz.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.DPBiz
 * JD-Core Version:    0.7.0.1
 */