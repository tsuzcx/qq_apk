package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PopupMoreListDialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow.OnDismissListener jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TroopAppShortcutBarHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private CommonAdapter jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
  private ImportantMessageReporter jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private ArrayList<ShortcutBarInfo> jdField_a_of_type_JavaUtilArrayList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private View b;
  
  public PopupMoreListDialog(AIOShortcutBarContext paramAIOShortcutBarContext, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper, PopupWindow.OnDismissListener paramOnDismissListener, ImportantMessageReporter paramImportantMessageReporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper = paramTroopAppShortcutBarHelper;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter = paramImportantMessageReporter;
    this.jdField_a_of_type_AndroidAppActivity = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_AndroidContentContext = paramAIOShortcutBarContext.a();
  }
  
  private void a(ViewHolder paramViewHolder, ShortcutBarInfo paramShortcutBarInfo, int paramInt)
  {
    if ((paramViewHolder != null) && (paramShortcutBarInfo != null))
    {
      if (!(paramShortcutBarInfo instanceof ShortcutBarInfo)) {
        return;
      }
      Object localObject = (ShortcutBarMoreListHolder)paramViewHolder;
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopShortcutbarShortcutBarInfo = paramShortcutBarInfo;
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
      if (paramViewHolder != null) {
        paramViewHolder.a(Long.valueOf(paramShortcutBarInfo.a()), Long.valueOf(paramShortcutBarInfo.b()));
      }
      boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
      boolean bool1 = true;
      if (paramInt == 0)
      {
        if (bool2) {
          ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840890));
        } else {
          ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840889));
        }
      }
      else if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        if (bool2) {
          ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840892));
        } else {
          ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840891));
        }
      }
      else if (bool2) {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840894));
      } else {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840893));
      }
      if (bool2)
      {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
      }
      else
      {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      }
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramShortcutBarInfo.a());
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(paramShortcutBarInfo);
      ((ShortcutBarMoreListHolder)localObject).itemView.setTag(paramShortcutBarInfo);
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new PopupMoreListDialog.5(this));
      paramViewHolder = this.jdField_a_of_type_AndroidContentContext;
      localObject = ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView;
      String str = paramShortcutBarInfo.b();
      if (paramShortcutBarInfo.b() != 1) {
        bool1 = false;
      }
      TroopAppShortcutUtils.a(paramViewHolder, (ImageView)localObject, str, 19.0F, bool1);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.type = 1000;
      localLayoutParams.format = -3;
      localLayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      int j = -1;
      localLayoutParams.width = -1;
      int i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i <= 0) {
            i = j;
          }
        }
      }
      localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.height = i;
      localLayoutParams.windowAnimations = 2131755514;
    }
    if (this.b == null)
    {
      this.b = new View(this.jdField_a_of_type_AndroidAppActivity);
      this.b.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165476));
      this.b.setOnClickListener(new PopupMoreListDialog.1(this));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558576, null);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout)((View)localObject).findViewById(2131379312);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379315));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379313));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838593));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838592));
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView, ViewUtils.a(175.0F), -2, true);
    localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new PopupMoreListDialog.2(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter = new PopupMoreListDialog.3(this, this.jdField_a_of_type_AndroidAppActivity, 2131562989);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(new PopupMoreListDialog.4(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!(localArrayList.get(0) instanceof ShortcutBarInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.notifyDataSetChanged();
  }
  
  public int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void a()
  {
    f();
    g();
    h();
    e();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localObject != null) && (paramView != null))
      {
        localObject = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        if (localObject != null)
        {
          paramView.getLocationOnScreen(new int[2]);
          if (paramInt1 > this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2) {
            ((LinearLayout.LayoutParams)localObject).leftMargin = (this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2 + ViewUtils.a(73.0F) / 2);
          } else {
            ((LinearLayout.LayoutParams)localObject).leftMargin = (ViewUtils.a(73.0F) / 2 + paramInt1);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = this.jdField_a_of_type_MqqAppAppRuntime;
          if (paramView != null) {
            if (ThemeUtil.isInNightMode(paramView)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
            } else {
              this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1, paramInt2, paramInt3, paramInt4);
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
        if (paramView != null) {
          paramView.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localObject = ((OverScrollRecyclerView)localObject).getLayoutParams();
      if (paramArrayList.size() > 5) {
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.a(247.0F);
      } else {
        ((ViewGroup.LayoutParams)localObject).height = -2;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
      if (paramArrayList != null)
      {
        paramArrayList.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public boolean a()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      return localPopupWindow.isShowing();
    }
    return false;
  }
  
  public void b()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramView != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((ArrayList)localObject2).size();
      }
      ((ImportantMessageReporter)localObject1).a(paramInt1);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject1 != null)
      {
        localObject2 = new int[2];
        paramView.getLocationOnScreen((int[])localObject2);
        if (paramInt3 > 0) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = (localObject2[0] - paramInt3 + ViewUtils.a(73.0F) / 2);
        } else {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = (localObject2[0] + ViewUtils.a(73.0F) / 2);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
        if (localObject1 != null) {
          if (ThemeUtil.isInNightMode((AppRuntime)localObject1)) {
            this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
          } else {
            this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
          }
        }
      }
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt2, paramInt3, paramInt4);
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
      if (paramView != null) {
        paramView.notifyDataSetChanged();
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity))
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.b);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.b);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMoreListDialog", 2, localException.toString());
      }
    }
  }
  
  public void d()
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.b);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.b);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMoreListDialog", 2, localException.toString());
      }
    }
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog
 * JD-Core Version:    0.7.0.1
 */