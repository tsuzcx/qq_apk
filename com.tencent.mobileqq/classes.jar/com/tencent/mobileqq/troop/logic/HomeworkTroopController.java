package com.tencent.mobileqq.troop.logic;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopClassInfoTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.groupclass.TroopAioClassController;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.OnHomeworkTroopIdentityCheckListener;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeworkTroopController
  extends TroopAioClassController
{
  public static long a;
  protected int a;
  protected PanelIconLinearLayout a;
  HWTroopUtils.OnHomeworkTroopIdentityCheckListener a;
  protected CalloutPopupWindow a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public HomeworkTroopController(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidWidgetImageView = paramTroopChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView = new RedDotAnimateView(paramBaseActivity.getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(9.0F, paramBaseActivity.getActivity().getResources()), AIOUtils.a(9.0F, paramBaseActivity.getActivity().getResources()));
    localLayoutParams.addRule(7, 2131377172);
    localLayoutParams.addRule(6, 2131377172);
    localLayoutParams.rightMargin = AIOUtils.a(4.0F, paramBaseActivity.getActivity().getResources());
    localLayoutParams.topMargin = AIOUtils.a(11.0F, paramBaseActivity.getActivity().getResources());
    paramTroopChatPie.b().addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramTroopChatPie.a();
    if ((jdField_a_of_type_Long < 0L) && (jdField_a_of_type_Long != -9223372036854775808L))
    {
      a(paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).getLong("homework_troop_ent", -9223372036854775808L));
      return;
    }
    a(jdField_a_of_type_Long);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new HomeworkTroopController.3(this, paramInt), paramLong);
  }
  
  private void a(long paramLong)
  {
    boolean bool2 = false;
    bool3 = true;
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramLong != -9223372036854775808L)
      {
        bool1 = bool2;
        if (paramLong >= 0L)
        {
          bool1 = bool2;
          if (l >= paramLong) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("HomeworkTroopController", 2, new Object[] { "parse troopUin error. troopUin=", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
          bool1 = bool3;
        }
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      QLog.e("HomeworkTroopController", 2, "updateEnt troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + ", = enableEnt" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      paramConfig = ConfigServlet.a(paramConfig);
      localEditor = paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).edit();
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        str = (String)paramConfig.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkTroopController", 2, new Object[] { "parse handleHomeworkTroopConfig: ", str });
        }
        for (;;)
        {
          try
          {
            paramConfig = new JSONObject(str);
            if (paramConfig.has("HWTroopAIOTip"))
            {
              localObject = paramConfig.getJSONObject("HWTroopAIOTip");
              if (((JSONObject)localObject).has("show")) {
                localEditor.putInt("homework_troop_aio_tip_show", ((JSONObject)localObject).getInt("show"));
              }
            }
            if (paramConfig.has("keywordConfigs"))
            {
              localObject = paramConfig.getJSONArray("keywordConfigs").toString();
              localEditor.putString("troop_school_keyword_config", (String)localObject);
              ((SchoolTroopKeywordManager)paramQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER)).a((String)localObject);
            }
            localObject = paramConfig.optString("grayTroopUin");
            l1 = 0L;
          }
          catch (JSONException paramConfig)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramConfig = str;
            if (str != null) {
              continue;
            }
            paramConfig = "";
            QLog.e("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopConfig json fail. content: ", paramConfig });
            localEditor.clear();
            continue;
          }
          try
          {
            l2 = Long.parseLong((String)localObject);
            l1 = l2;
            localEditor.putLong("homework_troop_ent", l2);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localEditor.putLong("homework_troop_ent", -9223372036854775808L);
            l2 = l1;
          }
        }
        localObject = (TroopClassControllerManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER);
        if ((((TroopClassControllerManager)localObject).a instanceof HomeworkTroopController))
        {
          ((HomeworkTroopController)((TroopClassControllerManager)localObject).a).a(l2);
          ((HomeworkTroopController)((TroopClassControllerManager)localObject).a).d();
        }
        ((TroopAppMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR)).a(paramConfig);
        localEditor.apply();
        paramQQAppInterface.getPreferences().edit().putInt("homework_troop_config_version", i).apply();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        String str;
        Object localObject;
        long l1;
        long l2;
        return;
        localEditor.clear();
      }
    }
    QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig:localVersion == version = " + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopReportor.a(paramQQAppInterface, paramString, "homework", "AioAssign_Show", 0, 0, new String[] { paramString, "", "", TroopReportor.a(paramQQAppInterface, paramString) });
    TroopReportor.a(paramQQAppInterface, paramString, "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { paramString, "", "", "" });
  }
  
  private boolean a()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    return (localMiniAppConfBean != null) && (localMiniAppConfBean.f());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isAdmin());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar != null) && (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(paramTroopChatPie.a()))) {}
    do
    {
      do
      {
        return;
        if (!((TroopListenTogetherPanel)paramTroopChatPie.a(33)).c()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
      return;
      if (!((StudyRoomTipBarHelper)paramTroopChatPie.a(75)).d()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
    return;
    if (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      if (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar == null) {
        paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar = new HomeworkTroopTipsBar(paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(paramTroopChatPie.a(), true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  public void a(boolean paramBoolean, TroopChatPie paramTroopChatPie)
  {
    a(paramBoolean, new HomeworkTroopController.4(this), paramTroopChatPie);
  }
  
  public void a(boolean paramBoolean1, TroopChatPie paramTroopChatPie, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "updateTroopAioUI" + paramBoolean1);
    }
    if (paramBoolean2)
    {
      paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTroopChatPie);
      paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(paramTroopChatPie);
      if (paramBoolean1) {
        a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
    c(paramBoolean1);
    if (!paramBoolean1)
    {
      if (paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar != null) {
        paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(paramTroopChatPie.a(), false);
      }
      e(false);
      b(false);
      return;
    }
    a(true, null, paramTroopChatPie);
    if (paramTroopChatPie.a().isResume())
    {
      b(true);
      return;
    }
    paramTroopChatPie.Y = true;
  }
  
  public void a(boolean paramBoolean, HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener, TroopChatPie paramTroopChatPie)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      if (paramOnHomeworkTroopIdentityCheckListener != null) {
        HWTroopUtils.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramOnHomeworkTroopIdentityCheckListener, paramBoolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener = new HomeworkTroopController.5(this, paramTroopChatPie);
      }
      HWTroopUtils.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener, paramBoolean);
      return;
    }
    if (localTroopInfo == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("HomeworkTroopController", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void b()
  {
    d(false);
    a();
  }
  
  public void b(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.c != null) && (paramTroopChatPie.c.isShowing())) {
      return;
    }
    a(paramTroopChatPie);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Boolean) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip start. isHomeworkTroop=", Boolean.valueOf(paramBoolean), ", canShow=", Boolean.valueOf(bool) });
      }
      if (bool) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      bool = false;
      break;
      if (!paramBoolean) {
        break label238;
      }
      paramBoolean = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(1, 500L);
        HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
    } while (paramBoolean);
    a(2, 500L);
    HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification", true);
    return;
    label238:
    a();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing()) && (this.jdField_a_of_type_Int > 0)) {
      a(this.jdField_a_of_type_Int, 0L);
    }
  }
  
  public void c(TroopChatPie paramTroopChatPie)
  {
    HWTroopClassInfoTipsHelper localHWTroopClassInfoTipsHelper;
    if (paramTroopChatPie != null)
    {
      localHWTroopClassInfoTipsHelper = (HWTroopClassInfoTipsHelper)paramTroopChatPie.a(73);
      if ((localHWTroopClassInfoTipsHelper != null) && ((localHWTroopClassInfoTipsHelper.a == null) || (!localHWTroopClassInfoTipsHelper.a.a(paramTroopChatPie.a())))) {
        break label40;
      }
    }
    label40:
    do
    {
      return;
      TroopListenTogetherPanel localTroopListenTogetherPanel = (TroopListenTogetherPanel)paramTroopChatPie.a(33);
      if ((localTroopListenTogetherPanel == null) || (!localTroopListenTogetherPanel.c())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HomeworkTroopController", 2, "showHomeworkTroopClassInfoAIOTip. isListenTogetherTime");
    return;
    if (localHWTroopClassInfoTipsHelper.a == null) {
      localHWTroopClassInfoTipsHelper.a = new HomeworkTroopClassInfoTipsBar(paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    localHWTroopClassInfoTipsHelper.a.a(paramTroopChatPie.a(), true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B27F", "0X800B27F", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      bool = a();
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, "handleHomeworkListIcon start. isHomeworkTroop=" + paramBoolean + "isShowMiniAppEntry" + bool);
      }
      if (!bool)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HomeworkTroopController.2(this));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844012);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework", "AioSee_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      localIWebProcessManagerService = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null) {}
    }
    while (a())
    {
      do
      {
        boolean bool;
        IWebProcessManagerService localIWebProcessManagerService;
        do
        {
          return;
        } while (!localIWebProcessManagerService.isNeedPreloadWebProcess());
        localIWebProcessManagerService.startWebProcess(-1, null);
      } while (!QLog.isColorLevel());
      QLog.d("HomeworkTroopController", 2, "start preloadWebProcess");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, " hide troop class hw rightbtn");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("HomeworkTroopController", 2, "updateHomeworkListEntry");
    }
    ThreadManager.getUIHandler().post(new HomeworkTroopController.1(this));
  }
  
  public void d(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "showHomeworkListRedDot,show = " + paramBoolean + ",context = " + localBaseActivity + ",mRightRedDot = " + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView);
    }
    if (localBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView == null) {
      return;
    }
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "showHomeworkListRedDot isShowMiniAppEntry = " + bool + ",enableEnt = " + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean) && (!bool))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.getVisibility() != 0) {
        TroopReportor.a("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibleAndZeroRadius();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(8);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("HomeworkTroopController", 2, "updateHomeworkListEntry-handleHomeworkListIcon 2 troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + ", = enableEnt" + this.jdField_a_of_type_Boolean + ",getVisibility = " + this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint start. show=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      int i = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint check cache. troopUin=", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ", result=", Integer.valueOf(i) });
      }
      if (i != 0)
      {
        d(true);
        return;
      }
    }
    d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController
 * JD-Core Version:    0.7.0.1
 */