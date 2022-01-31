package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$UserBlackList
  extends MessageMicro<UserBlackList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_uin", "black_feeds" }, new Object[] { Long.valueOf(0L), null }, UserBlackList.class);
  public final PBUInt64Field act_uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<ilive_feeds_tmem.RankBlackFeeds> black_feeds = PBField.initRepeatMessage(ilive_feeds_tmem.RankBlackFeeds.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.UserBlackList
 * JD-Core Version:    0.7.0.1
 */