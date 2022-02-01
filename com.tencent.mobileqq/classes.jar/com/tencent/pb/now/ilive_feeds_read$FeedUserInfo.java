package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.MedalInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$FeedUserInfo
  extends MessageMicro<FeedUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBRepeatMessageField<ilive_user_basic_info.MedalInfo> medal_infos = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field user_gender = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uin", "nick", "url", "medal_infos", "user_gender", "age" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, FeedUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.FeedUserInfo
 * JD-Core Version:    0.7.0.1
 */