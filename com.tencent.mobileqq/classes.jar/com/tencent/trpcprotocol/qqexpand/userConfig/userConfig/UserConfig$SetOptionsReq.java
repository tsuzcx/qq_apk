package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class UserConfig$SetOptionsReq
  extends MessageMicro<SetOptionsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "optionIDs", "options" }, new Object[] { Integer.valueOf(0), null }, SetOptionsReq.class);
  public final PBRepeatField<Integer> optionIDs = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public UserConfig.Options options = new UserConfig.Options();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.SetOptionsReq
 * JD-Core Version:    0.7.0.1
 */