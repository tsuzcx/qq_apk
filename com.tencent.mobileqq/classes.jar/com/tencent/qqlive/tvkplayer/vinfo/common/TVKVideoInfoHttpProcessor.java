package com.tencent.qqlive.tvkplayer.vinfo.common;

import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder;
import java.util.Map;

public class TVKVideoInfoHttpProcessor
{
  private static final String TAG = "TVKVideoInfoHttpProcessor";
  private static TVKVideoInfoHttpProcessor videoServiceUtil = null;
  private int mCgiNonWifiTimeout = 0;
  private int mCgiRetryTime = 0;
  private int mCgiWifiTimeout = 0;
  
  public static TVKVideoInfoHttpProcessor getInstance()
  {
    try
    {
      if (videoServiceUtil == null) {
        videoServiceUtil = new TVKVideoInfoHttpProcessor();
      }
      TVKVideoInfoHttpProcessor localTVKVideoInfoHttpProcessor = videoServiceUtil;
      return localTVKVideoInfoHttpProcessor;
    }
    finally {}
  }
  
  public void addToRequestQueue(int paramInt, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    paramString = new UriBuilder().setUrl(paramString).addParam(paramMap1).buildUri();
    TVKLogUtil.i("TVKVideoInfoHttpProcessor", "http request, url:" + paramString);
    paramMap1 = TVKHttpProcessorFactory.getInstance();
    int i = this.mCgiNonWifiTimeout;
    paramMap1.postAsync(paramString, paramMap2, new byte[0], i * paramInt, paramITVKHttpCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor
 * JD-Core Version:    0.7.0.1
 */