package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import org.json.JSONObject;

final class ShareQQArkHelper$4
  implements MiniAppCmdInterface
{
  ShareQQArkHelper$4(int paramInt, Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      if (this.a == 5)
      {
        localObject = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        if (localObject == null) {
          return;
        }
        localObject = ((BaseRuntime)localObject).getShareState();
        if (localObject == null) {
          return;
        }
        ((ShareState)localObject).shareJson = paramJSONObject.toString();
      }
      ShareQQArkHelper.a(this.b, this.c, paramJSONObject, this.a);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdListener: share failed ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.e("ShareQQArkHelper", 1, ((StringBuilder)localObject).toString());
    ShareQQArkHelper.a(this.b, paramBoolean, paramJSONObject, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareQQArkHelper.4
 * JD-Core Version:    0.7.0.1
 */