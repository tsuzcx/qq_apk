package com.tencent.mobileqq.theme.ListenTogetherTheme;

import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class AIOMusicSkin$3
  implements QuickUpdateListener
{
  AIOMusicSkin$3(AIOMusicSkin paramAIOMusicSkin) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "onCompleted, scid:" + paramString1);
    }
    this.a.a();
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.3
 * JD-Core Version:    0.7.0.1
 */