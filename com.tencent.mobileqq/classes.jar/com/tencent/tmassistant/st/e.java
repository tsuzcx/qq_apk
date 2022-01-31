package com.tencent.tmassistant.st;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.notification.g;
import java.util.ArrayList;
import java.util.Iterator;

public class e
  extends PostHttpRequest
{
  protected static e a = null;
  protected a b = null;
  private StatReportRequest c;
  
  public int a(ArrayList<StatItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        StatItem localStatItem = (StatItem)localIterator.next();
        r.c("SDKREPORT", ">>sendRequest type = " + localStatItem.type + " data = " + g.a(localStatItem.records));
      }
      if (this.c == null) {
        this.c = new StatReportRequest();
      }
      this.c.data = paramArrayList;
      paramArrayList = ProtocolPackage.buildRequest(this.c);
      int i = paramArrayList.head.requestId;
      r.c("StatReportEngine", "selfUpdateReport sendStatReportRequest ret = " + i);
      paramArrayList = ProtocolPackage.buildPostData(paramArrayList);
      r.c("StatReportEngine", "selfUpdateReport sendStatReportRequest");
      super.sendRequest(paramArrayList);
      return i;
    }
    return -1;
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    r.c("StatReportEngine", "errorCode: " + paramInt);
    Response localResponse = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    paramArrayOfByte1 = (Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.head != null)) {}
    for (int i = paramArrayOfByte1.head.requestId;; i = 0)
    {
      if (paramArrayOfByte2 == null)
      {
        r.c("StatReportEngine", "response is null");
        this.b.onStatReportFinish(i, null, null, paramInt);
        return;
      }
      if ((localResponse != null) && (localResponse.body != null))
      {
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(localResponse.body, StatReportResponse.class);
        if (paramArrayOfByte1 != null) {
          if ((this.b != null) && (paramInt == 0)) {
            if ((paramArrayOfByte1 instanceof StatReportResponse))
            {
              paramArrayOfByte1 = (StatReportResponse)paramArrayOfByte1;
              if (paramArrayOfByte1.ret != 0) {
                break label166;
              }
              this.b.onStatReportFinish(i, null, paramArrayOfByte1, 0);
            }
          }
        }
      }
      for (;;)
      {
        r.c("StatReportEngine", "exit");
        return;
        label166:
        this.b.onStatReportFinish(i, null, paramArrayOfByte1, paramArrayOfByte1.ret);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
        continue;
        this.b.onStatReportFinish(i, null, null, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.st.e
 * JD-Core Version:    0.7.0.1
 */