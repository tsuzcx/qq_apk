package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;

public class CoolTextView
  extends TextView
{
  int a;
  int b;
  int c;
  URLDrawable d;
  URLDrawable e;
  Rect f = new Rect();
  Rect g = new Rect();
  int h;
  float i;
  private CoolTextView.CoolBuilder j = new CoolTextView.CoolBuilder();
  
  public CoolTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoolTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    URLDrawable localURLDrawable = this.d;
    if (localURLDrawable == null) {
      return;
    }
    localURLDrawable.setBounds(0, 0, this.a, this.b);
    setCompoundDrawables(this.d, null, null, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    URLDrawable localURLDrawable = this.e;
    if (localURLDrawable == null) {
      return;
    }
    localURLDrawable.setBounds(this.g);
    this.e.draw(paramCanvas);
  }
  
  protected void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      localMarginLayoutParams.setMargins(paramInt1, paramInt3, paramInt2, paramInt4);
      setLayoutParams(localMarginLayoutParams);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.onDraw(paramCanvas);
    paramCanvas.drawText(this.j.g, this.f.left, this.i, getPaint());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = Layout.getDesiredWidth(this.j.g, getPaint());
    paramInt1 = this.a;
    int k = (int)f1;
    setMeasuredDimension(paramInt1 + k + ViewUtils.dip2px(7.5F), Math.max(this.b, this.c));
    paramInt1 = Math.abs(this.b - this.c);
    paramInt2 = this.c + paramInt1;
    k = this.a + k + ViewUtils.dip2px(7.5F);
    Object localObject = this.g;
    ((Rect)localObject).left = 10;
    ((Rect)localObject).right = k;
    int m = this.h;
    ((Rect)localObject).top = (paramInt1 - m);
    ((Rect)localObject).bottom = (paramInt2 + m);
    localObject = this.f;
    ((Rect)localObject).left = (this.a + 5);
    ((Rect)localObject).top = (paramInt1 - m);
    ((Rect)localObject).right = k;
    ((Rect)localObject).bottom = (paramInt2 + m);
    localObject = getPaint().getFontMetrics();
    f1 = (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
    float f2 = ((Paint.FontMetrics)localObject).bottom;
    this.i = (this.f.centerY() + (f1 - f2));
  }
  
  public void setCoolBuilder(CoolTextView.CoolBuilder paramCoolBuilder)
  {
    if (paramCoolBuilder != null) {
      this.j = paramCoolBuilder;
    }
    this.a = ViewUtils.dip2px(this.j.a);
    this.b = ViewUtils.dip2px(this.j.b);
    this.c = ViewUtils.dip2px(this.j.c);
    if (!TextUtils.isEmpty(this.j.e))
    {
      paramCoolBuilder = new ApngOptions();
      paramCoolBuilder.a(URLDrawableHelperConstants.a);
      paramCoolBuilder.a(new int[] { 9 });
      this.d = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.j.e, paramCoolBuilder);
    }
    if (!TextUtils.isEmpty(this.j.f)) {
      this.e = VasApngUtil.getRegionUrlDrawable(this.j.f, getResources().getDisplayMetrics().densityDpi);
    } else {
      this.e = null;
    }
    setTextSize(1, this.j.h);
    try
    {
      if (!TextUtils.isEmpty(this.j.d)) {
        setTextColor(Color.parseColor(this.j.d));
      } else {
        setTextColor(getResources().getColor(2131167993));
      }
    }
    catch (Exception paramCoolBuilder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID_LOG,color_parse,");
      localStringBuilder.append(paramCoolBuilder.getMessage());
      QLog.d("CoolTextView", 2, localStringBuilder.toString());
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.CoolTextView
 * JD-Core Version:    0.7.0.1
 */