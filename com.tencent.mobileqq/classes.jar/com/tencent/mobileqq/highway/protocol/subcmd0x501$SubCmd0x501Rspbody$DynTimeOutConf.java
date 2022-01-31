package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$DynTimeOutConf
  extends MessageMicro<DynTimeOutConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152 }, new String[] { "uint32_tbase_2g", "uint32_tbase_3g", "uint32_tbase_4g", "uint32_tbase_wifi", "uint32_torg_2g", "uint32_torg_3g", "uint32_torg_4g", "uint32_torg_wifi", "uint32_max_timeout", "uint32_enable_dyn_timeout", "uint32_max_timeout_2g", "uint32_max_timeout_3g", "uint32_max_timeout_4g", "uint32_max_timeout_wifi", "uint32_hb_timeout_2g", "uint32_hb_timeout_3g", "uint32_hb_timeout_4g", "uint32_hb_timeout_wifi", "uint32_hb_timeout_default" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DynTimeOutConf.class);
  public final PBUInt32Field uint32_enable_dyn_timeout = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_timeout_2g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_timeout_3g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_timeout_4g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_timeout_default = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_timeout_wifi = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_timeout = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_timeout_2g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_timeout_3g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_timeout_4g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_timeout_wifi = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tbase_2g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tbase_3g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tbase_4g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tbase_wifi = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torg_2g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torg_3g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torg_4g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torg_wifi = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf
 * JD-Core Version:    0.7.0.1
 */