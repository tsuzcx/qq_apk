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
  extends MessageMicro<UserInfo>
{
  public static final int APP_FRIEND = 1;
  public static final int QQ_FRIEND = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBBytesField anchor_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field explicit_uid = PBField.initUInt64(0L);
  public final PBUInt32Field friend_type = PBField.initUInt32(0);
  public final PBBytesField head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBUInt32Field is_qq_user = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public ilive_user_basic_info.UserExtraInfo userExtraInfo = new ilive_user_basic_info.UserExtraInfo();
  public final PBUInt32Field user_gender = PBField.initUInt32(0);
  public final PBBytesField user_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uid", "head_img_url", "anchor_name", "userExtraInfo", "friend_type", "user_logo_url", "is_qq_user", "uin", "user_gender", "age", "tinyid", "explicit_uid", "id_type" }, new Object[] { localLong, localByteStringMicro1, localByteStringMicro2, null, localInteger, localByteStringMicro3, localInteger, localLong, localInteger, localInteger, localLong, localLong, localInteger }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.UserInfo
 * JD-Core Version:    0.7.0.1
 */