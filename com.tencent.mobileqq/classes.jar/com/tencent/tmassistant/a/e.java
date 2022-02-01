package com.tencent.tmassistant.a;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.SDKDataReportRequest;
import com.tencent.tmassistant.common.jce.SDKDataReportResponse;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.n;

class e
  extends PostHttpRequest
{
  private f a;
  
  void a(f paramf)
  {
    this.a = paramf;
  }
  
  boolean a(SDKDataReportRequest paramSDKDataReportRequest)
  {
    if (paramSDKDataReportRequest == null) {
      return false;
    }
    byte[] arrayOfByte = ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(paramSDKDataReportRequest));
    if (arrayOfByte == null) {
      return false;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size:");
      localStringBuilder.append(arrayOfByte.length);
      localStringBuilder.append("|");
      localStringBuilder.append(n.a(String.valueOf(paramSDKDataReportRequest.uin)));
      localStringBuilder.append("|");
      localStringBuilder.append(paramSDKDataReportRequest.qimei);
      localStringBuilder.append("|");
      localStringBuilder.append(paramSDKDataReportRequest.qadid);
      ab.c("SDKDataReportEngine_", localStringBuilder.toString());
      label105:
      return sendRequest(arrayOfByte);
    }
    catch (Exception paramSDKDataReportRequest)
    {
      break label105;
    }
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte2 != null) && (paramInt == 0))
    {
      paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.body != null))
      {
        ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ onFinished");
        paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, SDKDataReportResponse.class);
        if ((paramArrayOfByte1 instanceof SDKDataReportResponse))
        {
          paramArrayOfByte1 = (SDKDataReportResponse)paramArrayOfByte1;
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("SDKDataReportEngine_ sdkDataReportRsp.ret=");
          paramArrayOfByte2.append(paramArrayOfByte1.ret);
          ab.c("SDKDataReportEngine_", paramArrayOfByte2.toString());
          if (paramArrayOfByte1.ret == 0)
          {
            paramArrayOfByte1 = this.a;
            if (paramArrayOfByte1 != null) {
              paramArrayOfByte1.b();
            }
          }
          else
          {
            paramArrayOfByte1 = this.a;
            if (paramArrayOfByte1 != null) {
              paramArrayOfByte1.a(paramInt);
            }
          }
        }
        else
        {
          paramArrayOfByte1 = this.a;
          if (paramArrayOfByte1 != null) {
            paramArrayOfByte1.a(paramInt);
          }
        }
        return;
      }
      ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ error2");
      paramArrayOfByte1 = this.a;
      if (paramArrayOfByte1 != null) {
        paramArrayOfByte1.a(paramInt);
      }
      return;
    }
    ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ error1");
    paramArrayOfByte1 = this.a;
    if (paramArrayOfByte1 != null) {
      paramArrayOfByte1.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.a.e
 * JD-Core Version:    0.7.0.1
 */