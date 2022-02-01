package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BusinessInfoCheckUpdate$RedDisplayInfo
  extends MessageMicro<RedDisplayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "red_type_info", "tab_display_info" }, new Object[] { null, null }, RedDisplayInfo.class);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> red_type_info = PBField.initRepeatMessage(BusinessInfoCheckUpdate.RedTypeInfo.class);
  public BusinessInfoCheckUpdate.RedTypeInfo tab_display_info = new BusinessInfoCheckUpdate.RedTypeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */