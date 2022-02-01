package com.tencent.mobileqq.pb;

public final class UserDynamicTab$ModelRule
  extends MessageMicro<ModelRule>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "model_type", "tab_id" }, new Object[] { Integer.valueOf(0), null }, ModelRule.class);
  public final PBEnumField model_type = PBField.initEnum(0);
  public final PBRepeatMessageField<UserDynamicTab.ModelTabId> tab_id = PBField.initRepeatMessage(UserDynamicTab.ModelTabId.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.ModelRule
 * JD-Core Version:    0.7.0.1
 */