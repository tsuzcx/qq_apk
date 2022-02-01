package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserInfo$ExpandInfo
  extends MessageMicro<ExpandInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "declarationa", "voice_url", "voice_duration", "voice_color" }, new Object[] { "", "", Integer.valueOf(0), "" }, ExpandInfo.class);
  public final PBStringField declarationa = PBField.initString("");
  public final PBStringField voice_color = PBField.initString("");
  public final PBUInt32Field voice_duration = PBField.initUInt32(0);
  public final PBStringField voice_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.ExpandInfo
 * JD-Core Version:    0.7.0.1
 */