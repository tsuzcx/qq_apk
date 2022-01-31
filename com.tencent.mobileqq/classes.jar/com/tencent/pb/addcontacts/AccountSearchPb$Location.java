package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

public final class AccountSearchPb$Location
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17 }, new String[] { "double_latitude", "double_longitude" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D) }, Location.class);
  public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
  public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.Location
 * JD-Core Version:    0.7.0.1
 */