package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.IWriteFuncListener;
import java.util.List;
import java.util.Map;

class TVKHttpClient$2
  implements IWriteFuncListener
{
  TVKHttpClient$2(TVKHttpClient paramTVKHttpClient, ITVKHttpProcessor.IWriteCallback paramIWriteCallback) {}
  
  public void onWriteBody(byte[] paramArrayOfByte, int paramInt)
  {
    this.val$callback.writeBody(paramArrayOfByte, paramInt);
  }
  
  public void onWriteBodyEnd()
  {
    this.val$callback.onWriteBodyEnd();
  }
  
  public void onWriteHeaders(Map<String, List<String>> paramMap)
  {
    this.val$callback.writeHeaders(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpClient.2
 * JD-Core Version:    0.7.0.1
 */