package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserConfig$SetPrefOptionsReq
  extends MessageMicro<SetPrefOptionsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> pref_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBUInt32Field tag_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "tag_id", "pref_ids" }, new Object[] { localInteger, localInteger }, SetPrefOptionsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.SetPrefOptionsReq
 * JD-Core Version:    0.7.0.1
 */