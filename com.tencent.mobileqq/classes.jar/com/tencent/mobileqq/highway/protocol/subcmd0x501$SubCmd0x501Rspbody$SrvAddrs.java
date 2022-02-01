package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$SrvAddrs
  extends MessageMicro<SrvAddrs>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.IpAddr.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.Ip6Addr> rpt_msg_addrs_v6 = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.Ip6Addr.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> rpt_msg_netsegconf = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.NetSegConf.class);
  public final PBUInt32Field uint32_fragment_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_service_type", "rpt_msg_addrs", "uint32_fragment_size", "rpt_msg_netsegconf", "rpt_msg_addrs_v6" }, new Object[] { localInteger, null, localInteger, null, null }, SrvAddrs.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs
 * JD-Core Version:    0.7.0.1
 */