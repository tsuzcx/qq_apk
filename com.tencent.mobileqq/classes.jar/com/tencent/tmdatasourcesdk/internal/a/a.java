package com.tencent.tmdatasourcesdk.internal.a;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.network.PostHttpRequest;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppDetailParam;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailRequest;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.GetAppSimpleDetailResponse;
import java.util.ArrayList;

public class a
  extends PostHttpRequest
{
  protected ITMAssistantExchangeURLListenner a = null;
  
  public a(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    this.a = paramITMAssistantExchangeURLListenner;
  }
  
  public boolean a(ArrayList<AppDetailParam> paramArrayList)
  {
    GetAppSimpleDetailRequest localGetAppSimpleDetailRequest = new GetAppSimpleDetailRequest();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appDetailParams size = ");
      localStringBuilder.append(paramArrayList.size());
      ab.c("GetAppSimpleDetailHttpRequest", localStringBuilder.toString());
      localGetAppSimpleDetailRequest.appReqList = paramArrayList;
      super.sendRequest(ProtocolPackage.buildPostData(ProtocolPackage.buildRequest(localGetAppSimpleDetailRequest)));
      return true;
    }
    ab.e("GetAppSimpleDetailHttpRequest", "appDetailParams is null");
    return false;
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2 == null)
    {
      ab.e("GetAppSimpleDetailHttpRequest", "response is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request length = ");
    Object localObject;
    if (paramArrayOfByte1 == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramArrayOfByte1.length);
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(",response length = ");
    localStringBuilder.append(paramArrayOfByte2.length);
    localStringBuilder.append(",errorCode = ");
    localStringBuilder.append(paramInt);
    ab.c("GetAppSimpleDetailHttpRequest", localStringBuilder.toString());
    if ((this.a != null) && (paramInt == 0))
    {
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 4))
      {
        paramArrayOfByte2 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
        paramArrayOfByte1 = ProtocolPackage.bytes2JceObj(((Request)ProtocolPackage.bytes2JceObj(paramArrayOfByte1, Request.class)).body, GetAppSimpleDetailRequest.class);
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.body != null))
        {
          paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1, paramArrayOfByte2.body);
          if ((paramArrayOfByte1 instanceof GetAppSimpleDetailResponse))
          {
            paramArrayOfByte1 = (GetAppSimpleDetailResponse)paramArrayOfByte1;
            if (paramArrayOfByte1.ret == 0)
            {
              paramArrayOfByte1 = paramArrayOfByte1.appSimpleDetailList;
              if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.size() > 0))
              {
                this.a.onExchangedURLSucceed(paramArrayOfByte1, true);
                return;
              }
              ab.d("GetAppSimpleDetailHttpRequest", " appDetails 为空!!");
              this.a.onExchangedURLSucceed(null, false);
              return;
            }
            paramArrayOfByte2 = new StringBuilder();
            paramArrayOfByte2.append(" 后台返回的ret错误，错误值为：");
            paramArrayOfByte2.append(paramArrayOfByte1.ret);
            ab.d("GetAppSimpleDetailHttpRequest", paramArrayOfByte2.toString());
            this.a.onExchangedURLSucceed(null, false);
          }
        }
      }
    }
    else
    {
      ab.d("GetAppSimpleDetailHttpRequest", " error happened!!");
      if (this.a != null)
      {
        ab.d("GetAppSimpleDetailHttpRequest", "mListener.onExchangedURLSucceed");
        this.a.onExchangedURLSucceed(null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.internal.a.a
 * JD-Core Version:    0.7.0.1
 */