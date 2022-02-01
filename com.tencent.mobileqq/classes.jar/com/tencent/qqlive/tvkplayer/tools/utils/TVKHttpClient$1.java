package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Request;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Request.NetworkRequestCompleteListener;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Response;
import java.io.IOException;

class TVKHttpClient$1
  implements Request.NetworkRequestCompleteListener
{
  TVKHttpClient$1(TVKHttpClient paramTVKHttpClient, ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback) {}
  
  public void onErrorResponse(Request paramRequest, IOException paramIOException)
  {
    if ((paramIOException instanceof HttpDataSource.InvalidResponseCodeException))
    {
      paramRequest = (HttpDataSource.InvalidResponseCodeException)paramIOException;
      paramIOException = new ITVKHttpProcessor.InvalidResponseCodeException(paramRequest.responseCode, paramRequest.responseMessage);
    }
    this.val$callback.onFailure(paramIOException);
  }
  
  public void onResponseReceived(Request paramRequest, Response paramResponse)
  {
    this.val$callback.onSuccess(new ITVKHttpProcessor.HttpResponse(paramResponse.responseHeaders, paramResponse.result));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpClient.1
 * JD-Core Version:    0.7.0.1
 */