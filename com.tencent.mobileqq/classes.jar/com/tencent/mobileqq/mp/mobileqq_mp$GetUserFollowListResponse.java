package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetUserFollowListResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "ret_info", "follow_seqno", "public_account_seqno", "total_count", "info", "has_next", "group_info_seqno", "group_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Boolean.valueOf(false), Integer.valueOf(0), null }, GetUserFollowListResponse.class);
  public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
  public final PBRepeatMessageField group_info = PBField.initRepeatMessage(mobileqq_mp.GroupInfo.class);
  public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
  public final PBBoolField has_next = PBField.initBool(false);
  public final PBRepeatMessageField info = PBField.initRepeatMessage(mobileqq_mp.PublicAccountInfo.class);
  public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse
 * JD-Core Version:    0.7.0.1
 */