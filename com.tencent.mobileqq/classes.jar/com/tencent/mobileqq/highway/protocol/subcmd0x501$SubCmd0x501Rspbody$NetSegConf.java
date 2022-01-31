package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$NetSegConf
  extends MessageMicro<NetSegConf>
{
  public static final int UINT32_CURCONNNUM_FIELD_NUMBER = 4;
  public static final int UINT32_NET_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_SEGNUM_FIELD_NUMBER = 3;
  public static final int UINT32_SEGSIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_net_type", "uint32_segsize", "uint32_segnum", "uint32_curconnnum" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NetSegConf.class);
  public final PBUInt32Field uint32_curconnnum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_segnum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_segsize = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf
 * JD-Core Version:    0.7.0.1
 */