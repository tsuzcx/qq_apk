package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$ClearAnchorRedPointReq
  extends MessageMicro<ClearAnchorRedPointReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "anchor_uid", "feed_id" }, new Object[] { Long.valueOf(0L), "" }, ClearAnchorRedPointReq.class);
  public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
  public final PBStringField feed_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.ClearAnchorRedPointReq
 * JD-Core Version:    0.7.0.1
 */