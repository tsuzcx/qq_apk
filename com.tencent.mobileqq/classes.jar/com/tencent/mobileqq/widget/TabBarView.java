package com.tencent.mobileqq.widget;

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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabBarView
  extends LinearLayout
{
  protected static int a;
  private static final int p;
  private static final int q;
  private static final int r = 10;
  private static final int s = 14;
  protected float a;
  protected long a;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new TabBarView.1(this);
  protected LinearLayout.LayoutParams a;
  public TabBarView.OnTabChangeListener a;
  protected List<RedDotTextView> a;
  private boolean jdField_a_of_type_Boolean = false;
  protected int b;
  Paint b;
  protected List<LinearLayout> b;
  protected int c;
  protected List<String> c;
  protected int d;
  public int e;
  protected int f;
  public int g;
  public int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m = s;
  protected int n = -1;
  protected int o = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    p = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 40.0F + 0.5F);
    q = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
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
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_Int = p;
    this.jdField_c_of_type_Int = q;
    this.e = paramContext.getResources().getColor(2131167064);
    this.f = paramContext.getResources().getColor(2131167056);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130850760));
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    TabBarView.OnTabChangeListener localOnTabChangeListener = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener;
    if (localOnTabChangeListener != null) {
      localOnTabChangeListener.onTabSelected(paramInt1, paramInt2);
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
          ((StringBuilder)localObject).append(localRedDotTextView.getText());
          ((StringBuilder)localObject).append("，");
          ((StringBuilder)localObject).append(getContext().getString(2131691115));
          if (this.o == i1)
          {
            ((StringBuilder)localObject).append("，");
            ((StringBuilder)localObject).append("已选中");
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
    if (paramInt1 >= 0) {
      try
      {
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          TextView localTextView1 = (TextView)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if (localTextView1 != null)
          {
            localTextView1.setTextColor(this.f);
            if ((this.g != 0) && (this.h != 0)) {
              localTextView1.setBackgroundResource(this.h);
            }
          }
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TabBarView", 2, localIndexOutOfBoundsException1, new Object[0]);
        }
      }
    }
    try
    {
      TextView localTextView2 = (TextView)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (localTextView2 != null)
      {
        localTextView2.setTextColor(this.e);
        if (this.g != 0)
        {
          localTextView2.setBackgroundResource(this.g);
          return;
        }
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabBarView", 2, localIndexOutOfBoundsException2, new Object[0]);
      }
    }
  }
  
  public int a()
  {
    return this.o;
  }
  
  protected int a(View paramView)
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
  
  public View a(int paramInt)
  {
    View localView2 = getChildAt(paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = null;
    }
    return localView1;
  }
  
  public RedDotTextView a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView == null) {
      return null;
    }
    localView = localView.findViewById(2131378532);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public RedDotTextView a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, false, false, false);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt, paramString, paramBoolean1, paramBoolean2, false);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      LinearLayout localLinearLayout1 = new LinearLayout(getContext());
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(paramString);
      localRedDotTextView.setTextSize(2, this.m);
      localRedDotTextView.setTextColor(this.f);
      localRedDotTextView.setPadding(this.i, this.k, this.j, this.l);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setFocusable(true);
      localRedDotTextView.setContentDescription(paramString);
      localRedDotTextView.setGravity(17);
      if (!TextUtils.isEmpty(paramString)) {
        localRedDotTextView.setOnClickListener(new TabBarView.2(this, paramInt));
      }
      ViewCompat.setAccessibilityDelegate(localRedDotTextView, new TabBarView.3(this));
      this.jdField_a_of_type_JavaUtilList.add(localRedDotTextView);
      this.jdField_b_of_type_JavaUtilList.add(localLinearLayout1);
      this.jdField_c_of_type_JavaUtilList.add(paramString);
      int i5 = this.jdField_a_of_type_JavaUtilList.size();
      HashMap localHashMap = new HashMap();
      int i2;
      int i3;
      if (!paramBoolean3) {
        if (paramBoolean1)
        {
          if (i5 >= 6) {
            localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 6.0F + 0.5F)));
          } else {
            localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / i5 + 0.5F)));
          }
        }
        else
        {
          if (i5 == 2) {
            localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
          }
          if (i5 == 6)
          {
            paramString = Boolean.valueOf(true);
            i2 = 0;
            i1 = 0;
            while (i1 < i5)
            {
              int i4 = ((String)this.jdField_c_of_type_JavaUtilList.get(i1)).toString().length();
              if (i1 == 0)
              {
                i3 = i4;
              }
              else
              {
                i3 = i2;
                if (i2 != i4)
                {
                  paramString = Boolean.valueOf(false);
                  i3 = i2;
                }
              }
              i1 += 1;
              i2 = i3;
            }
            if (paramString.booleanValue())
            {
              localHashMap.put("width", Integer.valueOf(69));
            }
            else
            {
              localHashMap.put("paddingLeft", Integer.valueOf(8));
              localHashMap.put("paddingRight", Integer.valueOf(8));
            }
          }
          if (i5 > 6)
          {
            localHashMap.put("paddingLeft", Integer.valueOf(8));
            localHashMap.put("paddingRight", Integer.valueOf(8));
          }
        }
      }
      paramString = new LinearLayout.LayoutParams(0, -1);
      int i1 = 0;
      while (i1 < i5)
      {
        LinearLayout localLinearLayout2 = (LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i1);
        if (localHashMap.get("width") != null)
        {
          paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
        }
        else if ((localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
        {
          i2 = (int)(Integer.parseInt(localHashMap.get("paddingLeft").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          i3 = (int)(Integer.parseInt(localHashMap.get("paddingRight").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = i2;
          paramString.rightMargin = i3;
          paramString.width = -2;
        }
        else if (paramBoolean3)
        {
          i2 = (int)((this.m + this.d * 2) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = i2;
          paramString.rightMargin = i2;
          paramString.width = -2;
        }
        else
        {
          paramString.weight = 1.0F;
        }
        if ((paramBoolean2) && (i5 == 2))
        {
          if (i1 == 0)
          {
            paramString.gravity = 21;
            localLinearLayout2.setLayoutParams(paramString);
            localLinearLayout2.setGravity(21);
            localLinearLayout2.setPadding(0, 0, 50, 0);
          }
          else if (i1 == 1)
          {
            paramString.gravity = 19;
            localLinearLayout2.setLayoutParams(paramString);
            localLinearLayout2.setGravity(19);
            localLinearLayout2.setPadding(50, 0, 0, 0);
          }
        }
        else
        {
          paramString.gravity = 17;
          localLinearLayout2.setLayoutParams(paramString);
          localLinearLayout2.setGravity(17);
        }
        i1 += 1;
      }
      localRedDotTextView.setId(2131378532);
      if (localHashMap.get("paddingLeft") != null) {
        localLinearLayout1.addView(localRedDotTextView, paramString);
      } else {
        localLinearLayout1.addView(localRedDotTextView, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      }
      if (i5 == 2) {
        setGravity(1);
      } else {
        setGravity(8388627);
      }
      addView(localLinearLayout1, paramInt);
      return localRedDotTextView;
    }
    paramString = new IllegalArgumentException("position is not legal, please check!");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public RedDotTextView a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  public void a()
  {
    this.o = -1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      this.jdField_b_of_type_JavaUtilList.remove(paramInt);
      this.jdField_c_of_type_JavaUtilList.remove(paramInt);
      removeViewAt(paramInt);
      return;
    }
    throw new IllegalArgumentException("index is not legal, please check!");
  }
  
  protected void a(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.o);
    if (localView1 != null)
    {
      View localView2 = (View)this.jdField_a_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.m * getContext().getResources().getDisplayMetrics().density + 0.5F);
      float f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.o)).toString());
      int i2 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
      int i1 = (int)(i2 + f1);
      if (localView2 != null)
      {
        int i3 = localView1.getLeft() + i2 - this.d;
        int i4 = localView1.getLeft() + i1 + this.d;
        i2 = i4;
        i1 = i3;
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          localView1 = getChildAt(this.n);
          i2 = i4;
          i1 = i3;
          if (localView1 != null)
          {
            f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.n)).toString());
            i1 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
            i2 = (int)(i1 + f1);
            i1 = (int)(i3 + this.jdField_a_of_type_Float * (localView1.getLeft() + i1 - this.d - i3));
            i2 = (int)(i4 + this.jdField_a_of_type_Float * (localView1.getLeft() + i2 + this.d - i4));
          }
        }
        paramCanvas.drawRect(i1, getHeight() - this.jdField_c_of_type_Int, i2, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_b_of_type_Int);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectBgRes(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.e = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
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
    i1 = this.o;
    if (i1 != paramInt)
    {
      if (i1 == -1) {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.n = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
      }
      if (paramBoolean2) {
        a(this.o, paramInt);
      }
      this.n = paramInt;
      this.jdField_a_of_type_Float = 1.0F;
      b(this.o, paramInt);
      invalidate();
      this.o = paramInt;
      b();
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2)) {
      a(i1, i1);
    }
  }
  
  public void setTabHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.k = paramInt2;
    this.j = paramInt3;
    this.l = paramInt4;
  }
  
  public void setUnSelectBgRes(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setUnderLineMargin(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */