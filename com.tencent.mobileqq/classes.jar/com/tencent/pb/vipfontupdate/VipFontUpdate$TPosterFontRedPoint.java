package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TPosterFontRedPoint
  extends MessageMicro<TPosterFontRedPoint>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field u64_last = initUInt64(0L);
  public final PBUInt64Field u64_ts = initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = initFieldMap(new int[] { 8, 16 }, new String[] { "u64_ts", "u64_last" }, new Object[] { localLong, localLong }, TPosterFontRedPoint.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterFontRedPoint
 * JD-Core Version:    0.7.0.1
 */