package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VaProfileGate$GetGiftListRsp
  extends MessageMicro<GetGiftListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "gift_url", "custom_url", "desc", "is_on" }, new Object[] { "", "", "", Boolean.valueOf(false) }, GetGiftListRsp.class);
  public final PBStringField custom_url = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBRepeatField<String> gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBoolField is_on = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.GetGiftListRsp
 * JD-Core Version:    0.7.0.1
 */