package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.net.ParseException;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadUtil;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

class TVKLiveInfoRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKLiveInfoRequest$1(TVKLiveInfoRequest paramTVKLiveInfoRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("livecgi error = ");
    localStringBuilder.append(paramIOException.toString());
    TVKLogUtil.w("MediaPlayerMgr[TVKLiveInfoRequest.java]", localStringBuilder.toString());
    if (TVKLiveInfoRequest.access$000(this.this$0) <= 3)
    {
      if (TVKLiveInfoRequest.access$100(this.this$0) == 1) {
        TVKLiveInfoRequest.access$102(this.this$0, 2);
      } else {
        TVKLiveInfoRequest.access$102(this.this$0, 1);
      }
      TVKLogUtil.w("MediaPlayerMgr[TVKLiveInfoRequest.java]", " change host, retry");
      TVKLiveInfoRequest.access$008(this.this$0);
      paramIOException = new StringBuilder();
      paramIOException.append(" retry count ");
      paramIOException.append(TVKLiveInfoRequest.access$000(this.this$0));
      TVKLogUtil.w("MediaPlayerMgr[TVKLiveInfoRequest.java]", paramIOException.toString());
      this.this$0.execute();
      return;
    }
    paramIOException = new TVKLiveVideoInfo();
    paramIOException.setErrModule(10000);
    paramIOException.setRetCode(141001);
    paramIOException.setErrInfo("getvinfo retry count Limit exceeded!");
    TVKLiveInfoRequest.access$300(this.this$0).onFailure(TVKLiveInfoRequest.access$200(this.this$0), paramIOException);
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    paramHttpResponse = new String(paramHttpResponse.mData);
    if (paramHttpResponse.length() > 0) {
      try
      {
        if ((this.this$0.isServerTimeErr(paramHttpResponse)) && (TVKLiveInfoRequest.access$400(this.this$0) < 3))
        {
          TVKLogUtil.w("MediaPlayerMgr[TVKLiveInfoRequest.java]", String.format("[err85]On success:ResponseBody = %s,", new Object[] { paramHttpResponse }));
          this.this$0.execute();
          TVKLiveInfoRequest.access$408(this.this$0);
          return;
        }
        TVKLiveInfoRequest.access$402(this.this$0, 0);
        TVKLiveInfoRequest.access$102(this.this$0, 1);
        TVKLiveInfoRequest.access$002(this.this$0, 1);
        try
        {
          TVKThreadUtil.THREAD_POOL_EXECUTOR.execute(new TVKLiveInfoRequest.1.1(this, paramHttpResponse));
          return;
        }
        catch (Throwable paramHttpResponse)
        {
          TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", paramHttpResponse);
          return;
        }
        TVKLiveVideoInfo localTVKLiveVideoInfo;
        return;
      }
      catch (ParseException paramHttpResponse)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", paramHttpResponse);
        localTVKLiveVideoInfo = new TVKLiveVideoInfo();
        localTVKLiveVideoInfo.setErrModule(10000);
        localTVKLiveVideoInfo.setErrInfo(paramHttpResponse.getMessage());
        localTVKLiveVideoInfo.setRetCode(121008);
        TVKLiveInfoRequest.access$300(this.this$0).onFailure(TVKLiveInfoRequest.access$200(this.this$0), localTVKLiveVideoInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */