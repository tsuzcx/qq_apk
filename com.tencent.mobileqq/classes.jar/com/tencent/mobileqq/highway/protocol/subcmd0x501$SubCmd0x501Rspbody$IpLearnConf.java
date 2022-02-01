package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$IpLearnConf
  extends MessageMicro<IpLearnConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_enable_ip_learn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_refresh_cached_ip = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_refresh_cached_ip", "uint32_enable_ip_learn" }, new Object[] { localInteger, localInteger }, IpLearnConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf
 * JD-Core Version:    0.7.0.1
 */