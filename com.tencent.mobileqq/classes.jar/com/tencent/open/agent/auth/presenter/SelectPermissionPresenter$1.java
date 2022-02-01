package com.tencent.open.agent.auth.presenter;

import android.graphics.Bitmap;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.util.UiThreadUtil;
import mqq.app.AppRuntime;

class SelectPermissionPresenter$1
  implements Runnable
{
  SelectPermissionPresenter$1(SelectPermissionPresenter paramSelectPermissionPresenter) {}
  
  public void run()
  {
    Bitmap localBitmap = OpenSdkVirtualUtil.a(SelectPermissionPresenter.a(this.this$0).getApp(), SelectPermissionPresenter.a(this.this$0));
    if (localBitmap == null) {
      return;
    }
    UiThreadUtil.a(new SelectPermissionPresenter.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.1
 * JD-Core Version:    0.7.0.1
 */