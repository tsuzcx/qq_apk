package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class UserConfig$Options
  extends MessageMicro<Options>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "wangzheOptions", "expandWallOptions", "pref_ids", "expandEntranceOptions" }, new Object[] { null, null, Integer.valueOf(0), null }, Options.class);
  public UserConfig.ExpandEntranceOptions expandEntranceOptions = new UserConfig.ExpandEntranceOptions();
  public UserConfig.ExpandWallOptions expandWallOptions = new UserConfig.ExpandWallOptions();
  public final PBRepeatField<Integer> pref_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public UserConfig.WangzheOptions wangzheOptions = new UserConfig.WangzheOptions();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.Options
 * JD-Core Version:    0.7.0.1
 */