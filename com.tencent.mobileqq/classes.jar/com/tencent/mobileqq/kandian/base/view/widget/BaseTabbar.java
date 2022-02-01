package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseTabbar
  extends LinearLayout
{
  private static int jdField_b_of_type_Int;
  private static final int jdField_c_of_type_Int;
  private static final int d;
  private static final int e = 14;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 1;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new BaseTabbar.1(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public BaseTabbar.OnTabChangeListener a;
  private List<BaseTabbar.TabHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = true;
  public final Paint b;
  private List<RelativeLayout> jdField_b_of_type_JavaUtilList = new ArrayList();
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int f = jdField_c_of_type_Int;
  private int g = d;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = e;
  private int o = -1;
  private int p = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_c_of_type_Int = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 40.0F + 0.5F);
    d = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public BaseTabbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext.getResources().getColor(2131167064);
    this.i = paramContext.getResources().getColor(2131167056);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130850760));
    if (jdField_b_of_type_Int == 0) {
      jdField_b_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8355712);
    int i1 = ViewUtils.a();
    if (i1 > 480) {
      this.jdField_a_of_type_Int = 1;
    } else {
      this.jdField_a_of_type_Int = 2;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("width:");
      paramContext.append(i1);
      paramContext.append("mode:");
      paramContext.append(this.jdField_a_of_type_Int);
      QLog.d("TabBarView", 2, paramContext.toString());
    }
  }
  
  private float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramFloat < 0.6F) {
        return 0.0F;
      }
      return (paramFloat - 0.6F) / 0.4F;
    }
    if (paramFloat < 0.6F) {
      return paramFloat / 0.6F;
    }
    return 1.0F;
  }
  
  private int a(View paramView)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (getChildAt(i1).equals(paramView)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void a()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = ((BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((RedDotTextView)localObject).getText());
          localStringBuilder.append(getContext().getString(2131691115));
          ((RedDotTextView)localObject).setContentDescription(localStringBuilder.toString());
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    BaseTabbar.OnTabChangeListener localOnTabChangeListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$OnTabChangeListener;
    if (localOnTabChangeListener != null) {
      localOnTabChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  public int a()
  {
    return this.p;
  }
  
  public BaseTabbar.TabHolder a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      if (!a(paramInt)) {
        localRelativeLayout.setVisibility(8);
      }
      Object localObject = LayoutInflater.from(getContext()).inflate(2131560101, localRelativeLayout, true);
      BaseTabbar.TabHolder localTabHolder = new BaseTabbar.TabHolder();
      localTabHolder.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131378219);
      localTabHolder.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131378460));
      localTabHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376320));
      localTabHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131372042));
      localTabHolder.b = ((ImageView)((View)localObject).findViewById(2131368461));
      localTabHolder.c = ((ImageView)((View)localObject).findViewById(2131377645));
      localObject = localTabHolder.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
      ((RedDotTextView)localObject).setText(paramString);
      ((RedDotTextView)localObject).setTextSize(2, this.n);
      ((RedDotTextView)localObject).setTextColor(this.i);
      ((RedDotTextView)localObject).setPadding(this.j, this.l, this.k, this.m);
      ((RedDotTextView)localObject).setSingleLine();
      ((RedDotTextView)localObject).setFocusable(true);
      ((RedDotTextView)localObject).setContentDescription(paramString);
      ((RedDotTextView)localObject).setGravity(17);
      localTabHolder.b.setContentDescription(paramString);
      int i1 = this.jdField_a_of_type_Int;
      if (i1 == 1) {
        localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, FontSettingManager.systemMetrics.density * 10.0F);
      } else if (i1 == 2) {
        localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, FontSettingManager.systemMetrics.density * 7.0F);
      }
      ViewCompat.setAccessibilityDelegate((View)localObject, new BaseTabbar.2(this));
      this.jdField_a_of_type_JavaUtilList.add(localTabHolder);
      this.jdField_b_of_type_JavaUtilList.add(localRelativeLayout);
      this.jdField_c_of_type_JavaUtilList.add(paramString);
      if (this.jdField_a_of_type_JavaUtilList.size() == 2) {
        setGravity(1);
      } else {
        setGravity(8388627);
      }
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      addView(localRelativeLayout, paramInt, (ViewGroup.LayoutParams)localObject);
      if (!TextUtils.isEmpty(paramString)) {
        localRelativeLayout.setOnClickListener(new BaseTabbar.3(this, paramInt));
      }
      return localTabHolder;
    }
    throw new IllegalArgumentException("position is not legal, please check!");
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localTabHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < ((List)localObject).size()))
    {
      localObject = (BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if (localObject != null) {
        ((BaseTabbar.TabHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.i);
      }
    }
    if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = (BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (localObject != null) {
        ((BaseTabbar.TabHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.h);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if (paramInt2 == 0)
      {
        localTabHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (paramBoolean)
      {
        if (paramInt2 > 99)
        {
          TextView localTextView = localTabHolder.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(String.valueOf(99));
          localStringBuilder.append("+");
          localTextView.setText(localStringBuilder.toString());
          if (this.jdField_a_of_type_Int == 1) {
            localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, FontSettingManager.systemMetrics.density * 8.5F);
          }
        }
        else
        {
          localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt2));
          if (this.jdField_a_of_type_Int == 1) {
            localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, FontSettingManager.systemMetrics.density * 10.0F);
          }
        }
        localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localTabHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      localTabHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localTabHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected abstract boolean a(int paramInt);
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.p);
    View localView2 = getChildAt(this.o);
    if (localView1 != null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
      int i3 = localView1.getLeft();
      int i2 = localView1.getRight();
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.jdField_a_of_type_JavaUtilList.get(this.p);
      int i1 = i2;
      if (localTabHolder.a())
      {
        i1 = i2;
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          boolean bool;
          if (this.p < this.o) {
            bool = true;
          } else {
            bool = false;
          }
          i2 = (int)(localView1.getLeft() + a(this.jdField_a_of_type_Float, bool) * (localView2.getLeft() - localView1.getLeft()));
          i1 = (int)(localView1.getRight() + a(this.jdField_a_of_type_Float, bool ^ true) * (localView2.getRight() - localView1.getRight()));
          i3 = i2;
        }
        paramCanvas.drawRect(i3, getHeight() - this.g, i1, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      i2 = (localView2.getLeft() + localView2.getRight()) / 2;
      i3 = localTabHolder.jdField_a_of_type_AndroidViewView.getTop();
      int i4 = localTabHolder.jdField_a_of_type_AndroidViewView.getBottom();
      int i5 = (i3 + i4) / 2;
      float f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)((1.0F - this.jdField_a_of_type_Float) * 96.0F));
      paramCanvas.clipRect(0, i3, i1, i4);
      paramCanvas.drawCircle(i2, i5, f1 * 1.2F * this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.f);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(BaseTabbar.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.h = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    invalidate();
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    setSelectedTab(paramInt, paramBoolean, false);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setTabHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    this.l = paramInt2;
    this.k = paramInt3;
    this.m = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar
 * JD-Core Version:    0.7.0.1
 */