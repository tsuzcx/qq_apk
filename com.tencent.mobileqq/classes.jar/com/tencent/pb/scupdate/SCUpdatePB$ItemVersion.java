package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$ItemVersion
  extends MessageMicro<ItemVersion>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "bid", "scid", "version", "flag", "subappid", "subitemid" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ItemVersion.class);
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBStringField scid = PBField.initString("");
  public final PBUInt32Field subappid = PBField.initUInt32(0);
  public final PBUInt32Field subitemid = PBField.initUInt32(0);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.ItemVersion
 * JD-Core Version:    0.7.0.1
 */