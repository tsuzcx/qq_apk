package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearbyProfile$CommonTag
  extends MessageMicro<CommonTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tag" }, new Object[] { null }, CommonTag.class);
  public final PBRepeatMessageField<nearbyProfile.CommonTag.Tag> tag = PBField.initRepeatMessage(nearbyProfile.CommonTag.Tag.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.CommonTag
 * JD-Core Version:    0.7.0.1
 */