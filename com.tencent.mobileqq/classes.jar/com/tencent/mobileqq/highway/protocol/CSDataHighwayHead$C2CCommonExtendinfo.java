package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$C2CCommonExtendinfo
  extends MessageMicro<C2CCommonExtendinfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_info_id", "msg_filter_extendinfo" }, new Object[] { Integer.valueOf(0), null }, C2CCommonExtendinfo.class);
  public CSDataHighwayHead.FilterExtendinfo msg_filter_extendinfo = new CSDataHighwayHead.FilterExtendinfo();
  public final PBUInt32Field uint32_info_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.C2CCommonExtendinfo
 * JD-Core Version:    0.7.0.1
 */