package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.OnStatusItemClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.OnlineStatusPanelListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AutoStatusSelectView
  extends BaseStatusCardView
  implements Handler.Callback, View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, OnlineStatusPermissionManager.ReceiveDataListener
{
  public Button a;
  public int b = 1;
  protected int c = 40001;
  protected TextView d;
  protected ViewGroup e;
  protected OnlineStatusViewCtrl f;
  protected QBaseActivity g;
  protected OnlineStatusPermissionChecker.OnlineStatusPermissionItem h;
  private View o;
  private View p;
  private Button q;
  private LinearLayout r;
  private OnLineStatusBlurBg s;
  private AppRuntime.Status t;
  private TextView u;
  private TextView v;
  private long w;
  private Handler x;
  private TextView y;
  private boolean z = true;
  
  public AutoStatusSelectView(@NonNull QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramQBaseActivity, paramOnDismissCallback);
    this.g = paramQBaseActivity;
    this.s = paramOnLineStatusBlurBg;
    if (paramOnLineStatusBlurBg == null) {
      this.s = new OnLineStatusBlurBg();
    }
    this.x = new Handler(Looper.getMainLooper(), this);
    c();
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  private void c()
  {
    this.o = LayoutInflater.from(this.g).inflate(2131624872, null);
    this.o.setOnClickListener(this);
    this.y = ((TextView)this.o.findViewById(2131448814));
    this.y.setTypeface(Typeface.defaultFromStyle(1));
    this.p = this.o.findViewById(2131431357);
    this.p.setOnClickListener(this);
    this.a = ((Button)this.o.findViewById(2131430020));
    this.q = ((Button)this.o.findViewById(2131429840));
    this.q.setOnClickListener(this);
    this.r = ((LinearLayout)this.o.findViewById(2131430200));
    this.a.setTag(Integer.valueOf(2));
    this.a.setOnClickListener(this);
    this.d = ((TextView)this.o.findViewById(2131448525));
    this.u = ((TextView)this.o.findViewById(2131433806));
    this.v = ((TextView)this.o.findViewById(2131445513));
    this.e = ((ViewGroup)this.o.findViewById(2131439580));
    this.j = this.p;
    View localView = this.o;
    this.i = localView;
    setContentView(localView);
  }
  
  private void n()
  {
    boolean bool = OnlineStatusItem.a(this.t, this.w);
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    if (bool) {
      j = 32;
    } else {
      j = 86;
    }
    int j = Utils.a(j, this.g.getResources());
    this.q.setVisibility(i);
    if (i == 0) {
      ReportHelperKt.a("0X800B0F0");
    }
    this.r.setPadding(j, 0, j, 0);
  }
  
  protected void a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.t = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    this.w = OnLineStatusHelper.a().a(localAppRuntime);
    n();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.c) && (paramInt2 == -1) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      this.z = false;
      this.h = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item"));
      c(false);
    }
  }
  
  protected void a(View paramView)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText(this.g, 1, 2131916775, 0).show();
      dismiss();
      this.n.a(40001);
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool = OnlineStatusItem.a(((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), OnLineStatusHelper.a().a(localAppRuntime));
    this.n.a(40001L);
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool) });
    }
    OnlineStatusPermissionServlet.a(localAppRuntime, l(), f(), bool ^ true);
    dismiss();
    paramView = paramView.getTag();
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      if (i == 2)
      {
        paramView = f().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800AF40", ((Integer)paramView.next()).intValue(), "1");
        }
      }
      if (i == 1)
      {
        paramView = f().iterator();
        while (paramView.hasNext()) {
          ReportHelperKt.a("0X800B00F", ((Integer)paramView.next()).intValue(), "1");
        }
      }
    }
    ReportHelperKt.a("0X8009DE0", 40001);
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.z)
    {
      this.z = false;
      this.h = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      c(true);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "oldItem =", paramOnlineStatusItem1, " oldItem=", paramOnlineStatusItem2 });
    }
    int i;
    if ((paramOnlineStatusItem1 == null) && (paramOnlineStatusItem2 != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      this.x.removeMessages(1);
      this.d.setText(2131888293);
    }
    else
    {
      this.x.removeMessages(1);
      if ((paramOnlineStatusItem2 instanceof AutoStatusItem)) {
        this.d.setText(((AutoStatusItem)paramOnlineStatusItem2).i);
      }
      this.x.sendEmptyMessageDelayed(1, 5000L);
    }
    c(false);
    if (i != 0) {
      ReportHelperKt.a("0X800AF3F", (int)paramOnlineStatusItem2.b, String.valueOf(this.b));
    }
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    this.h = paramOnlineStatusPermissionItem;
    boolean bool;
    if (paramOnlineStatusPermissionItem == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.z = bool;
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      View localView = this.o;
      if (localView != null)
      {
        localView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.o;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    if (!OnlineStatusItem.a(this.t, this.w))
    {
      this.a.setText(2131888287);
      if (paramBoolean2)
      {
        this.a.setEnabled(false);
        return;
      }
      this.a.setEnabled(true);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.a.setText(2131888288);
      this.a.setEnabled(false);
      return;
    }
    if (paramBoolean1)
    {
      this.a.setText(2131888288);
      this.a.setEnabled(true);
      this.a.setTag(Integer.valueOf(1));
      return;
    }
    this.a.setText(2131890660);
    this.a.setEnabled(false);
    this.a.setTag(Integer.valueOf(2));
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.j.getWidth() != 0) && (this.j.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.j.getWidth();
      paramArrayOfInt[1] = this.j.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.j.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.j.getResources()));
    paramArrayOfInt[1] = Utils.a(480.0F, this.j.getResources());
  }
  
  protected void b()
  {
    this.d.setText(2131888293);
    Object localObject = this.f;
    if (localObject == null)
    {
      localObject = new OnlineStatusPanelParams();
      ((OnlineStatusPanelParams)localObject).a = 3;
      ((OnlineStatusPanelParams)localObject).k = true;
      ((OnlineStatusPanelParams)localObject).j = false;
      ((OnlineStatusPanelParams)localObject).b = true;
      ((OnlineStatusPanelParams)localObject).g = 5;
      ((OnlineStatusPanelParams)localObject).i = (this.g.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.g.getResources()));
      this.f = new OnlineStatusViewCtrl(this.g, this.e, this, (OnlineStatusPanelParams)localObject, this);
      this.f.a();
      return;
    }
    ((OnlineStatusViewCtrl)localObject).b();
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.u.setVisibility(4);
      this.v.setVisibility(4);
      return;
    }
    this.u.setVisibility(0);
    this.v.setVisibility(0);
    int i = 2131888286;
    if (paramBoolean1) {
      i = 2131888292;
    }
    String str1 = getContext().getResources().getString(i);
    String str2 = getContext().getResources().getString(2131888291);
    this.u.setText(new QQText(str1, 3, 16));
    this.u.setContentDescription(str1);
    this.v.setText(str2);
    this.v.setOnClickListener(new AutoStatusSelectView.1(this, paramBoolean1));
    this.v.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    if (ThemeImageWrapper.isNightMode()) {
      this.v.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837602, 0);
    } else {
      this.v.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837601, 0);
    }
    if (AppSetting.e) {
      this.u.setAccessibilityDelegate(new AutoStatusSelectView.2(this));
    }
  }
  
  public void c(View paramView) {}
  
  protected void c(boolean paramBoolean)
  {
    boolean bool1;
    if (paramBoolean) {
      bool1 = j();
    } else {
      bool1 = this.f.d().isEmpty();
    }
    boolean bool2 = i();
    boolean bool3 = d(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
    }
    a(bool3, bool1);
    b(bool2, bool1);
  }
  
  public ArrayList<OnlineStatusItem> d()
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = (OnlineAutoStatusBean)QConfigManager.b().b(652);
    ArrayList localArrayList = new ArrayList();
    if (localOnlineAutoStatusBean != null)
    {
      if (localOnlineAutoStatusBean.a == null) {
        return localArrayList;
      }
      return OnlineStatusBean.a(localOnlineAutoStatusBean.a.a(false));
    }
    return localArrayList;
  }
  
  protected boolean d(boolean paramBoolean)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = this.h;
    if ((localOnlineStatusPermissionItem != null) && (localOnlineStatusPermissionManager.a(localOnlineStatusPermissionItem, this))) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    return localOnlineStatusPermissionManager.a(this.f.d());
  }
  
  public void dg_()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.g.requestPermissions(new AutoStatusSelectView.3(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    else
    {
      a(null);
      show();
    }
    ReportHelperKt.a("0X800AF3E", 1);
  }
  
  public ArrayList<OnlineStatusItem> e()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ArrayList localArrayList2 = d();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)localIterator.next();
          if (localOnlineStatusItem.b == localInteger.intValue()) {
            localArrayList1.add(localOnlineStatusItem);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public ArrayList<Integer> f()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.f.d();
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return localArrayList;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Integer.valueOf((int)((OnlineStatusItem)((Iterator)localObject).next()).b));
      }
    }
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.d.setText(2131888293);
    }
    return false;
  }
  
  protected boolean i()
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false, this);
      return (localObject != null) && (!((OnlineStatusFriendsPermissionItem)localObject).allHasPermission);
    }
    return true ^ ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission();
  }
  
  protected boolean j()
  {
    List localList = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).b();
    if (localList == null) {
      return true;
    }
    return localList.isEmpty();
  }
  
  protected void k()
  {
    this.x.removeCallbacksAndMessages(null);
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem l()
  {
    return this.h;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445146)
    {
      dismiss();
      ReportHelperKt.a("0X800AF94");
    }
    else if (paramView.getId() == 2131429840)
    {
      ReportHelperKt.a("0X800B0F1");
      ((IOnlineStatusService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L);
      dismiss();
    }
    else if (paramView.getId() == 2131430020)
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.p.setBackgroundResource(2130847806);
      a(false, null, Color.parseColor("#FF010101"));
    }
    else
    {
      this.p.setBackgroundResource(2130847805);
      OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
      localBlurBgItem.a = this.g;
      this.s.a(localBlurBgItem, this);
    }
    b();
    a();
    c(true);
    a(this.y);
    a(this.d, 2131165997, 2131168417);
    super.show();
    e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView
 * JD-Core Version:    0.7.0.1
 */