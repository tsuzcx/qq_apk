package com.tencent.mobileqq.minigame.api;

import ajyc;
import android.content.Context;
import bbcv;
import bbgg;
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
    bbgg localbbgg = bbcv.a(this.val$context, 230, null, GameWnsUtils.getGameErrorDialogContent(), ajyc.a(2131710219), ajyc.a(2131710220), new QQEnvImp.2.1(this), new QQEnvImp.2.2(this));
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
    MiniReportManager.reportEventType(GameInfoManager.g().getMiniAppConfig(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2
 * JD-Core Version:    0.7.0.1
 */