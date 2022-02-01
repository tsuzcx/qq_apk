package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ShareQQArkHelper$5
  implements Runnable
{
  ShareQQArkHelper$5(boolean paramBoolean, MiniProgramShareUtils.OnShareListener paramOnShareListener, Boolean paramBoolean1, long paramLong, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject;
    if (!this.a)
    {
      localObject = this.b;
      if (localObject != null) {
        ((MiniProgramShareUtils.OnShareListener)localObject).onShared(this.c.booleanValue(), false);
      }
    }
    if (this.d == -100070004L)
    {
      localObject = this.b;
      if (localObject != null) {
        ((MiniProgramShareUtils.OnShareListener)localObject).onShared(this.c.booleanValue(), false);
      }
      localObject = this.e;
      DialogUtil.a((Context)localObject, 233, ((Activity)localObject).getString(2131916547), this.f, new ShareQQArkHelper.5.1(this), null).show();
      return;
    }
    ShareQQArkHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareQQArkHelper.5
 * JD-Core Version:    0.7.0.1
 */