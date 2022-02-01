package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ilive_feeds_source$CollectFeedsDataRsp
  extends MessageMicro<CollectFeedsDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "error_code" }, new Object[] { Integer.valueOf(0) }, CollectFeedsDataRsp.class);
  public final PBInt32Field error_code = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_source.CollectFeedsDataRsp
 * JD-Core Version:    0.7.0.1
 */