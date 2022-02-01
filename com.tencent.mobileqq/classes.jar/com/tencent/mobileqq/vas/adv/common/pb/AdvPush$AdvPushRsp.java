package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class AdvPush$AdvPushRsp
  extends MessageMicro<AdvPushRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "next_req_gap" }, new Object[] { Long.valueOf(0L) }, AdvPushRsp.class);
  public final PBInt64Field next_req_gap = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushRsp
 * JD-Core Version:    0.7.0.1
 */