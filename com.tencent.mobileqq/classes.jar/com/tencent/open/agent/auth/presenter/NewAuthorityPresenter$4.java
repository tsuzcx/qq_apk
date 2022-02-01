package com.tencent.open.agent.auth.presenter;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.model.AccountInfo;

class NewAuthorityPresenter$4
  implements HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  NewAuthorityPresenter$4(NewAuthorityPresenter paramNewAuthorityPresenter) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "onTaskCompleted uin=", AuthorityUtil.a(paramString), ", bitmap=", paramBitmap });
    if (paramBitmap != null)
    {
      if (!paramString.equals(this.a.w.a)) {
        return;
      }
      NewAuthorityPresenter.d(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.4
 * JD-Core Version:    0.7.0.1
 */