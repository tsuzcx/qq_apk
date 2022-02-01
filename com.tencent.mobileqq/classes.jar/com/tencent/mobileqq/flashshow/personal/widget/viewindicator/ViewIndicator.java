package com.tencent.mobileqq.flashshow.personal.widget.viewindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.flashshow.impl.R.styleable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewIndicator
  extends LinearLayoutCompat
{
  private static final int a = Color.parseColor("#000000");
  private static final int b = Color.parseColor("#DC143C");
  private final Set<ViewPager2> A = new HashSet();
  private boolean B = false;
  private int c = 0;
  private boolean d;
  private boolean e;
  private int f;
  private float g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private final int p;
  private final int q;
  private final ArrayList<Integer> r = new ArrayList();
  private final int s;
  private float t = 0.0F;
  private float u = 0.0F;
  private Paint v;
  private Path w;
  private List<String> x;
  private final Set<ViewIndicator.TextItemClickListener> y = new HashSet();
  private final Set<ViewPager> z = new HashSet();
  
  public ViewIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setGravity(16);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fd);
    this.f = paramContext.getInt(R.styleable.ft, 4);
    this.n = (i1 / this.f);
    this.n = paramContext.getDimensionPixelSize(R.styleable.fm, this.n);
    this.h = paramContext.getDimensionPixelSize(R.styleable.fl, 0);
    this.g = paramContext.getDimensionPixelSize(R.styleable.fr, 14);
    this.i = paramContext.getInt(R.styleable.fs, 0);
    this.j = paramContext.getInt(R.styleable.fq, 17);
    this.d = paramContext.getBoolean(R.styleable.fp, true);
    this.k = paramContext.getInt(R.styleable.fn, a);
    this.l = paramContext.getInt(R.styleable.fo, b);
    this.m = paramContext.getInt(R.styleable.fj, 1);
    this.s = paramContext.getInt(R.styleable.fe, this.l);
    this.q = paramContext.getDimensionPixelSize(R.styleable.fh, 5);
    this.e = paramContext.getBoolean(R.styleable.ff, true);
    float f1 = paramContext.getFloat(R.styleable.fi, 1.0F);
    this.o = ((int)(this.n * f1));
    this.o = paramContext.getDimensionPixelSize(R.styleable.fk, this.o);
    this.p = paramContext.getDimensionPixelSize(R.styleable.fg, 4);
    paramContext.recycle();
    a();
    b();
    this.t = getPaddingLeft();
  }
  
  private TextView a(int paramInt, String paramString)
  {
    Object localObject;
    if (this.d) {
      localObject = new ColorTrackTextView(getContext(), this.k, this.l, this.h);
    } else {
      localObject = new TextView(getContext());
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    ((TextView)localObject).setTextSize(0, this.g);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setTypeface(((TextView)localObject).getTypeface(), this.i);
    ((TextView)localObject).setPadding(0, 0, this.h, 0);
    ((TextView)localObject).setGravity(this.j);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setOnClickListener(new ViewIndicator.1(this, paramInt));
    return localObject;
  }
  
  private void a()
  {
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setColor(this.s);
    this.v.setStyle(Paint.Style.FILL);
    this.v.setTextSize(this.g);
    this.v.setPathEffect(new CornerPathEffect(3.0F));
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (paramInt >= getChildCount()) {
      return;
    }
    if (this.d)
    {
      ((ColorTrackTextView)getChildAt(paramInt)).a(paramFloat, true);
      if (paramInt < getChildCount() - 1) {
        ((ColorTrackTextView)getChildAt(paramInt + 1)).a(paramFloat, false);
      }
    }
    a(paramInt, Float.valueOf(paramFloat));
    postInvalidate();
  }
  
  private void a(int paramInt, Float paramFloat)
  {
    if (this.r.isEmpty()) {
      return;
    }
    int i1 = ((Integer)this.r.get(paramInt)).intValue();
    float f1 = i1;
    this.u = f1;
    paramInt += 1;
    if (paramInt < this.r.size())
    {
      paramInt = ((Integer)this.r.get(paramInt)).intValue();
      this.u = (f1 + paramFloat.floatValue() * (paramInt - i1));
    }
  }
  
  private void b()
  {
    this.w = new Path();
    RectF localRectF = new RectF(0.0F, 0.0F, this.o, this.p);
    Path localPath = this.w;
    int i1 = this.p;
    localPath.addRoundRect(localRectF, i1 / 2, i1 / 2, Path.Direction.CW);
  }
  
  private void c()
  {
    removeAllViews();
    if (this.x == null) {
      return;
    }
    int i1 = 0;
    while (i1 < this.x.size())
    {
      addView(a(i1, (String)this.x.get(i1)));
      i1 += 1;
    }
    if (this.c >= getChildCount()) {
      this.c = 0;
    }
  }
  
  private void setText(int paramInt)
  {
    this.c = paramInt;
    int i1 = 0;
    while (i1 < getChildCount())
    {
      Object localObject;
      if (this.d)
      {
        localObject = (ColorTrackTextView)getChildAt(i1);
        float f1;
        if (i1 == paramInt) {
          f1 = 1.0F;
        } else {
          f1 = -1.0F;
        }
        ((ColorTrackTextView)localObject).a(f1, false);
      }
      else
      {
        localObject = (TextView)getChildAt(i1);
        int i2;
        if (i1 == paramInt) {
          i2 = this.l;
        } else {
          i2 = this.k;
        }
        ((TextView)localObject).setTextColor(i2);
      }
      i1 += 1;
    }
    a(paramInt, 0.0F);
  }
  
  public void a(ViewPager2 paramViewPager2)
  {
    if (this.A.contains(paramViewPager2)) {
      return;
    }
    paramViewPager2.registerOnPageChangeCallback(new ViewIndicator.3(this));
    this.A.add(paramViewPager2);
  }
  
  public void a(ViewIndicator.TextItemClickListener paramTextItemClickListener)
  {
    if (this.y.contains(paramTextItemClickListener)) {
      return;
    }
    this.y.add(paramTextItemClickListener);
  }
  
  public void a(List<String> paramList)
  {
    this.x = paramList;
    c();
    requestLayout();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.r.size() > 1) && (this.m != 0) && (paramCanvas != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.t + this.u - this.o / 2, getHeight() - this.p - this.q);
      paramCanvas.drawPath(this.w, this.v);
      paramCanvas.restore();
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r.clear();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < getChildCount(); paramInt2 = paramInt3)
    {
      paramInt3 = getChildAt(paramInt1).getMeasuredWidth() - this.h;
      if (paramInt1 == 0)
      {
        this.r.add(Integer.valueOf(paramInt3 / 2));
      }
      else
      {
        ArrayList localArrayList = this.r;
        localArrayList.add(Integer.valueOf(((Integer)localArrayList.get(paramInt1 - 1)).intValue() + paramInt2 / 2 + paramInt3 / 2 + this.h));
      }
      paramInt1 += 1;
    }
    setText(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator
 * JD-Core Version:    0.7.0.1
 */