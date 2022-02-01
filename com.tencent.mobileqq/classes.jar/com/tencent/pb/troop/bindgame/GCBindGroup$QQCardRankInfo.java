package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GCBindGroup$QQCardRankInfo
  extends MessageMicro<QQCardRankInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "summary", "rank" }, new Object[] { "", Integer.valueOf(0) }, QQCardRankInfo.class);
  public final PBInt32Field rank = PBField.initInt32(0);
  public final PBStringField summary = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQCardRankInfo
 * JD-Core Version:    0.7.0.1
 */