package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.IPullRefreshHeader;

public class SkinPullRefreshHeader
  extends RelativeLayout
  implements IPullRefreshHeader
{
  private static final int k = Color.parseColor("#f7f7f7");
  public long a = 0L;
  GradientDrawable b = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { Color.parseColor("#59000000"), 0 });
  private int c = 0;
  private Context d;
  private RelativeLayout e;
  private ImageView f;
  private ProgressBar g;
  private TextView h;
  private View i;
  private View j;
  
  public SkinPullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    setBackgroundColor(k);
  }
  
  private void a()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (this.c == 0)
    {
      a((RelativeLayout.LayoutParams)localObject, 10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    else
    {
      a((RelativeLayout.LayoutParams)localObject, 12);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
    }
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
  
  public void a(int paramInt)
  {
    this.g.setVisibility(4);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.h.setVisibility(0);
    this.g.setVisibility(4);
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
      paramInt = (int)this.h.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.h.setText((CharSequence)localObject);
  }
  
  public void a(long paramLong)
  {
    this.g.setVisibility(0);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      this.f.setImageDrawable(paramDrawable);
      setBackgroundColor(k);
      paramDrawable = this.i;
      if (paramDrawable != null)
      {
        if (paramBoolean)
        {
          paramDrawable.setVisibility(0);
          this.i.setBackgroundDrawable(this.b);
          return;
        }
        paramDrawable.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      this.h.setText(paramString);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public void b(long paramLong)
  {
    this.h.setText(2131916804);
  }
  
  public void c(long paramLong)
  {
    this.g.setVisibility(4);
    this.h.setVisibility(4);
  }
  
  public void f()
  {
    ProgressBar localProgressBar = this.g;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.g.setVisibility(0);
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
    this.e = ((RelativeLayout)findViewById(2131431322));
    this.g = ((ProgressBar)findViewById(2131444560));
    this.f = ((ImageView)findViewById(2131444561));
    this.h = ((TextView)findViewById(2131444559));
    this.i = findViewById(2131444555);
    this.j = findViewById(2131444562);
    c(0L);
  }
  
  public void setAdTabVisibility(boolean paramBoolean)
  {
    View localView = this.j;
    if (localView != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localView.setVisibility(m);
    }
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
    if (this.c != paramInt)
    {
      this.c = paramInt;
      a();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */