package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$ReadOriginalFeedsReq
  extends MessageMicro<ReadOriginalFeedsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uid", "type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReadOriginalFeedsReq.class);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadOriginalFeedsReq
 * JD-Core Version:    0.7.0.1
 */