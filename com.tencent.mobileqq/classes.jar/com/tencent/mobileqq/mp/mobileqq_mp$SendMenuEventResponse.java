package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$SendMenuEventResponse
  extends MessageMicro<SendMenuEventResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret_info", "seqno" }, new Object[] { null, Integer.valueOf(0) }, SendMenuEventResponse.class);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse
 * JD-Core Version:    0.7.0.1
 */