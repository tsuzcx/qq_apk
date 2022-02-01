package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGameList
  extends MessageMicro<STGameList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBInt32Field tab = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "game_id", "tab" }, new Object[] { localInteger, localInteger }, STGameList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGameList
 * JD-Core Version:    0.7.0.1
 */