package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearbyProfile$GetProfileReq
  extends MessageMicro<GetProfileReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "fields" }, new Object[] { "" }, GetProfileReq.class);
  public final PBRepeatField<String> fields = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetProfileReq
 * JD-Core Version:    0.7.0.1
 */