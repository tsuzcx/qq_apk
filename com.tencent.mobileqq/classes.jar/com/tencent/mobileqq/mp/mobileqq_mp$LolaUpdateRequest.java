package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$LolaUpdateRequest
  extends MessageMicro<LolaUpdateRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "versionInfo", "request_item" }, new Object[] { "", null }, LolaUpdateRequest.class);
  public final PBRepeatMessageField<mobileqq_mp.UpdateRequestItem> request_item = PBField.initRepeatMessage(mobileqq_mp.UpdateRequestItem.class);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateRequest
 * JD-Core Version:    0.7.0.1
 */