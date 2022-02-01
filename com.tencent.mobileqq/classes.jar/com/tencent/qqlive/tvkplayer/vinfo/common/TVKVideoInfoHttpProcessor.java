package com.tencent.qqlive.tvkplayer.vinfo.common;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder;
import java.util.Map;

public class TVKVideoInfoHttpProcessor
{
  private static final String TAG = "MediaPlayerMgr[TVKVideoInfoHttpProcessor.java]";
  private static TVKVideoInfoHttpProcessor videoServiceUtil;
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
    addToRequestQueue(paramInt, paramString, paramMap1, paramMap2, new byte[0], paramITVKHttpCallback);
  }
  
  public void addToRequestQueue(int paramInt, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, @NonNull byte[] paramArrayOfByte, ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    paramString = new UriBuilder().setUrl(paramString).addParam(paramMap1).buildUri();
    paramMap1 = new StringBuilder();
    paramMap1.append("http request, url:");
    paramMap1.append(paramString);
    TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoHttpProcessor.java]", paramMap1.toString());
    TVKHttpProcessorFactory.getInstance().postAsync(paramString, paramMap2, paramArrayOfByte, this.mCgiNonWifiTimeout * paramInt, paramITVKHttpCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor
 * JD-Core Version:    0.7.0.1
 */