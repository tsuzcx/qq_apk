package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import anni;
import bglp;
import bgpa;
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
    bgpa localbgpa = bglp.a(this.val$context, 230, null, GameWnsUtils.getGameErrorDialogContent(), anni.a(2131708990), anni.a(2131708991), new QQEnvImp.2.1(this), new QQEnvImp.2.2(this));
    localbgpa.setCanceledOnTouchOutside(false);
    localbgpa.show();
    MiniReportManager.reportEventType(QQEnvImp.access$000(this.this$0).getGameInfoManager().getMiniAppConfig(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2
 * JD-Core Version:    0.7.0.1
 */