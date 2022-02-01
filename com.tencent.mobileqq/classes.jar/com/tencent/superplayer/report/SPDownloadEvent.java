package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class SPDownloadEvent
{
  private static final String TAG = "SPDownloadEvent";
  private static HashMap<Integer, String> sBossIdMap;
  private int mBossIdInt = 0;
  private Map<String, String> mData = new HashMap();
  
  private SPDownloadEvent()
  {
    if (sBossIdMap == null)
    {
      sBossIdMap = new HashMap();
      sBossIdMap.put(Integer.valueOf(3646), "ServerQuality");
      sBossIdMap.put(Integer.valueOf(8954), "CdnQuality");
      sBossIdMap.put(Integer.valueOf(8877), "DownloadSpeed");
    }
  }
  
  private void innerParseEvent(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtil.w("SPDownloadEvent", "parseEvent failed for reportStr is empty");
      return;
    }
    paramString = paramString.replaceFirst(".*\\?", "").split("&");
    if (paramString.length > 0)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length >= 2) {
          this.mData.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    try
    {
      this.mBossIdInt = Integer.parseInt((String)this.mData.get("BossId"));
      return;
    }
    catch (Throwable paramString)
    {
      LogUtil.e("SPDownloadEvent", "parseEvent exception", paramString);
    }
  }
  
  public static SPDownloadEvent parseEvent(String paramString)
  {
    SPDownloadEvent localSPDownloadEvent = new SPDownloadEvent();
    localSPDownloadEvent.innerParseEvent(paramString);
    return localSPDownloadEvent;
  }
  
  public int getBossIdInt()
  {
    return this.mBossIdInt;
  }
  
  public Map<String, String> getDataMap()
  {
    return this.mData;
  }
  
  public String getEventName()
  {
    return (String)sBossIdMap.get(Integer.valueOf(this.mBossIdInt));
  }
  
  public boolean needReport()
  {
    return sBossIdMap.containsKey(Integer.valueOf(this.mBossIdInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.report.SPDownloadEvent
 * JD-Core Version:    0.7.0.1
 */