package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.autoreply.AutoReplyServlet;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.music.LyricStateListener;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi.PaiYiPaiCallback;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusTranslateUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankRequest;

public class OnlineStatusAIOPopUpWindow
  extends PopupWindow
  implements View.OnClickListener, LyricStateListener, IOnlineStatusAIOTempApi.PaiYiPaiCallback, OnlineStatusController.PanelTouchListener
{
  private Activity a;
  private OnlineStatusController b;
  private Animation c;
  private View d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private AppInterface k;
  private String l;
  private LinearLayout m;
  private Friends n;
  private OnlineStatusLyricView o;
  private BusinessObserver p;
  private BusinessObserver q;
  private AppRuntime.Status r;
  private View s;
  private View t;
  private int u;
  private IAccountPanel v;
  private boolean w = false;
  private final OnlineStatusObserver x = new OnlineStatusAIOPopUpWindow.4(this);
  
  public OnlineStatusAIOPopUpWindow(AppInterface paramAppInterface, Activity paramActivity, String paramString, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.a = paramActivity;
    this.k = paramAppInterface;
    this.l = paramString;
    this.n = ((IFriendDataService)this.k.getRuntimeService(IFriendDataService.class, "")).getFriend(this.l, true, true);
    this.q = ((IOnlineStatusAIOTempApi)QRoute.api(IOnlineStatusAIOTempApi.class)).getPaiYiPaiObserver(paramAppInterface, this);
    this.p = new OnlineStatusAIOPopUpWindow.1(this, paramAppInterface);
  }
  
  public static OnlineStatusAIOPopUpWindow a(AppInterface paramAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    paramAppInterface = new OnlineStatusAIOPopUpWindow(paramAppInterface, paramActivity, paramString, LayoutInflater.from(paramActivity).inflate(2131627858, null), paramInt1, paramInt2);
    paramAppInterface.c();
    paramAppInterface.e();
    return paramAppInterface;
  }
  
  private void a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setOutlineProvider(new OnlineStatusAIOPopUpWindow.3(this));
    }
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView = paramTextView.getPaint();
    paramTextView.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView.setStrokeWidth(1.0F);
  }
  
  private void q()
  {
    this.r = OnlineStatusTranslateUtils.a(this.n);
    this.h.setCompoundDrawables(null, null, null, null);
    f();
    if ((this.n.uExtOnlineStatus == 1080L) && (this.n.curOlympicRank <= 0L)) {
      p();
    }
  }
  
  private void r()
  {
    Object localObject = (IProfileCardUtil)QRoute.api(IProfileCardUtil.class);
    AppInterface localAppInterface = this.k;
    localObject = ((IProfileCardUtil)localObject).initCard(localAppInterface, localAppInterface.getCurrentAccountUin());
    int i2 = ((Card)localObject).constellation;
    int i1 = 0;
    if (i2 == 0)
    {
      QLog.d("OnlineStatusAIOPopUpWindow", 1, "user constellation status is 0");
      QQToast.makeText(this.a, 2131896409, 0).show();
      return;
    }
    if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(41609, (Card)localObject) != 2) {
      i1 = 1;
    }
    if (i1 == 0)
    {
      DialogUtil.a(this.a, 230, HardCodeUtil.a(2131896413), HardCodeUtil.a(2131896410), 2131896411, 2131896412, new OnlineStatusAIOPopUpWindow.6(this), new OnlineStatusAIOPopUpWindow.7(this)).show();
      return;
    }
    s();
  }
  
  private void s()
  {
    ((IOnlineStatusService)this.k.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(this.r, this.n.uExtOnlineStatus);
    ExtensionBizInfoHelper.a.a(this.k, 1040);
  }
  
  private void t()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      OnlineStatusAIOPopUpWindow.8 local8 = new OnlineStatusAIOPopUpWindow.8(this);
      ((AppActivity)this.a).requestPermissions(local8, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    u();
  }
  
  private void u()
  {
    ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.k.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(9);
    ((IOnlineStatusService)this.k.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(this.r, this.n.uExtOnlineStatus);
  }
  
  private void v()
  {
    if (!OnlineStatusSPUtil.a(BaseApplication.getContext(), this.k.getCurrentUin()))
    {
      StatusRankMgr.StatusRankRequest localStatusRankRequest = new StatusRankMgr.StatusRankRequest();
      localStatusRankRequest.status_id.set(1080);
      localStatusRankRequest.uin.set(0L);
      localStatusRankRequest.genrank.set(true);
      OlympicProtocolHelper.a(this.k, localStatusRankRequest, new OnlineStatusAIOPopUpWindow.10(this));
    }
  }
  
  public void a()
  {
    if (!this.o.d()) {
      this.o.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (isShowing())
    {
      IAccountPanel localIAccountPanel = this.v;
      if ((localIAccountPanel != null) && (localIAccountPanel.isShowing())) {
        this.v.a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      QQToast.makeText(this.a, 2, 2131890658, 0).show();
    }
  }
  
  protected void a(OnlineStatusItem paramOnlineStatusItem, String paramString)
  {
    if ((paramOnlineStatusItem.b != 1030L) && (paramOnlineStatusItem.b != 1040L) && (paramOnlineStatusItem.b != 1028L) && (paramOnlineStatusItem.b != 1080L))
    {
      if (OnlineStatusTranslateUtils.a(this.r))
      {
        h();
        return;
      }
      this.i.setVisibility(8);
      return;
    }
    if (paramOnlineStatusItem.b == 1030L)
    {
      g();
      i();
      return;
    }
    if (paramOnlineStatusItem.b == 1028L)
    {
      if (!TextUtils.isEmpty(this.n.songId)) {
        g();
      }
      a(paramString);
      return;
    }
    if (paramOnlineStatusItem.b == 1040L)
    {
      g();
      j();
      return;
    }
    if (paramOnlineStatusItem.b == 1080L) {
      k();
    }
  }
  
  protected void a(String paramString)
  {
    this.o.setVisibility(0);
    this.o.setText(paramString);
    ((OnlineStatusHandler)this.k.getBusinessHandler(OnlineStatusHandler.class.getName())).a(this.n);
    this.o.setFriendSession(this.n, paramString);
    this.o.setLyricStateListener(this);
    this.i.setVisibility(8);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QQTheme.isNowThemeIsNight();
    int i1;
    if (paramBoolean2) {
      i1 = 2130839608;
    } else {
      i1 = 2130839606;
    }
    Object localObject = this.d;
    if (bool) {
      i1 = 2130839605;
    }
    ((View)localObject).setBackgroundResource(i1);
    TextView localTextView = this.h;
    String str = "#FFFFFF";
    if (bool) {}
    while (paramBoolean1)
    {
      localObject = "#FFFFFF";
      break;
    }
    localObject = "#03081A";
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localTextView = this.g;
    if (bool) {}
    while (paramBoolean1)
    {
      localObject = "#FFFFFF";
      break;
    }
    localObject = "#03081A";
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localTextView = this.j;
    if (bool) {
      localObject = str;
    } else if (paramBoolean1) {
      localObject = str;
    } else {
      localObject = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject));
    localObject = this.s;
    int i2 = 2130847809;
    if (bool) {
      i1 = 2130847809;
    } else {
      i1 = 2130847808;
    }
    ((View)localObject).setBackgroundResource(i1);
    localObject = this.t;
    if (bool) {
      i1 = i2;
    } else {
      i1 = 2130847808;
    }
    ((View)localObject).setBackgroundResource(i1);
    ViewCompat.setElevation(this.s, ViewUtils.dip2px(4.0F));
    a(this.s);
    ViewCompat.setElevation(this.t, ViewUtils.dip2px(4.0F));
    a(this.t);
    a(this.j);
    a(this.g);
    a(this.h);
  }
  
  public void b()
  {
    this.o.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    this.u = paramInt;
  }
  
  protected void c()
  {
    View localView = getContentView();
    this.b = ((OnlineStatusController)localView.findViewById(2131431322));
    this.e = ((ImageView)localView.findViewById(2131435757));
    this.f = ((TextView)localView.findViewById(2131435784));
    this.s = localView.findViewById(2131435774);
    this.g = ((TextView)localView.findViewById(2131435771));
    this.t = localView.findViewById(2131435770);
    this.h = ((TextView)localView.findViewById(2131435764));
    this.i = ((TextView)localView.findViewById(2131435765));
    this.m = ((LinearLayout)localView.findViewById(2131447803));
    this.o = ((OnlineStatusLyricView)localView.findViewById(2131435766));
    this.d = localView.findViewById(2131439574);
    this.j = ((TextView)localView.findViewById(2131435759));
    Object localObject = ((IQQAvatarCompatibleService)this.k.getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(1, this.n.uin, (byte)3, 100, false, (byte)1, 0);
    this.e.setImageBitmap((Bitmap)localObject);
    this.f.setText(this.n.name);
    this.i.setVisibility(8);
    this.o.setVisibility(8);
    localObject = new StringBuilder(HardCodeUtil.a(2131892371));
    ((StringBuilder)localObject).append(OnlineStatusTranslateUtils.a(this.n.gender));
    this.g.setText(((StringBuilder)localObject).toString());
    this.m.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    localView.findViewById(2131437320).setOnClickListener(this);
    localView.setOnClickListener(this);
    this.b.setDisableMinScrollY(true);
    this.b.setAtPanelTouchListener(this);
    a(false, false);
  }
  
  public void d() {}
  
  public void dismiss()
  {
    super.dismiss();
    this.o.f();
    this.k.removeObserver(this.p);
    this.k.removeObserver(this.q);
    this.k.removeObserver(this.x);
    Window localWindow = this.a.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  protected void e()
  {
    q();
  }
  
  void f()
  {
    Object localObject = this.n;
    if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, this.n.iTermType) != 0) || ((!TextUtils.isEmpty(this.n.strTermDesc)) && (this.n.strTermDesc.contains("TIM")))))
    {
      boolean bool2 = this.k.getCurrentUin().equals(this.l);
      boolean bool1 = true;
      localObject = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(this.r, this.n.uExtOnlineStatus, bool2 ^ true);
      if ((OnlineStatusUtils.a(this.n.detalStatusFlag, this.n.iTermType) != 4) || (((OnlineStatusItem)localObject).b <= 0L) || (localObject == null)) {
        bool1 = false;
      }
      String str = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(this.k, this.n, this.i, 1, (OnlineStatusItem)localObject, Boolean.valueOf(bool1));
      if ((!TextUtils.isEmpty(str)) && (!Utils.c(this.l)))
      {
        this.h.setVisibility(0);
        this.h.setText(str);
        int i1;
        if (((OnlineStatusItem)localObject).b == 1080L) {
          i1 = 6;
        } else {
          i1 = 5;
        }
        ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).showOnlineStatusDrawable(this.n, this.h, false, (OnlineStatusItem)localObject, i1);
      }
      a((OnlineStatusItem)localObject, str);
    }
  }
  
  protected void g()
  {
    Drawable localDrawable;
    if (QQTheme.isNowThemeIsNight()) {
      localDrawable = this.a.getResources().getDrawable(2130842364);
    } else {
      localDrawable = this.a.getResources().getDrawable(2130839445);
    }
    Object localObject = MobileQQ.sMobileQQ;
    int i1 = Utils.a(20.0F, MobileQQ.getContext().getResources());
    localDrawable.setBounds(0, 0, i1, i1);
    localObject = this.h.getCompoundDrawables();
    this.h.setCompoundDrawables(localObject[0], localObject[1], localDrawable, localObject[3]);
  }
  
  protected void h()
  {
    if (!this.w) {
      AutoReplyServlet.a(this.k, this.n.uin, new OnlineStatusAIOPopUpWindow.2(this));
    }
  }
  
  protected void i()
  {
    String str;
    if (this.n.weatherDecs == null) {
      str = "";
    } else {
      str = this.n.weatherDecs;
    }
    if (!StringUtil.isEmpty(str))
    {
      this.i.setVisibility(0);
      this.i.setText(str);
      return;
    }
    this.i.setVisibility(8);
  }
  
  protected void j()
  {
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.n.constellationLuckyColor))
    {
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131891450));
      ((StringBuilder)localObject).append(this.n.constellationLuckyColor);
      int i1 = 0;
      while (i1 < 4)
      {
        ((StringBuilder)localObject).append(" ");
        i1 += 1;
      }
    }
    if (!TextUtils.isEmpty(this.n.constellationLuckyNumber))
    {
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131891451));
      ((StringBuilder)localObject).append(this.n.constellationLuckyNumber);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (!StringUtil.isEmpty((String)localObject))
    {
      this.i.setVisibility(0);
      this.i.setText((CharSequence)localObject);
      return;
    }
    this.i.setVisibility(8);
  }
  
  protected void k()
  {
    String str;
    if (OnLineStatusHelper.a().d())
    {
      str = OnLineStatusHelper.a().e();
      if (!StringUtil.isEmpty(str))
      {
        g();
        this.i.setVisibility(0);
        this.i.setText(str);
        return;
      }
      this.i.setVisibility(8);
      return;
    }
    if (this.n.curOlympicRank > 0L)
    {
      str = MobileQQ.sMobileQQ.getResources().getString(2131897110, new Object[] { String.valueOf(this.n.curOlympicRank) });
      g();
      this.i.setVisibility(0);
      this.i.setText(str);
    }
  }
  
  public void l()
  {
    this.b.scrollTo(0, 0);
    Animation localAnimation = this.c;
    if ((localAnimation != null) && (!localAnimation.hasEnded())) {
      return;
    }
    if (this.c == null) {
      this.c = AnimationUtils.loadAnimation(this.a, 2130772014);
    }
    this.b.startAnimation(this.c);
  }
  
  public void m()
  {
    boolean bool = this.k.getCurrentUin().equals(this.l);
    OnlineStatusItem localOnlineStatusItem = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(this.r, this.n.uExtOnlineStatus, bool ^ true);
    bool = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    Object localObject = (IOnlineStatusService)this.k.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = ((IOnlineStatusService)localObject).getOnlineStatus();
    long l1 = OnLineStatusHelper.a().a(this.k);
    if ((!OnlineStatusItem.a(this.r, this.n.uExtOnlineStatus)) && (localStatus == this.r) && (l1 == this.n.uExtOnlineStatus))
    {
      localObject = MobileQQ.sMobileQQ.getResources().getString(2131896433, new Object[] { localOnlineStatusItem.c });
      QQToast.makeText(MobileQQ.sMobileQQ, 2, (CharSequence)localObject, 1).show();
    }
    else if ((bool) && (!localOnlineStatusItem.j))
    {
      localObject = MobileQQ.sMobileQQ.getResources().getString(2131896432, new Object[] { localOnlineStatusItem.c });
      QQToast.makeText(MobileQQ.sMobileQQ, 2, (CharSequence)localObject, 1).show();
    }
    else if (localOnlineStatusItem.b == 1030L)
    {
      t();
    }
    else if (localOnlineStatusItem.b == 1040L)
    {
      r();
    }
    else if (OnlineStatusItem.a(this.r, this.n.uExtOnlineStatus))
    {
      n();
    }
    else
    {
      ((IOnlineStatusService)localObject).updateOnlineStatus(this.r, this.n.uExtOnlineStatus);
    }
    ReportHelperKt.a("0X800BBE0", 0, String.valueOf(this.u), localOnlineStatusItem.c);
  }
  
  protected void n()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      ((AppActivity)this.a).requestPermissions(new OnlineStatusAIOPopUpWindow.5(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    o();
  }
  
  protected void o()
  {
    long l1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.k);
    Object localObject = ((IOnlineStatusService)this.k.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    OnlineStatusItem localOnlineStatusItem = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusItem(40000);
    if (OnlineStatusItem.a((AppRuntime.Status)localObject, l1))
    {
      if (localOnlineStatusItem != null) {
        localObject = localOnlineStatusItem.c;
      } else {
        localObject = HardCodeUtil.a(2131896389);
      }
      localObject = MobileQQ.sMobileQQ.getResources().getString(2131896433, new Object[] { localObject });
      QQToast.makeText(MobileQQ.sMobileQQ, 2, (CharSequence)localObject, 1).show();
      return;
    }
    ((IOnlineStatusService)this.k.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(this.r, 40001L);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131447803)
    {
      dismiss();
    }
    else if (i1 == 2131439574)
    {
      ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).handleAIOSubTitleClicked(this.k, this.a, this.l, paramView);
    }
    else
    {
      String str = "";
      if (i1 == 2131435774)
      {
        m();
        if (this.i.getText() != null) {
          str = this.h.getText().toString();
        }
        ReportHelperKt.a("0X800BBDE", 0, String.valueOf(this.u), str);
      }
      else if (i1 == 2131435770)
      {
        if (AppNetConnInfo.isNetSupport())
        {
          ((IOnlineStatusAIOTempApi)QRoute.api(IOnlineStatusAIOTempApi.class)).sendPaiYiPaiReq(this.k, this.n.uin, this.n.uin);
          new DoubleTapEffect(this.e).a();
          if (this.i.getText() != null) {
            str = this.h.getText().toString();
          }
          ReportHelperKt.a("0X800BBDC", 0, String.valueOf(this.u), str);
        }
        else
        {
          QQToast.makeText(this.a, 1, 2131892104, 0).show();
        }
      }
      else if (i1 != 2131437320)
      {
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  void p()
  {
    if (TextUtils.isEmpty(this.n.uin)) {
      return;
    }
    Friends localFriends = this.n;
    StatusRankMgr.StatusRankRequest localStatusRankRequest = new StatusRankMgr.StatusRankRequest();
    localStatusRankRequest.status_id.set(1080);
    localStatusRankRequest.genrank.set(false);
    localStatusRankRequest.uin.set(Long.parseLong(this.n.uin));
    OlympicProtocolHelper.a(this.k, localStatusRankRequest, new OnlineStatusAIOPopUpWindow.9(this, localFriends));
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.k.addObserver(this.p);
    this.k.addObserver(this.q);
    this.k.addObserver(this.x);
    paramView = this.a.getWindow();
    if (paramView != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramView.getAttributes();
      localLayoutParams.alpha = 0.5F;
      paramView.setAttributes(localLayoutParams);
    }
    if (this.i.getText() != null) {
      paramView = this.h.getText().toString();
    } else {
      paramView = "";
    }
    ReportHelperKt.a("0X800BBDB", 0, String.valueOf(this.u), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow
 * JD-Core Version:    0.7.0.1
 */