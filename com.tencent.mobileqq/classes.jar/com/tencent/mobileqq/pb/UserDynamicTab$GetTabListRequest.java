package com.tencent.mobileqq.pb;

public final class UserDynamicTab$GetTabListRequest
  extends MessageMicro<GetTabListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "sequence", "kandian_data", "qua", "device_info" }, new Object[] { Long.valueOf(0L), null, "", "" }, GetTabListRequest.class);
  public final PBStringField device_info = PBField.initString("");
  public UserDynamicTab.TabData kandian_data = new UserDynamicTab.TabData();
  public final PBStringField qua = PBField.initString("");
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.GetTabListRequest
 * JD-Core Version:    0.7.0.1
 */