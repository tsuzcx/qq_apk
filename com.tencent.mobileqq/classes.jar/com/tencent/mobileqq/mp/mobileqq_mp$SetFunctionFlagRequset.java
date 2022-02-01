package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SetFunctionFlagRequset
  extends MessageMicro<SetFunctionFlagRequset>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBUInt32Field value = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uin", "type", "value", "account_type", "luin", "version" }, new Object[] { localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger }, SetFunctionFlagRequset.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset
 * JD-Core Version:    0.7.0.1
 */