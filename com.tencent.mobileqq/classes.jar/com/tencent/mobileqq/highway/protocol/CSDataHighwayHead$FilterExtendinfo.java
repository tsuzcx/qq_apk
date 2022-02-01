package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$FilterExtendinfo
  extends MessageMicro<FilterExtendinfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_filter_flag", "msg_image_filter_request" }, new Object[] { Integer.valueOf(0), null }, FilterExtendinfo.class);
  public CSDataHighwayHead.ImageFilterRequest msg_image_filter_request = new CSDataHighwayHead.ImageFilterRequest();
  public final PBUInt32Field uint32_filter_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterExtendinfo
 * JD-Core Version:    0.7.0.1
 */