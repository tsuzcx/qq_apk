package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class AudioEntity$Builder
{
  private Map<String, Object> audioCustomParams;
  private String contentId;
  private int playType;
  private WeakReference<Object> weakPage;
  
  public Builder addCustomParam(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    if (this.audioCustomParams == null) {
      this.audioCustomParams = new HashMap(1);
    }
    this.audioCustomParams.put(paramString, paramObject);
    return this;
  }
  
  public Builder addCustomParams(Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    if (this.audioCustomParams == null) {
      this.audioCustomParams = new HashMap(1);
    }
    this.audioCustomParams.putAll(paramMap);
    return this;
  }
  
  public AudioEntity build()
  {
    AudioEntity localAudioEntity = new AudioEntity(null);
    AudioEntity.access$102(localAudioEntity, this.contentId);
    AudioEntity.access$202(localAudioEntity, this.playType);
    AudioEntity.access$302(localAudioEntity, this.weakPage);
    AudioEntity.access$402(localAudioEntity, this.audioCustomParams);
    return localAudioEntity;
  }
  
  public Builder removeAllCustomParams()
  {
    Map localMap = this.audioCustomParams;
    if (localMap != null) {
      localMap.clear();
    }
    return this;
  }
  
  public Builder removeCustomParam(String paramString)
  {
    Map localMap = this.audioCustomParams;
    if (localMap != null) {
      localMap.remove(paramString);
    }
    return this;
  }
  
  public Builder setContentId(String paramString)
  {
    this.contentId = paramString;
    return this;
  }
  
  public Builder setPage(Object paramObject)
  {
    if (paramObject == null) {
      return this;
    }
    this.weakPage = new WeakReference(paramObject);
    return this;
  }
  
  public Builder setPlayType(int paramInt)
  {
    this.playType = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity.Builder
 * JD-Core Version:    0.7.0.1
 */