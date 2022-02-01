package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$ReqNearbySummaryCard
  extends MessageMicro<ReqNearbySummaryCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public NowSummaryCard.ClientInfo client_info = new NowSummaryCard.ClientInfo();
  public final PBUInt64Field come_from = PBField.initUInt64(0L);
  public NowSummaryCard.LocationInfo location = new NowSummaryCard.LocationInfo();
  public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uin", "tiny_id", "location", "client_info", "come_from" }, new Object[] { localLong, localLong, null, null, localLong }, ReqNearbySummaryCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.ReqNearbySummaryCard
 * JD-Core Version:    0.7.0.1
 */