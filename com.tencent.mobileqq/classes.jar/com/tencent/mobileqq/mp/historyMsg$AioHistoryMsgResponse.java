package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class historyMsg$AioHistoryMsgResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField msg_infos = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public historyMsg.RetInfo ret_info = new historyMsg.RetInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "puin", "msg_infos" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro }, AioHistoryMsgResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgResponse
 * JD-Core Version:    0.7.0.1
 */