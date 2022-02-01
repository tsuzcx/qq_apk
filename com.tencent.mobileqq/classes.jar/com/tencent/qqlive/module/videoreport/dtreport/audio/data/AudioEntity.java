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
    WeakReference localWeakReference = this.weakPage;
    if (localWeakReference == null) {
      return null;
    }
    return localWeakReference.get();
  }
  
  public String getPlayType()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.playType);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    if (!VideoReportInner.getInstance().isDebugMode()) {
      return super.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioInfo:");
    localStringBuilder.append("contentId:");
    localStringBuilder.append(this.contentId);
    localStringBuilder.append("\n");
    localStringBuilder.append("playType:");
    localStringBuilder.append(this.playType);
    localStringBuilder.append("\n");
    Object localObject = this.weakPage;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      localStringBuilder.append(localObject.toString());
    }
    else
    {
      localStringBuilder.append("page is null");
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity
 * JD-Core Version:    0.7.0.1
 */