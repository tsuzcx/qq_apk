package com.tencent.open.agent.auth.presenter;

import android.graphics.Bitmap;
import com.tencent.open.agent.auth.IBaseView;
import com.tencent.open.agent.util.SSOLog;

class BaseAuthorityPresenter$1
  implements Runnable
{
  BaseAuthorityPresenter$1(BaseAuthorityPresenter paramBaseAuthorityPresenter, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.this$0.l = true;
    SSOLog.b("BaseAuthorityPresenter", "get app icon done");
    this.this$0.z.a("", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.1
 * JD-Core Version:    0.7.0.1
 */