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
  private static int f;
  private static final int i;
  private static final int j;
  private static final int k = 14;
  private List<String> A = new ArrayList();
  private Handler B = new BaseTabbar.1(this);
  public BaseTabbar.OnTabChangeListener a;
  public final Paint b;
  public final Paint c;
  int d = 1;
  Paint e = new Paint();
  private boolean g = true;
  private AtomicBoolean h = new AtomicBoolean(false);
  private int l = i;
  private int m = j;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t = k;
  private float u;
  private int v = -1;
  private int w = -1;
  private LinearLayout.LayoutParams x;
  private List<BaseTabbar.TabHolder> y = new ArrayList();
  private List<RelativeLayout> z = new ArrayList();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    i = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 40.0F + 0.5F);
    j = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public BaseTabbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.n = paramContext.getResources().getColor(2131168002);
    this.o = paramContext.getResources().getColor(2131167993);
    this.c = new Paint();
    this.c.setColor(this.n);
    this.x = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.x;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130852582));
    if (f == 0) {
      f = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
    this.b = new Paint();
    this.b.setColor(-8355712);
    int i1 = ViewUtils.getScreenWidth();
    if (i1 > 480) {
      this.d = 1;
    } else {
      this.d = 2;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("width:");
      paramContext.append(i1);
      paramContext.append("mode:");
      paramContext.append(this.d);
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
      int i2 = this.y.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = ((BaseTabbar.TabHolder)this.y.get(i1)).a;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((RedDotTextView)localObject).getText());
          localStringBuilder.append(getContext().getString(2131888061));
          ((RedDotTextView)localObject).setContentDescription(localStringBuilder.toString());
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    BaseTabbar.OnTabChangeListener localOnTabChangeListener = this.a;
    if (localOnTabChangeListener != null) {
      localOnTabChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  public BaseTabbar.TabHolder a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      if (!a(paramInt)) {
        localRelativeLayout.setVisibility(8);
      }
      Object localObject = LayoutInflater.from(getContext()).inflate(2131626148, localRelativeLayout, true);
      BaseTabbar.TabHolder localTabHolder = new BaseTabbar.TabHolder();
      localTabHolder.d = ((View)localObject).findViewById(2131446737);
      localTabHolder.a = ((RedDotTextView)((View)localObject).findViewById(2131447062));
      localTabHolder.b = ((ImageView)((View)localObject).findViewById(2131444531));
      localTabHolder.c = ((TextView)((View)localObject).findViewById(2131439505));
      localTabHolder.e = ((ImageView)((View)localObject).findViewById(2131435357));
      localTabHolder.f = ((ImageView)((View)localObject).findViewById(2131446057));
      localObject = localTabHolder.a;
      ((RedDotTextView)localObject).setText(paramString);
      ((RedDotTextView)localObject).setTextSize(2, this.t);
      ((RedDotTextView)localObject).setTextColor(this.o);
      ((RedDotTextView)localObject).setPadding(this.p, this.r, this.q, this.s);
      ((RedDotTextView)localObject).setSingleLine();
      ((RedDotTextView)localObject).setFocusable(true);
      ((RedDotTextView)localObject).setContentDescription(paramString);
      ((RedDotTextView)localObject).setGravity(17);
      localTabHolder.e.setContentDescription(paramString);
      int i1 = this.d;
      if (i1 == 1) {
        localTabHolder.c.setTextSize(0, FontSettingManager.systemMetrics.density * 10.0F);
      } else if (i1 == 2) {
        localTabHolder.c.setTextSize(0, FontSettingManager.systemMetrics.density * 7.0F);
      }
      ViewCompat.setAccessibilityDelegate((View)localObject, new BaseTabbar.2(this));
      this.y.add(localTabHolder);
      this.z.add(localRelativeLayout);
      this.A.add(paramString);
      if (this.y.size() == 2) {
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
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.y;
    if (localObject == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < ((List)localObject).size()))
    {
      localObject = (BaseTabbar.TabHolder)this.y.get(paramInt1);
      if (localObject != null) {
        ((BaseTabbar.TabHolder)localObject).a.setTextColor(this.o);
      }
    }
    if ((paramInt2 >= 0) && (paramInt2 < this.y.size()))
    {
      localObject = (BaseTabbar.TabHolder)this.y.get(paramInt2);
      if (localObject != null) {
        ((BaseTabbar.TabHolder)localObject).a.setTextColor(this.n);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= this.y.size()) {
        return;
      }
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.y.get(paramInt1);
      if (paramInt2 == 0)
      {
        localTabHolder.b.setVisibility(8);
        localTabHolder.c.setVisibility(8);
        return;
      }
      if (paramBoolean)
      {
        if (paramInt2 > 99)
        {
          TextView localTextView = localTabHolder.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(String.valueOf(99));
          localStringBuilder.append("+");
          localTextView.setText(localStringBuilder.toString());
          if (this.d == 1) {
            localTabHolder.c.setTextSize(0, FontSettingManager.systemMetrics.density * 8.5F);
          }
        }
        else
        {
          localTabHolder.c.setText(String.valueOf(paramInt2));
          if (this.d == 1) {
            localTabHolder.c.setTextSize(0, FontSettingManager.systemMetrics.density * 10.0F);
          }
        }
        localTabHolder.c.setVisibility(0);
        localTabHolder.b.setVisibility(8);
        return;
      }
      localTabHolder.b.setVisibility(0);
      localTabHolder.c.setVisibility(8);
    }
  }
  
  protected abstract boolean a(int paramInt);
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.y.size()) {
        return;
      }
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.y.get(paramInt);
      localTabHolder.c.setVisibility(8);
      localTabHolder.b.setVisibility(8);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.w);
    View localView2 = getChildAt(this.v);
    if (localView1 != null)
    {
      this.e.setTextSize(this.t * getContext().getResources().getDisplayMetrics().density + 0.5F);
      int i3 = localView1.getLeft();
      int i2 = localView1.getRight();
      BaseTabbar.TabHolder localTabHolder = (BaseTabbar.TabHolder)this.y.get(this.w);
      int i1 = i2;
      if (localTabHolder.a())
      {
        i1 = i2;
        if (this.u > 0.0F)
        {
          boolean bool;
          if (this.w < this.v) {
            bool = true;
          } else {
            bool = false;
          }
          i2 = (int)(localView1.getLeft() + a(this.u, bool) * (localView2.getLeft() - localView1.getLeft()));
          i1 = (int)(localView1.getRight() + a(this.u, bool ^ true) * (localView2.getRight() - localView1.getRight()));
          i3 = i2;
        }
        paramCanvas.drawRect(i3, getHeight() - this.m, i1, getHeight(), this.c);
      }
      i2 = (localView2.getLeft() + localView2.getRight()) / 2;
      i3 = localTabHolder.d.getTop();
      int i4 = localTabHolder.d.getBottom();
      int i5 = (i3 + i4) / 2;
      float f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.b.setAlpha((int)((1.0F - this.u) * 96.0F));
      paramCanvas.clipRect(0, i3, i1, i4);
      paramCanvas.drawCircle(i2, i5, f1 * 1.2F * this.u, this.b);
    }
  }
  
  public int getSelectedTabIndex()
  {
    return this.w;
  }
  
  public int getTabHeight()
  {
    return this.l;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.l);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnTabChangeListener(BaseTabbar.OnTabChangeListener paramOnTabChangeListener)
  {
    this.a = paramOnTabChangeListener;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.n = paramInt;
    this.c.setColor(this.n);
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
    this.l = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.x = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p = paramInt1;
    this.r = paramInt2;
    this.q = paramInt3;
    this.s = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar
 * JD-Core Version:    0.7.0.1
 */