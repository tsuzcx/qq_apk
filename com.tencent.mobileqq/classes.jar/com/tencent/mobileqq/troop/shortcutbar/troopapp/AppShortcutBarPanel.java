package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class AppShortcutBarPanel
  extends IAppShortcutBarDataUI
{
  private long jdField_a_of_type_Long;
  protected View.OnClickListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ShortcutBarAIOHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper;
  private AppShortcutBarPanel.ScrollInfo jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private LinearLayout c;
  
  public AppShortcutBarPanel(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new AppShortcutBarPanel.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372724));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372714));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372722));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = ((ShortcutBarAIOHelper)paramILifeCycleHelper);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.b();
  }
  
  private void a(TroopShortcutBarApp paramTroopShortcutBarApp, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(paramTroopShortcutBarApp);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131378033);
    ((TextView)localObject).setText(paramTroopShortcutBarApp.a());
    label98:
    String str;
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131378030);
      if (!bool2) {
        break label221;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838748));
      localObject = (TextView)paramView.findViewById(2131378032);
      if ((paramTroopShortcutBarApp.c() == 0) && (!paramTroopShortcutBarApp.b())) {
        break label244;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130838065, 0, 0, 0);
      label152:
      paramView = (URLImageView)paramView.findViewById(2131378031);
      if (!bool2) {
        break label253;
      }
      paramView.setColorFilter(1996488704);
      label173:
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext;
      str = paramTroopShortcutBarApp.b();
      if (paramTroopShortcutBarApp.b() != 1) {
        break label261;
      }
    }
    for (;;)
    {
      TroopAppShortcutUtils.a((Context)localObject, paramView, str, 19.0F, bool1);
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label221:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838747));
      break label98;
      label244:
      ((TextView)localObject).setVisibility(4);
      break label152;
      label253:
      paramView.setColorFilter(0);
      break label173;
      label261:
      bool1 = false;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    TroopShortcutBarApp localTroopShortcutBarApp = TroopShortcutBarApp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696186), "https://sola.gtimg.cn/aoi/sola/20200528211216_3ydkcWft2I.png");
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561699, null);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (this.c.getChildCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.i();
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_b_of_type_AndroidWidgetLinearLayout == null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.c.getChildCount() == 0) {}
    for (int i = 1;; i = 0)
    {
      long l2 = 0L;
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo = new AppShortcutBarPanel.ScrollInfo();
      paramArrayList = paramArrayList.iterator();
      boolean bool = false;
      int j = 1;
      for (;;)
      {
        Object localObject;
        if (paramArrayList.hasNext())
        {
          localObject = (ShortcutBarInfo)paramArrayList.next();
          if ((localObject != null) && ((localObject instanceof TroopShortcutBarApp))) {
            localObject = (TroopShortcutBarApp)localObject;
          }
        }
        else
        {
          long l1;
          label812:
          for (;;)
          {
            for (;;)
            {
              try
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
                  break label812;
                }
                View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561699, null);
                a((TroopShortcutBarApp)localObject, localView);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
                localView.setId((int)((TroopShortcutBarApp)localObject).b());
                this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_b_of_type_Int = localView.getWidth();
                if (i == 0) {
                  break label812;
                }
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
                localLayoutParams.setMargins(AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources()), 0, 0, 0);
                localView.setLayoutParams(localLayoutParams);
                i = 0;
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
                    if (!((TroopShortcutBarApp)localObject).c()) {
                      continue;
                    }
                    l1 = ((TroopShortcutBarApp)localObject).c();
                    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int = j;
                    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Long = ((TroopShortcutBarApp)localObject).b();
                  }
                }
                if (j == 4) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_b_of_type_Long = ((TroopShortcutBarApp)localObject).b();
                }
                if (!((TroopShortcutBarApp)localObject).c()) {
                  break label815;
                }
                ((TroopShortcutBarApp)localObject).c(false);
                break label815;
                l1 = l2;
                if (!((TroopShortcutBarApp)localObject).b()) {
                  continue;
                }
                l1 = l2;
                if (((TroopShortcutBarApp)localObject).c() <= l2) {
                  continue;
                }
                l2 = ((TroopShortcutBarApp)localObject).c();
                l1 = l2;
                if (j <= this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Int = j;
                this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopappAppShortcutBarPanel$ScrollInfo.jdField_a_of_type_Long = ((TroopShortcutBarApp)localObject).b();
                l1 = l2;
                continue;
                this.jdField_a_of_type_Boolean = bool;
              }
              catch (OutOfMemoryError paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got OOM, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              catch (InflateException paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              if ((bool) && (paramBoolean)) {}
              try
              {
                f();
                if (bool)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.h();
                  if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                  {
                    this.jdField_b_of_type_Boolean = true;
                    paramArrayList = String.valueOf(this.jdField_a_of_type_Long);
                    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramArrayList);
                    if (localObject == null) {
                      break;
                    }
                    ReportController.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", paramArrayList, String.valueOf(((TroopInfo)localObject).dwGroupClassExt), "");
                    TroopEssenceReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true);
                    TroopEssenceReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true);
                  }
                  ThreadManager.getUIHandler().postDelayed(new AppShortcutBarPanel.1(this), 800L);
                  return;
                }
              }
              catch (OutOfMemoryError paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "AppShortcutBarPanel.updateAppShortcutPanel ManageBtn got OOM, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
              catch (InflateException paramArrayList)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateAppShortcutPanel ManageBtn got InflateException, e:" + paramArrayList.getMessage());
                }
                System.gc();
                return;
              }
            }
            this.jdField_a_of_type_Boolean = false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.i();
            return;
          }
          label815:
          j += 1;
          bool = true;
          l2 = l1;
        }
      }
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    String str;
    TroopInfo localTroopInfo;
    do
    {
      return;
      str = String.valueOf(this.jdField_a_of_type_Long);
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
    } while (localTroopInfo == null);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
    int i = 0;
    label89:
    long l;
    if (i < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof TroopShortcutBarApp))
        {
          localObject = (TroopShortcutBarApp)localObject;
          if (localObject != null)
          {
            l = ((TroopShortcutBarApp)localObject).b();
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (((Long)((Iterator)localObject).next()).longValue() != l);
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        ReportController.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), str, String.valueOf(localTroopInfo.dwGroupClassExt), "");
        if (l == 101914115L) {
          QQGameTroopManager.a(0, str, true);
        }
      }
      i += 1;
      break label89;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */