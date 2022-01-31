package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

public abstract interface Network
{
  public abstract Response performRequest(Request paramRequest);
  
  public abstract void performRequest(Request paramRequest, IWriteFuncListener paramIWriteFuncListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Network
 * JD-Core Version:    0.7.0.1
 */