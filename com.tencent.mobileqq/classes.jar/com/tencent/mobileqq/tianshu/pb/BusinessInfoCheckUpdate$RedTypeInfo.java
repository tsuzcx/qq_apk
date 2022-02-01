package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$RedTypeInfo
  extends MessageMicro<RedTypeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField red_content = PBField.initString("");
  public final PBStringField red_desc = PBField.initString("");
  public final PBUInt32Field red_priority = PBField.initUInt32(0);
  public final PBUInt32Field red_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "red_type", "red_content", "red_desc", "red_priority" }, new Object[] { localInteger, "", "", localInteger }, RedTypeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo
 * JD-Core Version:    0.7.0.1
 */