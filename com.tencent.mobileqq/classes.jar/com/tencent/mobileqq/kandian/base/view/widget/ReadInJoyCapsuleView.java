package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ReadInJoyCapsuleView
  extends FrameLayout
{
  TextView a;
  ImageView b;
  private final Path c = new Path();
  private final RectF d = new RectF();
  private final Paint e = new Paint(1);
  private final PorterDuffXfermode f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private String g;
  private Drawable h;
  private Drawable i;
  private int j;
  private int k;
  private int l;
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyCapsuleView, 0, 0);
    try
    {
      this.g = paramAttributeSet.getString(3);
      this.h = paramAttributeSet.getDrawable(4);
      this.j = paramAttributeSet.getDimensionPixelSize(5, 6);
      this.k = paramAttributeSet.getDimensionPixelSize(0, 24);
      this.l = paramAttributeSet.getColor(1, -1);
      this.i = paramAttributeSet.getDrawable(2);
      paramAttributeSet.recycle();
      a(paramContext);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = new ImageView(paramContext);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.setImageDrawable(this.i);
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    this.a = new TextView(paramContext);
    Object localObject = this.a;
    ((TextView)localObject).setTypeface(((TextView)localObject).getTypeface(), 1);
    this.a.setTextColor(this.l);
    this.a.setText(this.g);
    this.a.setTextSize(0, this.k);
    localObject = this.h;
    if (localObject != null) {
      setDrawableLeft((Drawable)localObject);
    }
    this.a.setIncludeFontPadding(false);
    this.a.setGravity(16);
    localObject = new FrameLayout.LayoutParams(-2, -2, 17);
    ((FrameLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
    ((FrameLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
    addView(this.a, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(Canvas paramCanvas)
  {
    int m = getWidth();
    float f1 = getHeight();
    float f2 = 0.5F * f1;
    this.c.moveTo(f2, 0.0F);
    Object localObject = this.c;
    float f3 = m;
    ((Path)localObject).lineTo(f3 - f2, 0.0F);
    localObject = this.d;
    float f4 = 2.0F * f2;
    ((RectF)localObject).set(f3 - f4, 0.0F, f3, f1);
    this.c.arcTo(this.d, -90.0F, 180.0F);
    this.c.lineTo(f2, f1);
    this.d.set(0.0F, 0.0F, f4, f1);
    this.c.arcTo(this.d, 90.0F, 180.0F);
    this.c.close();
    this.e.setXfermode(this.f);
    this.e.setColor(-16777216);
    this.e.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.c, this.e);
    this.e.setXfermode(null);
    this.c.reset();
  }
  
  public void a()
  {
    this.b.clearColorFilter();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(null, null, 31);
    super.dispatchDraw(paramCanvas);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getBackgroundSrc()
  {
    return this.i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildWithMargins(this.a, paramInt1, 0, paramInt2, 0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    paramInt1 = View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, 1073741824);
    this.b.measure(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setBackgroundSrc(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    this.b.setImageDrawable(this.i);
  }
  
  public void setColorFilter(int paramInt)
  {
    this.b.setColorFilter(paramInt, PorterDuff.Mode.DARKEN);
  }
  
  public void setDrawableLeft(Drawable paramDrawable)
  {
    this.h = paramDrawable;
    float f1 = this.k / this.h.getIntrinsicHeight();
    paramDrawable = this.h;
    paramDrawable.setBounds(0, 0, (int)(paramDrawable.getIntrinsicWidth() * f1), (int)(this.h.getIntrinsicHeight() * f1));
    this.a.setCompoundDrawables(this.h, null, null, null);
    this.a.setCompoundDrawablePadding(this.j);
  }
  
  public void setText(String paramString)
  {
    this.g = paramString;
    this.a.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.l = paramInt;
    this.a.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCapsuleView
 * JD-Core Version:    0.7.0.1
 */