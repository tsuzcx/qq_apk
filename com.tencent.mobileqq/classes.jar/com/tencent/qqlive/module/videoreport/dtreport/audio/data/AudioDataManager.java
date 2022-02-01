package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;

public class AudioDataManager
  implements IAudioDataManager
{
  private static final String TAG = "AudioDataManager";
  
  public static IAudioDataManager getInstance()
  {
    return AudioDataManager.InstanceHolder.sInstance;
  }
  
  public void bindAudioInfo(Object paramObject, AudioEntity paramAudioEntity)
  {
    AudioEntity localAudioEntity = paramAudioEntity;
    if (paramAudioEntity == null) {
      localAudioEntity = new AudioEntity.Builder().setContentId("").setPlayType(-1).build();
    }
    AudioDataStorage.setData(paramObject, localAudioEntity);
  }
  
  @Nullable
  public AudioEntity getAudioInfo(Object paramObject)
  {
    paramObject = AudioDataStorage.getData(paramObject);
    if (paramObject == null) {
      Log.e("AudioDataManager", "AudioInfo is null, check'");
    }
    return paramObject;
  }
  
  public boolean isForeground(Object paramObject)
  {
    paramObject = getAudioInfo(paramObject);
    if (paramObject != null) {
      paramObject = paramObject.getPageObject();
    } else {
      paramObject = null;
    }
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if ((paramObject != null) && (localPageInfo != null)) {
      return paramObject.equals(localPageInfo.getPage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager
 * JD-Core Version:    0.7.0.1
 */