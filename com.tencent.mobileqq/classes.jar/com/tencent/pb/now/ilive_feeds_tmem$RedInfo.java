package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_tmem$RedInfo
  extends MessageMicro<RedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field last_feed_time = PBField.initUInt64(0L);
  public final PBUInt64Field time = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uid", "time", "last_feed_time" }, new Object[] { localLong, localLong, localLong }, RedInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem.RedInfo
 * JD-Core Version:    0.7.0.1
 */