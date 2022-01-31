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
    if (paramSDKDataReportRequest == null) {}
    byte[] arrayOfByte;
    do
    {
      return false;
      arrayOfByte = ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(paramSDKDataReportRequest));
    } while (arrayOfByte == null);
    try
    {
      ab.c("SDKDataReportEngine_", "size:" + arrayOfByte.length + "|" + n.a(String.valueOf(paramSDKDataReportRequest.uin)) + "|" + paramSDKDataReportRequest.qimei + "|" + paramSDKDataReportRequest.qadid);
      label85:
      return sendRequest(arrayOfByte);
    }
    catch (Exception paramSDKDataReportRequest)
    {
      break label85;
    }
  }
  
  public void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte2 == null) || (paramInt != 0))
    {
      ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ error1");
      if (this.a != null) {
        this.a.a(paramInt);
      }
    }
    label172:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
            if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.body != null)) {
              break;
            }
            ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ error2");
          } while (this.a == null);
          this.a.a(paramInt);
          return;
          ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ onFinished");
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, SDKDataReportResponse.class);
          if (!(paramArrayOfByte1 instanceof SDKDataReportResponse)) {
            break label172;
          }
          paramArrayOfByte1 = (SDKDataReportResponse)paramArrayOfByte1;
          ab.c("SDKDataReportEngine_", "SDKDataReportEngine_ sdkDataReportRsp.ret=" + paramArrayOfByte1.ret);
          if (paramArrayOfByte1.ret != 0) {
            break;
          }
        } while (this.a == null);
        this.a.b();
        return;
      } while (this.a == null);
      this.a.a(paramInt);
      return;
    } while (this.a == null);
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.a.e
 * JD-Core Version:    0.7.0.1
 */