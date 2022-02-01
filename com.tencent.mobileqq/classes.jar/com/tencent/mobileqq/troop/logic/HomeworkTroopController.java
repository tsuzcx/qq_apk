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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.groupclass.TroopAioClassController;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.OnHomeworkTroopIdentityCheckListener;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.mobileqq.utils.TroopReportor;
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
  public static long i = -1L;
  protected PanelIconLinearLayout f;
  protected CalloutPopupWindow g;
  protected int h;
  public boolean j = true;
  HWTroopUtils.OnHomeworkTroopIdentityCheckListener k;
  
  public HomeworkTroopController(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopChatPie paramTroopChatPie)
  {
    this.a = paramQQAppInterface;
    this.b = new WeakReference(paramBaseActivity);
    this.c = paramTroopChatPie.ah;
    this.e = paramTroopChatPie.bX();
    this.d = new RedDotAnimateView(paramBaseActivity.getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(9.0F, paramBaseActivity.getActivity().getResources()), AIOUtils.b(9.0F, paramBaseActivity.getActivity().getResources()));
    localLayoutParams.addRule(7, 2131444904);
    localLayoutParams.addRule(6, 2131444904);
    localLayoutParams.rightMargin = AIOUtils.b(4.0F, paramBaseActivity.getActivity().getResources());
    localLayoutParams.topMargin = AIOUtils.b(11.0F, paramBaseActivity.getActivity().getResources());
    paramTroopChatPie.bY().addView(this.d, localLayoutParams);
    this.d.setVisibility(4);
    this.f = paramTroopChatPie.bZ();
    long l = i;
    if ((l < 0L) && (l != -9223372036854775808L))
    {
      paramBaseActivity = paramQQAppInterface.getApp();
      paramTroopChatPie = new StringBuilder();
      paramTroopChatPie.append("homework_troop_config");
      paramTroopChatPie.append(paramQQAppInterface.getCurrentUin());
      a(paramBaseActivity.getSharedPreferences(paramTroopChatPie.toString(), 0).getLong("homework_troop_ent", -9223372036854775808L));
      return;
    }
    a(i);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (!this.j) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new HomeworkTroopController.3(this, paramInt), paramLong);
  }
  
  private void a(long paramLong)
  {
    boolean bool2 = true;
    try
    {
      long l = Long.parseLong(this.c.b);
      bool1 = bool2;
      if (paramLong == -9223372036854775808L) {
        break label90;
      }
      if ((paramLong >= 0L) && (l < paramLong)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      boolean bool1;
      label51:
      StringBuilder localStringBuilder;
      break label51;
    }
    bool1 = bool2;
    if (QLog.isColorLevel())
    {
      QLog.e("HomeworkTroopController", 2, new Object[] { "parse troopUin error. troopUin=", this.c.b });
      bool1 = bool2;
    }
    label90:
    this.j = bool1;
    if ((QLog.isColorLevel()) && (this.c != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEnt troopUin = ");
      localStringBuilder.append(this.c.b);
      localStringBuilder.append(", = enableEnt");
      localStringBuilder.append(this.j);
      QLog.e("HomeworkTroopController", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int m = paramConfig.version.get();
    int n = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleHomeworkTroopConfig: ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      ((StringBuilder)localObject1).append("| localVersion: ");
      ((StringBuilder)localObject1).append(n);
      QLog.i("HomeworkTroopController", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (m != n)
    {
      paramConfig = ConfigServlet.a(paramConfig);
      localObject1 = paramQQAppInterface.getApp();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("homework_troop_config");
      ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentUin());
      localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        localObject1 = (String)paramConfig.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkTroopController", 2, new Object[] { "parse handleHomeworkTroopConfig: ", localObject1 });
        }
      }
    }
    try
    {
      paramConfig = new JSONObject((String)localObject1);
      if (paramConfig.has("HWTroopAIOTip"))
      {
        localObject3 = paramConfig.getJSONObject("HWTroopAIOTip");
        if (((JSONObject)localObject3).has("show")) {
          ((SharedPreferences.Editor)localObject2).putInt("homework_troop_aio_tip_show", ((JSONObject)localObject3).getInt("show"));
        }
      }
      if (paramConfig.has("keywordConfigs"))
      {
        localObject3 = paramConfig.getJSONArray("keywordConfigs").toString();
        ((SharedPreferences.Editor)localObject2).putString("troop_school_keyword_config", (String)localObject3);
        ((SchoolTroopKeywordManager)paramQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER)).a((String)localObject3);
      }
      localObject3 = paramConfig.optString("grayTroopUin");
      l1 = 0L;
    }
    catch (JSONException paramConfig)
    {
      Object localObject3;
      long l1;
      long l2;
      label347:
      break label429;
    }
    try
    {
      l2 = Long.parseLong((String)localObject3);
      l1 = l2;
      ((SharedPreferences.Editor)localObject2).putLong("homework_troop_ent", l2);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label347;
    }
    ((SharedPreferences.Editor)localObject2).putLong("homework_troop_ent", -9223372036854775808L);
    localObject3 = (TroopClassControllerManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER);
    if ((((TroopClassControllerManager)localObject3).a instanceof HomeworkTroopController))
    {
      ((HomeworkTroopController)((TroopClassControllerManager)localObject3).a).a(l1);
      ((HomeworkTroopController)((TroopClassControllerManager)localObject3).a).d();
    }
    ((ITroopAppService)paramQQAppInterface.getRuntimeService(ITroopAppService.class, "all")).tryParseAppConfig(paramConfig);
    break label486;
    label429:
    if (QLog.isColorLevel())
    {
      paramConfig = (ConfigurationService.Config)localObject1;
      if (localObject1 == null) {
        paramConfig = "";
      }
      QLog.e("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopConfig json fail. content: ", paramConfig });
    }
    ((SharedPreferences.Editor)localObject2).clear();
    break label486;
    ((SharedPreferences.Editor)localObject2).clear();
    label486:
    ((SharedPreferences.Editor)localObject2).apply();
    paramQQAppInterface.getPreferences().edit().putInt("homework_troop_config_version", m).apply();
    return;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleHomeworkTroopConfig:localVersion == version = ");
      paramQQAppInterface.append(m);
      QLog.i("HomeworkTroopController", 2, paramQQAppInterface.toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.isAdmin()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopReportor.a(paramQQAppInterface, paramString, "homework", "AioAssign_Show", 0, 0, new String[] { paramString, "", "", TroopReportor.a(paramQQAppInterface, paramString) });
    TroopReportor.a(paramQQAppInterface, paramString, "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { paramString, "", "", "" });
  }
  
  private boolean f()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    return (localMiniAppConfBean != null) && (localMiniAppConfBean.g());
  }
  
  public void a()
  {
    CalloutPopupWindow localCalloutPopupWindow = this.g;
    if (localCalloutPopupWindow != null)
    {
      localCalloutPopupWindow.dismiss();
      this.g = null;
      this.h = 0;
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    HWTroopClassInfoTipsHelper localHWTroopClassInfoTipsHelper = (HWTroopClassInfoTipsHelper)paramTroopChatPie.q(73);
    if (localHWTroopClassInfoTipsHelper.a(paramTroopChatPie.J())) {
      return;
    }
    if (((TroopListenTogetherPanel)paramTroopChatPie.q(33)).e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
      }
      return;
    }
    if (((StudyRoomTipBarHelper)paramTroopChatPie.q(75)).e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
      }
      return;
    }
    BaseApplication localBaseApplication = paramTroopChatPie.d.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("homework_troop_config");
    localStringBuilder.append(paramTroopChatPie.d.getCurrentUin());
    boolean bool;
    if (localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
    }
    if (bool) {
      localHWTroopClassInfoTipsHelper.a(paramTroopChatPie.J(), true);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTroopAioUI");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("HomeworkTroopController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean2)
    {
      paramTroopChatPie.W.a(paramTroopChatPie.d, paramTroopChatPie.ah, paramTroopChatPie);
      paramTroopChatPie.W.a(paramTroopChatPie);
      if (paramBoolean1) {
        b(paramTroopChatPie.d, paramTroopChatPie.ah.b);
      }
    }
    c(paramBoolean1);
    Object localObject = (HWTroopClassInfoTipsHelper)paramTroopChatPie.q(73);
    if (!paramBoolean1)
    {
      ((HWTroopClassInfoTipsHelper)localObject).a(paramTroopChatPie.J(), false);
      e(false);
      b(false);
      return;
    }
    a(true, null, paramTroopChatPie);
    if (paramTroopChatPie.aX().isResume())
    {
      b(true);
      return;
    }
    ((HWTroopClassInfoTipsHelper)localObject).c = true;
  }
  
  public void a(boolean paramBoolean, HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener, TroopChatPie paramTroopChatPie)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramTroopChatPie.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramTroopChatPie.ah.b);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop()))
    {
      if (paramOnHomeworkTroopIdentityCheckListener != null)
      {
        HWTroopUtils.a(paramTroopChatPie.d, paramTroopChatPie.ah.b, paramTroopChatPie.d.getCurrentAccountUin(), paramOnHomeworkTroopIdentityCheckListener, paramBoolean);
        return;
      }
      if (this.k == null) {
        this.k = new HomeworkTroopController.5(this, paramTroopChatPie);
      }
      HWTroopUtils.a(paramTroopChatPie.d, paramTroopChatPie.ah.b, paramTroopChatPie.d.getCurrentAccountUin(), this.k, paramBoolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBoolean = false;
      if (localTroopInfo == null) {
        paramBoolean = true;
      }
      QLog.d("HomeworkTroopController", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    d(false);
    a();
  }
  
  public void b(TroopChatPie paramTroopChatPie)
  {
    a(paramTroopChatPie);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((this.j) && (a(this.a, this.c.b))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip start. isHomeworkTroop=", Boolean.valueOf(paramBoolean), ", canShow=", Boolean.valueOf(bool) });
    }
    if (!bool) {
      return;
    }
    if (paramBoolean)
    {
      paramBoolean = HWTroopUtils.a(this.a, this.c.b, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(1, 500L);
        HWTroopUtils.a(this.a, this.c.b, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = HWTroopUtils.a(this.a, this.c.b, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(2, 500L);
        HWTroopUtils.a(this.a, this.c.b, "homework_troop_aio_panel_tip_notification", true);
      }
    }
    else
    {
      a();
    }
  }
  
  public void c()
  {
    CalloutPopupWindow localCalloutPopupWindow = this.g;
    if ((localCalloutPopupWindow != null) && (localCalloutPopupWindow.isShowing()))
    {
      int m = this.h;
      if (m > 0) {
        a(m, 0L);
      }
    }
  }
  
  public void c(TroopChatPie paramTroopChatPie)
  {
    if (paramTroopChatPie != null)
    {
      HWTroopClassInfoTipsHelper localHWTroopClassInfoTipsHelper = (HWTroopClassInfoTipsHelper)paramTroopChatPie.q(73);
      if (localHWTroopClassInfoTipsHelper != null)
      {
        if ((localHWTroopClassInfoTipsHelper.e != null) && (localHWTroopClassInfoTipsHelper.e.a(paramTroopChatPie.J()))) {
          return;
        }
        TroopListenTogetherPanel localTroopListenTogetherPanel = (TroopListenTogetherPanel)paramTroopChatPie.q(33);
        if ((localTroopListenTogetherPanel != null) && (localTroopListenTogetherPanel.e()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HomeworkTroopController", 2, "showHomeworkTroopClassInfoAIOTip. isListenTogetherTime");
          }
          return;
        }
        if (localHWTroopClassInfoTipsHelper.e == null) {
          localHWTroopClassInfoTipsHelper.e = new HomeworkTroopClassInfoTipsBar(paramTroopChatPie.f, paramTroopChatPie.ah);
        }
        localHWTroopClassInfoTipsHelper.e.a(paramTroopChatPie.J(), true);
        ReportController.b(this.a, "dc00898", "", "", "0X800B27F", "0X800B27F", 0, 0, this.c.b, "", "", "");
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.j) && (paramBoolean))
    {
      boolean bool = f();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleHomeworkListIcon start. isHomeworkTroop=");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("isShowMiniAppEntry");
        ((StringBuilder)localObject).append(bool);
        QLog.d("HomeworkTroopController", 2, ((StringBuilder)localObject).toString());
      }
      if (!bool)
      {
        this.e.setOnClickListener(new HomeworkTroopController.2(this));
        this.e.setImageResource(2130844887);
        this.e.setVisibility(0);
      }
      TroopReportor.a(this.a, this.c.b, "homework", "AioSee_Show", 0, 0, new String[] { this.c.b, "", "", TroopReportor.a(this.a, this.c.b) });
      Object localObject = (IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject == null) {
        return;
      }
      if (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess())
      {
        ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkTroopController", 2, "start preloadWebProcess");
        }
      }
    }
    else if (!f())
    {
      this.e.setOnClickListener(null);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, " hide troop class hw rightbtn");
      }
      this.e.setVisibility(8);
    }
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
    Object localObject = (BaseActivity)this.b.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHomeworkListRedDot,show = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",context = ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(",mRightRedDot = ");
      localStringBuilder.append(this.d);
      QLog.d("HomeworkTroopController", 2, localStringBuilder.toString());
    }
    if (localObject == null) {
      return;
    }
    if (this.d != null)
    {
      boolean bool = f();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showHomeworkListRedDot isShowMiniAppEntry = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",enableEnt = ");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("HomeworkTroopController", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.j) && (paramBoolean) && (!bool))
      {
        if (this.d.getVisibility() != 0) {
          TroopReportor.a("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.c.b });
        }
        this.d.setVisibleAndZeroRadius();
        this.d.b();
        return;
      }
      this.d.setVisibility(8);
    }
  }
  
  public void e()
  {
    if ((this.e != null) && (this.d != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateHomeworkListEntry-handleHomeworkListIcon 2 troopUin = ");
        localStringBuilder.append(this.c.b);
        localStringBuilder.append(", = enableEnt");
        localStringBuilder.append(this.j);
        localStringBuilder.append(",getVisibility = ");
        localStringBuilder.append(this.e.getVisibility());
        QLog.e("HomeworkTroopController", 2, localStringBuilder.toString());
      }
      if (this.e.getVisibility() == 8) {
        this.d.setVisibility(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint start. show=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.j) && (paramBoolean))
    {
      int m = ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).getAIOHomeworkBtnRedPoint(this.a, this.c.b);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint check cache. troopUin=", this.c.b, ", result=", Integer.valueOf(m) });
      }
      if (m != 0)
      {
        d(true);
        return;
      }
    }
    d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController
 * JD-Core Version:    0.7.0.1
 */