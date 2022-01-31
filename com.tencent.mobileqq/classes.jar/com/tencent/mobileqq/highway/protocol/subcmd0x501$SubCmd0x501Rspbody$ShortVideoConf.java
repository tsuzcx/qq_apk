package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$ShortVideoConf
  extends MessageMicro<ShortVideoConf>
{
  public static final int CHANNEL_TYPE_NEW = 2;
  public static final int CHANNEL_TYPE_OLD = 1;
  public static final int CHANNEL_TYPE_TRANSFER_WHILE_RECORDING = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_channel_type", "rpt_msg_netsegconf", "bool_open_hardware_codec", "bool_send_ahead_signal" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false), Boolean.valueOf(false) }, ShortVideoConf.class);
  public final PBBoolField bool_open_hardware_codec = PBField.initBool(false);
  public final PBBoolField bool_send_ahead_signal = PBField.initBool(false);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf
 * JD-Core Version:    0.7.0.1
 */