package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$UserActList
  extends MessageMicro<UserActList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field act_uin = PBField.initUInt64(0L);
  public final PBRepeatField<ByteStringMicro> feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_uin", "feeds_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, UserActList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.UserActList
 * JD-Core Version:    0.7.0.1
 */