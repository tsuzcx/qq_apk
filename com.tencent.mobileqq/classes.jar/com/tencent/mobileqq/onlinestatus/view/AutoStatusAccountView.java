package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AutoStatusAccountView
  extends AutoStatusSelectView
{
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem o;
  private ArrayList<OnlineStatusItem> p;
  private boolean q = true;
  
  public AutoStatusAccountView(@NonNull QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    this.b = 2;
    this.c = 40000;
  }
  
  public static void a(AutoStatusSelectView paramAutoStatusSelectView, View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      if (i == 2)
      {
        paramAutoStatusSelectView = paramAutoStatusSelectView.f().iterator();
        while (paramAutoStatusSelectView.hasNext()) {
          ReportHelperKt.a("0X800AF40", ((Integer)paramAutoStatusSelectView.next()).intValue(), "2");
        }
      }
      if (i == 1)
      {
        paramAutoStatusSelectView = paramAutoStatusSelectView.f().iterator();
        while (paramAutoStatusSelectView.hasNext()) {
          ReportHelperKt.a("0X800B00F", ((Integer)paramAutoStatusSelectView.next()).intValue(), "2");
        }
      }
    }
  }
  
  private void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(0);
    localArrayList.addAll(paramArrayList);
    this.p = localArrayList;
  }
  
  private boolean n()
  {
    if (this.o == null) {
      return false;
    }
    if (this.h == null) {
      return false;
    }
    if (this.o.isAllHasPermission() != this.h.isAllHasPermission()) {
      return true;
    }
    if (this.o.getPermissionUins().size() != this.h.getPermissionUins().size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusAccountView", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(this.o.getPermissionUins().size()), " item.size=", Integer.valueOf(this.h.getPermissionUins().size()) });
      }
      return true;
    }
    return !this.o.getPermissionUins().containsAll(this.h.getPermissionUins());
  }
  
  private boolean o()
  {
    Object localObject = this.p;
    if (localObject == null) {
      return false;
    }
    if (((ArrayList)localObject).size() != this.f.d().size()) {
      return true;
    }
    localObject = this.f.d().iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnlineStatusItem localOnlineStatusItem1 = (OnlineStatusItem)((Iterator)localObject).next();
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        OnlineStatusItem localOnlineStatusItem2 = (OnlineStatusItem)localIterator.next();
        if (localOnlineStatusItem1.b == localOnlineStatusItem2.b)
        {
          i = 1;
          break label111;
        }
      }
      int i = 0;
      label111:
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected void a() {}
  
  protected void a(View paramView)
  {
    c();
    this.n.a(40001L);
    dismiss();
    a(this, paramView);
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem == null) {
      paramOnlineStatusPermissionItem = this.h;
    }
    this.o = paramOnlineStatusPermissionItem;
    super.a(this.o);
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.g.requestPermissions(new AutoStatusAccountView.1(this, paramBoolean, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    else
    {
      a(paramBoolean);
      a(paramOnlineStatusPermissionItem);
      show();
    }
    ReportHelperKt.a("0X800AF9A");
    ReportHelperKt.a("0X800AF3E", 2);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusAccountView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    this.a.setText(2131892267);
    if (paramBoolean2)
    {
      this.a.setEnabled(false);
      return;
    }
    if (!this.q)
    {
      this.a.setEnabled(true);
      return;
    }
    if (paramBoolean1)
    {
      this.a.setEnabled(true);
      return;
    }
    this.a.setEnabled(false);
  }
  
  protected void b()
  {
    this.d.setText(2131888293);
    if (this.f == null)
    {
      OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
      localOnlineStatusPanelParams.a = 3;
      localOnlineStatusPanelParams.k = true;
      localOnlineStatusPanelParams.j = false;
      localOnlineStatusPanelParams.b = true;
      localOnlineStatusPanelParams.g = 5;
      localOnlineStatusPanelParams.i = (this.g.getResources().getDisplayMetrics().widthPixels - Utils.a(26.0F, this.g.getResources()));
      this.f = new OnlineStatusViewCtrl(this.g, this.e, this, localOnlineStatusPanelParams, this);
      this.f.a();
      return;
    }
    this.f.a(this.p);
  }
  
  public void c()
  {
    this.o = this.h;
    a(this.f.d());
  }
  
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
      QLog.d("AutoStatusAccountView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
    }
    a(bool3, bool1);
    b(bool2, bool1);
  }
  
  protected boolean d(boolean paramBoolean)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    if ((this.o == null) && (localOnlineStatusPermissionManager.a(this.h, this))) {
      return true;
    }
    if ((this.o != null) && (n())) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    if (this.p == null) {
      return localOnlineStatusPermissionManager.a(this.f.d());
    }
    return o();
  }
  
  public void dg_()
  {
    a(false, null);
  }
  
  public ArrayList<OnlineStatusItem> e()
  {
    ArrayList localArrayList = super.e();
    a(localArrayList);
    return localArrayList;
  }
  
  public ArrayList<Integer> f()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.p;
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
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445146)
    {
      this.h = this.o;
      dismiss();
      ReportHelperKt.a("0X800AF94");
    }
    else if (paramView.getId() == 2131430020)
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView
 * JD-Core Version:    0.7.0.1
 */