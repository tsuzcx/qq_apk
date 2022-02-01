package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PPCLoginAuth$plat_info
  extends MessageMicro<plat_info>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "implat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, plat_info.class);
  public final PBInt64Field implat = PBField.initInt64(0L);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.ppcloginauth.PPCLoginAuth.plat_info
 * JD-Core Version:    0.7.0.1
 */