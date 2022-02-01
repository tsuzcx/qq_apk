package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyProfile$GetMiniCardRsp
  extends MessageMicro<GetMiniCardRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "ret_msg", "is_show", "mini_card" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), null }, GetMiniCardRsp.class);
  public final PBBoolField is_show = PBField.initBool(false);
  public final PBRepeatMessageField<nearbyProfile.MiniCard> mini_card = PBField.initRepeatMessage(nearbyProfile.MiniCard.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetMiniCardRsp
 * JD-Core Version:    0.7.0.1
 */