package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;
import java.util.Map;

public class AudioEntity
{
  private static final String TAG = "AudioEntity";
  private Map<String, Object> audioCustomParams;
  private String contentId;
  private int playType = -1;
  private WeakReference<Object> weakPage;
  
  public Map<String, Object> getAudioCustomParams()
  {
    return this.audioCustomParams;
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  @Nullable
  public Object getPageObject()
  {
    if (this.weakPage == null) {
      return null;
    }
    return this.weakPage.get();
  }
  
  public String getPlayType()
  {
    return this.playType + "";
  }
  
  public String toString()
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return super.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioInfo:").append("contentId:").append(this.contentId).append("\n").append("playType:").append(this.playType).append("\n");
    Object localObject;
    if (this.weakPage == null)
    {
      localObject = "null";
      if (localObject == null) {
        break label102;
      }
      localStringBuilder.append(localObject.toString());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localObject = this.weakPage.get();
      break;
      label102:
      localStringBuilder.append("page is null").append("\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity
 * JD-Core Version:    0.7.0.1
 */