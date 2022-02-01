package com.tencent.mobileqq.gamecenter.util;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class QQGameHelper$2$1
  implements AsyncBack
{
  QQGameHelper$2$1(QQGameHelper.2 param2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 2, "load 4235 html web resource finish code:" + paramInt);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.2.1
 * JD-Core Version:    0.7.0.1
 */