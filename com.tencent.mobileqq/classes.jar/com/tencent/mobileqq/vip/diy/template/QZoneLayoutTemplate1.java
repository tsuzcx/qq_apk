package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QZoneLayoutTemplate1
  extends ViewGroup
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected List<View> e;
  private ImageView f;
  private ImageView g;
  
  public QZoneLayoutTemplate1(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new ColorDrawable(-16777216);
    this.e = new ArrayList();
    this.f = new ImageView(paramContext);
    this.g = new ImageView(paramContext);
    this.f.setImageDrawable(paramAttributeSet);
    this.g.setImageDrawable(paramAttributeSet);
    super.addView(this.f);
    super.addView(this.g);
    this.c = a(8.0F);
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    this.e.add(paramView);
    int i = this.d;
    paramView.setPadding(i, i, i, i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.a / 3;
    if (this.e.size() > 0) {
      ((View)this.e.get(0)).layout(0, 0, paramInt1, paramInt1);
    }
    Object localObject;
    if (this.e.size() > 1)
    {
      localObject = (View)this.e.get(1);
      paramInt2 = this.c;
      paramInt3 = paramInt1 * 2;
      ((View)localObject).layout(paramInt1 + paramInt2, 0, paramInt2 + paramInt3, paramInt1);
      this.g.layout(paramInt3 + this.c * 2, 0, this.a, paramInt1);
    }
    if (this.e.size() > 2)
    {
      localObject = (View)this.e.get(2);
      paramInt2 = this.a;
      paramInt3 = this.c;
      ((View)localObject).layout(paramInt2 - paramInt1 * 2 - paramInt3, paramInt1 + paramInt3, paramInt2 - paramInt1 - paramInt3, this.b);
      localObject = this.f;
      paramInt2 = this.c;
      ((ImageView)localObject).layout(0, paramInt1 + paramInt2, paramInt1 - paramInt2 * 2, this.b);
    }
    if (this.e.size() > 3)
    {
      localObject = (View)this.e.get(3);
      paramInt2 = this.a;
      ((View)localObject).layout(paramInt2 - paramInt1, paramInt1 + this.c, paramInt2, this.b);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = this.a;
    int i = paramInt1 * 2 / 3;
    paramInt2 = this.c;
    this.b = (i + paramInt2);
    i = paramInt1 / 3;
    ImageView localImageView = this.g;
    int j = i * 2;
    localImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - j - paramInt2 * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    this.f.measure(View.MeasureSpec.makeMeasureSpec(this.a - j - this.c * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    if (this.e.size() > 0) {
      ((View)this.e.get(0)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.e.size() > 1) {
      ((View)this.e.get(1)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.e.size() > 2) {
      ((View)this.e.get(2)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.e.size() > 3) {
      ((View)this.e.get(3)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.e.size() > 2)
    {
      setMeasuredDimension(this.a, this.b);
      return;
    }
    setMeasuredDimension(this.a, i);
  }
  
  public void removeAllViewsInLayout()
  {
    super.removeAllViewsInLayout();
    super.addView(this.f);
    super.addView(this.g);
    this.e.clear();
  }
  
  public void setBorderColor(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setBackgroundColor(paramInt);
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setItemBg(Drawable paramDrawable, int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (paramDrawable != null) {
        localView.setBackgroundDrawable(paramDrawable);
      } else {
        localView.setBackgroundColor(paramInt);
      }
    }
  }
  
  public void setLeftView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.f.setImageDrawable(paramString);
  }
  
  public void setRightView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.g.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1
 * JD-Core Version:    0.7.0.1
 */