package com.tencent.protofile.discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlyTicket$DiscussGetUrlResponse
  extends MessageMicro
{
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int SHORT_URL_FIELD_NUMBER = 5;
  public static final int SIG_FIELD_NUMBER = 3;
  public static final int URL_FIELD_NUMBER = 2;
  public static final int V_TIME_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "ret_info", "url", "sig", "v_time", "short_url" }, new Object[] { null, "", "", Integer.valueOf(0), "" }, DiscussGetUrlResponse.class);
  public FlyTicket.RetInfo ret_info = new FlyTicket.RetInfo();
  public final PBStringField short_url = PBField.initString("");
  public final PBStringField sig = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field v_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse
 * JD-Core Version:    0.7.0.1
 */