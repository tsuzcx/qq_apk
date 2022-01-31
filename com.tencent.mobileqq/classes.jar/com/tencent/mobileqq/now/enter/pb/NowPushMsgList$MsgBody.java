package com.tencent.mobileqq.now.enter.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowPushMsgList$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_now_push_msg" }, new Object[] { null }, MsgBody.class);
  public final PBRepeatMessageField rpt_now_push_msg = PBField.initRepeatMessage(NowPushMsgList.NowPushMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody
 * JD-Core Version:    0.7.0.1
 */