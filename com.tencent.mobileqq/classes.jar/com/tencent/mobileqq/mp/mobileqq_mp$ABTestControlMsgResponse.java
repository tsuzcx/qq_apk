package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$ABTestControlMsgResponse
  extends MessageMicro<ABTestControlMsgResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "ret_info", "subscribe_newaio_switch", "abtest_switch", "extra_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, ABTestControlMsgResponse.class);
  public final PBInt32Field abtest_switch = PBField.initInt32(0);
  public final PBStringField extra_info = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBInt32Field subscribe_newaio_switch = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ABTestControlMsgResponse
 * JD-Core Version:    0.7.0.1
 */