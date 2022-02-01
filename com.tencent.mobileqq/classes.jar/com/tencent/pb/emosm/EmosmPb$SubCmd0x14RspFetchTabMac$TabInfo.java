package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x14RspFetchTabMac$TabInfo
  extends MessageMicro<TabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 50 }, new String[] { "uint32_tab_id", "fixed32_expire_time", "uint32_flags", "int32_wording_id", "int32_tab_type", "str_tab_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TabInfo.class);
  public final PBFixed32Field fixed32_expire_time = PBField.initFixed32(0);
  public final PBInt32Field int32_tab_type = PBField.initInt32(0);
  public final PBInt32Field int32_wording_id = PBField.initInt32(0);
  public final PBStringField str_tab_name = PBField.initString("");
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x14RspFetchTabMac.TabInfo
 * JD-Core Version:    0.7.0.1
 */