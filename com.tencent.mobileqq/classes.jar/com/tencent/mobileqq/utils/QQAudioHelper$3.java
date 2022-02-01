package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class QQAudioHelper$3
  implements Runnable
{
  QQAudioHelper$3(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("de:");
    localStringBuilder.append(this.a);
    localObject = QQToast.a((Context)localObject, localStringBuilder.toString(), 1);
    ((QQToast)localObject).a();
    ((QQToast)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQAudioHelper.3
 * JD-Core Version:    0.7.0.1
 */