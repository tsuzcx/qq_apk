package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileDialog
  extends MessageMicro<MobileDialog>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74 }, new String[] { "appid", "fromRoleID", "fromOpenID", "fromTinyID", "toRoleID", "toOpenID", "toTinyID", "time", "sig" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L), "" }, MobileDialog.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField fromOpenID = PBField.initString("");
  public final PBStringField fromRoleID = PBField.initString("");
  public final PBStringField fromTinyID = PBField.initString("");
  public final PBStringField sig = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
  public final PBStringField toOpenID = PBField.initString("");
  public final PBStringField toRoleID = PBField.initString("");
  public final PBStringField toTinyID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.MobileDialog
 * JD-Core Version:    0.7.0.1
 */