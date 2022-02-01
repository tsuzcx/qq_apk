package com.tencent.tmdownloader.internal.network;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.GetHalleyUrlReq;
import com.tencent.tmassistant.common.jce.GetHalleyUrlRsp;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;

public class GetHalleyUrlHttpRequest
  extends PostHttpRequest
{
  protected static final String TAG = "GetHalleyUrlHttpRequest";
  protected IGetHalleyUrlHttpListener mListener = null;
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinished errorCode: ");
    localStringBuilder.append(paramInt);
    ab.c(str, localStringBuilder.toString());
    paramArrayOfByte1 = ProtocolPackage.bytes2JceObj(ProtocolPackage.unpackRequestPackage(paramArrayOfByte1).body, GetHalleyUrlReq.class);
    if (paramArrayOfByte2 == null)
    {
      ab.c(TAG, "onFinished response is null!");
      ab.c(TAG, "exit");
      this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, null, false);
      return;
    }
    paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.body != null))
    {
      paramArrayOfByte2 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte2.body, GetHalleyUrlRsp.class);
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("halleyTest GetHalleyUrlHttpRequest finish jceResponse = ");
      localStringBuilder.append(paramArrayOfByte2);
      ab.c(str, localStringBuilder.toString());
      if (paramArrayOfByte2 != null)
      {
        if ((this.mListener != null) && (paramInt == 0))
        {
          if ((paramArrayOfByte2 instanceof GetHalleyUrlRsp))
          {
            paramArrayOfByte2 = (GetHalleyUrlRsp)paramArrayOfByte2;
            if (paramArrayOfByte2.ret == 0) {
              this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, paramArrayOfByte2, true);
            } else {
              this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, paramArrayOfByte2, false);
            }
          }
        }
        else {
          this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, null, false);
        }
      }
      else {
        this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, null, false);
      }
    }
    else
    {
      this.mListener.onHalleyUrlHttpRequestFinish((GetHalleyUrlReq)paramArrayOfByte1, null, false);
    }
    ab.c(TAG, "exit");
  }
  
  public void sendHalleyUrlRequest(String paramString)
  {
    GetHalleyUrlReq localGetHalleyUrlReq = new GetHalleyUrlReq();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localGetHalleyUrlReq.origins = localArrayList;
    super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(localGetHalleyUrlReq)));
  }
  
  public void setGetHalleyUrlHttpListener(IGetHalleyUrlHttpListener paramIGetHalleyUrlHttpListener)
  {
    this.mListener = paramIGetHalleyUrlHttpListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.network.GetHalleyUrlHttpRequest
 * JD-Core Version:    0.7.0.1
 */