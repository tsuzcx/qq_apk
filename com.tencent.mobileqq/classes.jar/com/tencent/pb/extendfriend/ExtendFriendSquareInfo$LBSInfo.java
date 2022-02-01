package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ExtendFriendSquareInfo$LBSInfo
  extends MessageMicro<LBSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public ExtendFriendSquareInfo.GPS msg_gps = new ExtendFriendSquareInfo.GPS();
  public final PBRepeatMessageField<ExtendFriendSquareInfo.Cell> rpt_msg_cells = PBField.initRepeatMessage(ExtendFriendSquareInfo.Cell.class);
  public final PBRepeatMessageField<ExtendFriendSquareInfo.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(ExtendFriendSquareInfo.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo.LBSInfo
 * JD-Core Version:    0.7.0.1
 */