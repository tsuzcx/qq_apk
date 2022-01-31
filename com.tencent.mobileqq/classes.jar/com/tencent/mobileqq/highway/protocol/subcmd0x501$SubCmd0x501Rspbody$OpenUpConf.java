package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$OpenUpConf
  extends MessageMicro<OpenUpConf>
{
  public static final int BOOL_ENABLE_OPENUP_FIELD_NUMBER = 1;
  public static final int UINT32_PRE_SEND_SEGNUM_3G_FIELD_NUMBER = 3;
  public static final int UINT32_PRE_SEND_SEGNUM_4G_FIELD_NUMBER = 4;
  public static final int UINT32_PRE_SEND_SEGNUM_FIELD_NUMBER = 2;
  public static final int UINT32_PRE_SEND_SEGNUM_WIFI_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "bool_enable_openup", "uint32_pre_send_segnum", "uint32_pre_send_segnum_3g", "uint32_pre_send_segnum_4g", "uint32_pre_send_segnum_wifi" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, OpenUpConf.class);
  public final PBBoolField bool_enable_openup = PBField.initBool(false);
  public final PBUInt32Field uint32_pre_send_segnum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_send_segnum_3g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_send_segnum_4g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_send_segnum_wifi = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf
 * JD-Core Version:    0.7.0.1
 */