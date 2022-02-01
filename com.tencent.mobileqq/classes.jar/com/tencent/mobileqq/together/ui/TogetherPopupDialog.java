package com.tencent.mobileqq.together.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherConfigureBean;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.config.business.WatchTogetherBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.together.clockin.ClockInData;
import com.tencent.mobileqq.together.clockin.ClockInViewHelper;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.AtPanelTouchListener;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class TogetherPopupDialog
  extends PopupWindow
  implements View.OnClickListener, AtPanelTouchController.AtPanelTouchListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TogetherPopupDialog.2(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  TogetherObserver jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver = new TogetherPopupDialog.1(this);
  ClockInViewHelper jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper;
  TogetherPanelTouchController jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController;
  TogetherPopupDialog.TogetherEntryAdapter jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter;
  RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView;
  ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  
  public TogetherPopupDialog(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  @RequiresApi(api=17)
  public static int a(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getResources();
      Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 15)
      {
        localObject = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        localDisplay.getRealMetrics((DisplayMetrics)localObject);
        if (localDisplayMetrics.heightPixels != ((DisplayMetrics)localObject).heightPixels) {
          return a(paramContext.getResources());
        }
      }
      else
      {
        int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
        if ((i > 0) && (((Resources)localObject).getBoolean(i)))
        {
          i = a((Resources)localObject);
          return i;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("TogetherPopupDialog", 1, paramContext, new Object[0]);
    }
    return 0;
  }
  
  private static int a(Resources paramResources)
  {
    int i = paramResources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private View a(TogetherPopupDialog paramTogetherPopupDialog, Activity paramActivity, int paramInt1, int paramInt2)
  {
    View localView = paramTogetherPopupDialog.getContentView();
    localView.findViewById(2131379076).setOnClickListener(this);
    localView.findViewById(2131379076).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719717));
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131372305);
    Object localObject1 = (DiniFlyAnimationView)localView.findViewById(2131376962);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364697));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper == null)
    {
      localObject2 = new ClockInData();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((localObject3 != null) && (((TroopChatPie)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        ((ClockInData)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper = new ClockInViewHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ClockInData)localObject2, this.jdField_a_of_type_AndroidWidgetFrameLayout, localRelativeLayout, (DiniFlyAnimationView)localObject1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView = ((RoundRectUrlImageView)localView.findViewById(2131363394));
    localObject1 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    if (localObject1 != null)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = URLDrawable.getDrawable(((TogetherControlManager.EntryBannerInfo)localObject1).c, (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setEnableEffect(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setTag(localObject1);
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695166));
      }
      localObject2 = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TogetherControlManager.EntryBannerInfo)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get());
      localStringBuilder.append("");
      ((TogetherControlManager)localObject2).a((String)localObject3, 101, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378967));
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter = new TogetherPopupDialog.TogetherEntryAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localObject1 = (TogetherEntryBean)QConfigManager.a().a(553);
    if ((localObject1 != null) && (((TogetherEntryBean)localObject1).a.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter.a(((TogetherEntryBean)localObject1).a);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter.a(TogetherEntryData.a());
    }
    localObject1 = (RelativeLayout)localView.findViewById(2131370156);
    paramInt2 = ViewUtils.b(10.0F);
    int i = a(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)localView.findViewById(2131365197));
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController = ((TogetherPanelTouchController)localView.findViewById(2131365169));
    b(paramInt2 + i);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setMode(paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setHeadView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setAtPanelTouchListener(paramTogetherPopupDialog);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
    return localView;
  }
  
  public static TogetherPopupDialog a(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131561296, null);
    paramTroopChatPie = new TogetherPopupDialog(paramTroopChatPie, paramBaseActivity, localView, paramInt1, paramInt2);
    paramTroopChatPie.a(paramTroopChatPie, paramBaseActivity, 1, paramInt3);
    localView.findViewById(2131370156).setBackgroundColor(localView.getResources().getColor(2131167028));
    paramTroopChatPie.setFocusable(false);
    localView.setOnClickListener(paramTroopChatPie);
    ((RelativeLayout)localView.findViewById(2131372305)).setOnClickListener(paramTroopChatPie);
    paramTroopChatPie.setInputMethodMode(1);
    paramTroopChatPie.setSoftInputMode(16);
    paramTroopChatPie.setClippingEnabled(false);
    paramTroopChatPie.setOutsideTouchable(true);
    if (AppSetting.d) {
      a(paramTroopChatPie);
    }
    return paramTroopChatPie;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("setTouchModal")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).app != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()))) {
      paramHashMap.put("A8", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if ((localObject != null) && (((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramHashMap.put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void b(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter.a();
    int j = (i / 2 + i % 2) * 70;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.getVisibility() == 0) {
      i = 150;
    } else {
      i = 0;
    }
    int m = UIUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int k = ViewUtils.b(i + j);
    int n = ViewUtils.b(304) + paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("togetherHeightDp = ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(",bannerLayoutHeightDp = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", screenHeight = ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(", scrollViewHeight = ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",otherViewHeight");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(",bottomHeight = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherPopupDialog", 2, ((StringBuilder)localObject).toString());
    }
    i = m - n;
    if (i > k)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setControlLitTongue(false);
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = i;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
    this.jdField_a_of_type_ComTencentWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setControlLitTongue(true);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  void a(String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b());
    if (localTroopInfo == null) {
      return;
    }
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    Bundle localBundle = TogetherUtils.a(true, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 0);
    if (localTogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, localTroopInfo.troopuin, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
      }
    }
    else {
      TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramString, null, localBundle, 1);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.scrollTo(0, 0);
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772011);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter;
    if (localObject != null) {
      ((TogetherPopupDialog.TogetherEntryAdapter)localObject).c();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper != null)
    {
      HashMap localHashMap = new HashMap();
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper.b()) {
        localHashMap.put("op_via", "2");
      } else {
        localHashMap.put("op_via", "1");
      }
      a(localHashMap);
      ClockReportUtil.a("click#aio_icon", localHashMap);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper;
    if (localObject != null)
    {
      ((ClockInViewHelper)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInViewHelper = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).app != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter;
    if (localObject != null)
    {
      ((TogetherPopupDialog.TogetherEntryAdapter)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter = null;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    TogetherPopupDialog.TogetherEntryAdapter localTogetherEntryAdapter = this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog$TogetherEntryAdapter;
    if (localTogetherEntryAdapter != null) {
      localTogetherEntryAdapter.b();
    }
  }
  
  void e()
  {
    ListenTogetherUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, str, "", localStringBuilder.toString(), "");
    localObject = new HashMap();
    ((HashMap)localObject).put("op_via", "4");
    a((HashMap)localObject);
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
  }
  
  void f()
  {
    Object localObject1 = (TogetherConfigureBean)QConfigManager.a().a(535);
    if ((localObject1 != null) && (((TogetherConfigureBean)localObject1).a != null))
    {
      Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b());
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      boolean bool = ((TogetherControlManager)localObject3).a(2, 1, ((TroopInfo)localObject2).uin);
      Bundle localBundle = TogetherUtils.a(true, ((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), ((TroopInfo)localObject2).isAdmin(), ((TroopInfo)localObject2).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 0);
      int i = ((TogetherConfigureBean)localObject1).a.a();
      if (i != 0)
      {
        if (i != 1)
        {
          if (((TogetherControlManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, ((TroopInfo)localObject2).troopuin, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
            }
          }
          else {
            TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, ((TogetherConfigureBean)localObject1).a.b(), ((TogetherConfigureBean)localObject1).a.a(), ((TogetherConfigureBean)localObject1).a.b(), localBundle, 1);
          }
        }
        else if (!((TroopInfo)localObject2).isAdmin())
        {
          if (bool) {
            ((TogetherControlManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
          } else {
            ((TogetherControlManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
          }
        }
        else if (bool) {
          ((TogetherControlManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
        } else {
          ((TogetherControlManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
        }
      }
      else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693100, 0).a();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, (String)localObject2, "", ((StringBuilder)localObject3).toString(), "");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("op_via", "5");
      a((HashMap)localObject1);
      ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693100, 0).a();
  }
  
  void g()
  {
    new Bundle();
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b());
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = ((TogetherControlManager)localObject1).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b());
    localObject2 = TogetherUtils.a(bool, ((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), ((TroopInfo)localObject2).isAdmin(), ((TroopInfo)localObject2).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 0);
    if (bool) {
      ((TogetherControlManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 1, 4, 0, (Bundle)localObject2);
    } else {
      ((TogetherControlManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(), 1, 4, 0, (Bundle)localObject2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_AIO", "", "hi_tab", "clk_sing", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("op_via", "6");
    a((HashMap)localObject1);
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
  }
  
  void h()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("pages/index/index?mode=qun&gid=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = URLEncoder.encode(((StringBuilder)localObject3).toString(), "UTF-8");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("https://m.q.qq.com/a/p/1108291530?via=2010_1&referer=2010&s=");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject3 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("mqqapi://microapp/open?url=");
      ((StringBuilder)localObject4).append(URLEncoder.encode((String)localObject3, "UTF-8"));
      localObject3 = ((StringBuilder)localObject4).toString();
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("handleMiniAIOEntry : ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.d("TogetherPopupDialog", 2, ((StringBuilder)localObject4).toString());
      }
      localObject4 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER)).b((String)localObject1);
      boolean bool;
      if (localObject4 == null) {
        bool = false;
      } else {
        bool = ((TroopInfo)localObject4).isAdmin();
      }
      localObject1 = new EntryModel(1, Long.parseLong((String)localObject1), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, bool);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject3, 2010, (EntryModel)localObject1, null);
    }
    catch (Exception localException)
    {
      QLog.e("TogetherPopupDialog", 1, localException, new Object[0]);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, (String)localObject3, "", ((StringBuilder)localObject4).toString(), "");
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("op_via", "8");
    a((HashMap)localObject2);
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject2);
  }
  
  void i()
  {
    QPublicFragmentActivity.start(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVGameRoomCenterFragment.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_via", "7");
    a(localHashMap);
    ClockReportUtil.a("click#aio_front_panel", localHashMap);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363394)
    {
      TogetherControlManager.EntryBannerInfo localEntryBannerInfo = (TogetherControlManager.EntryBannerInfo)paramView.getTag();
      if (localEntryBannerInfo != null)
      {
        if (("1".equals(localEntryBannerInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserDelegationActivity.class);
          ((Intent)localObject).putExtra("url", localEntryBannerInfo.b);
          ((Intent)localObject).putExtra("fromOneCLickCLose", true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
        }
        else if (("2".equals(localEntryBannerInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          localObject = new Intent("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(localEntryBannerInfo.b));
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
        }
        else if (("3".equals(localEntryBannerInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          a(localEntryBannerInfo.b);
        }
        Object localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "3");
        a((HashMap)localObject);
        ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
        localObject = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localEntryBannerInfo.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get());
        localStringBuilder.append("");
        ((TogetherControlManager)localObject).a(str, 102, localStringBuilder.toString());
      }
    }
    else if (paramView.getId() == 2131379076)
    {
      dismiss();
    }
    else if (paramView.getId() != 2131364697)
    {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog
 * JD-Core Version:    0.7.0.1
 */