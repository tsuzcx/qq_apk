package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;

public class RequestHeartBreak
  extends HwRequest
{
  public int connId;
  public boolean isUrgent = false;
  
  public RequestHeartBreak(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramInt1, null, -1, paramLong);
    this.connId = paramInt2;
    this.isUrgent = paramBoolean;
    if (this.isUrgent) {
      this.timeOut = 10000L;
    }
    this.isOpenUpEnable = OpenUpConfig.isOpenUpEnable;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("DUMP_REQ [TYPE_HEARTBREAK] Info: ");
    localStringBuilder1.append(super.dumpBaseInfo());
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" ConnId:");
    localStringBuilder2.append(this.connId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" Urgent:");
    localStringBuilder2.append(this.isUrgent);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public int getPriority()
  {
    return 0;
  }
  
  public byte[] getRequestBody()
  {
    return super.getRequestBody();
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    return null;
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    paramRequestWorker.engine.mConnManager.onHeartBreakResp(this.sendConnId, this.endpoint, this.isUrgent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestHeartBreak
 * JD-Core Version:    0.7.0.1
 */