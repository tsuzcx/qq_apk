package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_like$FeedsUnLikeRsp
  extends MessageMicro<FeedsUnLikeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "total", "ret" }, new Object[] { localInteger, localInteger }, FeedsUnLikeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeRsp
 * JD-Core Version:    0.7.0.1
 */