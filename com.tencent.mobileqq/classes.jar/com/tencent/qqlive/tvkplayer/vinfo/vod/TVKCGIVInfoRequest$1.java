package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class TVKCGIVInfoRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKCGIVInfoRequest$1(TVKCGIVInfoRequest paramTVKCGIVInfoRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onFailure, e:" + paramIOException.toString());
    long l1 = SystemClock.elapsedRealtime();
    long l2 = TVKCGIVInfoRequest.access$500(this.this$0);
    if ((paramIOException instanceof ITVKHttpProcessor.InvalidResponseCodeException)) {}
    for (int i = ((ITVKHttpProcessor.InvalidResponseCodeException)paramIOException).responseCode;; i = TVKVideoInfoErrorCodeUtil.getErrCodeByThrowable(paramIOException.getCause()))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] failed, time cost:" + (l1 - l2) + "ms error:" + paramIOException.toString());
      if ((TVKCGIVInfoRequest.access$000(this.this$0)) && (TVKCGIVInfoRequest.access$100(this.this$0) == TVKCGIVInfoRequest.access$200()) && (TVKCGIVInfoRequest.access$300(this.this$0) != null))
      {
        int j = 1401000 + i;
        TVKCGIVInfoRequest.access$300(this.this$0).OnVInfoFailure(TVKCGIVInfoRequest.access$400(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) }), j);
      }
      if ((i >= 16) && (i <= 20)) {
        TVKCGIVInfoRequest.access$602(this.this$0, true);
      }
      if (TVKCGIVInfoRequest.access$900(this.this$0).useIpV6Dns()) {
        TVKVideoInfoCache.getInstance().setIpv6Error(true);
      }
      this.this$0.executeRequest();
      return;
    }
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "getvinfo onSuccess.");
    label387:
    label627:
    for (;;)
    {
      try
      {
        if ((paramHttpResponse.mHeaders.containsKey("Content-Encoding")) && (((List)paramHttpResponse.mHeaders.get("Content-Encoding")).contains("gzip")))
        {
          paramHttpResponse = TVKUtils.GZIPDeCompress(paramHttpResponse.mData);
          if (paramHttpResponse == null) {
            break label627;
          }
          paramHttpResponse = new String(paramHttpResponse, "UTF-8");
          long l1 = SystemClock.elapsedRealtime();
          long l2 = TVKCGIVInfoRequest.access$500(this.this$0);
          TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] success time cost:" + (l1 - l2) + " xml:" + paramHttpResponse);
          if (paramHttpResponse.contains("<?xml")) {
            break label255;
          }
          TVKCGIVInfoRequest.access$602(this.this$0, false);
          this.this$0.executeRequest();
          return;
        }
      }
      catch (Exception paramHttpResponse)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", paramHttpResponse);
        if ((!TVKCGIVInfoRequest.access$000(this.this$0)) || (TVKCGIVInfoRequest.access$100(this.this$0) != TVKCGIVInfoRequest.access$200())) {
          continue;
        }
        if (TVKCGIVInfoRequest.access$300(this.this$0) == null) {
          continue;
        }
        TVKCGIVInfoRequest.access$300(this.this$0).OnVInfoFailure(TVKCGIVInfoRequest.access$400(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(1401023) }), 1401023);
        return;
        this.this$0.executeRequest();
        return;
      }
      paramHttpResponse = new String(paramHttpResponse.mData, "UTF-8");
      continue;
      label255:
      if (!TextUtils.isEmpty(paramHttpResponse))
      {
        paramHttpResponse = new TVKCGIParser(paramHttpResponse);
        if (paramHttpResponse.init())
        {
          if ((TVKCGIVInfoRequest.access$700(this.this$0) <= 2) && ((paramHttpResponse.isXML85ErrorCode()) || (paramHttpResponse.isXMLHaveRetryNode())))
          {
            TVKLogUtil.i("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] cgi return retry or 85 error");
            TVKCGIVInfoRequest.access$704(this.this$0);
            TVKCGIVInfoRequest.access$106(this.this$0);
            TVKCGIVInfoRequest.access$806(this.this$0);
            if (TVKCGIVInfoRequest.access$700(this.this$0) == 2)
            {
              paramHttpResponse = this.this$0;
              if (TVKCGIVInfoRequest.access$000(this.this$0)) {
                break label387;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              TVKCGIVInfoRequest.access$002(paramHttpResponse, bool);
              TVKCGIVInfoRequest.access$102(this.this$0, 0);
              this.this$0.executeRequest();
              return;
            }
          }
          if (TVKCGIVInfoRequest.access$300(this.this$0) != null) {
            TVKCGIVInfoRequest.access$300(this.this$0).OnVInfoSuccess(TVKCGIVInfoRequest.access$400(this.this$0), paramHttpResponse.getXml(), paramHttpResponse.getDocument());
          }
        }
        else
        {
          TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] xml parse error");
          if ((TVKCGIVInfoRequest.access$000(this.this$0)) && (TVKCGIVInfoRequest.access$100(this.this$0) == TVKCGIVInfoRequest.access$200()))
          {
            if (TVKCGIVInfoRequest.access$300(this.this$0) != null) {
              TVKCGIVInfoRequest.access$300(this.this$0).OnVInfoFailure(TVKCGIVInfoRequest.access$400(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(1401015) }), 1401015);
            }
          }
          else {
            this.this$0.executeRequest();
          }
        }
      }
      else
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCGIVInfoRequest.java]", "[vinfo][getvinfo] return xml error!");
        if ((TVKCGIVInfoRequest.access$000(this.this$0)) && (TVKCGIVInfoRequest.access$100(this.this$0) == TVKCGIVInfoRequest.access$200()))
        {
          if (TVKCGIVInfoRequest.access$300(this.this$0) != null) {
            TVKCGIVInfoRequest.access$300(this.this$0).OnVInfoFailure(TVKCGIVInfoRequest.access$400(this.this$0), String.format("%d.%d", new Object[] { Integer.valueOf(101), Integer.valueOf(1401013) }), 1401013);
          }
        }
        else
        {
          this.this$0.executeRequest();
          return;
          paramHttpResponse = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */