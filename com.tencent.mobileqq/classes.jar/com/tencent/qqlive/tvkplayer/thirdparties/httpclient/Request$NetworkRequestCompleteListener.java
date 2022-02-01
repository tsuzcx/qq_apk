package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;

public abstract interface Request$NetworkRequestCompleteListener
{
  public abstract void onErrorResponse(Request paramRequest, IOException paramIOException);
  
  public abstract void onResponseReceived(Request paramRequest, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Request.NetworkRequestCompleteListener
 * JD-Core Version:    0.7.0.1
 */