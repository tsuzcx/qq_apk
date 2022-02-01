package com.tencent.mobileqq.kandian.biz.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import mqq.app.AppRuntime;

class RIJTipMessageManager$4
  implements View.OnClickListener
{
  RIJTipMessageManager$4(RIJTipMessageManager paramRIJTipMessageManager) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    paramView = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((paramView != null) && (paramView.isFromNotification)) {
      RIJMsgBoxUtils.a(RIJTipMessageManager.a(this.a).a(), 5, false, paramView.mMsgId);
    } else {
      RIJMsgBoxUtils.a(RIJTipMessageManager.a(this.a).a(), 3);
    }
    if (Aladdin.getConfig(338).getIntegerFromString("allow_report_in_dau", 0) == 1)
    {
      if ((RIJTipMessageManager.a(this.a).a() instanceof ReadInJoyNewFeedsActivity))
      {
        ((ReadInJoyNewFeedsActivity)RIJTipMessageManager.a(this.a).a()).d(2);
        return;
      }
      if ((RIJTipMessageManager.a(this.a).a() instanceof SplashActivity))
      {
        paramView = (RIJTabFrameBase)RIJJumpUtils.a(RIJTipMessageManager.a(this.a).a());
        if (paramView != null) {
          paramView.b(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager.4
 * JD-Core Version:    0.7.0.1
 */