package com.tencent.mobileqq.dov.story.api.impl;

import com.tencent.mobileqq.dov.story.api.ISVParamManager;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;

public class SVParamManagerImpl
  implements ISVParamManager
{
  public int getBitRate(int paramInt)
  {
    return SVParamManager.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.SVParamManagerImpl
 * JD-Core Version:    0.7.0.1
 */