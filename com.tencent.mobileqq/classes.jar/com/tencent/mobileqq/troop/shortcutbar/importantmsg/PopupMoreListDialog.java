package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class PopupMoreListDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow.OnDismissListener jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ShortcutBarAIOHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper;
  private CommonAdapter jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter;
  private ImportantMessageReporter jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private ArrayList<ShortcutBarInfo> jdField_a_of_type_JavaUtilArrayList;
  private View b;
  
  public PopupMoreListDialog(BaseChatPie paramBaseChatPie, ILifeCycleHelper paramILifeCycleHelper, PopupWindow.OnDismissListener paramOnDismissListener, ImportantMessageReporter paramImportantMessageReporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = ((ShortcutBarAIOHelper)paramILifeCycleHelper);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter = paramImportantMessageReporter;
  }
  
  private void a(ViewHolder paramViewHolder, ShortcutBarInfo paramShortcutBarInfo, int paramInt)
  {
    boolean bool1 = true;
    if ((paramViewHolder == null) || (paramShortcutBarInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(paramShortcutBarInfo instanceof ShortcutBarInfo))) {
      return;
    }
    Object localObject = (ShortcutBarMoreListHolder)paramViewHolder;
    ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopShortcutbarShortcutBarInfo = paramShortcutBarInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.a(Long.valueOf(paramShortcutBarInfo.a()), Long.valueOf(paramShortcutBarInfo.b()));
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    label148:
    String str;
    if (paramInt == 0) {
      if (bool2)
      {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841015));
        if (!bool2) {
          break label399;
        }
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramShortcutBarInfo.a());
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(paramShortcutBarInfo);
        ((ShortcutBarMoreListHolder)localObject).itemView.setTag(paramShortcutBarInfo);
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new PopupMoreListDialog.5(this));
        paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext;
        localObject = ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView;
        str = paramShortcutBarInfo.b();
        if (paramShortcutBarInfo.b() != 1) {
          break label415;
        }
      }
    }
    for (;;)
    {
      TroopAppShortcutUtils.a(paramViewHolder, (ImageView)localObject, str, 19.0F, bool1);
      return;
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841014));
      break;
      if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        if (bool2)
        {
          ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841017));
          break;
        }
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841016));
        break;
      }
      if (bool2)
      {
        ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841019));
        break;
      }
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841018));
      break;
      label399:
      ((ShortcutBarMoreListHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label148;
      label415:
      bool1 = false;
    }
  }
  
  private void e()
  {
    int j = -1;
    int i;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label215;
          }
          i = j;
        }
      }
    }
    label215:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755337;
      if (this.b == null)
      {
        this.b = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        this.b.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources().getColor(2131165500));
        this.b.setOnClickListener(new PopupMoreListDialog.1(this));
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131558678, null);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379983);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379986));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379984));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 1, false));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838748));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView, ViewUtils.a(175.0F), -2, true);
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener != null) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new PopupMoreListDialog.2(this));
      return;
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838747));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter = new PopupMoreListDialog.3(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), 2131563166);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(new PopupMoreListDialog.4(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!(this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof ShortcutBarInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramView != null))
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        paramView.getLocationOnScreen(new int[2]);
        if (paramInt1 <= this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2) {
          break label155;
        }
        localLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2 + ViewUtils.a(73.0F) / 2);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label173;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
      }
      return;
      label155:
      localLayoutParams.leftMargin = (ViewUtils.a(73.0F) / 2 + paramInt1);
      break;
      label173:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
    }
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.getLayoutParams();
    if (paramArrayList.size() > 5) {}
    for (localLayoutParams.height = ViewUtils.a(247.0F);; localLayoutParams.height = -2)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      return this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label220;
      }
      paramInt1 = 0;
      ((ImportantMessageReporter)localObject).a(paramInt1);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        if (paramInt3 <= 0) {
          break label231;
        }
        ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] - paramInt3 + ViewUtils.a(73.0F) / 2);
        label93:
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label252;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
      label142:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        if (!LiuHaiUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a())) {
          break label263;
        }
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView()).addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
      }
      return;
      label220:
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label231:
      ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] + ViewUtils.a(73.0F) / 2);
      break label93;
      label252:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
      break label142;
      label263:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindowManager().addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
  }
  
  public void c()
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()))
      {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView()).removeView(this.b);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindowManager().removeView(this.b);
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
      if (LiuHaiUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a())) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView()).removeView(this.b);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindowManager().removeView(this.b);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMoreListDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog
 * JD-Core Version:    0.7.0.1
 */