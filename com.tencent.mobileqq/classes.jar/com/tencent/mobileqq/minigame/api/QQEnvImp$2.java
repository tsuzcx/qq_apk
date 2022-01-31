package com.tencent.mobileqq.minigame.api;

import ajya;
import android.content.Context;
import bbdj;
import bbgu;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class QQEnvImp$2
  implements Runnable
{
  QQEnvImp$2(QQEnvImp paramQQEnvImp, Context paramContext, DialogCallback paramDialogCallback) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.val$context, 230, null, GameWnsUtils.getGameErrorDialogContent(), ajya.a(2131710230), ajya.a(2131710231), new QQEnvImp.2.1(this), new QQEnvImp.2.2(this));
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
    MiniReportManager.reportEventType(GameInfoManager.g().getMiniAppConfig(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2
 * JD-Core Version:    0.7.0.1
 */