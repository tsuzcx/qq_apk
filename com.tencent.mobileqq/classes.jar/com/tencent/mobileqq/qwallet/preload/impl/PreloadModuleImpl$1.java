package com.tencent.mobileqq.qwallet.preload.impl;

import com.qwallet.temp.AsyncBackTemp;
import com.tencent.qphone.base.util.QLog;

class PreloadModuleImpl$1
  implements AsyncBackTemp
{
  PreloadModuleImpl$1(PreloadModuleImpl paramPreloadModuleImpl) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpByBusinessId loaded, code:");
      localStringBuilder.append(paramInt);
      QLog.d("PreloadModule", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpByBusinessId progress:");
      localStringBuilder.append(paramString);
      QLog.d("PreloadModule", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */