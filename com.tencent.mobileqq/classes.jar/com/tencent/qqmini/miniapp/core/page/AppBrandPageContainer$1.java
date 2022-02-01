package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandPageContainer$1
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  AppBrandPageContainer$1(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onSoftKeyboardClosed()
  {
    QMLog.e("minisdk-start-AppBrandPageContainer", "onSoftKeyboardClosed ");
    AppBrandPageContainer.access$100(this.this$0);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSoftKeyboardOpened ");
    localStringBuilder.append(paramInt);
    QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
    AppBrandPageContainer.access$000(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.1
 * JD-Core Version:    0.7.0.1
 */