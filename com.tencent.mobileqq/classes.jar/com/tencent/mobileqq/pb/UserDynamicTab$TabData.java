package com.tencent.mobileqq.pb;

public final class UserDynamicTab$TabData
  extends MessageMicro<TabData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField first_show = PBField.initBool(false);
  public final PBBoolField gray_status = PBField.initBool(false);
  public final PBUInt32Field tab_id = PBField.initUInt32(0);
  public final PBEnumField tab_status = PBField.initEnum(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "tab_id", "tab_status", "gray_status", "first_show" }, new Object[] { localInteger, localInteger, localBoolean, localBoolean }, TabData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.TabData
 * JD-Core Version:    0.7.0.1
 */