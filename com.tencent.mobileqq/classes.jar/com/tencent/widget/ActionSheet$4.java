package com.tencent.widget;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class ActionSheet$4
  implements URLDrawable.DownloadListener
{
  ActionSheet$4(ActionSheet paramActionSheet) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFileDownloadFailed ");
    localStringBuilder.append(paramInt);
    QLog.i("ActionSheet", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadStarted()
  {
    QLog.i("ActionSheet", 1, "onFileDownloadStarted");
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFileDownloadSucceed ");
    localStringBuilder.append(paramLong);
    QLog.i("ActionSheet", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.4
 * JD-Core Version:    0.7.0.1
 */