package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LbsShare$NearByShopsResp
  extends MessageMicro<NearByShopsResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBUInt32Field next_begin = PBField.initUInt32(0);
  public final PBRepeatMessageField<LbsShare.Shop> poilist = PBField.initRepeatMessage(LbsShare.Shop.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ec", "poilist", "next_begin", "total" }, new Object[] { localInteger, null, localInteger, localInteger }, NearByShopsResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.LbsShare.NearByShopsResp
 * JD-Core Version:    0.7.0.1
 */