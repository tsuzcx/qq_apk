package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$PTVConf
  extends MessageMicro<PTVConf>
{
  public static final int BOOL_OPEN_HARDWARE_CODEC_FIELD_NUMBER = 3;
  public static final int RPT_MSG_NETSEGCONF_FIELD_NUMBER = 2;
  public static final int UINT32_CHANNEL_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_channel_type", "rpt_msg_netsegconf", "bool_open_hardware_codec" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false) }, PTVConf.class);
  public final PBBoolField bool_open_hardware_codec = PBField.initBool(false);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf
 * JD-Core Version:    0.7.0.1
 */