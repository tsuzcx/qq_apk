package com.tencent.mobileqq.widget;

import akxa;
import akxb;
import akxc;
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
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabBarView
  extends LinearLayout
{
  public static int a;
  private static final int i;
  private static final int j;
  private static final int k = 10;
  private static final int l = 14;
  private float jdField_a_of_type_Float;
  public long a;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new akxa(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public TabBarView.OnTabChangeListener a;
  public List a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  Paint b;
  public List b;
  public int c;
  public List c;
  public int d;
  public int e;
  public int f;
  public int g = l;
  public int h = -1;
  private int m = i;
  private int n = j;
  private int o;
  private int p;
  private int q = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    i = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    j = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.p = paramContext.getResources().getColor(2131494220);
    this.jdField_b_of_type_Int = paramContext.getResources().getColor(2131494214);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.p);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130846046));
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener.onTabSelected(paramInt1, paramInt2);
    }
  }
  
  private void b()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int i2 = getChildCount();
      localObject = new StringBuilder(30);
      int i1 = 0;
      while (i1 < i2)
      {
        RedDotTextView localRedDotTextView = a(i1);
        if (localRedDotTextView != null)
        {
          ((StringBuilder)localObject).append(localRedDotTextView.getText()).append("，").append(getContext().getString(2131427457));
          if (this.h == i1) {
            ((StringBuilder)localObject).append("，").append("已选中");
          }
          localRedDotTextView.setContentDescription(((StringBuilder)localObject).toString());
          ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {}
    try
    {
      TextView localTextView;
      if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        localTextView = (TextView)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        if (localTextView != null) {
          localTextView.setTextColor(this.jdField_b_of_type_Int);
        }
      }
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
    {
      for (;;)
      {
        try
        {
          localTextView = (TextView)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          if (localTextView != null) {
            localTextView.setTextColor(this.p);
          }
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TabBarView", 2, localIndexOutOfBoundsException2, new Object[0]);
        }
        localIndexOutOfBoundsException1 = localIndexOutOfBoundsException1;
        if (QLog.isColorLevel()) {
          QLog.d("TabBarView", 2, localIndexOutOfBoundsException1, new Object[0]);
        }
      }
    }
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int a(View paramView)
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
  
  public RedDotTextView a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView == null) {
      return null;
    }
    localView = localView.findViewById(2131362344);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public RedDotTextView a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, false);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(getContext());
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, this.g);
    localRedDotTextView.setTextColor(this.jdField_b_of_type_Int);
    localRedDotTextView.setPadding(this.jdField_c_of_type_Int, this.e, this.d, this.f);
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(17);
    if (!TextUtils.isEmpty(paramString)) {
      localLinearLayout1.setOnClickListener(new akxb(this, paramInt));
    }
    ViewCompat.setAccessibilityDelegate(localRedDotTextView, new akxc(this));
    this.jdField_a_of_type_JavaUtilList.add(localRedDotTextView);
    this.jdField_b_of_type_JavaUtilList.add(localLinearLayout1);
    this.jdField_c_of_type_JavaUtilList.add(paramString);
    int i4 = this.jdField_a_of_type_JavaUtilList.size();
    HashMap localHashMap = new HashMap();
    int i1;
    if (paramBoolean)
    {
      if (i4 >= 6) {
        localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 6.0F + 0.5F)));
      }
      for (;;)
      {
        paramString = new LinearLayout.LayoutParams(0, -1);
        i1 = 0;
        for (;;)
        {
          if (i1 >= i4) {
            break label766;
          }
          LinearLayout localLinearLayout2 = (LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i1);
          if ((localHashMap == null) || (localHashMap.get("width") == null)) {
            break;
          }
          paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
          label347:
          paramString.gravity = 17;
          localLinearLayout2.setLayoutParams(paramString);
          localLinearLayout2.setGravity(17);
          i1 += 1;
        }
        localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / i4 + 0.5F)));
      }
    }
    if (i4 == 2) {
      localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
    }
    int i2;
    label476:
    int i3;
    if (i4 == 6)
    {
      i1 = 0;
      paramString = Boolean.valueOf(true);
      i2 = 0;
      if (i2 < i4)
      {
        i3 = ((String)this.jdField_c_of_type_JavaUtilList.get(i2)).toString().length();
        if (i2 == 0) {
          i1 = i3;
        }
      }
    }
    for (;;)
    {
      i2 += 1;
      break label476;
      if (i1 != i3)
      {
        paramString = Boolean.valueOf(false);
        continue;
        if (paramString.booleanValue()) {
          localHashMap.put("width", Integer.valueOf(69));
        }
        for (;;)
        {
          if (i4 <= 6) {
            break label636;
          }
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
          break;
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
        }
        label636:
        break;
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
        {
          i2 = (int)(Integer.parseInt(localHashMap.get("paddingLeft").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          i3 = (int)(Integer.parseInt(localHashMap.get("paddingRight").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = i2;
          paramString.rightMargin = i3;
          paramString.width = -2;
          break label347;
        }
        paramString.weight = 1.0F;
        break label347;
        label766:
        localRedDotTextView.setId(2131362344);
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null))
        {
          localLinearLayout1.addView(localRedDotTextView, paramString);
          if (i4 != 2) {
            break label831;
          }
          setGravity(1);
        }
        for (;;)
        {
          addView(localLinearLayout1, paramInt);
          return localRedDotTextView;
          localLinearLayout1.addView(localRedDotTextView);
          break;
          label831:
          setGravity(8388627);
        }
      }
    }
  }
  
  public RedDotTextView a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  public void a()
  {
    this.h = -1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("index is not legal, please check!");
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    this.jdField_c_of_type_JavaUtilList.remove(paramInt);
    removeViewAt(paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.h);
    int i2;
    int i1;
    if (localView1 != null)
    {
      View localView2 = (View)this.jdField_a_of_type_JavaUtilList.get(this.h);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.g * getContext().getResources().getDisplayMetrics().density + 0.5F);
      float f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.h)).toString());
      i2 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
      i1 = (int)(f1 + i2);
      if (localView2 != null)
      {
        i2 = localView1.getLeft() + i2 - this.o;
        int i3 = localView1.getLeft();
        i1 = this.o + (i3 + i1);
        if (this.jdField_a_of_type_Float <= 0.0F) {
          break label334;
        }
        localView1 = getChildAt(this.q);
        if (localView1 == null) {
          break label334;
        }
        f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.q)).toString());
        int i4 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
        i3 = (int)(f1 + i4);
        f1 = i2;
        float f2 = this.jdField_a_of_type_Float;
        i2 = (int)((i4 + localView1.getLeft() - this.o - i2) * f2 + f1);
        f1 = i1;
        f2 = this.jdField_a_of_type_Float;
        i1 = (int)((i3 + localView1.getLeft() + this.o - i1) * f2 + f1);
      }
    }
    label334:
    for (;;)
    {
      paramCanvas.drawRect(i2, getHeight() - this.n, i1, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.m, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.m);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.p = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.p);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    setSelectedTab(paramInt, paramBoolean, true);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    int i2 = getChildCount();
    paramInt = i1;
    if (i1 >= i2) {
      paramInt = i2 - 1;
    }
    if (this.h != paramInt)
    {
      if (this.h == -1) {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.q = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!paramBoolean2))
    {
      return;
      if (paramBoolean2) {
        a(this.h, paramInt);
      }
      this.q = paramInt;
      this.jdField_a_of_type_Float = 1.0F;
      b(this.h, paramInt);
      invalidate();
      this.h = paramInt;
      b();
      return;
    }
    a(this.h, this.h);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.e = paramInt2;
    this.d = paramInt3;
    this.f = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setUnderLineMargin(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */