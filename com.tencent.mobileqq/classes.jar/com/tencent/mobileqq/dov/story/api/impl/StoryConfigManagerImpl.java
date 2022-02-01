package com.tencent.mobileqq.dov.story.api.impl;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.dov.story.api.IStoryConfigManager;

public class StoryConfigManagerImpl
  implements IStoryConfigManager
{
  public int getHighBitrate()
  {
    return StoryConfigManager.p();
  }
  
  public int getMaxUploadFileSize()
  {
    return StoryConfigManager.o();
  }
  
  public <V> V getStoryValue(@NonNull String paramString, @NonNull V paramV)
  {
    return ((StoryConfigManager)SuperManager.a(10)).c(paramString, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.StoryConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */