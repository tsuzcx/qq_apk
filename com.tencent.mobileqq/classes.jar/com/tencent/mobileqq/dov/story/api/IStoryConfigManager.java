package com.tencent.mobileqq.dov.story.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStoryConfigManager
  extends QRouteApi
{
  public abstract int getHighBitrate();
  
  public abstract int getMaxUploadFileSize();
  
  public abstract <V> V getStoryValue(@NonNull String paramString, @NonNull V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.IStoryConfigManager
 * JD-Core Version:    0.7.0.1
 */