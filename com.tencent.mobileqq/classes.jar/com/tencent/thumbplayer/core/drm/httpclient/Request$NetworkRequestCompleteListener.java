package com.tencent.thumbplayer.core.drm.httpclient;

import java.io.IOException;

public abstract interface Request$NetworkRequestCompleteListener
{
  public abstract void onErrorResponse(Request paramRequest, IOException paramIOException);
  
  public abstract void onResponseReceived(Request paramRequest, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Request.NetworkRequestCompleteListener
 * JD-Core Version:    0.7.0.1
 */