package com.tencent.mobileqq.ocr.view;

import agid;
import agie;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class TranslatePopupActionSheetMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TranslatePopupActionSheetMenuDialog.MenuItem jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem;
  private TranslatePopupActionSheetMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener;
  private TranslatePopupActionSheetMenuDialog.OnDismissListener jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener;
  private boolean jdField_a_of_type_Boolean;
  
  private TranslatePopupActionSheetMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = PopupMenuDialog.a(paramContext, 2131558527) * paramInt + PopupMenuDialog.a(paramContext, 2131558951);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List paramList, boolean paramBoolean)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)LayoutInflater.from(paramActivity).inflate(2130970519, null);
    LinearLayout localLinearLayout = (LinearLayout)localBounceScrollView.findViewById(2131363062);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, PopupMenuDialog.a(paramActivity, 2131558527));
    int j = paramList.size();
    int i = 0;
    TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem;
    RelativeLayout localRelativeLayout;
    if (i < j)
    {
      localMenuItem = (TranslatePopupActionSheetMenuDialog.MenuItem)paramList.get(i);
      localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramActivity).inflate(2130968600, null);
      localRelativeLayout.setBackgroundResource(2130842960);
      if ((!paramBoolean) || (i <= 0)) {
        break label329;
      }
    }
    label167:
    label329:
    for (View localView = PopupMenuDialog.a(paramActivity);; localView = null)
    {
      ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131362817);
      TextView localTextView = (TextView)localRelativeLayout.findViewById(2131362816);
      localTextView.setText(localMenuItem.b);
      if (localMenuItem.jdField_a_of_type_Boolean)
      {
        localImageView.setVisibility(0);
        if (!TextUtils.isEmpty(localMenuItem.c)) {
          localTextView.setTextColor(Color.parseColor(localMenuItem.c));
        }
        if (localMenuItem.jdField_a_of_type_Float > 0.0F) {
          localTextView.setTextSize(localMenuItem.jdField_a_of_type_Float);
        }
        if (TextUtils.isEmpty(localMenuItem.d)) {
          break label295;
        }
        localRelativeLayout.setContentDescription(localMenuItem.d + " 按钮");
      }
      for (;;)
      {
        if (localView != null) {
          localLinearLayout.addView(localView);
        }
        localRelativeLayout.setTag(localMenuItem);
        localLinearLayout.addView(localRelativeLayout, localLayoutParams);
        i += 1;
        break;
        localImageView.setVisibility(8);
        break label167;
        localRelativeLayout.setContentDescription(localMenuItem.b + " 按钮");
      }
      return localBounceScrollView;
    }
  }
  
  public static TranslatePopupActionSheetMenuDialog a(Activity paramActivity, List paramList, TranslatePopupActionSheetMenuDialog.OnClickActionListener paramOnClickActionListener, TranslatePopupActionSheetMenuDialog.OnDismissListener paramOnDismissListener, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = a(paramActivity, paramList.size(), paramBoolean);
    if (paramInt <= 0) {
      paramInt = -1;
    }
    for (;;)
    {
      paramActivity = new TranslatePopupActionSheetMenuDialog(paramActivity, a(paramActivity, paramList, paramBoolean), paramInt, i, true);
      paramActivity.setAnimationStyle(2131624679);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        PopupMenuDialog.a(paramActivity, 1002);
      }
      if (AppSetting.b) {
        PopupMenuDialog.a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_a_of_type_Int = i;
      paramActivity.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener = paramOnClickActionListener;
      paramActivity.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener = paramOnDismissListener;
      paramActivity.jdField_a_of_type_Boolean = paramBoolean;
      return paramActivity;
    }
  }
  
  private void a()
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
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label231;
          }
          i = j;
        }
      }
    }
    label231:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131624681;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1291845632);
        this.jdField_a_of_type_AndroidViewView.setContentDescription("返回");
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new agid(this));
      }
      if ((AppSetting.b) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new agie(this));
      }
      return;
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof TranslatePopupActionSheetMenuDialog.MenuItem))) {
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
  
  public void dismiss()
  {
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem != null)) {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem);
        }
        this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener.a();
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
            QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2131034402);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt)
  {
    Rect localRect = new Rect();
    paramView.getRootView().getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return localRect.bottom - (arrayOfInt[1] + paramView.getHeight()) - paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TranslatePopupActionSheetMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = null;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$OnDismissListener.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslatePopupActionSheetMenuDialog$MenuItem = ((TranslatePopupActionSheetMenuDialog.MenuItem)paramView.getTag());
    dismiss();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = getMaxAvailableHeight(paramView, paramInt2);
    if (i < this.jdField_a_of_type_Int) {
      setHeight(i);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      super.showAsDropDown(paramView, paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.i("TranslatePopupActionSheetMenuDialog", 2, "showAsDropDown " + isAboveAnchor());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TranslatePopupActionSheetMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog
 * JD-Core Version:    0.7.0.1
 */