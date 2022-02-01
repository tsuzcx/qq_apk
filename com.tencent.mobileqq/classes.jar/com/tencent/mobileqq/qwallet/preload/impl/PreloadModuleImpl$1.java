package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class PreloadModuleImpl$1
  implements AsyncBack
{
  PreloadModuleImpl$1(PreloadModuleImpl paramPreloadModuleImpl) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId loaded, code:" + paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId progress:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */