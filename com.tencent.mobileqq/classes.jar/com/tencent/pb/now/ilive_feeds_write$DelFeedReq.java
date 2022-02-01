package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_write$DelFeedReq
  extends MessageMicro<DelFeedReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field anchor_del_user = PBField.initUInt32(0);
  public final PBEnumField del_source = PBField.initEnum(1);
  public final PBRepeatMessageField<ilive_feeds_write.DelFeedStuct> del_st = PBField.initRepeatMessage(ilive_feeds_write.DelFeedStuct.class);
  public final PBEnumField del_type = PBField.initEnum(1);
  public final PBUInt32Field select_all = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56 }, new String[] { "del_type", "uid", "del_st", "select_all", "del_source", "vid", "anchor_del_user" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0) }, DelFeedReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write.DelFeedReq
 * JD-Core Version:    0.7.0.1
 */