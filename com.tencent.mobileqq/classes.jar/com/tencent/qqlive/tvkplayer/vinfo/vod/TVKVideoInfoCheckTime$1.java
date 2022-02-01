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
    int i;
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {
      i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;
    } else {
      i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[videoInfo][checktime] failed, time cost:");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("ms error:");
    localStringBuilder.append(paramIOException.toString());
    TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", localStringBuilder.toString());
    if ((i >= 16) && (i <= 20)) {
      TVKVideoInfoCheckTime.access$502(this.this$0, true);
    }
    TVKVideoInfoCheckTime.access$400(this.this$0);
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    paramHttpResponse = new String(paramHttpResponse.mData);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKVideoInfoCheckTime.access$200(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoInfo][checkTime]success xml:");
    localStringBuilder.append(paramHttpResponse);
    localStringBuilder.append(" timecost:");
    localStringBuilder.append(l1 - l2);
    TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", localStringBuilder.toString());
    if ((TextUtils.isEmpty(paramHttpResponse)) || (!TVKVideoInfoCheckTime.access$300(this.this$0, paramHttpResponse))) {
      TVKVideoInfoCheckTime.access$400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCheckTime.1
 * JD-Core Version:    0.7.0.1
 */