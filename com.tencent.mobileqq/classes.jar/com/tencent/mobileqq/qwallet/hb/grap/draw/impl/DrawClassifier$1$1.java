package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class DrawClassifier$1$1
  implements IPreloadService.OnGetPathListener
{
  DrawClassifier$1$1(DrawClassifier.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel())
    {
      paramPathResult = new StringBuilder();
      paramPathResult.append("tryPreDownLoadModel finished:");
      paramPathResult.append(paramInt);
      QLog.d("DrawClassifier", 2, paramPathResult.toString());
    }
    if (paramInt == 0) {
      DrawClassifier.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier.1.1
 * JD-Core Version:    0.7.0.1
 */