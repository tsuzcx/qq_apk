package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.guild.vas.IGiftPanelAction;
import com.tencent.mobileqq.guild.vas.IGuildGiftPresenter;
import com.tencent.mobileqq.guild.vas.adapter.GiftListPageAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiftPanelController
  implements Application.ActivityLifecycleCallbacks, PopupWindow.OnDismissListener, IGiftPanelController
{
  private static final int a = ViewUtils.dpToPx(15.0F);
  private String b;
  private final IGuildGiftPresenter c;
  private PopupWindow d;
  private QQViewPager e;
  private LinearLayout f;
  private View g;
  private GiftListPageAdapter h;
  private RelativeLayout i;
  private TextView j;
  private TextView k;
  private ImageView l;
  private View m;
  private String n;
  private String o;
  private long p;
  
  public GiftPanelController(IGuildGiftPresenter paramIGuildGiftPresenter)
  {
    this.c = paramIGuildGiftPresenter;
  }
  
  private void a(int paramInt, Context paramContext)
  {
    if (paramInt > 0)
    {
      int i1 = paramInt / 8;
      if (paramInt % 8 == 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      int i2 = a;
      ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((i1 + paramInt) * i2);
        this.f.removeAllViews();
        this.g = new View(paramContext);
        this.g.setBackgroundDrawable(this.e.getResources().getDrawable(2130840813));
        paramContext = new ViewGroup.LayoutParams(a, -1);
        this.f.addView(this.g, paramContext);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131628329, null, false);
    this.m = localView.findViewById(2131434273);
    this.m.setOnClickListener(new GiftPanelController.4(this));
    this.k = ((TextView)localView.findViewById(2131434266));
    this.j = ((TextView)localView.findViewById(2131448689));
    this.l = ((ImageView)localView.findViewById(2131436533));
    localView.findViewById(2131434272).setOnClickListener(new GiftPanelController.5(this));
    this.d = new PopupWindow(localView, -1, (int)TypedValue.applyDimension(1, 392.0F, paramActivity.getResources().getDisplayMetrics()));
    this.d.setAnimationStyle(2131953021);
    this.d.setBackgroundDrawable(new BitmapDrawable());
    this.d.setFocusable(true);
    this.d.setOutsideTouchable(true);
    this.d.update();
    this.d.setOnDismissListener(this);
    this.e = ((QQViewPager)localView.findViewById(2131434274));
    this.f = ((LinearLayout)localView.findViewById(2131437475));
    this.i = ((RelativeLayout)localView.findViewById(2131434269));
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("url", g());
      localIntent.setData(Uri.parse(g()));
      localIntent.putExtra("flag_show_loading_dialog", false);
      localIntent.putExtra("hide_left_button", true);
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.e("GiftPanelController", 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  private void b(Activity paramActivity)
  {
    View localView = paramActivity.getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  private void b(List<giftList.GroupGiftItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
  }
  
  private void c(Activity paramActivity)
  {
    if (this.d != null)
    {
      if (this.c.d() == null) {
        return;
      }
      try
      {
        VideoReport.addToDetectionWhitelist(paramActivity);
        VideoReport.setPageId(this.d.getContentView(), "pg_sgrp_gift_panel");
        paramActivity = new HashMap();
        paramActivity.put("sgrp_channel_id", Long.valueOf(this.c.d().b()));
        paramActivity.put("sgrp_sub_channel_id", Long.valueOf(this.c.d().f()));
        paramActivity.put("pgid", "pg_sgrp_gift_panel");
        VideoReport.setPageParams(this.d.getContentView(), new PageParams(paramActivity));
        VideoReport.setElementId(this.m, "em_sgrp_recharge_entrance");
        VideoReport.setElementDynamicParams(this.m, new GiftPanelController.8(this));
        VideoReport.reportEvent("pgin", this.d.getContentView(), paramActivity);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    this.n = null;
    if (k() != null) {
      this.j.setText(k().getText(2131890382));
    }
    this.l.setVisibility(8);
  }
  
  private String g()
  {
    String str = this.b;
    if ((str != null) && (str.length() > 0)) {
      str = this.b;
    } else {
      str = "https://h5.qzone.qq.com/v2/vip/qun-gift/channel-charge-dialog?_wv=16781315&_wwv=13&themeMode={themeMode}&source={source}&clusterid={clusterid}&subclusterid={subclusterid}";
    }
    Object localObject = str;
    if (this.c.d() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.d().d());
      ((StringBuilder)localObject).append("");
      str = str.replace("{themeMode}", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.d().f());
      ((StringBuilder)localObject).append("");
      str = str.replace("{clusterid}", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.d().b());
      ((StringBuilder)localObject).append("");
      localObject = str.replace("{subclusterid}", ((StringBuilder)localObject).toString());
    }
    return ((String)localObject).replace("{source}", "1");
  }
  
  private void h()
  {
    WebAccelerateHelper.getInstance().preFetchResource(g());
  }
  
  private void i()
  {
    PopupWindow localPopupWindow = this.d;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      this.d.setAnimationStyle(0);
      this.d.update();
    }
  }
  
  private void j()
  {
    PopupWindow localPopupWindow = this.d;
    if (localPopupWindow != null) {
      localPopupWindow.getContentView().postDelayed(new GiftPanelController.7(this), 200L);
    }
  }
  
  private Context k()
  {
    PopupWindow localPopupWindow = this.d;
    if ((localPopupWindow != null) && (localPopupWindow.getContentView() != null)) {
      return this.d.getContentView().getContext();
    }
    return null;
  }
  
  public void a()
  {
    PopupWindow localPopupWindow = this.d;
    if ((localPopupWindow != null) && (localPopupWindow.getContentView() != null)) {
      this.d.getContentView().post(new GiftPanelController.3(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    String str = this.n;
    if (str == null)
    {
      if ((this.c.d() != null) && (k() != null)) {
        this.c.d().a(k().getString(2131890383));
      }
      return;
    }
    this.c.a(Long.parseLong(str), paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.p = paramLong;
    TextView localTextView = this.k;
    if (localTextView == null) {
      return;
    }
    localTextView.post(new GiftPanelController.6(this, paramLong, paramString));
  }
  
  public void a(Activity paramActivity, List<giftList.GroupGiftItem> paramList, IGiftPanelController.OnSelectLastPageListener paramOnSelectLastPageListener, long paramLong)
  {
    if (this.d == null) {
      a(paramActivity);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramActivity.getApplication().registerActivityLifecycleCallbacks(this);
    }
    this.o = paramActivity.getComponentName().getClassName();
    this.h = new GiftListPageAdapter(paramList, this);
    this.e.setAdapter(this.h);
    this.e.addOnPageChangeListener(new GiftPanelController.2(this, paramOnSelectLastPageListener));
    b(paramActivity);
    this.d.showAtLocation(paramActivity.getWindow().getDecorView(), 80, 0, 0);
    a((int)paramLong, paramActivity.getApplicationContext());
    b(paramList);
    h();
    this.c.e();
    c(paramActivity);
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramDrawable != null))
    {
      this.n = paramString1;
      this.j.setText(paramString2);
      this.l.setVisibility(0);
      this.l.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void a(List<giftList.GroupGiftItem> paramList)
  {
    QQViewPager localQQViewPager = this.e;
    if (localQQViewPager != null) {
      localQQViewPager.post(new GiftPanelController.1(this, paramList));
    }
  }
  
  public void b()
  {
    if (this.c.d() != null) {
      this.c.d().c();
    }
  }
  
  public void c()
  {
    if (k() != null) {
      a(k());
    }
  }
  
  public void d()
  {
    if ((this.c.d() != null) && (k() != null)) {
      this.c.d().a(k().getString(2131890384));
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity.getComponentName().getClassName().equals(this.o)) {
      i();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity.getComponentName().getClassName().equals(this.o))
    {
      j();
      this.c.e();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onDismiss()
  {
    f();
    if ((this.d != null) && (k() != null) && (Build.VERSION.SDK_INT >= 26)) {
      try
      {
        ((Application)k().getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.panel.GiftPanelController
 * JD-Core Version:    0.7.0.1
 */