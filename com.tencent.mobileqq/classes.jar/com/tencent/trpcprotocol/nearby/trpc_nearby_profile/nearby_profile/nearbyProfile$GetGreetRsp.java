package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyProfile$GetGreetRsp
  extends MessageMicro<GetGreetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> greet_msg = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field left_cnt = PBField.initUInt32(0);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "ret_msg", "left_cnt", "greet_msg" }, new Object[] { localInteger, "", localInteger, "" }, GetGreetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetGreetRsp
 * JD-Core Version:    0.7.0.1
 */