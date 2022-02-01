package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class ShareQQArkHelper$3
  extends CmdCallback.Stub
{
  ShareQQArkHelper$3(MiniArkShareModel paramMiniArkShareModel, Activity paramActivity, MiniProgramShareUtils.OnShareListener paramOnShareListener, QQProgressDialog paramQQProgressDialog) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("imageUrl");
      this.a.setPicUrl(paramBundle);
      ShareQQArkHelper.c(this.b, this.a, this.c);
      ShareQQArkHelper.a(this.d);
      return;
    }
    QLog.e("ShareQQArkHelper", 1, "dealWithShareImage error!");
    ShareQQArkHelper.a(this.d);
    ShareQQArkHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareQQArkHelper.3
 * JD-Core Version:    0.7.0.1
 */