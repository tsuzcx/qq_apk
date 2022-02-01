package com.tencent.protofile.discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FlyTicket$DiscussSigDecodeResponse
  extends MessageMicro<DiscussSigDecodeResponse>
{
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SIG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "sig" }, new Object[] { null, "" }, DiscussSigDecodeResponse.class);
  public FlyTicket.RetInfo ret_info = new FlyTicket.RetInfo();
  public final PBStringField sig = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse
 * JD-Core Version:    0.7.0.1
 */