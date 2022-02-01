package com.tencent.qqmini.miniapp.plugin;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class ChooseMessageFileJsPlugin$1
  implements IActivityResultListener
{
  ChooseMessageFileJsPlugin$1(ChooseMessageFileJsPlugin paramChooseMessageFileJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnActivityResult requestCode");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" resultCode:");
    localStringBuilder.append(paramInt2);
    QMLog.d("ChooseMessageFileJsPlugin", localStringBuilder.toString());
    if (paramInt1 == 6001)
    {
      ChooseMessageFileJsPlugin.access$000(this.this$0, paramIntent, this.val$req, paramInt2);
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ChooseMessageFileJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */