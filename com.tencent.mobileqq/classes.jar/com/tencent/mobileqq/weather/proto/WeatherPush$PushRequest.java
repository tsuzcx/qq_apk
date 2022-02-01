package com.tencent.mobileqq.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherPush$PushRequest
  extends MessageMicro<PushRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "pbReqMsgHead", "uin", "adcode", "hideRedPoint" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, PushRequest.class);
  public final PBUInt32Field adcode = PBField.initUInt32(0);
  public final PBBoolField hideRedPoint = PBField.initBool(false);
  public WeatherPush.PbReqMsgHead pbReqMsgHead = new WeatherPush.PbReqMsgHead();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.proto.WeatherPush.PushRequest
 * JD-Core Version:    0.7.0.1
 */