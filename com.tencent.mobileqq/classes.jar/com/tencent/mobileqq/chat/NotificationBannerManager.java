package com.tencent.mobileqq.chat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.config.business.NotificationBannerBean;
import com.tencent.mobileqq.config.business.NotificationBannerConfProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpToNotificationSettingUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class NotificationBannerManager
  implements Manager
{
  QQAppInterface a;
  
  public NotificationBannerManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static NotificationBannerManager a(QQAppInterface paramQQAppInterface)
  {
    return (NotificationBannerManager)paramQQAppInterface.getManager(QQManagerFactory.NOTIFICATION_BANNER_MANAGER);
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = JumpToNotificationSettingUtil.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(BannerManager paramBannerManager, Message paramMessage)
  {
    paramBannerManager.a(NotificationGuideBannerProcessor.a, 2, paramMessage);
    ReportController.a(this.a, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    long l = SharedPreUtils.c(this.a.getCurrentUin());
    return System.currentTimeMillis() - l < NotificationBannerConfProcessor.a().a();
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    SharedPreUtils.b(this.a.getCurrentUin(), l);
  }
  
  public void a(BannerManager paramBannerManager)
  {
    paramBannerManager.a(NotificationGuideBannerProcessor.a, 0, null);
  }
  
  public void a(BannerManager paramBannerManager, Message paramMessage)
  {
    if (b())
    {
      b(paramBannerManager, paramMessage);
      return;
    }
    a(paramBannerManager);
  }
  
  public void a(BannerManager paramBannerManager, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramBannerManager, null, paramView);
    if (b())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(BannerManager paramBannerManager, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = NotificationBannerConfProcessor.a().a();
    String str2 = NotificationBannerConfProcessor.a().b();
    paramTipsBar.setTipsIcon(this.a.getApp().getResources().getDrawable(2130841360));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.a().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.b(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).d();
    }
    paramTipsBar.a().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new NotificationBannerManager.1(this, paramBannerManager));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new NotificationBannerManager.2(this, paramBaseActivity));
    }
    paramTipsBar.setVisibility(8);
  }
  
  public boolean a()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool1 = NotificationBannerConfProcessor.a().a();
    boolean bool2 = a();
    boolean bool3 = c();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "bannerVisible: invoked. ", " confVisible: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(bool2), " limitedByDuration: ", Boolean.valueOf(bool3) });
    }
    return (bool1) && (!bool2) && (!bool3);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.NotificationBannerManager
 * JD-Core Version:    0.7.0.1
 */