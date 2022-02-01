package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AppShortcutBarPanel
  extends IAppShortcutBarDataUI
{
  public boolean a = false;
  protected View.OnClickListener b = new AppShortcutBarPanel.2(this);
  private AIOShortcutBarContext c;
  private AppShortcutBarScrollView d;
  private LinearLayout e;
  private LinearLayout f;
  private LinearLayout g;
  private TroopAppShortcutBarHelper h;
  private long i;
  private ArrayList<Long> j = new ArrayList();
  private boolean k = false;
  private AppShortcutBarPanel.ScrollInfo l;
  private SessionInfo m;
  private Activity n;
  private Context o;
  private AppRuntime p;
  
  public AppShortcutBarPanel(AIOShortcutBarContext paramAIOShortcutBarContext, AppShortcutBarScrollView paramAppShortcutBarScrollView, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.c = paramAIOShortcutBarContext;
    this.m = paramAIOShortcutBarContext.d();
    this.n = paramAIOShortcutBarContext.f();
    this.o = paramAIOShortcutBarContext.e();
    this.p = paramAIOShortcutBarContext.c();
    this.d = paramAppShortcutBarScrollView;
    this.e = ((LinearLayout)this.d.findViewById(2131439812));
    this.f = ((LinearLayout)this.e.findViewById(2131439802));
    this.g = ((LinearLayout)this.e.findViewById(2131439810));
    this.h = paramTroopAppShortcutBarHelper;
    this.i = this.h.w();
  }
  
  private void a(TroopShortcutBarApp paramTroopShortcutBarApp, View paramView)
  {
    paramView.setTag(paramTroopShortcutBarApp);
    paramView.setOnClickListener(this.b);
    boolean bool2 = ThemeUtil.isInNightMode(this.p);
    Object localObject = (TextView)paramView.findViewById(2131445857);
    ((TextView)localObject).setText(paramTroopShortcutBarApp.e());
    if (bool2) {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
    }
    localObject = (LinearLayout)paramView.findViewById(2131445854);
    if (bool2) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.o.getResources().getDrawable(2130838710));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.o.getResources().getDrawable(2130838709));
    }
    localObject = (TextView)paramView.findViewById(2131445856);
    int i1 = paramTroopShortcutBarApp.i();
    boolean bool1 = false;
    if ((i1 == 0) && (!paramTroopShortcutBarApp.k()))
    {
      ((TextView)localObject).setVisibility(4);
    }
    else
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837936, 0, 0, 0);
    }
    paramView = (URLImageView)paramView.findViewById(2131445855);
    if (bool2) {
      paramView.setColorFilter(1996488704);
    } else {
      paramView.setColorFilter(0);
    }
    localObject = this.o;
    String str = paramTroopShortcutBarApp.f();
    if (paramTroopShortcutBarApp.g() == 1) {
      bool1 = true;
    }
    TroopAppShortcutUtils.a((Context)localObject, paramView, str, 19.0F, bool1);
  }
  
  private void g()
  {
    TroopShortcutBarApp localTroopShortcutBarApp = TroopShortcutBarApp.a(this.o.getResources().getString(2131893971), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
    View localView = View.inflate(this.o, 2131627903, null);
    a(localTroopShortcutBarApp, localView);
    this.f.addView(localView);
  }
  
  public void a()
  {
    this.k = false;
    this.a = false;
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.a = false;
      Object localObject = this.f;
      if (localObject == null) {
        return;
      }
      ((LinearLayout)localObject).removeAllViews();
      if (this.g.getChildCount() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.l = new AppShortcutBarPanel.ScrollInfo();
      paramArrayList = paramArrayList.iterator();
      long l2 = 0L;
      int i3 = 1;
      int i2 = i1;
      boolean bool = false;
      int i1 = i3;
      while (paramArrayList.hasNext())
      {
        localObject = (ShortcutBarInfo)paramArrayList.next();
        if ((localObject != null) && ((localObject instanceof TroopShortcutBarApp)))
        {
          localObject = (TroopShortcutBarApp)localObject;
          try
          {
            View localView = View.inflate(this.o, 2131627903, null);
            a((TroopShortcutBarApp)localObject, localView);
            this.f.addView(localView);
            localView.setId((int)((TroopShortcutBarApp)localObject).d());
            this.l.b = localView.getWidth();
            i3 = i2;
            if (i2 != 0)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
              localLayoutParams.setMargins(ViewUtils.dip2px(14.0F), 0, 0, 0);
              localView.setLayoutParams(localLayoutParams);
              i3 = 0;
            }
            long l1;
            if (!((TroopShortcutBarApp)localObject).k())
            {
              l1 = l2;
              if (!((TroopShortcutBarApp)localObject).l()) {}
            }
            else
            {
              l1 = l2;
              if (this.g.getChildCount() == 0)
              {
                this.l.c = true;
                if (((TroopShortcutBarApp)localObject).l())
                {
                  l1 = ((TroopShortcutBarApp)localObject).j();
                  this.l.a = i1;
                  this.l.d = ((TroopShortcutBarApp)localObject).d();
                }
                else
                {
                  l1 = l2;
                  if (((TroopShortcutBarApp)localObject).k())
                  {
                    l1 = l2;
                    if (((TroopShortcutBarApp)localObject).j() > l2)
                    {
                      l2 = ((TroopShortcutBarApp)localObject).j();
                      l1 = l2;
                      if (i1 > this.l.a)
                      {
                        this.l.a = i1;
                        this.l.d = ((TroopShortcutBarApp)localObject).d();
                        l1 = l2;
                      }
                    }
                  }
                }
              }
            }
            if (i1 == 4) {
              this.l.e = ((TroopShortcutBarApp)localObject).d();
            }
            i1 += 1;
            if (((TroopShortcutBarApp)localObject).l()) {
              ((TroopShortcutBarApp)localObject).c(false);
            }
            bool = true;
            i2 = i3;
            l2 = l1;
          }
          catch (InflateException paramArrayList)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("AppShortcutBarPanel.updateAppShortcutPanel got InflateException, e:");
              ((StringBuilder)localObject).append(paramArrayList.getMessage());
              QLog.e("AppShortcutBarPanel", 2, ((StringBuilder)localObject).toString());
            }
            System.gc();
            return;
          }
          catch (OutOfMemoryError paramArrayList)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("AppShortcutBarPanel.updateAppShortcutPanel got OOM, e:");
              ((StringBuilder)localObject).append(paramArrayList.getMessage());
              QLog.e("AppShortcutBarPanel", 2, ((StringBuilder)localObject).toString());
            }
            System.gc();
            return;
          }
        }
      }
      this.a = bool;
      if ((bool) && (paramBoolean)) {
        try
        {
          g();
        }
        catch (InflateException paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("ShortcutBarAioHelper.updateAppShortcutPanel ManageBtn got InflateException, e:");
            ((StringBuilder)localObject).append(paramArrayList.getMessage());
            QLog.e("AppShortcutBarPanel", 2, ((StringBuilder)localObject).toString());
          }
          System.gc();
          return;
        }
        catch (OutOfMemoryError paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AppShortcutBarPanel.updateAppShortcutPanel ManageBtn got OOM, e:");
            ((StringBuilder)localObject).append(paramArrayList.getMessage());
            QLog.e("AppShortcutBarPanel", 2, ((StringBuilder)localObject).toString());
          }
          System.gc();
          return;
        }
      }
      if (bool)
      {
        this.h.m();
        if ((!this.k) && (this.p != null))
        {
          this.k = true;
          paramArrayList = String.valueOf(this.i);
          localObject = ((TroopManager)this.p.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramArrayList);
          if (localObject == null) {
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", paramArrayList, String.valueOf(((TroopInfo)localObject).dwGroupClassExt), "");
          TroopEssenceReportUtil.c((QQAppInterface)this.p, this.i, true);
          TroopEssenceReportUtil.d((QQAppInterface)this.p, this.i, true);
        }
        ThreadManager.getUIHandler().postDelayed(new AppShortcutBarPanel.1(this), 800L);
        return;
      }
      this.a = false;
      paramArrayList = this.h;
      if (paramArrayList != null) {
        paramArrayList.o();
      }
      return;
    }
    this.f.removeAllViews();
    if (this.g.getChildCount() == 0) {
      this.h.o();
    }
    this.a = false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    AppShortcutBarPanel localAppShortcutBarPanel = this;
    if ((localAppShortcutBarPanel.d != null) && (localAppShortcutBarPanel.f != null))
    {
      if (localAppShortcutBarPanel.p == null) {
        return;
      }
      String str = String.valueOf(localAppShortcutBarPanel.i);
      TroopInfo localTroopInfo = ((TroopManager)localAppShortcutBarPanel.p.getManager(QQManagerFactory.TROOP_MANAGER)).f(str);
      if (localTroopInfo == null) {
        return;
      }
      Rect localRect = new Rect();
      localAppShortcutBarPanel.d.getHitRect(localRect);
      int i1 = 0;
      for (;;)
      {
        localAppShortcutBarPanel = this;
        if (i1 >= localAppShortcutBarPanel.f.getChildCount()) {
          break;
        }
        Object localObject = localAppShortcutBarPanel.f.getChildAt(i1);
        if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof TroopShortcutBarApp))
          {
            localObject = (TroopShortcutBarApp)localObject;
            if (localObject != null)
            {
              long l1 = ((TroopShortcutBarApp)localObject).d();
              localObject = localAppShortcutBarPanel.j.iterator();
              while (((Iterator)localObject).hasNext()) {
                if (((Long)((Iterator)localObject).next()).longValue() == l1)
                {
                  i2 = 1;
                  break label205;
                }
              }
              int i2 = 0;
              label205:
              if (i2 == 0)
              {
                localAppShortcutBarPanel.j.add(Long.valueOf(l1));
                ReportController.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l1), str, String.valueOf(localTroopInfo.dwGroupClassExt), "");
                if (l1 == 101914115L) {
                  QQGameTroopManager.a(0, str, true);
                }
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public boolean f()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */