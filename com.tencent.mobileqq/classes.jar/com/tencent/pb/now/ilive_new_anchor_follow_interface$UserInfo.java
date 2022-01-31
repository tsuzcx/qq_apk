package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserExtraInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$UserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField full_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_fan = PBField.initUInt32(0);
  public final PBUInt32Field is_listened = PBField.initUInt32(0);
  public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
  public final PBUInt64Field logo_timestamp = PBField.initUInt64(0L);
  public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBBytesField sign_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public ilive_user_basic_info.UserExtraInfo userExtraInfo = new ilive_user_basic_info.UserExtraInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72, 82, 90 }, new String[] { "uin", "nick_name", "head_url", "sex", "sign_name", "logo_timestamp", "is_listened", "is_fan", "is_subscribe", "userExtraInfo", "full_head_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro4 }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.UserInfo
 * JD-Core Version:    0.7.0.1
 */