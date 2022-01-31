package com.tencent.mobileqq.widget;

import akgl;
import akgm;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class LeftPopupMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  public int a;
  public Activity a;
  public View a;
  public WindowManager.LayoutParams a;
  public Animation a;
  public PopupWindow.OnDismissListener a;
  public LeftPopupMenuDialog.IItemAdapter a;
  public LeftPopupMenuDialog.MenuItem a;
  public LeftPopupMenuDialog.OnClickActionListener a;
  public int b;
  
  private LeftPopupMenuDialog(Activity paramActivity, View paramView, LeftPopupMenuDialog.IItemAdapter paramIItemAdapter, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter = paramIItemAdapter;
    b();
  }
  
  private int a()
  {
    Object localObject1 = (LinearLayout)getContentView().findViewById(2131363039);
    int m = ((LinearLayout)localObject1).getChildCount();
    int j = PopupMenuDialog.a(this.jdField_a_of_type_AndroidAppActivity, 2131558949);
    int i = 0;
    if (i < m)
    {
      Object localObject2 = ((LinearLayout)localObject1).getChildAt(i);
      if ((((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof LeftPopupMenuDialog.MenuItem))) {
        localObject2 = (LeftPopupMenuDialog.MenuItem)((View)localObject2).getTag();
      }
      for (int k = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter.a((LeftPopupMenuDialog.MenuItem)localObject2, i, m);; k = ((View)localObject2).getMeasuredHeight())
      {
        if ((i > 6) || (j + k >= this.jdField_a_of_type_Int)) {
          break label141;
        }
        j += k;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("LeftPopupMenuDialog", 2, "getDisplayHeight() get a error, item view not set tag");
        }
      }
    }
    label141:
    if (QLog.isColorLevel()) {
      QLog.d("LeftPopupMenuDialog", 2, "getDisplayHeight() height = " + j);
    }
    if (j < this.b)
    {
      localObject1 = getContentView();
      if ((localObject1 != null) && ((localObject1 instanceof BounceScrollView))) {
        ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(true);
      }
    }
    return j;
  }
  
  public static LeftPopupMenuDialog a(Activity paramActivity, List paramList, LeftPopupMenuDialog.IItemAdapter paramIItemAdapter, LeftPopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupWindow.OnDismissListener paramOnDismissListener)
  {
    if ((paramIItemAdapter == null) || (paramList == null) || (paramActivity == null)) {
      throw new IllegalArgumentException("parameter itemAdapter can not be null.");
    }
    BounceScrollView localBounceScrollView = (BounceScrollView)LayoutInflater.from(paramActivity).inflate(2130971561, null);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    paramActivity = new LeftPopupMenuDialog(paramActivity, localBounceScrollView, paramIItemAdapter, -2, -2, true);
    paramActivity.setAnimationStyle(2131624679);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    if (Build.VERSION.SDK_INT >= 9) {
      PopupMenuDialog.a(paramActivity, 1002);
    }
    if (AppSetting.b) {
      PopupMenuDialog.a(paramActivity);
    }
    paramActivity.a(paramList);
    paramActivity.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
    paramActivity.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    return paramActivity;
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeftPopupMenuDialog", 2, "initListeners()");
    }
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof LeftPopupMenuDialog.MenuItem))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  @TargetApi(14)
  private void b()
  {
    int j = -1;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
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
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label247;
          }
          i = j;
        }
      }
    }
    label247:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131624680;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492885));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("返回");
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new akgl(this));
      }
      if ((!AppSetting.b) || (Build.VERSION.SDK_INT < 14)) {
        break;
      }
      getContentView().setAccessibilityDelegate(new akgm(this));
      return;
    }
  }
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeftPopupMenuDialog", 2, "updateItemViews()");
    }
    LinearLayout localLinearLayout = (LinearLayout)getContentView().findViewById(2131363039);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter == null) || (localLinearLayout == null)) {}
    do
    {
      return;
      localLinearLayout.removeAllViews();
    } while ((paramList == null) || (paramList.size() == 0));
    int i1 = paramList.size();
    int j = PopupMenuDialog.a(this.jdField_a_of_type_AndroidAppActivity, 2131558949);
    int i = -2;
    int k = 0;
    int m;
    if (k < i1)
    {
      LeftPopupMenuDialog.MenuItem localMenuItem = (LeftPopupMenuDialog.MenuItem)paramList.get(k);
      View localView = localLinearLayout.getChildAt(k);
      if (localView == null)
      {
        m = 1;
        label121:
        localView = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter.a(localView, localMenuItem, k, i1);
        if (localView == null) {
          break label291;
        }
        localView.setTag(localMenuItem);
        int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter.a(localMenuItem, k, i1);
        int n = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$IItemAdapter.b(localMenuItem, k, i1);
        if (m != 0) {
          localLinearLayout.addView(localView, new LinearLayout.LayoutParams(n, i2));
        }
        if (i >= n) {
          break label288;
        }
        i = n;
        label218:
        j += i2;
      }
    }
    label288:
    label291:
    for (;;)
    {
      k += 1;
      break;
      m = 0;
      break label121;
      if (this.b != j)
      {
        this.b = j;
        if (this.jdField_a_of_type_Int != 0) {
          setHeight(a());
        }
      }
      if (getWidth() != i) {
        setWidth(i);
      }
      a(getContentView());
      return;
      break label218;
    }
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeftPopupMenuDialog", 2, "dismiss()");
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem = null;
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener != null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener.onDismiss();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LeftPopupMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())) || (this.jdField_a_of_type_AndroidAppActivity == null));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2131034419);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LeftPopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem = null;
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener.onDismiss();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LeftPopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog$MenuItem = ((LeftPopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeftPopupMenuDialog", 2, "showAsDropDown()");
    }
    int i = getMaxAvailableHeight(paramView, paramInt2);
    if (i != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      setHeight(a());
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      View localView = getContentView();
      if ((localView != null) && ((localView instanceof BounceScrollView))) {
        ((BounceScrollView)localView).scrollTo(0, 0);
      }
      super.showAsDropDown(paramView, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LeftPopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LeftPopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */