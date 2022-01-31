package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import java.io.IOException;

class TVKVideoInfoCheckTime$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKVideoInfoCheckTime$1(TVKVideoInfoCheckTime paramTVKVideoInfoCheckTime) {}
  
  public void onFailure(IOException paramIOException)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKVideoInfoCheckTime.access$200(this.this$0);
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {}
    for (int i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;; i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause()))
    {
      TVKLogUtil.i("VideoInfo[TVKCGICheckTime]", "[videoInfo][checktime] failed, time cost:" + (l1 - l2) + "ms error:" + paramIOException.toString());
      if ((i >= 16) && (i <= 20)) {
        TVKVideoInfoCheckTime.access$502(this.this$0, true);
      }
      TVKVideoInfoCheckTime.access$400(this.this$0);
      return;
    }
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    paramHttpResponse = new String(paramHttpResponse.mData);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKVideoInfoCheckTime.access$200(this.this$0);
    TVKLogUtil.i("VideoInfo[TVKCGICheckTime]", "[VideoInfo][checkTime]success xml:" + paramHttpResponse + " timecost:" + (l1 - l2));
    if ((TextUtils.isEmpty(paramHttpResponse)) || (!TVKVideoInfoCheckTime.access$300(this.this$0, paramHttpResponse))) {
      TVKVideoInfoCheckTime.access$400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCheckTime.1
 * JD-Core Version:    0.7.0.1
 */