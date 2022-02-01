package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReportLogResponse;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;

public class d
  extends PostHttpRequest
{
  protected c a = null;
  
  public void a(c paramc)
  {
    this.a = paramc;
  }
  
  public boolean a(byte paramByte, b paramb)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendLogDataToServer logType:");
    ((StringBuilder)localObject).append(paramByte);
    ((StringBuilder)localObject).append(" logDataWrapper:");
    ((StringBuilder)localObject).append(paramb);
    ab.c("LogReportHttpRequest", ((StringBuilder)localObject).toString());
    if (paramb == null) {
      return false;
    }
    localObject = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    int i = GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext());
    return super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest((ReportLogRequest)ProtocolPackage.buildReportRequest(paramByte, paramb.b, (String)localObject, i, ""))));
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2 == null)
    {
      paramArrayOfByte1 = this.a;
      if (paramArrayOfByte1 != null) {
        paramArrayOfByte1.a(this, false);
      }
      return;
    }
    if (this.a != null)
    {
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 4) && (paramInt == 0))
      {
        paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        paramArrayOfByte1 = ProtocolPackage.bytes2JceObj(((Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class)).body, ReportLogRequest.class);
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.body != null))
        {
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1, paramArrayOfByte2.body);
          if ((paramArrayOfByte1 instanceof ReportLogResponse))
          {
            paramArrayOfByte1 = (ReportLogResponse)paramArrayOfByte1;
            if (paramArrayOfByte1.ret == 0)
            {
              this.a.a(this, true);
              return;
            }
            this.a.a(this, false);
            paramArrayOfByte2 = new StringBuilder();
            paramArrayOfByte2.append("response ret:");
            paramArrayOfByte2.append(paramArrayOfByte1.ret);
            ab.c("LogReportHttpRequest", paramArrayOfByte2.toString());
            return;
          }
          ab.c("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
        }
      }
      else
      {
        this.a.a(this, false);
      }
    }
    else {
      ab.c("LogReportHttpRequest", "mListener is null !");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.d
 * JD-Core Version:    0.7.0.1
 */