package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class historyMsg$AioHistoryMsgRequest
  extends MessageMicro<AioHistoryMsgRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
  public final PBUInt64Field msg_id = PBField.initUInt64(0L);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "puin", "msg_id", "msg_cnt" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, AioHistoryMsgRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgRequest
 * JD-Core Version:    0.7.0.1
 */