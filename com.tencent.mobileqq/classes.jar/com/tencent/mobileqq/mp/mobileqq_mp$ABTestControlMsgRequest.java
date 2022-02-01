package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_mp$ABTestControlMsgRequest
  extends MessageMicro<ABTestControlMsgRequest>
{
  public static final int ABTEST_GUANLIZHONGXIN = 2;
  public static final int ABTEST_SUBSCRIBE = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "versionInfo", "testType" }, new Object[] { "", Integer.valueOf(1) }, ABTestControlMsgRequest.class);
  public final PBEnumField testType = PBField.initEnum(1);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ABTestControlMsgRequest
 * JD-Core Version:    0.7.0.1
 */