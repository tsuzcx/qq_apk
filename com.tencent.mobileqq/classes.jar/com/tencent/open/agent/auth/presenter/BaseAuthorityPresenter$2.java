package com.tencent.open.agent.auth.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.entity.IconUrlSize;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import mqq.app.AppRuntime;

class BaseAuthorityPresenter$2
  implements Runnable
{
  BaseAuthorityPresenter$2(BaseAuthorityPresenter paramBaseAuthorityPresenter, IconUrlSize paramIconUrlSize) {}
  
  public void run()
  {
    AuthReporter.a("KEY_GET_APP_ICON");
    Bitmap localBitmap = AuthorityUtil.d(this.a.a.get());
    AuthReporter.a("KEY_GET_APP_ICON", this.this$0.w);
    if (localBitmap == null) {
      return;
    }
    OpenSdkVirtualUtil.a(this.this$0.C.getApp(), this.this$0.l(), localBitmap);
    this.this$0.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.2
 * JD-Core Version:    0.7.0.1
 */