package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import bfni;
import bfpq;
import bfpr;
import bfps;
import bfpt;
import bfpu;
import bfpv;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BubblePopupWindow
  implements View.OnClickListener
{
  private static final int[] jdField_c_of_type_ArrayOfInt = { 16842922 };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnScrollChangedListener jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener = new bfpq(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bfpr jdField_a_of_type_Bfpr;
  private bfps jdField_a_of_type_Bfps;
  private bfpt jdField_a_of_type_Bfpt;
  private bfpv jdField_a_of_type_Bfpv;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bfpr jdField_b_of_type_Bfpr;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = -1;
  private bfpr jdField_c_of_type_Bfpr;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = 1000;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int = -1;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = true;
  private int p;
  
  public BubblePopupWindow()
  {
    this(null, 0, 0);
  }
  
  public BubblePopupWindow(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842870);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    this(paramView, paramInt1, paramInt2, false);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    }
    a(paramView);
    e(paramInt1);
    d(paramInt2);
    a(paramBoolean);
  }
  
  private int a()
  {
    if (this.jdField_n_of_type_Int == -1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean) {
          return 2131755173;
        }
        return 2131755172;
      }
      return 0;
    }
    return this.jdField_n_of_type_Int;
  }
  
  private int a(int paramInt)
  {
    paramInt = 0xFF797DE7 & paramInt;
    int i1 = paramInt;
    if (this.jdField_n_of_type_Boolean) {
      i1 = paramInt | 0x8000;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      i1 |= 0x8;
      paramInt = i1;
      if (this.jdField_a_of_type_Int == 1) {
        paramInt = i1 | 0x20000;
      }
    }
    for (;;)
    {
      i1 = paramInt;
      if (!this.jdField_d_of_type_Boolean) {
        i1 = paramInt | 0x10;
      }
      paramInt = i1;
      if (this.jdField_e_of_type_Boolean) {
        paramInt = i1 | 0x40000;
      }
      i1 = paramInt;
      if (!this.jdField_f_of_type_Boolean) {
        i1 = paramInt | 0x200;
      }
      paramInt = i1;
      if (a()) {
        paramInt = i1 | 0x800000;
      }
      i1 = paramInt;
      if (this.jdField_g_of_type_Boolean) {
        i1 = paramInt | 0x100;
      }
      paramInt = i1;
      if (this.jdField_j_of_type_Boolean) {
        paramInt = i1 | 0x10000;
      }
      i1 = paramInt;
      if (this.jdField_l_of_type_Boolean) {
        i1 = paramInt | 0x20;
      }
      return i1;
      paramInt = i1;
      if (this.jdField_a_of_type_Int == 2) {
        paramInt = i1 | 0x20000;
      }
    }
  }
  
  private WindowManager.LayoutParams a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 51;
    int i1 = this.jdField_e_of_type_Int;
    this.jdField_f_of_type_Int = i1;
    localLayoutParams.width = i1;
    i1 = this.jdField_h_of_type_Int;
    this.jdField_i_of_type_Int = i1;
    localLayoutParams.height = i1;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {}
    for (localLayoutParams.format = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getOpacity();; localLayoutParams.format = -3)
    {
      localLayoutParams.flags = a(localLayoutParams.flags);
      localLayoutParams.type = this.jdField_m_of_type_Int;
      localLayoutParams.token = paramIBinder;
      localLayoutParams.softInputMode = this.jdField_b_of_type_Int;
      localLayoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
      return localLayoutParams;
    }
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    a(paramLayoutParams, false);
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewWindowManager == null)) {
      throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }
    bfpu localbfpu = new bfpu(this, this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    if (paramBoolean) {
      ((FrameLayout)localObject).setOnClickListener(this);
    }
    int i2;
    int i1;
    if (paramBoolean)
    {
      i2 = Math.round(TypedValue.applyDimension(1, 5.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
      i1 = Math.round(TypedValue.applyDimension(1, 5.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
    }
    for (;;)
    {
      ((FrameLayout)localObject).setPadding(i2, Math.round(TypedValue.applyDimension(1, 8.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())), i1, Math.round(TypedValue.applyDimension(1, 8.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())));
      localbfpu.addView((View)localObject, -1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838590);
      this.jdField_a_of_type_Bfpr = new bfpr(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838591));
      localObject = new LayerDrawable(new Drawable[] { localObject, this.jdField_a_of_type_Bfpr });
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
      localObject = new FrameLayout.LayoutParams(-1, -1, 17);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject = new FrameLayout.LayoutParams(-2, -2, 51);
      this.jdField_b_of_type_Bfpr = new bfpr(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838589));
      LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838588), this.jdField_b_of_type_Bfpr });
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(localLayerDrawable);
      localbfpu.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject = new FrameLayout.LayoutParams(-2, -2, 83);
      this.jdField_c_of_type_Bfpr = new bfpr(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838587));
      localLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838586), this.jdField_c_of_type_Bfpr });
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localLayerDrawable);
      localbfpu.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidViewView = localbfpu;
      this.jdField_j_of_type_Int = paramLayoutParams.width;
      this.jdField_k_of_type_Int = paramLayoutParams.height;
      return;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_m_of_type_Boolean = paramBoolean;
    Object localObject;
    ImageView localImageView;
    if (!paramBoolean)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        break label86;
      }
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      label25:
      int i1 = ((View)localObject).getMeasuredWidth();
      ((View)localObject).setVisibility(0);
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (paramInt - i1 / 2);
      if (!this.jdField_m_of_type_Boolean) {
        break label95;
      }
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 1;
    }
    for (;;)
    {
      localImageView.setVisibility(4);
      return;
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      break;
      label86:
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      break label25;
      label95:
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 1;
    }
  }
  
  private boolean a(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    View localView = paramView.getRootView();
    paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramInt1);
    paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
    paramLayoutParams.gravity = 83;
    paramView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
    Rect localRect1 = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect2);
    int i1 = this.jdField_j_of_type_Int;
    int i3 = this.jdField_k_of_type_Int;
    int i2;
    if (this.jdField_j_of_type_Int != -2)
    {
      i2 = i1;
      if (this.jdField_k_of_type_Int != -2) {}
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.jdField_j_of_type_Int == -2) {
        i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      }
      i2 = i1;
      if (this.jdField_k_of_type_Int == -2)
      {
        i3 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        i2 = i1;
      }
    }
    for (i1 = i3;; i1 = i3)
    {
      if (i2 > 0) {
        paramLayoutParams.x = (this.jdField_b_of_type_ArrayOfInt[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
      }
      boolean bool;
      if ((this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - i1 < localRect1.top) || (paramLayoutParams.x + i2 - localView.getWidth() > 0)) {
        if (this.jdField_i_of_type_Boolean)
        {
          i3 = paramView.getScrollX();
          int i4 = paramView.getScrollY();
          paramView.requestRectangleOnScreen(new Rect(i3, i4, i3 + i2 + paramInt1, i4 + i1 + paramView.getHeight() + paramInt2), true);
          paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          if (i2 > 0)
          {
            paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
            paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
            paramView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
          }
        }
        else
        {
          if (this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - i1 >= localRect1.top) {
            break label716;
          }
          if (i1 + localRect2.bottom + paramInt2 <= localRect1.bottom) {
            break label683;
          }
          paramLayoutParams.y = (localRect2.top + localRect2.height() / 2 + paramInt2);
          i1 = 1;
          bool = true;
          label427:
          if (this.jdField_h_of_type_Boolean)
          {
            i3 = localRect1.right - localRect1.left;
            i2 += paramLayoutParams.x;
            if (i2 > i3) {
              paramLayoutParams.x -= i2 - i3;
            }
            if (paramLayoutParams.x < localRect1.left)
            {
              paramLayoutParams.x = localRect1.left;
              paramLayoutParams.width = Math.min(paramLayoutParams.width, i3);
            }
            if ((!bool) || (i1 != 0)) {
              break label738;
            }
            paramInt2 = this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - this.jdField_k_of_type_Int;
            if (paramInt2 < 0) {
              paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);
            }
            paramLayoutParams.gravity |= 0x10000000;
          }
          label553:
          if ((bool) && (i1 == 0)) {
            paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
          }
          paramInt2 = this.jdField_b_of_type_ArrayOfInt[0];
          i1 = paramView.getWidth() / 2;
          i2 = paramLayoutParams.x;
          if (!bool) {
            break label757;
          }
          i3 = Math.round(TypedValue.applyDimension(1, 5.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
        }
      }
      for (paramLayoutParams.y -= i3;; paramLayoutParams.y -= i3)
      {
        a(bool, paramInt2 + i1 + paramInt1 - i2);
        return bool;
        paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramInt1);
        break;
        label683:
        paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramView.getHeight() + paramInt2);
        paramLayoutParams.gravity = 51;
        bool = false;
        i1 = 0;
        break label427;
        label716:
        paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
        i1 = 0;
        bool = true;
        break label427;
        label738:
        paramLayoutParams.y = Math.max(paramLayoutParams.y, localRect1.top);
        break label553;
        label757:
        i3 = Math.round(TypedValue.applyDimension(1, 3.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
      }
    }
  }
  
  private boolean a(WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, View paramView)
  {
    Object localObject = paramView.getRootView();
    paramLayoutParams.x = paramInt1;
    paramLayoutParams.y = paramInt2;
    boolean bool;
    Rect localRect;
    int i1;
    int i3;
    if (this.jdField_k_of_type_Boolean)
    {
      bool = false;
      paramLayoutParams.gravity = 51;
      localRect = new Rect();
      paramView.getWindowVisibleDisplayFrame(localRect);
      i1 = this.jdField_j_of_type_Int;
      i3 = this.jdField_k_of_type_Int;
      if (this.jdField_j_of_type_Int != -2)
      {
        i2 = i1;
        if (this.jdField_k_of_type_Int != -2) {
          break label515;
        }
      }
      this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.jdField_j_of_type_Int == -2) {
        i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      }
      i2 = i1;
      if (this.jdField_k_of_type_Int != -2) {
        break label515;
      }
    }
    for (int i2 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();; i2 = i3)
    {
      if (i1 > 0) {
        paramLayoutParams.x = (paramInt1 - i1 / 2);
      }
      i3 = localRect.top;
      if (this.jdField_l_of_type_Int > 0) {
        i3 = 0;
      }
      if ((!this.jdField_k_of_type_Boolean) && ((paramInt2 - i2 < i3) || (paramInt1 + i1 - ((View)localObject).getWidth() > 0)) && (paramInt2 - i2 < i3))
      {
        paramLayoutParams.gravity = 51;
        bool = false;
      }
      for (;;)
      {
        if (this.jdField_h_of_type_Boolean)
        {
          i2 = localRect.right - localRect.left;
          i1 = paramLayoutParams.x + i1;
          if (i1 > i2) {
            paramLayoutParams.x -= i1 - i2;
          }
          if (paramLayoutParams.x < localRect.left)
          {
            paramLayoutParams.x = localRect.left;
            paramLayoutParams.width = Math.min(paramLayoutParams.width, i2);
          }
          if (!bool) {
            break label488;
          }
          paramInt2 -= this.jdField_k_of_type_Int;
          if (paramInt2 >= 0) {}
        }
        label488:
        for (paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);; paramLayoutParams.y = Math.max(paramLayoutParams.y + this.jdField_l_of_type_Int, localRect.top))
        {
          paramLayoutParams.gravity |= 0x10000000;
          if (bool) {
            paramLayoutParams.y = (((View)localObject).getHeight() - paramLayoutParams.y);
          }
          a(bool, paramInt1 - paramLayoutParams.x);
          if ((Build.VERSION.SDK_INT >= 24) && ((paramView.getContext() instanceof Activity)) && (((Activity)paramView.getContext()).isInMultiWindowMode()))
          {
            localObject = new int[2];
            ((Activity)paramView.getContext()).getWindow().getDecorView().getLocationOnScreen((int[])localObject);
            if (localObject[1] > 10) {
              paramLayoutParams.y += localObject[1];
            }
            if (localObject[0] > 10) {
              paramLayoutParams.x -= localObject[0];
            }
          }
          return bool;
          bool = true;
          paramLayoutParams.gravity = 83;
          break;
        }
      }
      label515:
      i1 = i2;
    }
  }
  
  @TargetApi(14)
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      paramLayoutParams.packageName = this.jdField_a_of_type_AndroidContentContext.getPackageName();
    }
    if (bfni.d()) {
      this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutParams);
    }
  }
  
  private void c(View paramView, int paramInt1, int paramInt2)
  {
    d();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    paramView = paramView.getViewTreeObserver();
    if (paramView != null) {
      paramView.addOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
    }
    this.jdField_o_of_type_Int = paramInt1;
    this.p = paramInt2;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramInt3 != -1)
    {
      this.jdField_f_of_type_Int = paramInt3;
      e(paramInt3);
    }
    if (paramInt4 != -1)
    {
      this.jdField_i_of_type_Int = paramInt4;
      d(paramInt4);
    }
    if ((!b()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label282:
    label290:
    label291:
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i1;
      if (this.jdField_d_of_type_Int < 0)
      {
        i1 = this.jdField_d_of_type_Int;
        boolean bool1 = paramBoolean;
        if (paramInt3 != -1)
        {
          bool1 = paramBoolean;
          if (localLayoutParams.width != i1)
          {
            this.jdField_f_of_type_Int = i1;
            localLayoutParams.width = i1;
            bool1 = true;
          }
        }
        if (this.jdField_g_of_type_Int >= 0) {
          break label282;
        }
        paramInt3 = this.jdField_g_of_type_Int;
        label127:
        paramBoolean = bool1;
        if (paramInt4 != -1)
        {
          paramBoolean = bool1;
          if (localLayoutParams.height != paramInt3)
          {
            this.jdField_i_of_type_Int = paramInt3;
            localLayoutParams.height = paramInt3;
            paramBoolean = true;
          }
        }
        if (localLayoutParams.x != paramInt1)
        {
          localLayoutParams.x = paramInt1;
          paramBoolean = true;
        }
        if (localLayoutParams.y != paramInt2)
        {
          localLayoutParams.y = paramInt2;
          paramBoolean = true;
        }
        paramInt1 = a();
        if (paramInt1 != localLayoutParams.windowAnimations)
        {
          localLayoutParams.windowAnimations = paramInt1;
          paramBoolean = true;
        }
        paramInt1 = a(localLayoutParams.flags);
        if (paramInt1 == localLayoutParams.flags) {
          break label290;
        }
        localLayoutParams.flags = paramInt1;
        paramBoolean = bool2;
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label291;
        }
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
        return;
        i1 = this.jdField_f_of_type_Int;
        break;
        paramInt3 = this.jdField_i_of_type_Int;
        break label127;
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View paramView)
  {
    if (b()) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView;
      if ((this.jdField_a_of_type_AndroidContentContext == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
        this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidViewView.getContext();
      }
    } while ((this.jdField_a_of_type_AndroidViewWindowManager != null) || (this.jdField_a_of_type_AndroidViewView == null));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((b()) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    c(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    a(localLayoutParams);
    a(paramView, localLayoutParams, paramInt1, paramInt2);
    if (this.jdField_g_of_type_Int < 0)
    {
      paramInt1 = this.jdField_g_of_type_Int;
      this.jdField_i_of_type_Int = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.jdField_d_of_type_Int < 0)
    {
      paramInt1 = this.jdField_d_of_type_Int;
      this.jdField_f_of_type_Int = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = a();
    b(localLayoutParams);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, "showAtLocation() called with: parent = [" + paramView + "], x = [" + paramInt1 + "], y = [" + paramInt2 + "], isNoIcon = [" + paramBoolean + "]");
    }
    if ((b()) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    d();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    a(localLayoutParams, paramBoolean);
    a(localLayoutParams, paramInt1, paramInt2, paramView);
    if (this.jdField_g_of_type_Int < 0)
    {
      paramInt1 = this.jdField_g_of_type_Int;
      this.jdField_i_of_type_Int = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.jdField_d_of_type_Int < 0)
    {
      paramInt1 = this.jdField_d_of_type_Int;
      this.jdField_f_of_type_Int = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = a();
    b(localLayoutParams);
  }
  
  public void a(bfps parambfps)
  {
    this.jdField_a_of_type_Bfps = parambfps;
  }
  
  public void a(bfpv parambfpv)
  {
    this.jdField_a_of_type_Bfpv = parambfpv;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if ((this.jdField_c_of_type_Int < 0) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      if (this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().targetSdkVersion < 11) {}
    }
    while (this.jdField_c_of_type_Int == 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, "dismiss() called \n" + QLog.getStackTraceString(new RuntimeException()));
    }
    if ((b()) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_Boolean = false;
      d();
    }
    try
    {
      if (this.jdField_b_of_type_AndroidViewView.getParent() != null) {
        this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_b_of_type_AndroidViewView);
      }
      return;
    }
    finally
    {
      if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_b_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_b_of_type_AndroidViewView = null;
      if (this.jdField_a_of_type_Bfps != null) {
        this.jdField_a_of_type_Bfps.a();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    int i2 = 1;
    if ((!b()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i1 = 0;
      int i3 = a();
      if (i3 != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = i3;
        i1 = 1;
      }
      i3 = a(localLayoutParams.flags);
      if (i3 != localLayoutParams.flags)
      {
        localLayoutParams.flags = i3;
        i1 = i2;
      }
      while (i1 != 0)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
        return;
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_l_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void f(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetFrameLayout.getLocationOnScreen(arrayOfInt);
    int i2 = arrayOfInt[0];
    int i1;
    int i3;
    int i4;
    int i5;
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen(arrayOfInt);
      i1 = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
      i3 = arrayOfInt[0];
      i4 = Math.round(TypedValue.applyDimension(1, 5.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
      i5 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      if (paramInt / 2 + i3 + i1 / 2 >= i5 - i4) {
        break label169;
      }
    }
    label169:
    for (paramInt = i1 / 2 + i3 - paramInt / 2 - i2;; paramInt = i5 - i4 - paramInt - i2)
    {
      if (paramInt >= 0) {
        localLayoutParams.leftMargin = paramInt;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen(arrayOfInt);
      i1 = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredWidth();
      break;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    b();
    if (this.jdField_a_of_type_Bfpv != null) {
      this.jdField_a_of_type_Bfpv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */