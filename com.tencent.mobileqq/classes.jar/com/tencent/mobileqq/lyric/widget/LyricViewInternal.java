package com.tencent.mobileqq.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import avjs;
import avjt;
import avjv;
import avjx;
import avkl;
import avko;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LyricViewInternal
  extends View
{
  protected float a;
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected final Paint a;
  protected final Handler a;
  protected Scroller a;
  protected avjt a;
  protected Object a;
  protected final String a;
  public boolean a;
  protected int b;
  protected final Paint b;
  protected avjt b;
  protected String b;
  protected volatile boolean b;
  protected int c;
  protected final Paint c;
  protected volatile boolean c;
  protected int d;
  protected final Paint d;
  protected volatile boolean d;
  protected int e;
  protected final Paint e;
  protected volatile boolean e;
  protected int f;
  protected final Paint f;
  protected volatile boolean f;
  public int g;
  protected final Paint g;
  protected volatile boolean g;
  protected int h;
  protected final Paint h;
  protected volatile boolean h;
  protected int i;
  protected final Paint i;
  protected volatile boolean i;
  protected int j;
  protected final Paint j;
  protected int k = 3500;
  protected int l = -1;
  protected int m;
  protected int n = -1;
  protected int o = -1;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected volatile int t;
  protected int u;
  protected int v;
  protected int w;
  
  public LyricViewInternal(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternal(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_g_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_h_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_i_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_j_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new avko(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramAttributeSet = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    if (Build.VERSION.SDK_INT < 13) {}
    Object localObject;
    for (this.m = paramAttributeSet.getDefaultDisplay().getWidth();; this.m = ((Point)localObject).x)
    {
      localObject = new DisplayMetrics();
      paramAttributeSet.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131718544);
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131718543);
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
      return;
      localObject = new Point();
      paramAttributeSet.getDefaultDisplay().getSize((Point)localObject);
    }
  }
  
  public int a()
  {
    return this.t;
  }
  
  public int a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = true;
    return this.r;
  }
  
  public avjt a()
  {
    return this.jdField_a_of_type_Avjt;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.v = ((paramInt - this.jdField_f_of_type_Int - this.jdField_e_of_type_Int) / (this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) + 1);
    if (this.v < 0) {
      this.v = 2;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    a();
    postInvalidate();
  }
  
  protected void a(Canvas paramCanvas, int paramInt) {}
  
  protected void a(Canvas paramCanvas, Paint paramPaint, String paramString, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    paramString = paramString.split("\n");
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramString.length)
    {
      int i3 = this.jdField_h_of_type_Int;
      int i4 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString[i1]);
      paramCanvas.drawText(paramString[i1], (i3 - i4 >> 1) + paramInt1, paramInt2 + i2, paramPaint);
      paramPaint.getTextBounds(paramString[i1], 0, paramString[i1].length(), localRect);
      i2 += localRect.height() + 20;
      i1 += 1;
    }
  }
  
  void a(avjt paramavjt1, avjt paramavjt2)
  {
    for (;;)
    {
      try
      {
        Log.d("ModuleLyricViewInternal", "setLyric begin");
        this.jdField_c_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = false;
        if (paramavjt1 != null)
        {
          c();
          avjt localavjt = new avjt(2, 0, null);
          localavjt.a(paramavjt1);
          this.jdField_a_of_type_Avjt = localavjt;
          if ((paramavjt2 != null) && (paramavjt1.a() == paramavjt2.a()))
          {
            paramavjt1 = new avjt(2, 0, null);
            paramavjt1.a(paramavjt2);
            this.jdField_b_of_type_Avjt = paramavjt1;
            setState(70);
            Log.d("ModuleLyricViewInternal", "setLyric end");
            return;
          }
          Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
          this.jdField_b_of_type_Avjt = new avjt(2, 0, null);
          continue;
        }
        Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      }
      finally {}
      setState(40);
    }
  }
  
  protected void a(avjv paramavjv, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i3;
      int i2;
      try
      {
        ArrayList localArrayList = paramavjv.a();
        int i5 = this.s;
        Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        i3 = 0;
        i1 = paramInt2;
        if (i3 >= localArrayList.size()) {
          break label773;
        }
        avjx localavjx = (avjx)localArrayList.get(i3);
        if (localavjx.jdField_a_of_type_JavaUtilArrayList == null)
        {
          paramInt2 = i1;
          break label783;
        }
        int i4;
        float f3;
        float f2;
        float f1;
        long l1;
        float f4;
        if (i3 == 0)
        {
          i4 = this.jdField_c_of_type_Int;
          if ((localavjx.a() > i5) || (localavjx.b() < i5)) {
            continue;
          }
          f3 = 0.0F;
          f2 = 0.0F;
          paramavjv = null;
          i2 = 0;
          paramInt2 = 0;
          if (paramInt2 >= localavjx.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label776;
          }
          paramavjv = (avjs)localavjx.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
          avjs localavjs = null;
          if (paramInt2 < localavjx.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
            localavjs = (avjs)localavjx.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 + 1);
          }
          if ((paramavjv.jdField_a_of_type_Long > i5) || (localavjs == null) || (localavjs.jdField_a_of_type_Long <= i5)) {
            continue;
          }
          f1 = (float)(i5 - paramavjv.jdField_a_of_type_Long);
          l1 = paramavjv.jdField_b_of_type_Long;
          f1 /= (float)l1;
          f2 = f1;
          f3 = f1;
          if (paramavjv != null)
          {
            f1 = paramInt1;
            f4 = f1;
            if (paramInt2 == 0) {}
          }
        }
        try
        {
          if (localavjx.jdField_a_of_type_JavaLangString.length() >= ((avjs)localavjx.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 - 1)).jdField_b_of_type_Int)
          {
            f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(0, ((avjs)localavjx.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 - 1)).jdField_b_of_type_Int));
            f1 = f4 + f1;
            f4 = f1;
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          try
          {
            if (paramInt2 == localavjx.jdField_a_of_type_JavaUtilArrayList.size() - 1)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(paramavjv.jdField_a_of_type_Int, localavjx.jdField_a_of_type_JavaLangString.length()));
              i2 = localPaint.getColor();
              int i6 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
              localavjx.a(paramCanvas, paramInt1, i1 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, paramInt2, f1, f4, new int[] { i2, i6 }, new float[] { f3, f2 });
              paramInt2 = this.jdField_e_of_type_Int + i4 + i1;
              break label783;
              i4 = this.jdField_d_of_type_Int;
              continue;
              if ((paramavjv.jdField_a_of_type_Long <= i5) && (paramavjv.jdField_a_of_type_Long + paramavjv.jdField_b_of_type_Long >= i5))
              {
                f1 = (float)(i5 - paramavjv.jdField_a_of_type_Long);
                l1 = paramavjv.jdField_b_of_type_Long;
                f3 = f1 / (float)l1;
                f2 = f3;
                continue;
              }
              i2 = paramInt2;
              paramInt2 += 1;
              continue;
              f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(0, localavjx.jdField_a_of_type_JavaLangString.length()));
              f1 = f4 + f1;
              continue;
              localStringIndexOutOfBoundsException = localStringIndexOutOfBoundsException;
              f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(0, localavjx.jdField_a_of_type_JavaLangString.length()));
              f4 = f1 + f4;
              continue;
            }
            if (localavjx.jdField_a_of_type_JavaLangString.length() >= paramavjv.jdField_b_of_type_Int)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(paramavjv.jdField_a_of_type_Int, paramavjv.jdField_b_of_type_Int));
              continue;
            }
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(paramavjv.jdField_a_of_type_Int, localavjx.jdField_a_of_type_JavaLangString.length()));
            continue;
          }
          catch (StringIndexOutOfBoundsException paramavjv)
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localavjx.jdField_a_of_type_JavaLangString.substring(0, localavjx.jdField_a_of_type_JavaLangString.length()));
            continue;
          }
        }
        if (localavjx.b() < i5)
        {
          localavjx.a(paramCanvas, paramInt1, i1 + i4, localPaint, true);
          continue;
        }
        localavjx.a(paramCanvas, paramInt1, i1 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, true);
      }
      finally {}
      continue;
      label773:
      return;
      label776:
      paramInt2 = i2;
      continue;
      label783:
      i3 += 1;
      int i1 = paramInt2;
    }
  }
  
  protected void a(avjv paramavjv, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramavjv = paramavjv.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramavjv.size())
    {
      ((avjx)paramavjv.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(avjv paramavjv, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    paramavjv = paramavjv.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramavjv.size())
    {
      ((avjx)paramavjv.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint1, paramPaint2);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(avjv paramavjv, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramavjv.a();
    if (paramBoolean) {}
    for (paramavjv = this.jdField_b_of_type_AndroidGraphicsPaint;; paramavjv = this.jdField_a_of_type_AndroidGraphicsPaint)
    {
      int i3 = this.jdField_b_of_type_Int;
      int i4 = this.jdField_c_of_type_Int;
      int i2 = 0;
      int i1 = paramInt2;
      paramInt2 = i2;
      while (paramInt2 < localArrayList.size())
      {
        ((avjx)localArrayList.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramavjv, paramBoolean);
        i1 += i3 + i4;
        paramInt2 += 1;
      }
    }
  }
  
  public void a(avkl paramavkl)
  {
    this.jdField_a_of_type_Avjt = new avjt(2, 0, null);
    this.jdField_b_of_type_Avjt = new avjt(2, 0, null);
    this.jdField_d_of_type_Int = paramavkl.jdField_j_of_type_Int;
    this.jdField_b_of_type_Int = paramavkl.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = paramavkl.jdField_i_of_type_Int;
    int i1 = paramavkl.jdField_e_of_type_Int;
    int i2 = paramavkl.jdField_f_of_type_Int;
    int i3 = paramavkl.jdField_g_of_type_Int;
    this.jdField_e_of_type_Int = paramavkl.jdField_h_of_type_Int;
    int i4 = paramavkl.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramavkl.jdField_a_of_type_Int;
    this.jdField_g_of_type_Boolean = paramavkl.jdField_a_of_type_Boolean;
    boolean bool = paramavkl.jdField_b_of_type_Boolean;
    this.jdField_i_of_type_Boolean = true;
    this.v = 3;
    this.w = 2;
    this.jdField_g_of_type_Int = paramavkl.l;
    this.jdField_a_of_type_Boolean = paramavkl.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(i1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(i1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(i2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(i1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(i2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(bool);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAlpha(127);
    this.jdField_g_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_g_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_g_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_g_of_type_AndroidGraphicsPaint.setAlpha(51);
    this.jdField_h_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_h_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_h_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_h_of_type_AndroidGraphicsPaint.setAlpha(25);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_i_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_i_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_i_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_i_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_j_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(i1);
    this.jdField_j_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_j_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_f_of_type_Int = this.jdField_c_of_type_Int;
  }
  
  public void a(boolean paramBoolean) {}
  
  protected int b()
  {
    if (this.jdField_j_of_type_Int == -1) {
      this.jdField_j_of_type_Int = ((int)(43.0F * this.jdField_a_of_type_Float));
    }
    return this.jdField_j_of_type_Int;
  }
  
  public int b(int paramInt)
  {
    paramInt = this.r;
    this.jdField_d_of_type_Boolean = false;
    return paramInt;
  }
  
  public avjt b()
  {
    return this.jdField_a_of_type_Avjt;
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new LyricViewInternal.2(this));
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.n = -1;
    this.o = -1;
    this.p = 0;
    this.q = 0;
    this.jdField_e_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = (getMeasuredHeight() >> 1) - this.jdField_b_of_type_Int;
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        scrollTo(0, 0);
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_JavaLangString, 0, i1);
      }
      break;
    }
    do
    {
      return;
      a(paramCanvas, 0);
      return;
    } while (this.jdField_a_of_type_JavaLangString == null);
    scrollTo(0, 0);
    this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_JavaLangString, 0, i1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    View localView = (View)((View)getParent()).getParent();
    int i2 = localView.getMeasuredWidth();
    int i3 = localView.getMeasuredHeight();
    if (this.jdField_i_of_type_Int == 70)
    {
      paramInt1 = i2 - (b() << 1);
      int i4 = this.jdField_b_of_type_Int;
      int i5 = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Avjt.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        if ((this.jdField_b_of_type_Avjt != null) && (this.jdField_a_of_type_Avjt.a() == this.jdField_b_of_type_Avjt.a()))
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label222;
          }
          this.jdField_b_of_type_Avjt.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        }
      }
      int i1;
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label241;
        }
        i1 = this.p;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.q) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Avjt.jdField_a_of_type_JavaUtilArrayList.get(i1) != null) {
            paramInt1 = paramInt2 + ((avjv)this.jdField_a_of_type_Avjt.jdField_a_of_type_JavaUtilArrayList.get(i1)).a();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
        this.jdField_a_of_type_Avjt.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        break;
        label222:
        this.jdField_b_of_type_Avjt.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
      }
      label241:
      paramInt1 = this.jdField_a_of_type_Avjt.b();
      paramInt2 = paramInt1;
      if (this.jdField_f_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (this.jdField_b_of_type_Avjt != null)
        {
          paramInt2 = paramInt1;
          if (this.jdField_b_of_type_Avjt.jdField_a_of_type_JavaUtilArrayList != null) {
            if (this.jdField_b_of_type_Boolean)
            {
              i1 = this.p;
              paramInt2 = paramInt1;
              if (i1 <= this.q)
              {
                paramInt2 = paramInt1;
                if (i1 < this.jdField_b_of_type_Avjt.jdField_a_of_type_JavaUtilArrayList.size()) {
                  if (i1 >= 0) {
                    break label332;
                  }
                }
                label332:
                for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + ((avjv)this.jdField_b_of_type_Avjt.jdField_a_of_type_JavaUtilArrayList.get(i1)).a())
                {
                  i1 += 1;
                  paramInt1 = paramInt2;
                  break;
                }
              }
            }
            else
            {
              paramInt2 = paramInt1 + this.jdField_b_of_type_Avjt.b();
            }
          }
        }
      }
      this.k = (paramInt2 * (i4 + i5));
      setMeasuredDimension(i2, this.k + i3);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void setDrawAttachInfo(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setHighlightCurrentLine(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setHighlightLineNumber(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setIndicator(Bitmap paramBitmap) {}
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLyricColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setLyricHilightColor(int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setScore(int[] paramArrayOfInt) {}
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      if ((this.jdField_a_of_type_Avjt == null) || (this.jdField_a_of_type_Avjt.a())) {
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      }
    }
    else
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
      return;
    }
    if ((this.n == paramInt1) && (this.o == paramInt2))
    {
      Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
      return;
    }
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = this.jdField_a_of_type_Avjt.b(paramInt1);
    this.q = this.jdField_a_of_type_Avjt.c(paramInt2);
    if ((this.p < 0) || (this.q < 0))
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void setState(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal
 * JD-Core Version:    0.7.0.1
 */