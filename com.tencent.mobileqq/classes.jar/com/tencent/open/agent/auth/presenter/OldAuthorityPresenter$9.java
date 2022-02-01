package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.model.AccountInfo;

class OldAuthorityPresenter$9
  implements HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  OldAuthorityPresenter$9(OldAuthorityPresenter paramOldAuthorityPresenter) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "onTaskCompleted identifier=", AuthorityUtil.a(paramString), ", bitmap=", paramBitmap });
    if (paramBitmap != null)
    {
      if (!paramString.equals(this.a.jdField_a_of_type_ComTencentOpenModelAccountInfo.a)) {
        return;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new OldAuthorityPresenter.9.1(this, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.9
 * JD-Core Version:    0.7.0.1
 */