package com.tencent.mobileqq.pb;

public final class UserDynamicTab$GetTabListResponse
  extends MessageMicro<GetTabListResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "tab_data", "sequence", "reson_code", "model_rule" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), null }, GetTabListResponse.class);
  public final PBRepeatMessageField<UserDynamicTab.ModelRule> model_rule = PBField.initRepeatMessage(UserDynamicTab.ModelRule.class);
  public final PBUInt32Field reson_code = PBField.initUInt32(0);
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
  public final PBRepeatMessageField<UserDynamicTab.TabData> tab_data = PBField.initRepeatMessage(UserDynamicTab.TabData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.GetTabListResponse
 * JD-Core Version:    0.7.0.1
 */