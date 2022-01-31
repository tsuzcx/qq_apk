package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_dynamic_search$TabItemGroup
  extends MessageMicro<TabItemGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_mask = PBField.initUInt32(0);
  public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_mask", "tab_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TabItemGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.TabItemGroup
 * JD-Core Version:    0.7.0.1
 */