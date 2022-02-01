package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveHomepageProto$UserExtraInfo
  extends MessageMicro<UserExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<NowQQLiveHomepageProto.MedalInfo> medal_info_list = PBField.initRepeatMessage(NowQQLiveHomepageProto.MedalInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_point = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "uin", "medal_info_list", "uint32_level", "uint32_point", "uint32_next_point", "uint32_pre_point", "version" }, new Object[] { Long.valueOf(0L), null, localInteger, localInteger, localInteger, localInteger, localInteger }, UserExtraInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserExtraInfo
 * JD-Core Version:    0.7.0.1
 */