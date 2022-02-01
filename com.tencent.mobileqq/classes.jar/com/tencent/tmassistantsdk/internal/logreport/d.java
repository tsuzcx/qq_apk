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
    ab.c("LogReportHttpRequest", "sendLogDataToServer logType:" + paramByte + " logDataWrapper:" + paramb);
    if (paramb == null) {
      return false;
    }
    String str = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    int i = GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext());
    return super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest((ReportLogRequest)ProtocolPackage.buildReportRequest(paramByte, paramb.b, str, i, ""))));
  }
  
  public void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2 == null) {
      if (this.a != null) {
        this.a.a(this, false);
      }
    }
    do
    {
      return;
      if (this.a == null) {
        break label177;
      }
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 4) || (paramInt != 0)) {
        break;
      }
      paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
      paramArrayOfByte1 = ProtocolPackage.bytes2JceObj(((Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class)).body, ReportLogRequest.class);
    } while ((paramArrayOfByte2 == null) || (paramArrayOfByte2.body == null));
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
      ab.c("LogReportHttpRequest", "response ret:" + paramArrayOfByte1.ret);
      return;
    }
    ab.c("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
    return;
    this.a.a(this, false);
    return;
    label177:
    ab.c("LogReportHttpRequest", "mListener is null !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.d
 * JD-Core Version:    0.7.0.1
 */