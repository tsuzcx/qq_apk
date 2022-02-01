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
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopAppShortcutBarHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private AppShortcutBarPanel.ScrollInfo jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public boolean a;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private LinearLayout c;
  
  public AppShortcutBarPanel(AIOShortcutBarContext paramAIOShortcutBarContext, AppShortcutBarScrollView paramAppShortcutBarScrollView, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new AppShortcutBarPanel.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_AndroidAppActivity = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_AndroidContentContext = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372301));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372291));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372299));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper = paramTroopAppShortcutBarHelper;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.b();
  }
  
  private void a(TroopShortcutBarApp paramTroopShortcutBarApp, View paramView)
  {
    paramView.setTag(paramTroopShortcutBarApp);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject = (TextView)paramView.findViewById(2131377458);
    ((TextView)localObject).setText(paramTroopShortcutBarApp.a());
    if (bool2) {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
    }
    localObject = (LinearLayout)paramView.findViewById(2131377455);
    if (bool2) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838593));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838592));
    }
    localObject = (TextView)paramView.findViewById(2131377457);
    int i = paramTroopShortcutBarApp.c();
    boolean bool1 = false;
    if ((i == 0) && (!paramTroopShortcutBarApp.b()))
    {
      ((TextView)localObject).setVisibility(4);
    }
    else
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837912, 0, 0, 0);
    }
    paramView = (URLImageView)paramView.findViewById(2131377456);
    if (bool2) {
      paramView.setColorFilter(1996488704);
    } else {
      paramView.setColorFilter(0);
    }
    localObject = this.jdField_a_of_type_AndroidContentContext;
    String str = paramTroopShortcutBarApp.b();
    if (paramTroopShortcutBarApp.b() == 1) {
      bool1 = true;
    }
    TroopAppShortcutUtils.a((Context)localObject, paramView, str, 19.0F, bool1);
  }
  
  private void f()
  {
    TroopShortcutBarApp localTroopShortcutBarApp = TroopShortcutBarApp.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696205), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561542, null);
    a(localTroopShortcutBarApp, localView);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) {
      return;
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jdField_a_of_type_Boolean = false;
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localObject == null) {
        return;
      }
      ((LinearLayout)localObject).removeAllViews();
      if (this.c.getChildCount() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo = new AppShortcutBarPanel.ScrollInfo();
      paramArrayList = paramArrayList.iterator();
      long l2 = 0L;
      int k = 1;
      int j = i;
      boolean bool = false;
      int i = k;
      while (paramArrayList.hasNext())
      {
        localObject = (ShortcutBarInfo)paramArrayList.next();
        if ((localObject != null) && ((localObject instanceof TroopShortcutBarApp)))
        {
          localObject = (TroopShortcutBarApp)localObject;
          try
          {
            View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561542, null);
            a((TroopShortcutBarApp)localObject, localView);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
            localView.setId((int)((TroopShortcutBarApp)localObject).b());
            this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_b_of_type_Int = localView.getWidth();
            k = j;
            if (j != 0)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
              localLayoutParams.setMargins(ViewUtils.a(14.0F), 0, 0, 0);
              localView.setLayoutParams(localLayoutParams);
              k = 0;
            }
            long l1;
            if (!((TroopShortcutBarApp)localObject).b())
            {
              l1 = l2;
              if (!((TroopShortcutBarApp)localObject).c()) {}
            }
            else
            {
              l1 = l2;
              if (this.c.getChildCount() == 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Boolean = true;
                if (((TroopShortcutBarApp)localObject).c())
                {
                  l1 = ((TroopShortcutBarApp)localObject).c();
                  this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int = i;
                  this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Long = ((TroopShortcutBarApp)localObject).b();
                }
                else
                {
                  l1 = l2;
                  if (((TroopShortcutBarApp)localObject).b())
                  {
                    l1 = l2;
                    if (((TroopShortcutBarApp)localObject).c() > l2)
                    {
                      l2 = ((TroopShortcutBarApp)localObject).c();
                      l1 = l2;
                      if (i > this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int = i;
                        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Long = ((TroopShortcutBarApp)localObject).b();
                        l1 = l2;
                      }
                    }
                  }
                }
              }
            }
            if (i == 4) {
              this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_b_of_type_Long = ((TroopShortcutBarApp)localObject).b();
            }
            i += 1;
            if (((TroopShortcutBarApp)localObject).c()) {
              ((TroopShortcutBarApp)localObject).c(false);
            }
            bool = true;
            j = k;
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
      this.jdField_a_of_type_Boolean = bool;
      if ((bool) && (paramBoolean)) {
        try
        {
          f();
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.g();
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
        {
          this.jdField_b_of_type_Boolean = true;
          paramArrayList = String.valueOf(this.jdField_a_of_type_Long);
          localObject = ((TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramArrayList);
          if (localObject == null) {
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", paramArrayList, String.valueOf(((TroopInfo)localObject).dwGroupClassExt), "");
          TroopEssenceReportUtil.c((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_Long, true);
          TroopEssenceReportUtil.d((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_Long, true);
        }
        ThreadManager.getUIHandler().postDelayed(new AppShortcutBarPanel.1(this), 800L);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper;
      if (paramArrayList != null) {
        paramArrayList.h();
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.c.getChildCount() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.h();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    AppShortcutBarPanel localAppShortcutBarPanel = this;
    if ((localAppShortcutBarPanel.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null) && (localAppShortcutBarPanel.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      if (localAppShortcutBarPanel.jdField_a_of_type_MqqAppAppRuntime == null) {
        return;
      }
      String str = String.valueOf(localAppShortcutBarPanel.jdField_a_of_type_Long);
      TroopInfo localTroopInfo = ((TroopManager)localAppShortcutBarPanel.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
      if (localTroopInfo == null) {
        return;
      }
      Rect localRect = new Rect();
      localAppShortcutBarPanel.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
      int i = 0;
      for (;;)
      {
        localAppShortcutBarPanel = this;
        if (i >= localAppShortcutBarPanel.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount()) {
          break;
        }
        Object localObject = localAppShortcutBarPanel.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof TroopShortcutBarApp))
          {
            localObject = (TroopShortcutBarApp)localObject;
            if (localObject != null)
            {
              long l = ((TroopShortcutBarApp)localObject).b();
              localObject = localAppShortcutBarPanel.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                if (((Long)((Iterator)localObject).next()).longValue() == l)
                {
                  j = 1;
                  break label205;
                }
              }
              int j = 0;
              label205:
              if (j == 0)
              {
                localAppShortcutBarPanel.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
                ReportController.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), str, String.valueOf(localTroopInfo.dwGroupClassExt), "");
                if (l == 101914115L) {
                  QQGameTroopManager.a(0, str, true);
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */