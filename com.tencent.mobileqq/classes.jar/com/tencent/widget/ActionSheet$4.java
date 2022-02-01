package com.tencent.widget;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class ActionSheet$4
  implements URLDrawable.DownloadListener
{
  ActionSheet$4(ActionSheet paramActionSheet) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.i("ActionSheet", 1, "onFileDownloadFailed " + paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    QLog.i("ActionSheet", 1, "onFileDownloadStarted");
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    QLog.i("ActionSheet", 1, "onFileDownloadSucceed " + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.4
 * JD-Core Version:    0.7.0.1
 */