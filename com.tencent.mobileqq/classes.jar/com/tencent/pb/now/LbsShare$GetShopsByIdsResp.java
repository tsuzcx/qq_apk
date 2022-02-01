package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LbsShare$GetShopsByIdsResp
  extends MessageMicro<GetShopsByIdsResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ec", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByIdsResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBRepeatMessageField<LbsShare.DPBiz> shops = PBField.initRepeatMessage(LbsShare.DPBiz.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.LbsShare.GetShopsByIdsResp
 * JD-Core Version:    0.7.0.1
 */