package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobileqq_mp$LolaUpdateResponse
  extends MessageMicro<LolaUpdateResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "response_item" }, new Object[] { null, null }, LolaUpdateResponse.class);
  public final PBRepeatMessageField<mobileqq_mp.UpdateResponseItem> response_item = PBField.initRepeatMessage(mobileqq_mp.UpdateResponseItem.class);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateResponse
 * JD-Core Version:    0.7.0.1
 */