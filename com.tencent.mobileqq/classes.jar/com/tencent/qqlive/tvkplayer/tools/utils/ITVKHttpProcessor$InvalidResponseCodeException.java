package com.tencent.qqlive.tvkplayer.tools.utils;

import android.support.annotation.Nullable;
import java.io.IOException;

public final class ITVKHttpProcessor$InvalidResponseCodeException
  extends IOException
{
  public final int responseCode;
  @Nullable
  public final String responseMessage;
  
  public ITVKHttpProcessor$InvalidResponseCodeException(int paramInt, @Nullable String paramString)
  {
    super("Response code: " + paramInt);
    this.responseCode = paramInt;
    this.responseMessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException
 * JD-Core Version:    0.7.0.1
 */