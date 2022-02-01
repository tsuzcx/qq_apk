package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserConfig$GetOptionsReq
  extends MessageMicro<GetOptionsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "optionIDs", "Uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetOptionsReq.class);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBRepeatField<Integer> optionIDs = PBField.initRepeat(PBEnumField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.GetOptionsReq
 * JD-Core Version:    0.7.0.1
 */