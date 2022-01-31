package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGameList
  extends MessageMicro<STGameList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "game_id", "tab" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STGameList.class);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBInt32Field tab = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGameList
 * JD-Core Version:    0.7.0.1
 */