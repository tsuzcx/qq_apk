package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyProfile$MiniCard
  extends MessageMicro<MiniCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public nearbyProfile.CommonTag common_tag = new nearbyProfile.CommonTag();
  public final PBUInt32Field constellation = PBField.initUInt32(0);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBStringField logo = PBField.initString("");
  public final PBUInt32Field marriage = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public final PBUInt32Field profession = PBField.initUInt32(0);
  public final PBUInt64Field target_id = PBField.initUInt64(0L);
  public final PBUInt32Field vip_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 72, 802 }, new String[] { "target_id", "nick", "logo", "gender", "age", "marriage", "profession", "constellation", "vip_type", "common_tag" }, new Object[] { Long.valueOf(0L), "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null }, MiniCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.MiniCard
 * JD-Core Version:    0.7.0.1
 */