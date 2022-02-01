package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.theme.TextHook;

public class PullRefreshHeader
  extends RelativeLayout
  implements IPullRefreshHeaderControl
{
  public long a = 0L;
  private int b = 0;
  private Context c;
  private RelativeLayout d;
  private ProgressBar e;
  private ImageView f;
  private TextView g;
  private RotateAnimation h;
  private RotateAnimation i;
  private TextView j;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    this.h = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.h.setDuration(100L);
    this.h.setFillAfter(true);
    this.i = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.i.setDuration(100L);
    this.i.setFillAfter(true);
  }
  
  private void a()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (this.b == 0)
    {
      a((RelativeLayout.LayoutParams)localObject, 10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    else
    {
      a((RelativeLayout.LayoutParams)localObject, 12);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private void d(long paramLong)
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      return;
    }
    if (paramLong != 0L)
    {
      localTextView.setVisibility(0);
      this.j.setText(String.format("%s%s", new Object[] { this.c.getString(2131916800), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      int i1 = this.o;
      if (i1 >= 0) {
        this.j.setTextColor(i1);
      }
    }
    else
    {
      localTextView.setVisibility(8);
    }
  }
  
  private void setColor(int paramInt)
  {
    if (paramInt != 0) {
      this.g.setTextColor(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          localObject = "";
        }
        else
        {
          getResources().getDrawable(2130851572);
          localObject = getResources().getString(2131916799);
        }
      }
      else
      {
        getResources().getDrawable(2130851571);
        localObject = getResources().getString(2131916799);
      }
    }
    else
    {
      getResources().getDrawable(2130851573);
      localObject = getResources().getString(2131916805);
    }
    this.g.setText((CharSequence)localObject);
    setColor(this.n);
    Object localObject = this.j;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramObject = (RelativeLayout)findViewById(2131444552);
      localObject = (RelativeLayout.LayoutParams)paramObject.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramObject.setBackgroundResource(2130838959);
      return;
    }
    if (paramInt == 5)
    {
      this.g.setText(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 2)
    {
      paramObject = (View)paramObject;
      localObject = (ViewGroup)findViewById(2131438474);
      if (indexOfChild(paramObject) < 0) {
        ((ViewGroup)localObject).addView(paramObject);
      }
      ((ViewGroup)localObject).setVisibility(0);
      return;
    }
    if (paramInt == 9)
    {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131444552);
      addView((View)paramObject, (ViewGroup.LayoutParams)localObject);
      return;
    }
    if (paramInt == 10)
    {
      removeView((View)paramObject);
      return;
    }
    if (paramInt == 4)
    {
      ((RelativeLayout)findViewById(2131444552)).setVisibility(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 12)
    {
      this.g.setTextColor(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 13)
    {
      TextHook.updateFont(this.g);
      return;
    }
    if (paramInt == 14)
    {
      ((RelativeLayout)findViewById(2131444552)).setBackgroundColor(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 16)
    {
      ((RelativeLayout)findViewById(2131444552)).setBackgroundResource(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 15)
    {
      ((ProgressBar)findViewById(2131444560)).setIndeterminateDrawable((Drawable)paramObject);
      return;
    }
    if (paramInt == 17) {
      setArrowColor(((Integer)paramObject).intValue());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    Drawable localDrawable;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localDrawable = null;
        } else {
          localDrawable = getResources().getDrawable(2130851572);
        }
      }
      else {
        localDrawable = getResources().getDrawable(2130851571);
      }
    }
    else {
      localDrawable = getResources().getDrawable(2130851573);
    }
    Object localObject = paramString;
    if (localDrawable != null)
    {
      paramInt = (int)this.g.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.g.setText((CharSequence)localObject);
    setColor(this.n);
    paramString = this.j;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.g.setText(2131916801);
      setColor(this.m);
      label18:
      d(paramLong);
      this.f.setVisibility(8);
      this.f.clearAnimation();
      this.e.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public Object b(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      paramObject = this.e;
      boolean bool;
      if ((paramObject != null) && (paramObject.getVisibility() != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    if (paramInt == 8) {
      return Integer.valueOf(indexOfChild((View)paramObject));
    }
    if (paramInt == 11) {
      return this.g.getText().toString();
    }
    return null;
  }
  
  public void b(long paramLong)
  {
    this.f.clearAnimation();
    this.f.startAnimation(this.h);
    this.g.setText(2131916804);
    setColor(this.l);
    d(paramLong);
  }
  
  public void c(long paramLong)
  {
    this.e.setVisibility(4);
    this.f.setVisibility(0);
    this.f.clearAnimation();
    if (this.b == 0)
    {
      if (this.p == 0) {
        this.f.setImageResource(2130851569);
      } else {
        this.f.setImageResource(2130839618);
      }
      this.g.setText(2131916802);
    }
    else
    {
      if (this.p == 0) {
        this.f.setImageResource(2130851570);
      } else {
        this.f.setImageResource(2130839619);
      }
      this.g.setText(2131916803);
    }
    setColor(this.k);
    d(paramLong);
  }
  
  public void f()
  {
    ProgressBar localProgressBar = this.e;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.e.setVisibility(0);
    }
  }
  
  public long g()
  {
    return this.a;
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((RelativeLayout)findViewById(2131431322));
    this.e = ((ProgressBar)findViewById(2131444560));
    this.f = ((ImageView)findViewById(2131444557));
    this.g = ((TextView)findViewById(2131444559));
    this.j = ((TextView)findViewById(2131444565));
    if (this.b != 0) {
      a();
    }
    if (this.p != 0) {
      this.f.setImageResource(2130839620);
    }
    c(0L);
  }
  
  public void setArrowColor(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      a();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramInt4;
    this.o = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */