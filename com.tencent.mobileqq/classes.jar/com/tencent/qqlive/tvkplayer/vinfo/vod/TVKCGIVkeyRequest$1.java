package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import java.io.IOException;

class TVKCGIVkeyRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKCGIVkeyRequest$1(TVKCGIVkeyRequest paramTVKCGIVkeyRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKCGIVkeyRequest.access$000(this.this$0);
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {}
    for (int i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;; i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause()))
    {
      TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] failed, time cost:" + (l1 - l2) + "ms error:" + paramIOException.toString());
      if ((TVKCGIVkeyRequest.access$500(this.this$0)) && (TVKCGIVkeyRequest.access$400(this.this$0) == TVKCGIVkeyRequest.access$800()) && (TVKCGIVkeyRequest.access$600(this.this$0) != null))
      {
        int j = 1402000 + i;
        TVKCGIVkeyRequest.access$600(this.this$0).onVkeyFailure(TVKCGIVkeyRequest.access$700(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(j) }), j);
      }
      if ((i >= 16) && (i <= 20)) {
        TVKCGIVkeyRequest.access$102(this.this$0, true);
      }
      this.this$0.executeRequest();
      return;
    }
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    boolean bool = true;
    paramHttpResponse = new String(paramHttpResponse.mData);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKCGIVkeyRequest.access$000(this.this$0);
    TVKLogUtil.i("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] success timecost:" + (l1 - l2) + " xml:" + paramHttpResponse);
    if (!paramHttpResponse.contains("<?xml"))
    {
      TVKCGIVkeyRequest.access$102(this.this$0, false);
      this.this$0.executeRequest();
    }
    label240:
    label378:
    do
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(paramHttpResponse)) {
            break label378;
          }
          paramHttpResponse = new TVKCGIParser(paramHttpResponse);
          if (!paramHttpResponse.init()) {
            break;
          }
          if ((TVKCGIVkeyRequest.access$200(this.this$0) <= 2) && ((paramHttpResponse.isXML85ErrorCode()) || (paramHttpResponse.isXMLHaveRetryNode())))
          {
            TVKCGIVkeyRequest.access$204(this.this$0);
            TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] 85 error code, retry time" + TVKCGIVkeyRequest.access$200(this.this$0));
            TVKCGIVkeyRequest.access$306(this.this$0);
            TVKCGIVkeyRequest.access$406(this.this$0);
            if (TVKCGIVkeyRequest.access$200(this.this$0) == 2)
            {
              paramHttpResponse = this.this$0;
              if (TVKCGIVkeyRequest.access$500(this.this$0)) {
                break label240;
              }
            }
            for (;;)
            {
              TVKCGIVkeyRequest.access$502(paramHttpResponse, bool);
              TVKCGIVkeyRequest.access$402(this.this$0, 0);
              this.this$0.executeRequest();
              return;
              bool = false;
            }
          }
        } while (TVKCGIVkeyRequest.access$600(this.this$0) == null);
        TVKCGIVkeyRequest.access$600(this.this$0).onVkeySuccess(TVKCGIVkeyRequest.access$700(this.this$0), paramHttpResponse.getXml(), paramHttpResponse.getDocument());
        return;
        TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getkey] xml parse error");
        if ((!TVKCGIVkeyRequest.access$500(this.this$0)) || (TVKCGIVkeyRequest.access$400(this.this$0) != TVKCGIVkeyRequest.access$800())) {
          break;
        }
      } while (TVKCGIVkeyRequest.access$600(this.this$0) == null);
      TVKCGIVkeyRequest.access$600(this.this$0).onVkeyFailure(TVKCGIVkeyRequest.access$700(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(1402015) }), 1402015);
      return;
      this.this$0.executeRequest();
      return;
      TVKLogUtil.e("MediaPlayer[TVKCGIVkeyRequest.java]", "[vinfo][getvkey] response not xml");
      if ((!TVKCGIVkeyRequest.access$500(this.this$0)) || (TVKCGIVkeyRequest.access$400(this.this$0) != TVKCGIVkeyRequest.access$800())) {
        break;
      }
    } while (TVKCGIVkeyRequest.access$600(this.this$0) == null);
    TVKCGIVkeyRequest.access$600(this.this$0).onVkeyFailure(TVKCGIVkeyRequest.access$700(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(103), Integer.valueOf(1402013) }), 1402013);
    return;
    this.this$0.executeRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVkeyRequest.1
 * JD-Core Version:    0.7.0.1
 */