package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class value$HwTmemList
  extends MessageMicro<HwTmemList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field actual_cnt = PBField.initInt32(0);
  public final PBRepeatMessageField<value.HwTmemList.HwSimpleInfo> simple_infos = PBField.initRepeatMessage(value.HwTmemList.HwSimpleInfo.class);
  public final PBInt32Field store_cnt = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "simple_infos", "actual_cnt", "store_cnt" }, new Object[] { null, localInteger, localInteger }, HwTmemList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwTmemList
 * JD-Core Version:    0.7.0.1
 */