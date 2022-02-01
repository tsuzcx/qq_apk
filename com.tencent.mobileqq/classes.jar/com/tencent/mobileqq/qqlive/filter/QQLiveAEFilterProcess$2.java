package com.tencent.mobileqq.qqlive.filter;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveCameraFilterLoaderListener;

class QQLiveAEFilterProcess$2
  implements QQLiveAEResManager.QQLiveFilterLoadListener
{
  QQLiveAEFilterProcess$2(QQLiveAEFilterProcess paramQQLiveAEFilterProcess, QQLiveCameraFilterLoaderListener paramQQLiveCameraFilterLoaderListener) {}
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (QQLiveAEFilterProcess.b(this.b) != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.a.a(true);
      QQLiveAEFilterProcess.b(this.b).updateLutGL(paramString);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess.2
 * JD-Core Version:    0.7.0.1
 */