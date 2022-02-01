package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class ilive_feeds_source$CollectFeedsDataReq
  extends MessageMicro<CollectFeedsDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField client_type = PBField.initEnum(1);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField feeds_source = PBField.initEnum(1);
  public final PBRepeatField<ByteStringMicro> feeds_topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "feeds_id", "feeds_source", "feeds_topic", "client_type" }, new Object[] { localByteStringMicro1, localInteger, localByteStringMicro2, localInteger }, CollectFeedsDataReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_source.CollectFeedsDataReq
 * JD-Core Version:    0.7.0.1
 */