package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$TmemOidbUserInfo
  extends MessageMicro<TmemOidbUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field constellation = PBField.initUInt32(0);
  public final PBUInt32Field home_town = PBField.initUInt32(0);
  public final PBUInt32Field interest_bit = PBField.initUInt32(0);
  public final PBUInt32Field profession = PBField.initUInt32(0);
  public final PBUInt32Field update_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "interest_bit", "constellation", "home_town", "profession", "update_time" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, TmemOidbUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.TmemOidbUserInfo
 * JD-Core Version:    0.7.0.1
 */