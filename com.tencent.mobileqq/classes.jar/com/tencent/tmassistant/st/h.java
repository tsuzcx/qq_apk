package com.tencent.tmassistant.st;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.notification.g;
import java.util.ArrayList;
import java.util.Iterator;

public class h
  extends PostHttpRequest
{
  protected static h a;
  protected d b = null;
  private StatReportRequest c;
  
  public int a(ArrayList<StatItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StatItem localStatItem = (StatItem)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(">>sendRequest type = ");
        localStringBuilder.append(localStatItem.type);
        localStringBuilder.append(" data = ");
        localStringBuilder.append(g.a(localStatItem.records));
        ab.c("SDKREPORT", localStringBuilder.toString());
      }
      if (this.c == null) {
        this.c = new StatReportRequest();
      }
      localObject = this.c;
      ((StatReportRequest)localObject).data = paramArrayList;
      paramArrayList = ProtocolPackage.buildRequest((JceStruct)localObject);
      int i = paramArrayList.head.requestId;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selfUpdateReport sendStatReportRequest ret = ");
      ((StringBuilder)localObject).append(i);
      ab.c("StatReportEngine", ((StringBuilder)localObject).toString());
      paramArrayList = ProtocolPackage.buildPostData(paramArrayList);
      ab.c("StatReportEngine", "selfUpdateReport sendStatReportRequest");
      super.sendRequest(paramArrayList);
      return i;
    }
    return -1;
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    ab.c("StatReportEngine", ((StringBuilder)localObject).toString());
    localObject = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    paramArrayOfByte1 = (Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class);
    int i;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.head != null)) {
      i = paramArrayOfByte1.head.requestId;
    } else {
      i = 0;
    }
    if (paramArrayOfByte2 == null)
    {
      ab.c("StatReportEngine", "response is null");
      this.b.onStatReportFinish(i, null, null, paramInt);
      return;
    }
    if ((localObject != null) && (((Response)localObject).body != null))
    {
      paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(((Response)localObject).body, StatReportResponse.class);
      if (paramArrayOfByte1 != null)
      {
        if ((this.b != null) && (paramInt == 0))
        {
          if ((paramArrayOfByte1 instanceof StatReportResponse))
          {
            paramArrayOfByte1 = (StatReportResponse)paramArrayOfByte1;
            if (paramArrayOfByte1.ret == 0) {
              this.b.onStatReportFinish(i, null, paramArrayOfByte1, 0);
            } else {
              this.b.onStatReportFinish(i, null, paramArrayOfByte1, paramArrayOfByte1.ret);
            }
          }
        }
        else {
          this.b.onStatReportFinish(i, null, null, paramInt);
        }
      }
      else {
        this.b.onStatReportFinish(i, null, null, paramInt);
      }
    }
    else
    {
      this.b.onStatReportFinish(i, null, null, paramInt);
    }
    ab.c("StatReportEngine", "exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.st.h
 * JD-Core Version:    0.7.0.1
 */