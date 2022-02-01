package com.tencent.mobileqq.pb;

public final class UserDynamicTab$SetTabListRequest
  extends MessageMicro<SetTabListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField extend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField from_type = PBField.initEnum(0);
  public final PBRepeatMessageField<UserDynamicTab.TabData> tab_data = PBField.initRepeatMessage(UserDynamicTab.TabData.class);
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "tab_data", "from_type", "uin", "extend" }, new Object[] { null, Integer.valueOf(0), "", localByteStringMicro }, SetTabListRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.SetTabListRequest
 * JD-Core Version:    0.7.0.1
 */