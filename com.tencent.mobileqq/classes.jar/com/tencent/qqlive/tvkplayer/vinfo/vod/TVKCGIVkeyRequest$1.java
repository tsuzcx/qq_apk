package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import java.io.IOException;

class TVKCGIVkeyRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKCGIVkeyRequest$1(TVKCGIVkeyRequest paramTVKCGIVkeyRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    TVKCGIVkeyRequest.access$100(this.this$0, paramIOException);
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKCGIVkeyRequest.access$000(this.this$0, paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVkeyRequest.1
 * JD-Core Version:    0.7.0.1
 */