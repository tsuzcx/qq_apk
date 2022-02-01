package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$GetResourceReqInfo
  extends MessageMicro<GetResourceReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field res_id = PBField.initUInt32(0);
  public final PBUInt32Field res_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "res_id", "res_seq" }, new Object[] { localInteger, localInteger }, GetResourceReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReqInfo
 * JD-Core Version:    0.7.0.1
 */