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
  TogetherPanelTouchController a;
  ScrollView b;
  TogetherPopupDialog.TogetherEntryAdapter c;
  BaseActivity d;
  RoundRectUrlImageView e;
  TroopChatPie f;
  FrameLayout g;
  ClockInViewHelper h;
  Animation i;
  LinearLayout j;
  TogetherObserver k = new TogetherPopupDialog.1(this);
  View.OnClickListener l = new TogetherPopupDialog.2(this);
  private Handler m = new Handler(Looper.getMainLooper());
  
  public TogetherPopupDialog(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.d = paramBaseActivity;
    this.f = paramTroopChatPie;
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
        int n = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
        if ((n > 0) && (((Resources)localObject).getBoolean(n)))
        {
          n = a((Resources)localObject);
          return n;
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
    int n = paramResources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (n > 0) {
      return paramResources.getDimensionPixelSize(n);
    }
    return 0;
  }
  
  private View a(TogetherPopupDialog paramTogetherPopupDialog, Activity paramActivity, int paramInt1, int paramInt2)
  {
    View localView = paramTogetherPopupDialog.getContentView();
    localView.findViewById(2131447803).setOnClickListener(this);
    localView.findViewById(2131447803).setContentDescription(this.d.getString(2131917320));
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131439816);
    Object localObject1 = (DiniFlyAnimationView)localView.findViewById(2131445326);
    this.g = ((FrameLayout)localView.findViewById(2131430799));
    this.g.setOnClickListener(this);
    Object localObject2;
    Object localObject3;
    if (this.h == null)
    {
      localObject2 = new ClockInData();
      localObject3 = this.f;
      if ((localObject3 != null) && (((TroopChatPie)localObject3).ah != null)) {
        ((ClockInData)localObject2).a = this.f.ah.b;
      }
      this.h = new ClockInViewHelper(this.d.app, this.d, (ClockInData)localObject2, this.g, localRelativeLayout, (DiniFlyAnimationView)localObject1, paramInt2);
    }
    this.e = ((RoundRectUrlImageView)localView.findViewById(2131429284));
    localObject1 = TogetherControlManager.a(this.d.app).b();
    if (localObject1 != null)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = URLDrawable.getDrawable(((TogetherControlManager.EntryBannerInfo)localObject1).c, (URLDrawable.URLDrawableOptions)localObject2);
      this.e.setAllRadius(ViewUtils.dpToPx(16.0F));
      this.e.setImageDrawable((Drawable)localObject2);
      this.e.setVisibility(0);
      this.e.setEnableEffect(true);
      this.e.setOnClickListener(this);
      this.e.setTag(localObject1);
      if (AppSetting.e) {
        this.e.setContentDescription(this.d.getString(2131892899));
      }
      localObject2 = TogetherControlManager.a(this.d.app);
      localObject3 = this.d.app.getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TogetherControlManager.EntryBannerInfo)localObject1).d.iAdId.get());
      localStringBuilder.append("");
      ((TogetherControlManager)localObject2).a((String)localObject3, 101, localStringBuilder.toString());
    }
    this.j = ((LinearLayout)localView.findViewById(2131447676));
    this.c = new TogetherPopupDialog.TogetherEntryAdapter(this.d, this.l, this.j);
    localObject1 = (TogetherEntryBean)QConfigManager.b().b(553);
    if ((localObject1 != null) && (((TogetherEntryBean)localObject1).c.size() > 0)) {
      this.c.a(((TogetherEntryBean)localObject1).c);
    } else {
      this.c.a(TogetherEntryData.a());
    }
    localObject1 = (RelativeLayout)localView.findViewById(2131437320);
    paramInt2 = ViewUtils.dpToPx(10.0F);
    int n = a(paramActivity);
    this.b = ((ScrollView)localView.findViewById(2131431361));
    this.a = ((TogetherPanelTouchController)localView.findViewById(2131431322));
    b(paramInt2 + n);
    this.a.setMode(paramInt1);
    this.a.setDisableMinScrollY(true);
    this.a.setHeadView(localRelativeLayout);
    this.a.setAtPanelTouchListener(paramTogetherPopupDialog);
    this.g.bringToFront();
    this.d.app.addObserver(this.k);
    return localView;
  }
  
  public static TogetherPopupDialog a(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131627652, null);
    paramTroopChatPie = new TogetherPopupDialog(paramTroopChatPie, paramBaseActivity, localView, paramInt1, paramInt2);
    paramTroopChatPie.a(paramTroopChatPie, paramBaseActivity, 1, paramInt3);
    localView.findViewById(2131437320).setBackgroundColor(localView.getResources().getColor(2131167964));
    paramTroopChatPie.setFocusable(false);
    localView.setOnClickListener(paramTroopChatPie);
    ((RelativeLayout)localView.findViewById(2131439816)).setOnClickListener(paramTroopChatPie);
    paramTroopChatPie.setInputMethodMode(1);
    paramTroopChatPie.setSoftInputMode(16);
    paramTroopChatPie.setClippingEnabled(false);
    paramTroopChatPie.setOutsideTouchable(true);
    if (AppSetting.e) {
      a(paramTroopChatPie);
    }
    return paramTroopChatPie;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int i1 = arrayOfMethod.length;
    int n = 0;
    while (n < i1)
    {
      Method localMethod = arrayOfMethod[n];
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
      n += 1;
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    Object localObject = this.d;
    if ((localObject != null) && (((BaseActivity)localObject).app != null) && (!TextUtils.isEmpty(this.d.app.getCurrentAccountUin()))) {
      paramHashMap.put("A8", this.d.app.getCurrentAccountUin());
    }
    localObject = this.f;
    if ((localObject != null) && (((TroopChatPie)localObject).ah != null) && (!TextUtils.isEmpty(this.f.ah.b))) {
      paramHashMap.put("qq_group_num", this.f.ah.b);
    }
  }
  
  private void b(int paramInt)
  {
    int n = this.c.a();
    int i1 = (n / 2 + n % 2) * 70;
    if (this.e.getVisibility() == 0) {
      n = 150;
    } else {
      n = 0;
    }
    int i3 = UIUtils.d(this.d);
    int i2 = ViewUtils.dpToPx(n + i1);
    int i4 = ViewUtils.dpToPx(304) + paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("togetherHeightDp = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",bannerLayoutHeightDp = ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", screenHeight = ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(", scrollViewHeight = ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(",otherViewHeight");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append(",bottomHeight = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherPopupDialog", 2, ((StringBuilder)localObject).toString());
    }
    n = i3 - i4;
    if (n > i2)
    {
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.setControlLitTongue(false);
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = n;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setControlLitTongue(true);
  }
  
  public void a()
  {
    this.a.scrollTo(0, 0);
    Object localObject = this.i;
    if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
      return;
    }
    if (this.i == null) {
      this.i = AnimationUtils.loadAnimation(this.d, 2130772014);
    }
    this.a.startAnimation(this.i);
    localObject = this.c;
    if (localObject != null) {
      ((TogetherPopupDialog.TogetherEntryAdapter)localObject).d();
    }
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  void a(String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.d.app.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.f.ae());
    if (localTroopInfo == null) {
      return;
    }
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.d.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    Bundle localBundle = TogetherUtils.a(true, localTroopInfo.isTroopOwner(this.d.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.f.ae(), 0);
    if (localTogetherControlManager.a(this.d, 2, localTroopInfo.troopuin, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
      }
    }
    else {
      TogetherUtils.a(this.d.app, 1, paramString, null, localBundle, 1);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if (this.h != null)
    {
      HashMap localHashMap = new HashMap();
      if (this.h.d()) {
        localHashMap.put("op_via", "2");
      } else {
        localHashMap.put("op_via", "1");
      }
      a(localHashMap);
      ClockReportUtil.a("click#aio_icon", localHashMap);
    }
  }
  
  public void c()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      ((ClockInViewHelper)localObject).b();
      this.h = null;
    }
    localObject = this.d;
    if ((localObject != null) && (((BaseActivity)localObject).app != null) && (this.k != null))
    {
      this.d.app.removeObserver(this.k);
      this.k = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((TogetherPopupDialog.TogetherEntryAdapter)localObject).e();
      this.c = null;
    }
  }
  
  public void d() {}
  
  public void dismiss()
  {
    super.dismiss();
    TogetherPopupDialog.TogetherEntryAdapter localTogetherEntryAdapter = this.c;
    if (localTogetherEntryAdapter != null) {
      localTogetherEntryAdapter.c();
    }
  }
  
  void e()
  {
    ListenTogetherUtils.b(this.d.app, this.d, 1, this.f.ae(), 0);
    Object localObject = this.f.d;
    String str = this.f.ah.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.c(this.f.d, String.valueOf(this.f.ah.b)));
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, str, "", localStringBuilder.toString(), "");
    localObject = new HashMap();
    ((HashMap)localObject).put("op_via", "4");
    a((HashMap)localObject);
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
  }
  
  void f()
  {
    Object localObject1 = (TogetherConfigureBean)QConfigManager.b().b(535);
    if ((localObject1 != null) && (((TogetherConfigureBean)localObject1).b != null))
    {
      Object localObject2 = ((TroopManager)this.d.app.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.f.ae());
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = (TogetherControlManager)this.d.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      boolean bool = ((TogetherControlManager)localObject3).b(2, 1, ((TroopInfo)localObject2).uin);
      Bundle localBundle = TogetherUtils.a(true, ((TroopInfo)localObject2).isTroopOwner(this.d.app.getCurrentAccountUin()), ((TroopInfo)localObject2).isAdmin(), ((TroopInfo)localObject2).troopowneruin, this.f.ae(), 0);
      int n = ((TogetherConfigureBean)localObject1).b.a();
      if (n != 0)
      {
        if (n != 1)
        {
          if (((TogetherControlManager)localObject3).a(this.d, 2, ((TroopInfo)localObject2).troopuin, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
            }
          }
          else {
            TogetherUtils.a(this.d.app, ((TogetherConfigureBean)localObject1).b.b(), ((TogetherConfigureBean)localObject1).b.c(), ((TogetherConfigureBean)localObject1).b.d(), localBundle, 1);
          }
        }
        else if (!((TroopInfo)localObject2).isAdmin())
        {
          if (bool) {
            ((TogetherControlManager)localObject3).b(this.d, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
          } else {
            ((TogetherControlManager)localObject3).a(this.d, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
          }
        }
        else if (bool) {
          ((TogetherControlManager)localObject3).b(this.d, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
        } else {
          ((TogetherControlManager)localObject3).a(this.d, ((TroopInfo)localObject2).troopuin, 1, 2, 0, localBundle);
        }
      }
      else {
        QQToast.makeText(this.d, 0, 2131890214, 0).show();
      }
      localObject1 = this.f.d;
      localObject2 = this.f.ah.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(TroopUtils.c(this.f.d, String.valueOf(this.f.ah.b)));
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, (String)localObject2, "", ((StringBuilder)localObject3).toString(), "");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("op_via", "5");
      a((HashMap)localObject1);
      ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
      return;
    }
    QQToast.makeText(this.d, 0, 2131890214, 0).show();
  }
  
  void g()
  {
    new Bundle();
    Object localObject2 = ((TroopManager)this.d.app.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.f.ae());
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (TogetherControlManager)this.d.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = ((TogetherControlManager)localObject1).b(4, 1, this.f.ae());
    localObject2 = TogetherUtils.a(bool, ((TroopInfo)localObject2).isTroopOwner(this.d.app.getCurrentAccountUin()), ((TroopInfo)localObject2).isAdmin(), ((TroopInfo)localObject2).troopowneruin, this.f.ae(), 0);
    if (bool) {
      ((TogetherControlManager)localObject1).b(this.d, this.f.ae(), 1, 4, 0, (Bundle)localObject2);
    } else {
      ((TogetherControlManager)localObject1).a(this.d, this.f.ae(), 1, 4, 0, (Bundle)localObject2);
    }
    localObject1 = this.f.d;
    localObject2 = this.f.ah.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.c(this.f.d, String.valueOf(this.f.ah.b)));
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
      Object localObject1 = this.f.ae();
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
      localObject4 = ((TroopManager)this.d.app.getManager(QQManagerFactory.TROOP_MANAGER)).f((String)localObject1);
      boolean bool;
      if (localObject4 == null) {
        bool = false;
      } else {
        bool = ((TroopInfo)localObject4).isAdmin();
      }
      localObject1 = new EntryModel(1, Long.parseLong((String)localObject1), this.f.ah.e, bool);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.d, (String)localObject3, 2010, (EntryModel)localObject1, null);
    }
    catch (Exception localException)
    {
      QLog.e("TogetherPopupDialog", 1, localException, new Object[0]);
    }
    Object localObject2 = this.f.d;
    Object localObject3 = this.f.ah.b;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(TroopUtils.c(this.f.d, String.valueOf(this.f.ah.b)));
    ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, (String)localObject3, "", ((StringBuilder)localObject4).toString(), "");
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("op_via", "8");
    a((HashMap)localObject2);
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject2);
  }
  
  void i()
  {
    QPublicFragmentActivity.start(this.d, AVGameRoomCenterFragment.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_via", "7");
    a(localHashMap);
    ClockReportUtil.a("click#aio_front_panel", localHashMap);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429284)
    {
      TogetherControlManager.EntryBannerInfo localEntryBannerInfo = (TogetherControlManager.EntryBannerInfo)paramView.getTag();
      if (localEntryBannerInfo != null)
      {
        if (("1".equals(localEntryBannerInfo.a)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          localObject = new Intent(this.d, QQBrowserDelegationActivity.class);
          ((Intent)localObject).putExtra("url", localEntryBannerInfo.b);
          ((Intent)localObject).putExtra("fromOneCLickCLose", true);
          this.d.startActivity((Intent)localObject);
        }
        else if (("2".equals(localEntryBannerInfo.a)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          localObject = new Intent("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(localEntryBannerInfo.b));
          this.d.startActivity((Intent)localObject);
        }
        else if (("3".equals(localEntryBannerInfo.a)) && (!TextUtils.isEmpty(localEntryBannerInfo.b)))
        {
          a(localEntryBannerInfo.b);
        }
        Object localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "3");
        a((HashMap)localObject);
        ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
        localObject = TogetherControlManager.a(this.d.app);
        String str = this.d.app.getCurrentUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localEntryBannerInfo.d.iAdId.get());
        localStringBuilder.append("");
        ((TogetherControlManager)localObject).a(str, 102, localStringBuilder.toString());
      }
    }
    else if (paramView.getId() == 2131447803)
    {
      dismiss();
    }
    else if (paramView.getId() != 2131430799)
    {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog
 * JD-Core Version:    0.7.0.1
 */