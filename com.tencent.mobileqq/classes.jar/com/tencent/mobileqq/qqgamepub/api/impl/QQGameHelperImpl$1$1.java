package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class QQGameHelperImpl$1$1
  implements AsyncBack
{
  QQGameHelperImpl$1$1(QQGameHelperImpl.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("load 4235 html web resource finish code:");
      paramString.append(paramInt);
      QLog.d("QQGamePub_QQGameHelper", 2, paramString.toString());
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.1.1
 * JD-Core Version:    0.7.0.1
 */