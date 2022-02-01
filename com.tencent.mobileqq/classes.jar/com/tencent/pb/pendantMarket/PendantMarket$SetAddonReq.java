package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PendantMarket$SetAddonReq
  extends MessageMicro<SetAddonReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field i_key_type = PBField.initUInt32(0);
  public final PBUInt32Field int_from_type = PBField.initUInt32(0);
  public final PBUInt32Field int_platform = PBField.initUInt32(0);
  public final PBUInt32Field int_valid_days = PBField.initUInt32(0);
  public final PBUInt32Field int_version = PBField.initUInt32(0);
  public final PBUInt64Field long_addon_id = PBField.initUInt64(0L);
  public final PBStringField str_open_key = PBField.initString("");
  public final PBStringField str_qq_version = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 64, 72 }, new String[] { "cmd", "int_platform", "int_version", "long_addon_id", "str_qq_version", "int_valid_days", "str_open_key", "i_key_type", "int_from_type" }, new Object[] { localInteger, localInteger, localInteger, Long.valueOf(0L), "", localInteger, "", localInteger, localInteger }, SetAddonReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.pendantMarket.PendantMarket.SetAddonReq
 * JD-Core Version:    0.7.0.1
 */