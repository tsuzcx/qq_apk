package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserExtraInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$UserInfo
  extends MessageMicro
{
  public static final int APP_FRIEND = 1;
  public static final int QQ_FRIEND = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBBytesField anchor_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field friend_type = PBField.initUInt32(0);
  public final PBBytesField head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_qq_user = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public ilive_user_basic_info.UserExtraInfo userExtraInfo = new ilive_user_basic_info.UserExtraInfo();
  public final PBUInt32Field user_gender = PBField.initUInt32(0);
  public final PBBytesField user_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 64, 72, 80 }, new String[] { "uid", "head_img_url", "anchor_name", "userExtraInfo", "friend_type", "user_logo_url", "is_qq_user", "uin", "user_gender", "age" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.UserInfo
 * JD-Core Version:    0.7.0.1
 */