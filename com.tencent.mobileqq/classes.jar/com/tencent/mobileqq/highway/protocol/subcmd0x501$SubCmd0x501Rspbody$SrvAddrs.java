package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$SrvAddrs
  extends MessageMicro<SrvAddrs>
{
  public static final int RPT_MSG_ADDRS_FIELD_NUMBER = 2;
  public static final int RPT_MSG_ADDRS_V6_FIELD_NUMBER = 5;
  public static final int RPT_MSG_NETSEGCONF_FIELD_NUMBER = 4;
  public static final int UINT32_FRAGMENT_SIZE_FIELD_NUMBER = 3;
  public static final int UINT32_SERVICE_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_service_type", "rpt_msg_addrs", "uint32_fragment_size", "rpt_msg_netsegconf", "rpt_msg_addrs_v6" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null, null }, SrvAddrs.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.IpAddr.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.Ip6Addr> rpt_msg_addrs_v6 = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.Ip6Addr.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
  public final PBUInt32Field uint32_fragment_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs
 * JD-Core Version:    0.7.0.1
 */