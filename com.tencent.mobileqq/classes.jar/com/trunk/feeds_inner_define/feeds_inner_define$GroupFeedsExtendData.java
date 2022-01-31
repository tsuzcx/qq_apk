package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_inner_define$GroupFeedsExtendData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reverse = PBField.initBytes(ByteStringMicro.EMPTY);
  public feeds_inner_define.ConcernUinRecordSet msg_concern_uin_record_set = new feeds_inner_define.ConcernUinRecordSet();
  public final PBUInt32Field uint32_author_ignore_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_reverse", "msg_concern_uin_record_set", "uint32_author_ignore_time" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0) }, GroupFeedsExtendData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.GroupFeedsExtendData
 * JD-Core Version:    0.7.0.1
 */