package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class nearbyProfile$SetProfileReq
  extends MessageMicro<SetProfileReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "base_profile" }, new Object[] { null }, SetProfileReq.class);
  public nearbyProfile.BaseProfile base_profile = new nearbyProfile.BaseProfile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.SetProfileReq
 * JD-Core Version:    0.7.0.1
 */