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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.data.Character;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.data.SentenceUI;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LyricViewInternal
  extends View
{
  protected float a;
  protected int a;
  protected volatile long a;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected final Paint a;
  protected final Handler a;
  protected Scroller a;
  protected Lyric a;
  protected Object a;
  protected final String a;
  public boolean a;
  protected int b;
  protected final Paint b;
  protected Lyric b;
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
  protected int k = -1;
  protected int l = 3500;
  protected int m = -1;
  protected int n;
  protected int o = -1;
  protected int p = -1;
  protected int q = 0;
  protected int r = 0;
  protected int s = 0;
  protected int t = 0;
  protected volatile int u = 0;
  protected int v;
  protected int w;
  protected int x;
  
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
    this.jdField_h_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new LyricViewInternal.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramAttributeSet = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    if (Build.VERSION.SDK_INT < 13)
    {
      this.n = paramAttributeSet.getDefaultDisplay().getWidth();
    }
    else
    {
      localObject = new Point();
      paramAttributeSet.getDefaultDisplay().getSize((Point)localObject);
      this.n = ((Point)localObject).x;
    }
    Object localObject = new DisplayMetrics();
    paramAttributeSet.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131719175);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131719174);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public int a()
  {
    return this.u;
  }
  
  public int a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = true;
    return this.s;
  }
  
  Lyric a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.w = ((paramInt - this.jdField_f_of_type_Int - this.jdField_e_of_type_Int) / (this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) + 1);
    if (this.w < 0) {
      this.w = 2;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.s = paramInt1;
    this.t = paramInt2;
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
      int i3 = this.jdField_i_of_type_Int;
      int i4 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString[i1]);
      paramCanvas.drawText(paramString[i1], (i3 - i4 >> 1) + paramInt1, paramInt2 + i2, paramPaint);
      paramPaint.getTextBounds(paramString[i1], 0, paramString[i1].length(), localRect);
      i2 += localRect.height() + 20;
      i1 += 1;
    }
  }
  
  void a(Lyric paramLyric1, Lyric paramLyric2)
  {
    try
    {
      Log.d("ModuleLyricViewInternal", "setLyric begin");
      this.jdField_c_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = false;
      if (paramLyric1 != null)
      {
        c();
        Lyric localLyric = new Lyric(2, 0, null);
        localLyric.a(paramLyric1);
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = localLyric;
        if ((paramLyric2 != null) && (paramLyric1.a() == paramLyric2.a()))
        {
          paramLyric1 = new Lyric(2, 0, null);
          paramLyric1.a(paramLyric2);
          this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = paramLyric1;
        }
        else
        {
          Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
          this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = new Lyric(2, 0, null);
        }
        setState(70);
      }
      else
      {
        Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
        setState(40);
      }
      Log.d("ModuleLyricViewInternal", "setLyric end");
      return;
    }
    finally {}
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = paramSentence.a();
        int i6 = this.t;
        localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        i1 = 0;
        i3 = paramInt2;
        paramInt2 = i1;
        if (paramInt2 >= localArrayList.size()) {
          continue;
        }
        localSentenceUI = (SentenceUI)localArrayList.get(paramInt2);
        if (localSentenceUI.jdField_a_of_type_JavaUtilArrayList == null) {
          continue;
        }
        if (paramInt2 == 0) {
          i4 = this.jdField_c_of_type_Int;
        } else {
          i4 = this.jdField_d_of_type_Int;
        }
        l1 = localSentenceUI.a();
        l2 = i6;
        if ((l1 > l2) || (localSentenceUI.b() < l2)) {
          continue;
        }
        paramSentence = null;
        i5 = 0;
        i2 = 0;
        i1 = paramInt2;
        paramInt2 = i5;
        i5 = localSentenceUI.jdField_a_of_type_JavaUtilArrayList.size();
        f3 = 0.0F;
        if (paramInt2 >= i5) {
          continue;
        }
        paramSentence = (Character)localSentenceUI.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
        if (paramInt2 >= localSentenceUI.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          continue;
        }
        localObject1 = (Character)localSentenceUI.jdField_a_of_type_JavaUtilArrayList.get(paramInt2 + 1);
      }
      finally
      {
        Paint localPaint;
        int i1;
        int i3;
        SentenceUI localSentenceUI;
        int i4;
        long l1;
        long l2;
        int i5;
        int i2;
        float f3;
        Object localObject1;
        float f2;
        float f1;
        float f5;
        float f4;
        continue;
        throw paramSentence;
        continue;
        Object localObject2 = null;
        continue;
        paramInt2 = i1;
        continue;
      }
      if ((paramSentence.jdField_a_of_type_Long <= l2) && (localObject1 != null) && (((Character)localObject1).jdField_a_of_type_Long > l2))
      {
        f3 = (float)(l2 - paramSentence.jdField_a_of_type_Long) / (float)paramSentence.jdField_b_of_type_Long;
        f2 = f3;
      }
      else if ((paramSentence.jdField_a_of_type_Long <= l2) && (paramSentence.jdField_a_of_type_Long + paramSentence.jdField_b_of_type_Long >= l2))
      {
        f1 = (float)(l2 - paramSentence.jdField_a_of_type_Long);
        l1 = paramSentence.jdField_b_of_type_Long;
        f3 = f1 / (float)l1;
        f2 = f3;
      }
      else
      {
        i2 = paramInt2;
        paramInt2 += 1;
        continue;
        paramInt2 = i2;
        f2 = 0.0F;
      }
      if (paramSentence == null) {
        continue;
      }
      f5 = paramInt1;
      f4 = f5;
      if (paramInt2 != 0) {}
      try
      {
        i2 = localSentenceUI.jdField_a_of_type_JavaLangString.length();
        localObject1 = localSentenceUI.jdField_a_of_type_JavaUtilArrayList;
        i5 = paramInt2 - 1;
        if (i2 >= ((Character)((ArrayList)localObject1).get(i5)).jdField_b_of_type_Int) {
          f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(0, ((Character)localSentenceUI.jdField_a_of_type_JavaUtilArrayList.get(i5)).jdField_b_of_type_Int));
        } else {
          f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(0, localSentenceUI.jdField_a_of_type_JavaLangString.length()));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        continue;
      }
      f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(0, localSentenceUI.jdField_a_of_type_JavaLangString.length()));
      f4 = f5 + f1;
      try
      {
        if (paramInt2 == localSentenceUI.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(paramSentence.jdField_a_of_type_Int, localSentenceUI.jdField_a_of_type_JavaLangString.length()));
        } else if (localSentenceUI.jdField_a_of_type_JavaLangString.length() >= paramSentence.jdField_b_of_type_Int) {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(paramSentence.jdField_a_of_type_Int, paramSentence.jdField_b_of_type_Int));
        } else {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(paramSentence.jdField_a_of_type_Int, localSentenceUI.jdField_a_of_type_JavaLangString.length()));
        }
      }
      catch (StringIndexOutOfBoundsException paramSentence)
      {
        continue;
      }
      f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.jdField_a_of_type_JavaLangString.substring(0, localSentenceUI.jdField_a_of_type_JavaLangString.length()));
      i2 = localPaint.getColor();
      i5 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
      localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, paramInt2, f1, f4, new int[] { i2, i5 }, new float[] { f3, f2 });
      paramInt2 = i1;
      continue;
      if (localSentenceUI.b() < l2) {
        localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, localPaint, true);
      } else {
        localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, this.jdField_c_of_type_AndroidGraphicsPaint, true);
      }
      i1 = this.jdField_e_of_type_Int;
      i3 += i4 + i1;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramSentence = paramSentence.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    paramSentence = paramSentence.a();
    int i3 = this.jdField_b_of_type_Int;
    int i4 = this.jdField_c_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramPaint1, paramPaint2);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramSentence.a();
    if (paramBoolean) {
      paramSentence = this.jdField_b_of_type_AndroidGraphicsPaint;
    } else {
      paramSentence = this.jdField_a_of_type_AndroidGraphicsPaint;
    }
    int i2 = this.jdField_b_of_type_Int;
    int i3 = this.jdField_c_of_type_Int;
    int i1 = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < localArrayList.size())
    {
      ((SentenceUI)localArrayList.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.jdField_c_of_type_Int, paramSentence, paramBoolean);
      i1 += i2 + i3;
      paramInt2 += 1;
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_d_of_type_Int = paramLyricViewAttribute.jdField_j_of_type_Int;
    this.jdField_b_of_type_Int = paramLyricViewAttribute.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = paramLyricViewAttribute.jdField_i_of_type_Int;
    int i1 = paramLyricViewAttribute.jdField_e_of_type_Int;
    int i2 = paramLyricViewAttribute.jdField_f_of_type_Int;
    int i3 = paramLyricViewAttribute.jdField_g_of_type_Int;
    this.jdField_e_of_type_Int = paramLyricViewAttribute.jdField_h_of_type_Int;
    int i4 = paramLyricViewAttribute.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramLyricViewAttribute.jdField_a_of_type_Int;
    this.jdField_g_of_type_Boolean = paramLyricViewAttribute.jdField_a_of_type_Boolean;
    boolean bool = paramLyricViewAttribute.jdField_b_of_type_Boolean;
    this.jdField_i_of_type_Boolean = true;
    this.w = 3;
    this.x = 2;
    this.jdField_g_of_type_Int = paramLyricViewAttribute.l;
    this.jdField_a_of_type_Boolean = paramLyricViewAttribute.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    paramLyricViewAttribute = this.jdField_c_of_type_AndroidGraphicsPaint;
    float f1 = i1;
    paramLyricViewAttribute.setTextSize(f1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(f1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(i2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f1);
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
    this.jdField_j_of_type_AndroidGraphicsPaint.setTextSize(f1);
    this.jdField_j_of_type_AndroidGraphicsPaint.setColor(i4);
    this.jdField_j_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_f_of_type_Int = this.jdField_c_of_type_Int;
  }
  
  public void a(boolean paramBoolean) {}
  
  protected int b()
  {
    if (this.k == -1) {
      this.k = ((int)(this.jdField_a_of_type_Float * 43.0F));
    }
    return this.k;
  }
  
  public int b(int paramInt)
  {
    paramInt = this.s;
    this.jdField_d_of_type_Boolean = false;
    return paramInt;
  }
  
  public Lyric b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new LyricViewInternal.2(this));
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.o = -1;
    this.p = -1;
    this.q = 0;
    this.r = 0;
    this.jdField_e_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = (getMeasuredHeight() >> 1) - this.jdField_b_of_type_Int;
    int i2 = this.jdField_j_of_type_Int;
    if ((i2 != 40) && (i2 != 60))
    {
      if (i2 != 70)
      {
        if (this.jdField_b_of_type_JavaLangString != null)
        {
          scrollTo(0, 0);
          this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
          a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_JavaLangString, 0, i1);
        }
      }
      else {
        a(paramCanvas, 0);
      }
    }
    else if (this.jdField_a_of_type_JavaLangString != null)
    {
      scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_JavaLangString, 0, i1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = (View)((View)getParent()).getParent();
    int i2 = ((View)localObject).getMeasuredWidth();
    int i3 = ((View)localObject).getMeasuredHeight();
    if (this.jdField_j_of_type_Int == 70)
    {
      paramInt1 = i2 - (b() << 1);
      paramInt2 = 0;
      int i4 = this.jdField_b_of_type_Int;
      int i5 = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a() == this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a())) {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        } else {
          this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        }
      }
      int i1;
      if (this.jdField_b_of_type_Boolean)
      {
        i1 = this.q;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.r) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(i1) != null) {
            paramInt1 = paramInt2 + ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(i1)).a();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.b();
      paramInt2 = paramInt1;
      if (this.jdField_f_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((Lyric)localObject).jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (this.jdField_b_of_type_Boolean)
            {
              i1 = this.q;
              for (;;)
              {
                paramInt2 = paramInt1;
                if (i1 > this.r) {
                  break;
                }
                paramInt2 = paramInt1;
                if (i1 < this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.size()) {
                  if (i1 < 0) {
                    paramInt2 = paramInt1;
                  } else {
                    paramInt2 = paramInt1 + ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(i1)).a();
                  }
                }
                i1 += 1;
                paramInt1 = paramInt2;
              }
            }
            paramInt2 = paramInt1 + this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.b();
          }
        }
      }
      this.l = (paramInt2 * (i4 + i5));
      setMeasuredDimension(i2, this.l + i3);
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
    this.x = paramInt;
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
      Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
      if ((localLyric != null) && (!localLyric.a()))
      {
        if ((this.o == paramInt1) && (this.p == paramInt2))
        {
          Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
          return;
        }
        this.o = paramInt1;
        this.p = paramInt2;
        this.q = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.b(paramInt1);
        this.r = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.c(paramInt2);
        if ((this.q >= 0) && (this.r >= 0))
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = false;
          return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      return;
    }
    Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
  }
  
  public void setState(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal
 * JD-Core Version:    0.7.0.1
 */