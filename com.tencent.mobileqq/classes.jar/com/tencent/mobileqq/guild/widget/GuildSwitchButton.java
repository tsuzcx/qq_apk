package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.impl.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GuildSwitchButton
  extends View
  implements View.OnClickListener, Checkable
{
  private static final int a = ViewUtils.dpToPx(16.0F);
  private static final int b = ViewUtils.dpToPx(10.0F);
  private static final int c = Color.parseColor("#0099FF");
  private static final int d = Color.parseColor("#BBC4D2");
  private Paint e;
  private Paint f;
  private RectF g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private int n;
  private int o;
  private int p;
  private boolean q = false;
  private GuildSwitchButton.OnCheckedChangeListener r;
  
  public GuildSwitchButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public GuildSwitchButton(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public GuildSwitchButton(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public GuildSwitchButton(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aH);
    } else {
      paramContext = null;
    }
    this.n = paramContext.getColor(R.styleable.aK, c);
    this.o = paramContext.getColor(R.styleable.aM, d);
    this.p = paramContext.getColor(R.styleable.aI, -1);
    this.i = paramContext.getDimension(R.styleable.aJ, b);
    this.h = paramContext.getDimension(R.styleable.aN, a);
    this.q = paramContext.getBoolean(R.styleable.aL, false);
    paramContext.recycle();
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.FILL);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(this.p);
    this.f.setStyle(Paint.Style.FILL);
    this.j = this.h;
    this.g = new RectF();
    postInvalidate();
    super.setOnClickListener(this);
  }
  
  private void b()
  {
    GuildSwitchButton.OnCheckedChangeListener localOnCheckedChangeListener = this.r;
    if (localOnCheckedChangeListener != null) {
      localOnCheckedChangeListener.onCheckedChanged(this, isChecked());
    }
  }
  
  void a()
  {
    if (this.q)
    {
      this.j = this.m;
      this.e.setColor(this.n);
      return;
    }
    this.j = this.l;
    this.e.setColor(this.o);
  }
  
  public boolean isChecked()
  {
    return this.q;
  }
  
  public void onClick(View paramView)
  {
    ((Vibrator)getContext().getSystemService("vibrator")).vibrate(20L);
    toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
    RectF localRectF = this.g;
    int i1 = a;
    paramCanvas.drawRoundRect(localRectF, i1, i1, this.e);
    paramCanvas.drawCircle(this.j, this.k, this.i, this.f);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    float f2 = this.h;
    this.l = f2;
    float f1 = paramInt1;
    this.m = (f1 - f2);
    this.j = this.l;
    f2 = paramInt2;
    this.k = (0.5F * f2);
    RectF localRectF = this.g;
    localRectF.left = 0.0F;
    localRectF.top = 0.0F;
    localRectF.right = f1;
    localRectF.bottom = f2;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.q = paramBoolean;
    postInvalidate();
    b();
  }
  
  public void setOnCheckedChangeListener(GuildSwitchButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.r = paramOnCheckedChangeListener;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener) {}
  
  public void setOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener) {}
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {}
  
  public void toggle()
  {
    this.q ^= true;
    postInvalidate();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildSwitchButton
 * JD-Core Version:    0.7.0.1
 */