package com.tencent.mobileqq.newnearby;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivityHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.newnearby.model.TabInfo;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.newnearby.util.PickLocationHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NearbyActivityController
{
  public static int a = 0;
  public static boolean b = false;
  private NearbyActivity c;
  private NearbyPagerAdapter d;
  private FrameLayout e;
  private NearbyHippyFragment f;
  private NonSwipeableViewPager g;
  private TabLayoutCompat h;
  private ImageView i;
  private QQBlurView j;
  private RedTouch k;
  private Promise l;
  private Handler m = new Handler();
  private Runnable n = new NearbyActivityController.1(this);
  private TabLayoutCompat.OnTabSelectedListener o = new NearbyActivityController.2(this);
  private View.OnClickListener p = new NearbyActivityController.3(this);
  
  public NearbyActivityController(NearbyActivity paramNearbyActivity)
  {
    this.c = paramNearbyActivity;
    this.c.getWindow().setBackgroundDrawable(this.c.getResources().getDrawable(1946353664));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.h = ((TabLayoutCompat)this.c.findViewById(1946419223));
    Object localObject1 = this.h.b(paramInt).b();
    Object localObject2 = (TextView)((View)localObject1).findViewById(1946419230);
    Resources localResources = this.c.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 1946288132;
    } else {
      i1 = 1946288133;
    }
    ((TextView)localObject2).setTextColor(localResources.getColor(i1));
    localObject2 = (ImageView)((View)localObject1).findViewById(1946419229);
    localObject1 = (TabInfo)((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabs().get(paramInt);
    if (paramBoolean) {
      localObject1 = ((TabInfo)localObject1).e;
    } else {
      localObject1 = ((TabInfo)localObject1).f;
    }
    ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
  }
  
  private void a(TabLayoutCompat.Tab paramTab)
  {
    int i1 = ((Integer)paramTab.a()).intValue();
    NearbyReportHelperImpl.reportTabClick(this.c, i1);
    if (i1 != a)
    {
      a(i1, true);
      a(a, false);
      a = i1;
    }
    if (a == 0)
    {
      d();
      this.g.setVisibility(8);
      this.e.setVisibility(0);
    }
    else
    {
      if ((i1 == TabInfo.a) && (this.h.b(TabInfo.a) != null))
      {
        n();
        return;
      }
      e();
      this.e.setVisibility(8);
      this.g.setVisibility(0);
      a(false);
      this.g.setCurrentItem(i1, false);
    }
    h();
    l();
  }
  
  private void g()
  {
    this.e = ((FrameLayout)this.c.findViewById(1946419224));
    FragmentTransaction localFragmentTransaction = this.c.getSupportFragmentManager().beginTransaction();
    this.f = new NearbyHippyFragment();
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "QQNearby";
    localOpenHippyInfo.processName = "tool";
    localOpenHippyInfo.framework = "react";
    localOpenHippyInfo.isTransparent = true;
    localOpenHippyInfo.updateJsBundleType = 1;
    Bundle localBundle = new Bundle();
    localBundle.putBundle("params", localOpenHippyInfo.toBundle());
    this.f.setArguments(localBundle);
    localFragmentTransaction.replace(1946419224, this.f);
    localFragmentTransaction.commit();
  }
  
  private void h()
  {
    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
      return;
    }
    View localView = this.c.getWindow().getDecorView();
    if (Build.VERSION.SDK_INT >= 23) {
      localView.setForeground(new ColorDrawable(1996488704));
    }
  }
  
  private void i()
  {
    Object localObject = this.c.centerView;
    ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
    localLayoutParams.width = 150;
    localLayoutParams.height = 90;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setBackgroundResource(1946550273);
    localObject = this.c.getTitleBarView();
    if ((localObject instanceof NavBarCommon))
    {
      localObject = (NavBarCommon)localObject;
      ((NavBarCommon)localObject).changeBg(true);
      localObject = ((NavBarCommon)localObject).getLeftBackIcon();
      if (a == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(0)) {
        ((TextView)localObject).setVisibility(8);
      } else {
        ((TextView)localObject).setOnClickListener(this.p);
      }
    }
    j();
    this.c.rightViewText.setBackgroundDrawable(null);
    this.c.rightViewText.setBackgroundColor(this.c.getResources().getColor(1946288129));
    localObject = this.c;
    this.k = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
    this.k.c(53).a();
    c();
  }
  
  private void j()
  {
    this.c.setRightButton(1946615840, new NearbyActivityController.4(this));
  }
  
  private void k()
  {
    this.g = ((NonSwipeableViewPager)this.c.findViewById(1946419225));
    this.g.requestParentDisallowInterecptTouchEvent(true);
    this.g.setPagingEnabled(false);
    this.g.setOffscreenPageLimit(3);
    this.d = new NearbyPagerAdapter(this.c.getSupportFragmentManager(), 1);
    this.g.setAdapter(this.d);
    this.h = ((TabLayoutCompat)this.c.findViewById(1946419223));
    this.h.a(this.o);
    this.j = ((QQBlurView)this.c.findViewById(1946419215));
  }
  
  private void l()
  {
    this.h.setBackgroundColor(this.c.getResources().getColor(1946288131));
    this.j.setVisibility(8);
    this.j.b();
    this.j.c();
    if (Build.VERSION.SDK_INT >= 24)
    {
      if ((((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).hasMatchTab()) && (a == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(2))) {
        return;
      }
      this.j.setVisibility(0);
      try
      {
        if (a == 0)
        {
          this.j.a(this.f.getView());
        }
        else
        {
          if (this.d == null) {
            return;
          }
          this.j.a(this.d.getItem(a).getView());
        }
        this.j.b(this.j);
        this.j.a(8);
        this.j.c(-1);
        this.j.setEnableBlur(true);
        this.j.setDisableBlurDrawableRes(2130841458);
        this.j.d();
        this.j.a();
        this.m.removeCallbacks(this.n);
        this.m.postDelayed(this.n, 5000L);
        return;
      }
      catch (Exception localException)
      {
        this.h.setBackgroundColor(this.c.getResources().getColor(1946288131));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init QQBlurView fail, error:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QQNearbyActivityImpl", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void m()
  {
    this.i = ((ImageView)this.c.findViewById(1946419216));
    this.i.setOnClickListener(new NearbyActivityController.5(this));
  }
  
  private void n()
  {
    Object localObject = AppConstants.NEARBY_LBS_HELLO_UIN;
    Intent localIntent = new Intent(this.c, MsgBoxListActivity.class);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("isFromQQNearby", true);
    localIntent.putExtra("isFromNearby", true);
    localIntent.putExtra("msgTabIndex", TabInfo.a);
    localIntent.putExtra("mUnReadMsgNum", 0);
    localObject = ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabs();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i2 = ((List)localObject).size();
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList1.add(Integer.valueOf(((TabInfo)((List)localObject).get(i1)).c));
      localArrayList2.add(((TabInfo)((List)localObject).get(i1)).b);
      i1 += 1;
    }
    localIntent.putExtra("tabTypes", localArrayList1);
    localIntent.putExtra("tabNames", localArrayList2);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131904965));
    this.c.startActivityForResult(localIntent, 10001);
    this.c.overridePendingTransition(0, 0);
  }
  
  public void a()
  {
    b = false;
    g();
    this.h = ((TabLayoutCompat)this.c.findViewById(1946419223));
    ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).reqTabConfig(this.c, this.h);
    i();
    m();
    h();
    d();
    PickLocationHelper.a(this.c);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NearbyActivity localNearbyActivity = this.c;
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 == 10001)
    {
      paramInt2 = paramIntent.getIntExtra("curIndex", -1);
      if (paramInt2 < 5)
      {
        paramInt1 = paramInt2;
        if (paramInt2 >= 0) {}
      }
      else
      {
        paramInt1 = ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(0);
      }
      if (this.h.getTabCount() == 0) {
        return;
      }
      this.h.b(paramInt1).f();
      if ((paramInt1 != a) && (paramInt1 != TabInfo.a))
      {
        a(paramInt1, true);
        a(a, false);
        a = paramInt1;
      }
      paramInt2 = paramIntent.getIntExtra("unReadMsgNum", 0);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("index=");
        paramIntent.append(paramInt1);
        paramIntent.append(", unReadMsgNum=");
        paramIntent.append(paramInt2);
        QLog.d("nearby.msgbox.tab", 2, paramIntent.toString());
      }
      this.c.setLastUnreadNum(paramInt2);
      NearbyActivityHelper.a(this.c.getMsgTabRedTouch(), paramInt2);
      return;
    }
    if (paramInt1 == 1000)
    {
      NearbyHippyCallback.a(localNearbyActivity, paramIntent, this.l);
      return;
    }
    if ((paramInt1 == 5) && (NearbyAlbumHelperImpl.getLock()))
    {
      NearbyAlbumHelperImpl.onPickPhotoFromQZone(paramIntent);
      NearbyAlbumHelperImpl.setLock(false);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.h.b(paramInt).f();
    if ((paramInt != a) && (paramInt != TabInfo.a))
    {
      a(paramInt, true);
      a(a, false);
      a = paramInt;
    }
    NearbyHippyFragment localNearbyHippyFragment = this.d.a(paramInt);
    if (localNearbyHippyFragment != null)
    {
      HippyMap localHippyMap1 = new HippyMap();
      localHippyMap1.pushInt("retCode", 0);
      HippyMap localHippyMap2 = new HippyMap();
      localHippyMap2.pushString("params", paramString);
      localHippyMap1.pushObject("data", localHippyMap2);
      localNearbyHippyFragment.sendHippyNativeEvent("switchTab", localHippyMap1);
    }
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(0))
    {
      d();
      return;
    }
    e();
  }
  
  public void a(Promise paramPromise)
  {
    this.l = paramPromise;
    paramPromise = new Intent(this.c, AgeSelectionActivity.class);
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(1);
    int i2 = localCalendar.get(2);
    paramPromise.putExtra("param_birthday", localCalendar.get(5) | i1 << 16 | i2 + 1 << 8);
    this.c.startActivityForResult(paramPromise, 1000);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (a == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(0)))
    {
      QLog.d("QQNearbyActivityImpl", 2, "setPubishView visible");
      this.i.setVisibility(0);
      NearbyUtils.b((AppInterface)this.c.app, "exp_pub", 1);
      return;
    }
    QLog.d("QQNearbyActivityImpl", 2, "setPubishView gone");
    this.i.setVisibility(8);
  }
  
  public void b()
  {
    k();
    d();
    h();
    l();
  }
  
  public void c()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = this.c.app.getNearbyProcManager().a(9);
    this.k.a(localRedTypeInfo);
  }
  
  public void d()
  {
    NearbyStatusBarHelper.b(this.c);
    Object localObject1 = this.c.centerView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = 150;
    ((ViewGroup.LayoutParams)localObject1).height = 90;
    this.c.centerView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.c.centerView.setBackgroundResource(1946550274);
    this.c.getWindow().setBackgroundDrawable(this.c.getResources().getDrawable(1946353664));
    localObject1 = this.c.getTitleBarView();
    if ((localObject1 instanceof NavBarCommon))
    {
      NavBarCommon localNavBarCommon = (NavBarCommon)localObject1;
      localNavBarCommon.changeBg(false);
      localNavBarCommon.setTitleColor(-1);
      Object localObject2 = localNavBarCommon.getLeftBackIcon();
      ((TextView)localObject2).setText("");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = this.c.getTitleBarLeftBackIcon();
      ViewGroup.LayoutParams localLayoutParams = ((ImageView)localObject2).getLayoutParams();
      localLayoutParams.height = 75;
      localLayoutParams.width = 150;
      ((ImageView)localObject2).setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 16) {
        ((ImageView)localObject2).setBackground(null);
      }
      ((ImageView)localObject2).setImageResource(1946353673);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_START);
      ((ImageView)localObject2).setVisibility(0);
      ((TextView)localNavBarCommon.findViewById(2131436211)).setTextColor(-1);
      ((View)localObject1).setBackgroundColor(this.c.getResources().getColor(1946288129));
    }
    j();
  }
  
  public void e()
  {
    NearbyStatusBarHelper.c(this.c);
    Object localObject = this.c.centerView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = 150;
    ((ViewGroup.LayoutParams)localObject).height = 90;
    this.c.centerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.centerView.setBackgroundResource(1946550273);
    this.c.getWindow().setBackgroundDrawable(this.c.getResources().getDrawable(1946288130));
    localObject = this.c.getTitleBarView();
    if ((localObject instanceof NavBarCommon))
    {
      localObject = (NavBarCommon)localObject;
      this.c.getTitleBarLeftBackIcon().setVisibility(8);
      ((NavBarCommon)localObject).changeBg(true);
      localObject = ((NavBarCommon)localObject).getLeftBackIcon();
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setOnClickListener(this.p);
    }
    j();
  }
  
  public void f()
  {
    if (a == 0) {
      d();
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyActivityController
 * JD-Core Version:    0.7.0.1
 */