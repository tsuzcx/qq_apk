package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.List;

public class PopupMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private PopupMenuDialog.MenuItem jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = null;
  private PopupMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener;
  private PopupMenuDialog.OnDismissListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  private PopupMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = a(paramContext, 2131298899) * paramInt + a(paramContext, 2131298897);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562927, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363856);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    a(paramActivity, paramList, (LinearLayout)localBounceScrollView.findViewById(2131365294));
    return localView;
  }
  
  private static View a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, boolean paramBoolean, int paramInt)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562927, null);
    Object localObject1 = (BounceScrollView)localView.findViewById(2131363856);
    if (paramInt != -1) {
      ((BounceScrollView)localObject1).setBackgroundResource(paramInt);
    }
    LinearLayout localLinearLayout = (LinearLayout)((BounceScrollView)localObject1).findViewById(2131365294);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    new LinearLayout.LayoutParams(-1, 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(paramActivity, 2131298899));
    paramInt = 0;
    PopupMenuDialog.MenuItem localMenuItem;
    Object localObject2;
    if (paramInt < paramList.size())
    {
      localMenuItem = (PopupMenuDialog.MenuItem)paramList.get(paramInt);
      if (paramInt == 0)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562926, null);
        localObject1 = null;
      }
    }
    for (;;)
    {
      Object localObject3 = (ImageView)((LinearLayout)localObject2).findViewById(2131368992);
      TextView localTextView = (TextView)((LinearLayout)localObject2).findViewById(2131379262);
      if (localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        ((ImageView)localObject3).setImageDrawable(localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable);
        label173:
        if ((localMenuItem.jdField_b_of_type_Int == 0) && (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          ((ImageView)localObject3).setVisibility(8);
          ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(localMenuItem.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(localMenuItem.jdField_b_of_type_JavaLangString)) {
          localTextView.setTextColor(Color.parseColor(localMenuItem.jdField_b_of_type_JavaLangString));
        }
        if (localMenuItem.jdField_a_of_type_Float > 0.0F) {
          localTextView.setTextSize(localMenuItem.jdField_a_of_type_Float);
        }
        if (TextUtils.isEmpty(localMenuItem.c)) {
          break label485;
        }
        ((LinearLayout)localObject2).setContentDescription(localMenuItem.c + HardCodeUtil.a(2131708323));
        label301:
        if (localObject1 != null) {
          localLinearLayout.addView((View)localObject1);
        }
        ((LinearLayout)localObject2).setTag(localMenuItem);
        if (localMenuItem.jdField_a_of_type_Int > 0) {
          ((LinearLayout)localObject2).setId(localMenuItem.jdField_a_of_type_Int);
        }
        localLinearLayout.addView((View)localObject2, localLayoutParams);
        paramInt += 1;
        break;
        if (paramInt == paramList.size() - 1)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562924, null);
          if (!paramBoolean) {
            break label528;
          }
          localObject3 = a(paramActivity);
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
        }
        if (!paramBoolean) {
          break label522;
        }
      }
      label522:
      for (localObject1 = a(paramActivity);; localObject1 = null)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562925, null);
        break;
        if (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
        {
          ((ImageView)localObject3).setImageDrawable(localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          break label173;
        }
        if (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          ((ImageView)localObject3).setImageDrawable(localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label173;
        }
        ((ImageView)localObject3).setImageResource(localMenuItem.jdField_b_of_type_Int);
        break label173;
        label485:
        ((LinearLayout)localObject2).setContentDescription(localMenuItem.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708319));
        break label301;
        return localView;
      }
      label528:
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static final View a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1);
    localLayoutParams.height = 1;
    paramContext.setBackgroundColor(Color.parseColor("#DEDFE0"));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, null);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, 0);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, paramInt, false);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt, boolean paramBoolean)
  {
    return a(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, paramInt, paramBoolean, -1, 2131755032);
  }
  
  public static PopupMenuDialog a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = a(paramActivity, paramList.size(), paramBoolean);
    if (paramInt1 <= 0) {
      paramInt1 = a(paramActivity, 2131298898);
    }
    for (;;)
    {
      paramActivity = new PopupMenuDialog(paramActivity, a(paramActivity, paramList, paramBoolean, paramInt2), paramInt1, i, true);
      paramActivity.setAnimationStyle(paramInt3);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        a(paramActivity, 1002);
      }
      if (AppSetting.d) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = i;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener = paramOnDismissListener;
      paramActivity.jdField_b_of_type_Boolean = paramBoolean;
      return paramActivity;
    }
  }
  
  private static void a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, LinearLayout paramLinearLayout)
  {
    a(paramActivity, paramList, paramLinearLayout, false);
  }
  
  private static void a(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList.size())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.get(i);
      LinearLayout.LayoutParams localLayoutParams;
      Object localObject;
      label68:
      ImageView localImageView;
      if (i == 0)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(62.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562923, null);
        localImageView = (ImageView)((LinearLayout)localObject).findViewById(2131368992);
        TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131379262);
        if (localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          break label392;
        }
        localImageView.setImageDrawable(localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable);
        label110:
        if ((localMenuItem.jdField_b_of_type_Int == 0) && (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localImageView.setVisibility(8);
          ((LinearLayout)localObject).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(localMenuItem.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(localMenuItem.jdField_b_of_type_JavaLangString)) {
          localTextView.setTextColor(Color.parseColor(localMenuItem.jdField_b_of_type_JavaLangString));
        }
        if (localMenuItem.jdField_a_of_type_Float > 0.0F) {
          localTextView.setTextSize(localMenuItem.jdField_a_of_type_Float);
        }
        if (TextUtils.isEmpty(localMenuItem.c)) {
          break label447;
        }
        ((LinearLayout)localObject).setContentDescription(localMenuItem.c + HardCodeUtil.a(2131708322));
      }
      for (;;)
      {
        ((LinearLayout)localObject).setTag(localMenuItem);
        if (localMenuItem.jdField_a_of_type_Int > 0) {
          ((LinearLayout)localObject).setId(localMenuItem.jdField_a_of_type_Int);
        }
        paramLinearLayout.addView((View)localObject, localLayoutParams);
        i += 1;
        break;
        if (i == paramList.size() - 1)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(62.0F, paramActivity.getResources()));
          localObject = LayoutInflater.from(paramActivity);
          if (paramBoolean) {}
          for (int j = 2131562922;; j = 2131562921)
          {
            localObject = (LinearLayout)((LayoutInflater)localObject).inflate(j, null);
            break;
          }
        }
        localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(52.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562922, null);
        break label68;
        label392:
        if (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
        {
          localImageView.setImageDrawable(localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          break label110;
        }
        if (localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localImageView.setImageDrawable(localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label110;
        }
        localImageView.setImageResource(localMenuItem.jdField_b_of_type_Int);
        break label110;
        label447:
        ((LinearLayout)localObject).setContentDescription(localMenuItem.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708320));
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof PopupMenuDialog.MenuItem))) {
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
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.d) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setWindowLayoutType")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {}
    for (paramInt = i * AIOUtils.a(52.0F, paramContext.getResources()) + AIOUtils.a(62.0F, paramContext.getResources()) * 2;; paramInt = AIOUtils.a(62.0F, paramContext.getResources()) * paramInt) {
      return paramInt + a(paramContext, 2131298897);
    }
  }
  
  public static PopupMenuDialog b(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int j = b(paramActivity, paramList.size());
    if (LocaleManager.a()) {}
    for (int i = a(paramActivity, 2131298893);; i = a(paramActivity, 2131298892))
    {
      paramActivity = new PopupMenuDialog(paramActivity, a(paramActivity, paramList), i, j, true);
      paramActivity.setAnimationStyle(2131755032);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      a(paramActivity, 1002);
      if (AppSetting.d) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = j;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
      paramActivity.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener = paramOnDismissListener;
      paramActivity.jdField_b_of_type_Boolean = false;
      return paramActivity;
    }
  }
  
  private void b()
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
            break label245;
          }
          i = j;
        }
      }
    }
    label245:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755337;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165500));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131708321));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new PopupMenuDialog.1(this));
      }
      if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new PopupMenuDialog.2(this));
      }
      return;
    }
  }
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      while (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem != null)) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem);
        }
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = null;
        if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener != null) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener.a();
        }
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772342);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem != null)) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener.a(this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem);
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = null;
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnDismissListener.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = ((PopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.jdField_a_of_type_Int)
    {
      int i = 0;
      if (j < this.jdField_b_of_type_Int) {
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131298897) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131298899) + 1);
      }
      if (i <= 0) {
        break label130;
      }
      setHeight(a(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_b_of_type_Boolean));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = j;
      try
      {
        if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
          ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
        for (;;)
        {
          super.showAsDropDown(paramView, paramInt1, paramInt2);
          return;
          label130:
          setHeight(this.jdField_b_of_type_Int);
          break;
          this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
      for (;;)
      {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */