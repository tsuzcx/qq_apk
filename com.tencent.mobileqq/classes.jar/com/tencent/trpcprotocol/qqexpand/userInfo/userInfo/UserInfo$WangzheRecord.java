package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserInfo$WangzheRecord
  extends MessageMicro<WangzheRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "record", "use_cache", "update_time" }, new Object[] { null, Boolean.valueOf(false), Long.valueOf(0L) }, WangzheRecord.class);
  public UserInfo.Record record = new UserInfo.Record();
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  public final PBBoolField use_cache = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.WangzheRecord
 * JD-Core Version:    0.7.0.1
 */