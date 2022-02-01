package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class mobileqq_mp$SecMsgConfigsResponse
  extends MessageMicro<SecMsgConfigsResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBInt32Field int32_show_in_palist = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_ret", "int32_show_in_palist" }, new Object[] { localInteger, localInteger }, SecMsgConfigsResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SecMsgConfigsResponse
 * JD-Core Version:    0.7.0.1
 */