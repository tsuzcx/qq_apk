package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xac5$NearbyNowData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_now_haiwan" }, new Object[] { null }, NearbyNowData.class);
  public final PBRepeatMessageField rpt_msg_now_haiwan = PBField.initRepeatMessage(oidb_0xac5.NowHaiWan.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0xac5.NearbyNowData
 * JD-Core Version:    0.7.0.1
 */