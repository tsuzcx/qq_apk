package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ITVKDataBinder$Factory
{
  private static final String TAG = "IVideoDataBinder.Factory";
  private static final Map<String, ITVKDataBinder> mBinders = new ConcurrentHashMap();
  
  public static void init(String paramString, IDTTVKDataProvider paramIDTTVKDataProvider)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] init binder for ");
    localStringBuilder.append(paramString);
    Log.d("IVideoDataBinder.Factory", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramIDTTVKDataProvider = new TVKDataBinder(paramString, paramIDTTVKDataProvider);
    mBinders.put(paramString, paramIDTTVKDataProvider);
  }
  
  public static void release(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] release binder for ");
    localStringBuilder.append(paramString);
    Log.d("IVideoDataBinder.Factory", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    mBinders.remove(paramString);
  }
  
  public static ITVKDataBinder with(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = (ITVKDataBinder)mBinders.get(paramString);
    } else {
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new DefaultTVKDataBinder();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder.Factory
 * JD-Core Version:    0.7.0.1
 */