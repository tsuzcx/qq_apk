import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep.1;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep.2;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class pxf
  extends pwy
{
  private Activity a;
  
  public pxf(@NotNull pwz parampwz, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(parampwz, "RIJMsgBoxPopupStep");
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
    i();
  }
  
  private boolean a(int paramInt)
  {
    QLog.d("RIJMsgBoxPopupStep", 2, "checkIfShowMsgBoxWithFloatingWindow | launchFrom : " + paramInt);
    if (paramInt != 5) {
      return false;
    }
    Object localObject = ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((localObject == null) || (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt <= 0))
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
      return false;
    }
    boolean bool = ((Boolean)bmhv.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
    QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | sp showFloatingWin " + bool);
    localObject = Aladdin.getConfig(262);
    if (localObject != null) {
      if (((AladdinConfig)localObject).getIntegerFromString("kandian_msg_box_popup_window_cfg", 0) == 1)
      {
        bool = true;
        bmhv.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
        QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | aladdin cfg showFloatingWin " + bool);
      }
    }
    for (;;)
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | showFloatingWindow " + bool);
      if (bool)
      {
        a(this.a, 6, "", 0L);
        if (this.a != null)
        {
          localObject = pqx.a(this.a);
          if (localObject != null) {
            ((ReadinjoyTabFrame)localObject).a(32);
          }
        }
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  private void i()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = localKandianMergeManager.a();
    if (localKandianMsgBoxRedPntInfo != null)
    {
      localKandianMsgBoxRedPntInfo.isRead = true;
      localKandianMergeManager.l();
      ThreadManagerV2.excute(new RIJMsgBoxPopupStep.2(this, localKandianMsgBoxRedPntInfo, localKandianMergeManager), 64, null, false);
    }
  }
  
  protected void g()
  {
    int i = 1;
    Object localObject = this.a.getIntent();
    boolean bool;
    if (((Intent)localObject).hasExtra("notification_message_id"))
    {
      String str = ((Intent)localObject).getStringExtra("notification_message_id");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((pro.b() == 2) && (pqt.c() == 2))
      {
        if (!str.isEmpty()) {
          ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
        }
      }
      else
      {
        ((Intent)localObject).removeExtra("notification_message_id");
        if ((pqt.c() != 1) && (pro.b() == 2)) {
          break label183;
        }
        a(this.a, 5, str, 200L);
        bool = true;
        label113:
        localObject = new pqg().a("uin", localQQAppInterface.getCurrentAccountUin()).a("push_type", Integer.valueOf(9));
        if (bool) {
          i = 3;
        }
        olh.a("0X80081DB", ((pqg)localObject).a("load_mode", Integer.valueOf(i)).a());
      }
    }
    for (;;)
    {
      a(bool);
      return;
      QLog.i("RIJMsgBoxPopupStep", 1, "readInJoy lock push, notificationMessageId is empty");
      break;
      label183:
      bool = false;
      break label113;
      bool = false;
    }
  }
  
  protected void h()
  {
    int i = this.a.getIntent().getIntExtra("launch_from", 5);
    if ((((KandianMergeManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).f() > 0) && (a(i))) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxf
 * JD-Core Version:    0.7.0.1
 */