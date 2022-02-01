package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ilive_feeds_write$FeedNoInterestReq
  extends MessageMicro<FeedNoInterestReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField feedid = PBField.initString("");
  public final PBInt32Field is_nointerest = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feedid", "is_nointerest", "type" }, new Object[] { "", localInteger, localInteger }, FeedNoInterestReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write.FeedNoInterestReq
 * JD-Core Version:    0.7.0.1
 */