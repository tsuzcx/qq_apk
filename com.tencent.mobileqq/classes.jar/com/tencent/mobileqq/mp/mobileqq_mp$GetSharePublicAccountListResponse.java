package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetSharePublicAccountListResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "seqno", "share_info" }, new Object[] { null, Integer.valueOf(0), null }, GetSharePublicAccountListResponse.class);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBRepeatMessageField share_info = PBField.initRepeatMessage(mobileqq_mp.ShareInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetSharePublicAccountListResponse
 * JD-Core Version:    0.7.0.1
 */