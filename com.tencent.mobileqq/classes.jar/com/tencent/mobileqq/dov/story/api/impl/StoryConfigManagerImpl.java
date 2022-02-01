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
    return StoryConfigManager.d();
  }
  
  public int getMaxUploadFileSize()
  {
    return StoryConfigManager.c();
  }
  
  public <V> V getStoryValue(@NonNull String paramString, @NonNull V paramV)
  {
    return ((StoryConfigManager)SuperManager.a(10)).b(paramString, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.StoryConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */