package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$PgcAnchorFilter
  extends MessageMicro<PgcAnchorFilter>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uin2gender", "interest_bit", "constellation", "home_town", "profession" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PgcAnchorFilter.class);
  public final PBUInt32Field constellation = PBField.initUInt32(0);
  public final PBUInt32Field home_town = PBField.initUInt32(0);
  public final PBUInt32Field interest_bit = PBField.initUInt32(0);
  public final PBUInt32Field profession = PBField.initUInt32(0);
  public final PBUInt32Field uin2gender = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.PgcAnchorFilter
 * JD-Core Version:    0.7.0.1
 */