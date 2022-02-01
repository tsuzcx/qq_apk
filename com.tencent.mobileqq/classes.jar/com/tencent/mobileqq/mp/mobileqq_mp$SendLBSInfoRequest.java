package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SendLBSInfoRequest
  extends MessageMicro<SendLBSInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cityinfo = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 25, 32, 42 }, new String[] { "uin", "latitude", "longitude", "luin", "cityinfo" }, new Object[] { Integer.valueOf(0), localDouble, localDouble, Long.valueOf(0L), "" }, SendLBSInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SendLBSInfoRequest
 * JD-Core Version:    0.7.0.1
 */