package com.tencent.pb.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CustomOnlineStatusPb$CustomOnlineStatusMsg
  extends MessageMicro<CustomOnlineStatusMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField sCustomDesc = PBField.initString("");
  public final PBStringField sCustomModel = PBField.initString("");
  public final PBUInt32Field uHasCustomInfo = PBField.initUInt32(0);
  public final PBUInt32Field uUpdateInterval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uHasCustomInfo", "sCustomDesc", "sCustomModel", "uUpdateInterval" }, new Object[] { localInteger, "", "", localInteger }, CustomOnlineStatusMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg
 * JD-Core Version:    0.7.0.1
 */