package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabBarView
  extends LinearLayout
{
  private static final int C;
  private static final int D;
  private static final int E = 10;
  private static final int F = 14;
  protected static int a;
  Paint A = new Paint();
  private boolean B = false;
  private Handler G = new TabBarView.1(this);
  public TabBarView.OnTabChangeListener b;
  protected int c = C;
  protected int d = D;
  protected int e;
  public int f;
  protected int g;
  public int h;
  public int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n = F;
  protected int o;
  protected int p;
  public final Paint q;
  protected float r;
  protected int s = -1;
  protected int t = -1;
  protected LinearLayout.LayoutParams u;
  protected List<RedDotTextView> v = new ArrayList();
  protected List<LinearLayout> w = new ArrayList();
  protected List<String> x = new ArrayList();
  protected String[] y;
  protected long z = 0L;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    C = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 40.0F + 0.5F);
    D = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext.getResources().getColor(2131168002);
    this.g = paramContext.getResources().getColor(2131167993);
    this.q = new Paint();
    this.q.setColor(this.f);
    this.u = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.u;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130852582));
    if (a == 0) {
      a = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    TabBarView.OnTabChangeListener localOnTabChangeListener = this.b;
    if (localOnTabChangeListener != null) {
      localOnTabChangeListener.onTabSelected(paramInt1, paramInt2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      try
      {
        if (paramInt1 < this.v.size())
        {
          TextView localTextView1 = (TextView)this.v.get(paramInt1);
          if (localTextView1 != null)
          {
            localTextView1.setTextColor(this.g);
            if ((this.h != 0) && (this.i != 0)) {
              localTextView1.setBackgroundResource(this.i);
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
      TextView localTextView2 = (TextView)this.v.get(paramInt2);
      if (localTextView2 != null)
      {
        localTextView2.setTextColor(this.f);
        if (this.h != 0)
        {
          localTextView2.setBackgroundResource(this.h);
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
  
  private void b(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.t);
    if (localView1 != null)
    {
      View localView2 = (View)this.v.get(this.t);
      this.A.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
      float f1 = this.A.measureText(((String)this.x.get(this.t)).toString());
      int i2 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
      int i1 = (int)(i2 + f1);
      if (localView2 != null)
      {
        int i3 = localView1.getLeft() + i2 - this.e;
        int i4 = localView1.getLeft() + i1 + this.e;
        i2 = i4;
        i1 = i3;
        if (this.r > 0.0F)
        {
          localView1 = getChildAt(this.s);
          i2 = i4;
          i1 = i3;
          if (localView1 != null)
          {
            f1 = this.A.measureText(((String)this.x.get(this.s)).toString());
            i1 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
            i2 = (int)(i1 + f1);
            i1 = (int)(i3 + this.r * (localView1.getLeft() + i1 - this.e - i3));
            i2 = (int)(i4 + this.r * (localView1.getLeft() + i2 + this.e - i4));
          }
        }
        paramCanvas.drawRect(i1, getHeight() - this.d, i2, getHeight(), this.q);
      }
    }
  }
  
  private void d()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int i2 = getChildCount();
      localObject = new StringBuilder(30);
      int i1 = 0;
      while (i1 < i2)
      {
        RedDotTextView localRedDotTextView = b(i1);
        if (localRedDotTextView != null)
        {
          ((StringBuilder)localObject).append(localRedDotTextView.getText());
          ((StringBuilder)localObject).append("，");
          ((StringBuilder)localObject).append(getContext().getString(2131888061));
          if (this.t == i1)
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
    if (QQTheme.isNowSimpleUI()) {
      return b(paramInt, paramString);
    }
    return b(paramInt, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public RedDotTextView a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  public void a()
  {
    this.t = -1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      this.v.remove(paramInt);
      this.w.remove(paramInt);
      this.x.remove(paramInt);
      removeViewAt(paramInt);
      return;
    }
    throw new IllegalArgumentException("index is not legal, please check!");
  }
  
  protected void a(int paramInt, String paramString, RedDotTextView paramRedDotTextView)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramRedDotTextView.setOnClickListener(new TabBarView.2(this, paramInt));
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (QQTheme.isNowSimpleUI())
    {
      a(paramCanvas, this.q, this.f);
      return;
    }
    b(paramCanvas);
  }
  
  protected void a(Canvas paramCanvas, Paint paramPaint, int paramInt)
  {
    paramPaint.setColor(paramInt);
    paramPaint.setAlpha(255);
    Object localObject = d(this.t);
    int[] arrayOfInt = d(this.s);
    paramInt = localObject[0];
    int i1 = localObject[2];
    int i2 = this.o;
    if (i2 > 0) {
      paramInt = i2;
    }
    i2 = this.p;
    if (i2 > 0) {
      i1 = i2;
    }
    i2 = arrayOfInt[1];
    int i3 = arrayOfInt[3];
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("letf is ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" right is ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" top is ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" bottom is ");
      ((StringBuilder)localObject).append(i3);
      QLog.d("TabBarView", 2, ((StringBuilder)localObject).toString());
    }
    paramCanvas.drawRect(paramInt, i2, i1, i3, paramPaint);
  }
  
  public RedDotTextView b(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView == null) {
      return null;
    }
    localView = localView.findViewById(2131447153);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public RedDotTextView b(int paramInt, String paramString)
  {
    QLog.d("TabBarView", 1, "addTabForSimple");
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      LinearLayout localLinearLayout = new LinearLayout(getContext());
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(paramString);
      localRedDotTextView.setTextSize(2, this.n);
      localRedDotTextView.setTextColor(this.g);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setFocusable(true);
      localRedDotTextView.setContentDescription(paramString);
      localRedDotTextView.setGravity(17);
      a(paramInt, paramString, localRedDotTextView);
      setAccessibilityDelegate(localRedDotTextView);
      this.v.add(localRedDotTextView);
      this.w.add(localLinearLayout);
      this.x.add(paramString);
      this.v.size();
      localRedDotTextView.setId(2131447153);
      localLinearLayout.addView(localRedDotTextView, new LinearLayout.LayoutParams(-2, -1));
      localLinearLayout.setGravity(16);
      setGravity(8388627);
      paramString = new LinearLayout.LayoutParams(-2, -1);
      if (this.v.size() == 1) {
        paramString.leftMargin = getTabMargin();
      }
      paramString.rightMargin = getTabMargin();
      addView(localLinearLayout, paramInt, paramString);
      return localRedDotTextView;
    }
    throw new IllegalArgumentException("position is not legal, please check!");
  }
  
  protected RedDotTextView b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      LinearLayout localLinearLayout1 = new LinearLayout(getContext());
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(paramString);
      localRedDotTextView.setTextSize(2, this.n);
      localRedDotTextView.setTextColor(this.g);
      localRedDotTextView.setPadding(this.j, this.l, this.k, this.m);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setFocusable(true);
      localRedDotTextView.setContentDescription(paramString);
      localRedDotTextView.setGravity(17);
      a(paramInt, paramString, localRedDotTextView);
      setAccessibilityDelegate(localRedDotTextView);
      this.v.add(localRedDotTextView);
      this.w.add(localLinearLayout1);
      this.x.add(paramString);
      int i5 = this.v.size();
      HashMap localHashMap = new HashMap();
      int i2;
      int i3;
      if (!paramBoolean3) {
        if (paramBoolean1)
        {
          if (i5 >= 6) {
            localHashMap.put("width", Integer.valueOf((int)(a / getResources().getDisplayMetrics().density / 6.0F + 0.5F)));
          } else {
            localHashMap.put("width", Integer.valueOf((int)(a / getResources().getDisplayMetrics().density / i5 + 0.5F)));
          }
        }
        else
        {
          if (i5 == 2) {
            localHashMap.put("width", Integer.valueOf((int)(a / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
          }
          if (i5 == 6)
          {
            paramString = Boolean.valueOf(true);
            i2 = 0;
            i1 = 0;
            while (i1 < i5)
            {
              int i4 = ((String)this.x.get(i1)).toString().length();
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
        LinearLayout localLinearLayout2 = (LinearLayout)this.w.get(i1);
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
          i2 = (int)((this.n + this.e * 2) * getResources().getDisplayMetrics().density + 0.5F);
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
      localRedDotTextView.setId(2131447153);
      if (localHashMap.get("paddingLeft") != null) {
        localLinearLayout1.addView(localRedDotTextView, paramString);
      } else {
        localLinearLayout1.addView(localRedDotTextView, this.u);
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
  
  protected void b()
  {
    int i1 = this.t;
    if (i1 != this.s)
    {
      i1 = d(i1)[0];
      int i2 = d(this.s)[0];
      int i3 = d(this.t)[2];
      int i4 = d(this.s)[2];
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });
      localValueAnimator.addUpdateListener(new TabBarView.4(this, i1, i2, i3, i4));
      localValueAnimator.start();
    }
  }
  
  public View c(int paramInt)
  {
    View localView2 = getChildAt(paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = null;
    }
    return localView1;
  }
  
  protected void c()
  {
    a(this.t, this.s);
    b(this.t, this.s);
    this.t = this.s;
    d();
  }
  
  protected int[] d(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject == null) {
      return new int[] { 0, 0, 0, 0 };
    }
    int i2 = ((View)localObject).getLeft();
    int i3 = ((View)localObject).getRight();
    int i1 = ((View)localObject).getHeight();
    this.A.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
    localObject = (String)this.x.get(paramInt);
    Rect localRect = new Rect();
    this.A.getTextBounds((String)localObject, 0, ((String)localObject).length(), localRect);
    paramInt = localRect.width();
    i2 = (i3 + i2) / 2;
    paramInt /= 2;
    i1 = i1 / 2 + ViewUtils.dpToPx(this.n) / 2 + ViewUtils.dpToPx(5.0F);
    return new int[] { i2 - paramInt, i1, i2 + paramInt, ViewUtils.dpToPx(2.0F) + i1 };
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  public int getSelectedTabIndex()
  {
    return this.t;
  }
  
  public int getTabHeight()
  {
    return this.c;
  }
  
  protected int getTabMargin()
  {
    this.A.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
    Object localObject = this.y;
    if (localObject != null)
    {
      if (localObject.length == 1) {
        return 42;
      }
      int i3 = localObject.length;
      int i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        String str = localObject[i1];
        i2 = (int)(i2 + this.A.measureText(str));
        i1 += 1;
      }
      i1 = (ViewUtils.getScreenWidth() - i2) / (this.y.length + 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gap is ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("TabBarView", 1, ((StringBuilder)localObject).toString());
      if (i1 >= 42) {
        return i1;
      }
    }
    return 42;
  }
  
  public int getTabSize()
  {
    return this.v.size();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.c);
  }
  
  protected void setAccessibilityDelegate(RedDotTextView paramRedDotTextView)
  {
    ViewCompat.setAccessibilityDelegate(paramRedDotTextView, new TabBarView.3(this));
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.b = paramOnTabChangeListener;
  }
  
  public void setSelectBgRes(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.f = paramInt;
    this.q.setColor(this.f);
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
    i1 = this.t;
    if (i1 != paramInt)
    {
      if (i1 == -1) {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        this.s = paramInt;
        if (QQTheme.isNowSimpleUI())
        {
          b();
          return;
        }
        this.r = 0.0F;
        this.G.sendEmptyMessage(0);
        return;
      }
      if (paramBoolean2) {
        a(this.t, paramInt);
      }
      this.s = paramInt;
      this.o = d(this.t)[0];
      this.p = d(this.t)[2];
      this.r = 1.0F;
      b(this.t, paramInt);
      invalidate();
      this.t = paramInt;
      d();
      return;
    }
    if ((this.B) && (paramBoolean2)) {
      a(i1, i1);
    }
  }
  
  public void setTabHeight(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.u = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setTabTitleList(String[] paramArrayOfString)
  {
    this.y = paramArrayOfString;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    this.l = paramInt2;
    this.k = paramInt3;
    this.m = paramInt4;
  }
  
  public void setUnSelectBgRes(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setUnderLineMargin(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */