package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class RequestFinishQuery
  extends RequestInfoQuery
{
  public static final int COMMON_QUERY = -1;
  public static int QUERY_HOLE_INTERVAL = 5000;
  public static final int QUERY_HOLE_INTERVAL_DEFAULT = 5000;
  public static int QUERY_HOLE_MAX_COUNT = 3;
  public static final int QUERY_HOLE_MAX_COUNT_DEFAULT = 3;
  public int mQueryHoleFinishIndex;
  
  public RequestFinishQuery(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte1, Transaction paramTransaction, long paramLong, byte[] paramArrayOfByte2)
  {
    super(paramString1, paramString2, paramInt, paramArrayOfByte1, paramTransaction, paramLong, paramArrayOfByte2);
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = super.getSegmentHead();
    if (this.mQueryHoleFinishIndex != -1) {
      localSegHead.uint32_query_times.set(this.mQueryHoleFinishIndex + 1);
    }
    return localSegHead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestFinishQuery
 * JD-Core Version:    0.7.0.1
 */