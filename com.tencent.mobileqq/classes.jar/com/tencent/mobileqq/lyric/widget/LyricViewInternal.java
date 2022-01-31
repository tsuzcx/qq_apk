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
import asbb;
import asbc;
import asbe;
import asbg;
import asbu;
import asbx;
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
  protected asbc a;
  protected Object a;
  protected final String a;
  public boolean a;
  protected int b;
  protected final Paint b;
  protected asbc b;
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
    this.jdField_a_of_type_AndroidOsHandler = new asbx(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramAttributeSet = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    if (Build.VERSION.SDK_INT < 13) {}
    Object localObject;
    for (this.m = paramAttributeSet.getDefaultDisplay().getWidth();; this.m = ((Point)localObject).x)
    {
      localObject = new DisplayMetrics();
      paramAttributeSet.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131719699);
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131719698);
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
  
  public asbc a()
  {
    return this.jdField_a_of_type_Asbc;
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
  
  void a(asbc paramasbc1, asbc paramasbc2)
  {
    for (;;)
    {
      try
      {
        Log.d("ModuleLyricViewInternal", "setLyric begin");
        this.jdField_c_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = false;
        if (paramasbc1 != null)
        {
          c();
          asbc localasbc = new asbc(2, 0, null);
          localasbc.a(paramasbc1);
          this.jdField_a_of_type_Asbc = localasbc;
          if ((paramasbc2 != null) && (paramasbc1.a() == paramasbc2.a()))
          {
            paramasbc1 = new asbc(2, 0, null);
            paramasbc1.a(paramasbc2);
            this.jdField_b_of_type_Asbc = paramasbc1;
            setState(70);
            Log.d("ModuleLyricViewInternal", "setLyric end");
            return;
          }
          Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
          this.jdField_b_of_type_Asbc = new asbc(2, 0, null);
          continue;
        }
        Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      }
      finally {}
      setState(40);
    }
  }
  
  protected void a(asbe paramasbe, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i3;
      int i2;
      try
      {
        ArrayList localArrayList = paramasbe.a();
        int i5 = this.s;
        Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        i3 = 0;
        i1 = paramInt2;
        if (i3 >= localArrayList.size()) {
          break label773;
        }
        asbg localasbg = (asbg)localArrayList.get(i3);
        if (localasbg.jdField_a_of_type_JavaUtilArrayList == null)
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
          if ((localasbg.a() > i5) || (localasbg.b() < i5)) {
            continue;
          }
          f3 = 0.0F;
          f2 = 0.0F;
          paramasbe = null;
          i2 = 0;
          paramInt2 = 0;
          if (paramInt2 >= localasbg.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label776;
          }
          paramasbe = (asbb)localasbg.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
          asbb localasbb = null;
          if (paramInt2 < localasbg.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
            localasbb = (asbb)localasbg.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 + 1);
          }
          if ((paramasbe.jdField_a_of_type_Long > i5) || (localasbb == null) || (localasbb.jdField_a_of_type_Long <= i5)) {
            continue;
          }
          f1 = (float)(i5 - paramasbe.jdField_a_of_type_Long);
          l1 = paramasbe.jdField_b_of_type_Long;
          f1 /= (float)l1;
          f2 = f1;
          f3 = f1;
          if (paramasbe != null)
          {
            f1 = paramInt1;
            f4 = f1;
            if (paramInt2 == 0) {}
          }
        }
        try
        {
          if (localasbg.jdField_a_of_type_JavaLangString.length() >= ((asbb)localasbg.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 - 1)).jdField_b_of_type_Int)
          {
            f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(0, ((asbb)localasbg.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 - 1)).jdField_b_of_type_Int));
            f1 = f4 + f1;
            f4 = f1;
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          try
          {
            if (paramInt2 == localasbg.jdField_a_of_type_JavaUtilArrayList.size() - 1)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(paramasbe.jdField_a_of_type_Int, localasbg.jdField_a_of_type_JavaLangString.length()));
              i2 = localPaint.getColor();
              int i6 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
              localasbg.a(paramCanvas, paramInt1, i1 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, paramInt2, f1, f4, new int[] { i2, i6 }, new float[] { f3, f2 });
              paramInt2 = this.jdField_e_of_type_Int + i4 + i1;
              break label783;
              i4 = this.jdField_d_of_type_Int;
              continue;
              if ((paramasbe.jdField_a_of_type_Long <= i5) && (paramasbe.jdField_a_of_type_Long + paramasbe.jdField_b_of_type_Long >= i5))
              {
                f1 = (float)(i5 - paramasbe.jdField_a_of_type_Long);
                l1 = paramasbe.jdField_b_of_type_Long;
                f3 = f1 / (float)l1;
                f2 = f3;
                continue;
              }
              i2 = paramInt2;
              paramInt2 += 1;
              continue;
              f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(0, localasbg.jdField_a_of_type_JavaLangString.length()));
              f1 = f4 + f1;
              continue;
              localStringIndexOutOfBoundsException = localStringIndexOutOfBoundsException;
              f4 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(0, localasbg.jdField_a_of_type_JavaLangString.length()));
              f4 = f1 + f4;
              continue;
            }
            if (localasbg.jdField_a_of_type_JavaLangString.length() >= paramasbe.jdField_b_of_type_Int)
            {
              f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(paramasbe.jdField_a_of_type_Int, paramasbe.jdField_b_of_type_Int));
              continue;
            }
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(paramasbe.jdField_a_of_type_Int, localasbg.jdField_a_of_type_JavaLangString.length()));
            continue;
          }
          catch (StringIndexOutOfBoundsException paramasbe)
          {
            f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localasbg.jdField_a_of_type_JavaLangString.substring(0, localasbg.jdField_a_of_type_JavaLangString.length()));
            continue;
          }
        }
        if (localasbg.b() < i5)
        {
          localasbg.a(paramCanvas, paramInt1, i1 + i4, localPaint, true);
          continue;
        }
        localasbg.a(paramCanvas, paramInt1, i1 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, true);
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
  
  protected void a(asbe paramasbe, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramasbe = paramasbe.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramasbe.size())
    {
      ((asbg)paramasbe.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(asbe paramasbe, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    paramasbe = paramasbe.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramasbe.size())
    {
      ((asbg)paramasbe.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint1, paramPaint2);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(asbe paramasbe, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramasbe.a();
    if (paramBoolean) {}
    for (paramasbe = this.jdField_b_of_type_AndroidGraphicsPaint;; paramasbe = this.jdField_a_of_type_AndroidGraphicsPaint)
    {
      int i3 = this.jdField_b_of_type_Int;
      int i4 = this.jdField_c_of_type_Int;
      int i2 = 0;
      int i1 = paramInt2;
      paramInt2 = i2;
      while (paramInt2 < localArrayList.size())
      {
        ((asbg)localArrayList.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramasbe, paramBoolean);
        i1 += i3 + i4;
        paramInt2 += 1;
      }
    }
  }
  
  public void a(asbu paramasbu)
  {
    this.jdField_a_of_type_Asbc = new asbc(2, 0, null);
    this.jdField_b_of_type_Asbc = new asbc(2, 0, null);
    this.jdField_d_of_type_Int = paramasbu.jdField_j_of_type_Int;
    this.jdField_b_of_type_Int = paramasbu.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = paramasbu.jdField_i_of_type_Int;
    int i1 = paramasbu.jdField_e_of_type_Int;
    int i2 = paramasbu.jdField_f_of_type_Int;
    int i3 = paramasbu.jdField_g_of_type_Int;
    this.jdField_e_of_type_Int = paramasbu.jdField_h_of_type_Int;
    int i4 = paramasbu.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramasbu.jdField_a_of_type_Int;
    this.jdField_g_of_type_Boolean = paramasbu.jdField_a_of_type_Boolean;
    boolean bool = paramasbu.jdField_b_of_type_Boolean;
    this.jdField_i_of_type_Boolean = true;
    this.v = 3;
    this.w = 2;
    this.jdField_g_of_type_Int = paramasbu.l;
    this.jdField_a_of_type_Boolean = paramasbu.jdField_c_of_type_Boolean;
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
  
  public asbc b()
  {
    return this.jdField_a_of_type_Asbc;
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
        this.jdField_a_of_type_Asbc.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        if ((this.jdField_b_of_type_Asbc != null) && (this.jdField_a_of_type_Asbc.a() == this.jdField_b_of_type_Asbc.a()))
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label222;
          }
          this.jdField_b_of_type_Asbc.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
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
          if (this.jdField_a_of_type_Asbc.jdField_a_of_type_JavaUtilArrayList.get(i1) != null) {
            paramInt1 = paramInt2 + ((asbe)this.jdField_a_of_type_Asbc.jdField_a_of_type_JavaUtilArrayList.get(i1)).a();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
        this.jdField_a_of_type_Asbc.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        break;
        label222:
        this.jdField_b_of_type_Asbc.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
      }
      label241:
      paramInt1 = this.jdField_a_of_type_Asbc.b();
      paramInt2 = paramInt1;
      if (this.jdField_f_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (this.jdField_b_of_type_Asbc != null)
        {
          paramInt2 = paramInt1;
          if (this.jdField_b_of_type_Asbc.jdField_a_of_type_JavaUtilArrayList != null) {
            if (this.jdField_b_of_type_Boolean)
            {
              i1 = this.p;
              paramInt2 = paramInt1;
              if (i1 <= this.q)
              {
                paramInt2 = paramInt1;
                if (i1 < this.jdField_b_of_type_Asbc.jdField_a_of_type_JavaUtilArrayList.size()) {
                  if (i1 >= 0) {
                    break label332;
                  }
                }
                label332:
                for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + ((asbe)this.jdField_b_of_type_Asbc.jdField_a_of_type_JavaUtilArrayList.get(i1)).a())
                {
                  i1 += 1;
                  paramInt1 = paramInt2;
                  break;
                }
              }
            }
            else
            {
              paramInt2 = paramInt1 + this.jdField_b_of_type_Asbc.b();
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
      if ((this.jdField_a_of_type_Asbc == null) || (this.jdField_a_of_type_Asbc.a())) {
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
    this.p = this.jdField_a_of_type_Asbc.b(paramInt1);
    this.q = this.jdField_a_of_type_Asbc.c(paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal
 * JD-Core Version:    0.7.0.1
 */