package com.tencent.qqlive.tvkplayer.tools.utils;

import java.io.IOException;

public abstract interface ITVKHttpProcessor$ITVKHttpCallback
{
  public abstract void onFailure(IOException paramIOException);
  
  public abstract void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback
 * JD-Core Version:    0.7.0.1
 */