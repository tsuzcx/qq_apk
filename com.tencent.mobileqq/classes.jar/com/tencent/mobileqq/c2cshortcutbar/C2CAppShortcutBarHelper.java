package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class C2CAppShortcutBarHelper
  extends TroopAppShortcutBarHelper
{
  C2CShortcutBarObserver k = new C2CAppShortcutBarHelper.2(this);
  private OverScrollCallbackHorizontalListView l;
  private C2CShortcutBarAdapter m;
  private long n;
  private boolean o;
  private List<C2CShortcutAppInfo> p = new ArrayList();
  private C2CShortcutBarAdapter.ItemExposeListener q = new C2CAppShortcutBarHelper.1(this);
  private C2CShortcutBarJumpController r;
  
  public C2CAppShortcutBarHelper(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    super(paramIAIOShortcutBarLogic);
  }
  
  private void a(C2CShortcutAppInfo paramC2CShortcutAppInfo, int paramInt)
  {
    if (paramC2CShortcutAppInfo == null) {
      return;
    }
    if (this.p.contains(paramC2CShortcutAppInfo)) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B329", "0X800B329", C2CShortcutBarManager.a((QQAppInterface)this.g).a(String.valueOf(this.n)), 0, paramC2CShortcutAppInfo.a, String.valueOf(paramInt), "", "");
    this.p.add(paramC2CShortcutAppInfo);
  }
  
  private void y()
  {
    if (!C2CShortcutBarSwitcher.a((QQAppInterface)this.g, String.valueOf(this.n), x()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
      return;
    }
    if (!C2CShortcutBarManager.a((QQAppInterface)this.g).b(Long.valueOf(this.n)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    C2CShortcutBarManager.a((QQAppInterface)this.g).b().a(this.n, x(), false, 0, "");
  }
  
  public void a()
  {
    if (this.g == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
      }
      return;
    }
    try
    {
      this.n = Long.parseLong(this.i.b);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init Exception", localNumberFormatException);
      }
    }
    List localList = C2CShortcutBarManager.a((QQAppInterface)this.g).c(Long.valueOf(this.n));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init friendUin = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(",appListSize = ");
      localStringBuilder.append(localList.size());
      QLog.d("C2CShortcutBarAIOHelper", 2, localStringBuilder.toString());
    }
    this.m = new C2CShortcutBarAdapter(this.f, localList, this.q);
    this.l = new OverScrollCallbackHorizontalListView(this.f);
    this.l.setId(2131445368);
    this.l.setAdapter(this.m);
    this.l.setOnItemClickListener(new C2CAppShortcutBarHelper.3(this));
    this.l.setOverScrollMode(0);
    this.l.setDividerWidth(ViewUtils.dip2px(8.0F));
    this.l.setPadding(ViewUtils.dip2px(14.0F), ViewUtils.dip2px(10.0F), 0, 0);
    this.l.setClipToPadding(false);
    this.d.a(1);
    ((QQAppInterface)this.g).addObserver(this.k);
    y();
  }
  
  public View b()
  {
    return this.l;
  }
  
  public ViewGroup.LayoutParams c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(39.0F));
    localLayoutParams.addRule(2, 2131435809);
    return localLayoutParams;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
    }
    super.e();
    m();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    ((QQAppInterface)this.g).removeObserver(this.k);
    this.o = false;
    this.p.clear();
    Object localObject = this.r;
    if (localObject != null) {
      ((C2CShortcutBarJumpController)localObject).a();
    }
    localObject = this.l;
    if ((localObject != null) && (((OverScrollCallbackHorizontalListView)localObject).getParent() != null) && (QLog.isColorLevel())) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
    }
    super.g();
  }
  
  public void h()
  {
    super.h();
    i().setPadding(j(), l(), k(), 0);
  }
  
  protected View i()
  {
    return this.l;
  }
  
  protected int j()
  {
    return ViewUtils.dip2px(14.0F);
  }
  
  protected int k()
  {
    return ViewUtils.dip2px(14.0F);
  }
  
  protected int l()
  {
    return ViewUtils.dip2px(10.0F);
  }
  
  public void m()
  {
    if (!C2CShortcutBarSwitcher.a((QQAppInterface)this.g, String.valueOf(this.n), x()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
      }
      return;
    }
    if ((x() == 1) && (this.e.o()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
      }
      return;
    }
    super.m();
  }
  
  protected boolean n()
  {
    return (u()) && (this.d.b(1));
  }
  
  protected boolean p()
  {
    return this.d.a(1);
  }
  
  public boolean u()
  {
    boolean bool2 = C2CShortcutBarSwitcher.a((QQAppInterface)this.g, String.valueOf(this.n), x());
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for switch off");
      }
      return false;
    }
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
      return false;
    }
    int i = this.m.getCount();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShortcutBarVisibleOrGoingToBeVisible dataSize = ");
      localStringBuilder.append(i);
      QLog.d("C2CShortcutBarAIOHelper", 2, localStringBuilder.toString());
    }
    if (i > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int x()
  {
    if (this.e.a() == 5) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CAppShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */