package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$IpLearnConf
  extends MessageMicro<IpLearnConf>
{
  public static final int UINT32_ENABLE_IP_LEARN_FIELD_NUMBER = 2;
  public static final int UINT32_REFRESH_CACHED_IP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_refresh_cached_ip", "uint32_enable_ip_learn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IpLearnConf.class);
  public final PBUInt32Field uint32_enable_ip_learn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_refresh_cached_ip = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf
 * JD-Core Version:    0.7.0.1
 */