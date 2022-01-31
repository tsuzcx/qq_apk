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
import bevr;
import bevs;
import bevt;
import bevu;
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
  protected static int a;
  private static final int p;
  private static final int q;
  private static final int r = 10;
  private static final int s = 14;
  public float a;
  public long a;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new bevr(this);
  protected LinearLayout.LayoutParams a;
  public bevu a;
  protected List<RedDotTextView> a;
  private boolean jdField_a_of_type_Boolean;
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
  public int n = -1;
  public int o = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    p = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
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
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_Int = p;
    this.jdField_c_of_type_Int = q;
    this.e = paramContext.getResources().getColor(2131166911);
    this.f = paramContext.getResources().getColor(2131166903);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130849796));
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bevu != null) {
      this.jdField_a_of_type_Bevu.onTabSelected(paramInt1, paramInt2);
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
          ((StringBuilder)localObject).append(localRedDotTextView.getText()).append("，").append(getContext().getString(2131691159));
          if (this.o == i1) {
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
        if (localTextView != null)
        {
          localTextView.setTextColor(this.f);
          if ((this.g != 0) && (this.h != 0)) {
            localTextView.setBackgroundResource(this.h);
          }
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
          if (localTextView != null)
          {
            localTextView.setTextColor(this.e);
            if (this.g != 0) {
              localTextView.setBackgroundResource(this.g);
            }
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
    return this.o;
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
    localView = localView.findViewById(2131377682);
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
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
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
      localRedDotTextView.setOnClickListener(new bevs(this, paramInt));
    }
    ViewCompat.setAccessibilityDelegate(localRedDotTextView, new bevt(this));
    this.jdField_a_of_type_JavaUtilList.add(localRedDotTextView);
    this.jdField_b_of_type_JavaUtilList.add(localLinearLayout1);
    this.jdField_c_of_type_JavaUtilList.add(paramString);
    int i4 = this.jdField_a_of_type_JavaUtilList.size();
    HashMap localHashMap = new HashMap();
    if (!paramBoolean3)
    {
      if (!paramBoolean1) {
        break label446;
      }
      if (i4 < 6) {
        break label406;
      }
      localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 6.0F + 0.5F)));
    }
    int i1;
    LinearLayout localLinearLayout2;
    for (;;)
    {
      paramString = new LinearLayout.LayoutParams(0, -1);
      i1 = 0;
      for (;;)
      {
        if (i1 >= i4) {
          break label912;
        }
        localLinearLayout2 = (LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i1);
        if ((localHashMap == null) || (localHashMap.get("width") == null)) {
          break;
        }
        paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
        label352:
        if ((!paramBoolean2) || (i4 != 2)) {
          break label890;
        }
        if (i1 != 0) {
          break label852;
        }
        paramString.gravity = 21;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(21);
        localLinearLayout2.setPadding(0, 0, 50, 0);
        label397:
        i1 += 1;
      }
      label406:
      localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / i4 + 0.5F)));
    }
    label446:
    if (i4 == 2) {
      localHashMap.put("width", Integer.valueOf((int)(jdField_a_of_type_Int / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
    }
    int i2;
    label507:
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
      break label507;
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
            break label667;
          }
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
          break;
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
        }
        label667:
        break;
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
        {
          i2 = (int)(Integer.parseInt(localHashMap.get("paddingLeft").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          i3 = (int)(Integer.parseInt(localHashMap.get("paddingRight").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = i2;
          paramString.rightMargin = i3;
          paramString.width = -2;
          break label352;
        }
        if (paramBoolean3)
        {
          i2 = (int)((this.m + this.d * 2) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = i2;
          paramString.rightMargin = i2;
          paramString.width = -2;
          break label352;
        }
        paramString.weight = 1.0F;
        break label352;
        label852:
        if (i1 != 1) {
          break label397;
        }
        paramString.gravity = 19;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(19);
        localLinearLayout2.setPadding(50, 0, 0, 0);
        break label397;
        label890:
        paramString.gravity = 17;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(17);
        break label397;
        label912:
        localRedDotTextView.setId(2131377682);
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null))
        {
          localLinearLayout1.addView(localRedDotTextView, paramString);
          if (i4 != 2) {
            break label977;
          }
          setGravity(1);
        }
        for (;;)
        {
          addView(localLinearLayout1, paramInt);
          return localRedDotTextView;
          localLinearLayout1.addView(localRedDotTextView);
          break;
          label977:
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
    this.o = -1;
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
  
  protected void a(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.o);
    int i2;
    int i1;
    if (localView1 != null)
    {
      View localView2 = (View)this.jdField_a_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.m * getContext().getResources().getDisplayMetrics().density + 0.5F);
      float f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.o)).toString());
      i2 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
      i1 = (int)(f1 + i2);
      if (localView2 != null)
      {
        i2 = localView1.getLeft() + i2 - this.d;
        int i3 = localView1.getLeft();
        i1 = this.d + (i3 + i1);
        if (this.jdField_a_of_type_Float <= 0.0F) {
          break label329;
        }
        localView1 = getChildAt(this.n);
        if (localView1 == null) {
          break label329;
        }
        f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.n)).toString());
        int i4 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
        i3 = (int)(f1 + i4);
        f1 = i2;
        float f2 = this.jdField_a_of_type_Float;
        i2 = (int)((i4 + localView1.getLeft() - this.d - i2) * f2 + f1);
        f1 = i1;
        f2 = this.jdField_a_of_type_Float;
        i1 = (int)((i3 + localView1.getLeft() + this.d - i1) * f2 + f1);
      }
    }
    label329:
    for (;;)
    {
      paramCanvas.drawRect(i2, getHeight() - this.jdField_c_of_type_Int, i1, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
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
  
  public void setOnTabChangeListener(bevu parambevu)
  {
    this.jdField_a_of_type_Bevu = parambevu;
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
    if (this.o != paramInt)
    {
      if (this.o == -1) {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.n = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!paramBoolean2))
    {
      return;
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
    a(this.o, this.o);
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