package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserInfo$Record
  extends MessageMicro<Record>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public static final int assassin = 3;
  public static final int assist = 6;
  public static final int mage = 4;
  public static final int occupation_unset = 0;
  public static final int shooter = 5;
  public static final int tank = 1;
  public static final int warrior = 2;
  public final PBRepeatMessageField<UserInfo.UserHeroInfo> best_heros = PBField.initRepeatMessage(UserInfo.UserHeroInfo.class);
  public final PBEnumField best_occupation = PBField.initEnum(0);
  public final PBInt64Field games_total = PBField.initInt64(0L);
  public final PBInt64Field grade = PBField.initInt64(0L);
  public final PBInt64Field mvp_total = PBField.initInt64(0L);
  public final PBDoubleField win_rate = PBField.initDouble(0.0D);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 24, 32, 40, 50 }, new String[] { "grade", "win_rate", "games_total", "mvp_total", "best_occupation", "best_heros" }, new Object[] { localLong, Double.valueOf(0.0D), localLong, localLong, Integer.valueOf(0), null }, Record.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.Record
 * JD-Core Version:    0.7.0.1
 */