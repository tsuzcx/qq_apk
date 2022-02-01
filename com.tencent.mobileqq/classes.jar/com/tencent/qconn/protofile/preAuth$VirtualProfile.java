package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class preAuth$VirtualProfile
  extends MessageMicro<VirtualProfile>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "vid", "nick_name", "avatar_url" }, new Object[] { Long.valueOf(0L), "", "" }, VirtualProfile.class);
  public final PBStringField avatar_url = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
  public final PBUInt64Field vid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.preAuth.VirtualProfile
 * JD-Core Version:    0.7.0.1
 */