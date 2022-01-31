package com.tencent.mobileqq.minigame.api;

import alpo;
import android.content.Context;
import bdcd;
import bdfq;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class QQEnvImp$2
  implements Runnable
{
  QQEnvImp$2(QQEnvImp paramQQEnvImp, Context paramContext, DialogCallback paramDialogCallback) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.val$context, 230, null, GameWnsUtils.getGameErrorDialogContent(), alpo.a(2131710602), alpo.a(2131710603), new QQEnvImp.2.1(this), new QQEnvImp.2.2(this));
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
    MiniReportManager.reportEventType(QQEnvImp.access$000(this.this$0).getGameInfoManager().getMiniAppConfig(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2
 * JD-Core Version:    0.7.0.1
 */