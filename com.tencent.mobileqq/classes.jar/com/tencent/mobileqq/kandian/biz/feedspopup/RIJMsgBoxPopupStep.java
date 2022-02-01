package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class RIJMsgBoxPopupStep
  extends BasePopupStep
{
  private Activity a;
  
  public RIJMsgBoxPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJMsgBoxPopupStep");
    this.a = paramActivity;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (paramActivity == null)
    {
      QLog.e("RIJMsgBoxPopupStep", 1, "openMsgBoxPage failed, activity = null");
      return;
    }
    paramActivity.getWindow().getDecorView().postDelayed(new RIJMsgBoxPopupStep.1(this, paramActivity, paramInt, paramString), paramLong);
    j();
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIfShowMsgBoxWithFloatingWindow | launchFrom : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJMsgBoxPopupStep", 2, ((StringBuilder)localObject).toString());
    if (paramInt != 5) {
      return false;
    }
    localObject = ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).Q();
    if ((localObject != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount((KandianMsgBoxRedPntInfo)localObject) > 0))
    {
      boolean bool = ((Boolean)RIJSPUtils.b("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfShowMsgBoxWithFloatingWindow | sp showFloatingWin ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("RIJMsgBoxPopupStep", 1, ((StringBuilder)localObject).toString());
      localObject = Aladdin.getConfig(262);
      if (localObject != null)
      {
        if (((AladdinConfig)localObject).getIntegerFromString("kandian_msg_box_popup_window_cfg", 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        RIJSPUtils.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIfShowMsgBoxWithFloatingWindow | aladdin cfg showFloatingWin ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("RIJMsgBoxPopupStep", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfShowMsgBoxWithFloatingWindow | showFloatingWindow ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("RIJMsgBoxPopupStep", 1, ((StringBuilder)localObject).toString());
      if (bool)
      {
        a(this.a, 6, "", 0L);
        localObject = this.a;
        if (localObject != null)
        {
          localObject = (RIJTabFrameBase)RIJJumpUtils.a((Context)localObject);
          if (localObject != null) {
            ((RIJTabFrameBase)localObject).b(32);
          }
        }
      }
      return bool;
    }
    QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
    return false;
  }
  
  private void j()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = localKandianMergeManager.Q();
    if (localKandianMsgBoxRedPntInfo != null)
    {
      localKandianMsgBoxRedPntInfo.isRead = true;
      localKandianMergeManager.I();
      ThreadManagerV2.excute(new RIJMsgBoxPopupStep.2(this, localKandianMsgBoxRedPntInfo, localKandianMergeManager), 64, null, false);
    }
  }
  
  protected void h()
  {
    Object localObject = this.a.getIntent();
    boolean bool3 = ((Intent)localObject).hasExtra("notification_message_id");
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      String str = ((Intent)localObject).getStringExtra("notification_message_id");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int j = RIJMsgBoxUtils.b();
      int i = 1;
      if ((j == 2) && (RIJKanDianLockScreenPushAladdinConfig.b() == 2)) {
        if (!str.isEmpty()) {
          ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
        } else {
          QLog.i("RIJMsgBoxPopupStep", 1, "readInJoy lock push, notificationMessageId is empty");
        }
      }
      ((Intent)localObject).removeExtra("notification_message_id");
      if (RIJKanDianLockScreenPushAladdinConfig.b() != 1)
      {
        bool1 = bool2;
        if (RIJMsgBoxUtils.b() == 2) {}
      }
      else
      {
        a(this.a, 5, str, 200L);
        bool1 = true;
      }
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", localQQAppInterface.getCurrentAccountUin()).addValueSafe("push_type", Integer.valueOf(9));
      if (bool1) {
        i = 3;
      }
      PublicAccountReportUtils.a("0X80081DB", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addValueSafe("load_mode", Integer.valueOf(i)).build());
    }
    a(bool1);
  }
  
  protected void i()
  {
    int i = this.a.getIntent().getIntExtra("launch_from", 5);
    boolean bool;
    if ((((KandianMergeManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).R() > 0) && (a(i))) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJMsgBoxPopupStep
 * JD-Core Version:    0.7.0.1
 */