package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$HwTmemList$HwSimpleInfo
  extends MessageMicro<HwSimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
  public final PBUInt32Field hw_type = PBField.initUInt32(0);
  public final PBUInt64Field team_id = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "hw_id", "uin", "team_id", "hw_type" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0) }, HwSimpleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwTmemList.HwSimpleInfo
 * JD-Core Version:    0.7.0.1
 */