package com.tencent.open.appcircle.module;

import android.util.Log;
import com.tencent.open.appcircle.protocol.BaseRequest;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;

public class StatReportHttpEngine
  extends BaseRequest
{
  protected StatReportHttpEngine.IStatReportListener a = null;
  
  public int a(ArrayList<StatItem> paramArrayList)
  {
    StatReportRequest localStatReportRequest = new StatReportRequest();
    localStatReportRequest.data = paramArrayList;
    return a(localStatReportRequest);
  }
  
  public void a(StatReportHttpEngine.IStatReportListener paramIStatReportListener)
  {
    this.a = paramIStatReportListener;
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    Log.i("StatReportHttpRequest", ((StringBuilder)localObject).toString());
    localObject = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    paramArrayOfByte1 = ProtocolPackage.unpackRequestPackage(paramArrayOfByte1);
    int i;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.head != null)) {
      i = paramArrayOfByte1.head.requestId;
    } else {
      i = 0;
    }
    if ((paramArrayOfByte2 == null) && (this.a != null))
    {
      Log.i("StatReportHttpRequest", "response is null");
      this.a.a(i, null, null, paramInt);
      return;
    }
    if (this.a != null) {
      if ((localObject != null) && (((Response)localObject).body != null))
      {
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(((Response)localObject).body, StatReportResponse.class);
        if (paramArrayOfByte1 != null)
        {
          if (paramInt == 0)
          {
            if ((paramArrayOfByte1 instanceof StatReportResponse))
            {
              paramArrayOfByte1 = (StatReportResponse)paramArrayOfByte1;
              if (paramArrayOfByte1.ret == 0) {
                this.a.a(i, null, paramArrayOfByte1, 0);
              } else {
                this.a.a(i, null, paramArrayOfByte1, paramArrayOfByte1.ret);
              }
            }
          }
          else {
            this.a.a(i, null, null, paramInt);
          }
        }
        else {
          this.a.a(i, null, null, paramInt);
        }
      }
      else
      {
        this.a.a(i, null, null, paramInt);
      }
    }
    Log.i("StatReportHttpRequest", "exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcircle.module.StatReportHttpEngine
 * JD-Core Version:    0.7.0.1
 */