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
  protected int A = -1;
  protected int B = 3500;
  protected int C = -1;
  Bitmap D = null;
  Context E;
  protected float F;
  protected int G;
  protected volatile boolean H;
  protected int I = -1;
  protected int J = -1;
  protected int K = 0;
  protected int L = 0;
  protected int M = 0;
  protected int N = 0;
  protected volatile int O = 0;
  protected Object P = new Object();
  protected volatile boolean Q = true;
  protected volatile long R = 0L;
  protected volatile boolean S;
  protected volatile boolean T;
  protected int U;
  protected volatile boolean V;
  protected volatile boolean W;
  protected volatile boolean Z;
  protected int a;
  protected volatile boolean aa;
  protected int ab;
  protected int ac;
  protected final Handler ad = new LyricViewInternal.1(this, Looper.getMainLooper());
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  public int g;
  public boolean h;
  protected final Paint i = new Paint();
  protected final Paint j = new Paint();
  protected final Paint k = new Paint();
  protected final Paint l = new Paint();
  protected final Paint m = new Paint();
  protected final Paint n = new Paint();
  protected final Paint o = new Paint();
  protected final Paint p = new Paint();
  protected final Paint q = new Paint();
  protected final Paint r = new Paint();
  protected int s = 0;
  protected Lyric t;
  protected Lyric u;
  protected final String v;
  protected String w;
  protected int x;
  protected Scroller y;
  protected int z = 0;
  
  public LyricViewInternal(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternal(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.E = paramContext;
    paramAttributeSet = (WindowManager)this.E.getSystemService("window");
    if (Build.VERSION.SDK_INT < 13)
    {
      this.G = paramAttributeSet.getDefaultDisplay().getWidth();
    }
    else
    {
      localObject = new Point();
      paramAttributeSet.getDefaultDisplay().getSize((Point)localObject);
      this.G = ((Point)localObject).x;
    }
    Object localObject = new DisplayMetrics();
    paramAttributeSet.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.F = ((DisplayMetrics)localObject).density;
    this.v = paramContext.getString(2131916717);
    this.w = paramContext.getString(2131916716);
    this.y = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public int a(int paramInt)
  {
    this.S = true;
    return this.M;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.M = paramInt1;
    this.N = paramInt2;
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
      int i3 = this.x;
      int i4 = (int)this.i.measureText(paramString[i1]);
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
      this.Q = true;
      this.T = false;
      if (paramLyric1 != null)
      {
        c();
        Lyric localLyric = new Lyric(2, 0, null);
        localLyric.a(paramLyric1);
        this.t = localLyric;
        if ((paramLyric2 != null) && (paramLyric1.b() == paramLyric2.b()))
        {
          paramLyric1 = new Lyric(2, 0, null);
          paramLyric1.a(paramLyric2);
          this.u = paramLyric1;
        }
        else
        {
          Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
          this.u = new Lyric(2, 0, null);
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
        ArrayList localArrayList = paramSentence.c();
        int i6 = this.N;
        localPaint = this.j;
        i1 = 0;
        i3 = paramInt2;
        paramInt2 = i1;
        if (paramInt2 >= localArrayList.size()) {
          continue;
        }
        localSentenceUI = (SentenceUI)localArrayList.get(paramInt2);
        if (localSentenceUI.e == null) {
          continue;
        }
        if (paramInt2 == 0) {
          i4 = this.c;
        } else {
          i4 = this.d;
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
        i5 = localSentenceUI.e.size();
        f3 = 0.0F;
        if (paramInt2 >= i5) {
          continue;
        }
        paramSentence = (Character)localSentenceUI.e.get(paramInt2);
        if (paramInt2 >= localSentenceUI.e.size() - 1) {
          continue;
        }
        localObject1 = (Character)localSentenceUI.e.get(paramInt2 + 1);
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
      if ((paramSentence.a <= l2) && (localObject1 != null) && (((Character)localObject1).a > l2))
      {
        f3 = (float)(l2 - paramSentence.a) / (float)paramSentence.b;
        f2 = f3;
      }
      else if ((paramSentence.a <= l2) && (paramSentence.a + paramSentence.b >= l2))
      {
        f1 = (float)(l2 - paramSentence.a);
        l1 = paramSentence.b;
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
        i2 = localSentenceUI.a.length();
        localObject1 = localSentenceUI.e;
        i5 = paramInt2 - 1;
        if (i2 >= ((Character)((ArrayList)localObject1).get(i5)).d) {
          f1 = this.j.measureText(localSentenceUI.a.substring(0, ((Character)localSentenceUI.e.get(i5)).d));
        } else {
          f1 = this.j.measureText(localSentenceUI.a.substring(0, localSentenceUI.a.length()));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        continue;
      }
      f1 = this.j.measureText(localSentenceUI.a.substring(0, localSentenceUI.a.length()));
      f4 = f5 + f1;
      try
      {
        if (paramInt2 == localSentenceUI.e.size() - 1) {
          f1 = this.l.measureText(localSentenceUI.a.substring(paramSentence.c, localSentenceUI.a.length()));
        } else if (localSentenceUI.a.length() >= paramSentence.d) {
          f1 = this.l.measureText(localSentenceUI.a.substring(paramSentence.c, paramSentence.d));
        } else {
          f1 = this.l.measureText(localSentenceUI.a.substring(paramSentence.c, localSentenceUI.a.length()));
        }
      }
      catch (StringIndexOutOfBoundsException paramSentence)
      {
        continue;
      }
      f1 = this.l.measureText(localSentenceUI.a.substring(0, localSentenceUI.a.length()));
      i2 = localPaint.getColor();
      i5 = this.k.getColor();
      localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, this.k, localPaint, this.l, paramInt2, f1, f4, new int[] { i2, i5 }, new float[] { f3, f2 });
      paramInt2 = i1;
      continue;
      if (localSentenceUI.b() < l2) {
        localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, localPaint, true);
      } else {
        localSentenceUI.a(paramCanvas, paramInt1, i3 + i4, this.k, true);
      }
      i1 = this.e;
      i3 += i4 + i1;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramSentence = paramSentence.c();
    int i3 = this.b;
    int i4 = this.c;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.c, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    paramSentence = paramSentence.c();
    int i3 = this.b;
    int i4 = this.c;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.c, paramPaint1, paramPaint2);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramSentence.c();
    if (paramBoolean) {
      paramSentence = this.j;
    } else {
      paramSentence = this.i;
    }
    int i2 = this.b;
    int i3 = this.c;
    int i1 = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < localArrayList.size())
    {
      ((SentenceUI)localArrayList.get(paramInt2)).a(paramCanvas, paramInt1, i1 + this.c, paramSentence, paramBoolean);
      i1 += i2 + i3;
      paramInt2 += 1;
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    this.t = new Lyric(2, 0, null);
    this.u = new Lyric(2, 0, null);
    this.d = paramLyricViewAttribute.j;
    this.b = paramLyricViewAttribute.d;
    this.c = paramLyricViewAttribute.i;
    int i1 = paramLyricViewAttribute.e;
    int i2 = paramLyricViewAttribute.f;
    int i3 = paramLyricViewAttribute.g;
    this.e = paramLyricViewAttribute.h;
    int i4 = paramLyricViewAttribute.b;
    this.a = paramLyricViewAttribute.a;
    this.W = paramLyricViewAttribute.l;
    boolean bool = paramLyricViewAttribute.m;
    this.aa = true;
    this.ab = 3;
    this.ac = 2;
    this.g = paramLyricViewAttribute.n;
    this.h = paramLyricViewAttribute.o;
    this.k.setAntiAlias(true);
    paramLyricViewAttribute = this.k;
    float f1 = i1;
    paramLyricViewAttribute.setTextSize(f1);
    this.k.setColor(i3);
    this.l.setAntiAlias(true);
    this.l.setTextSize(f1);
    this.l.setColor(i2);
    this.j.setAntiAlias(true);
    this.j.setTextSize(f1);
    this.j.setColor(i2);
    this.j.setFakeBoldText(bool);
    this.i.setAntiAlias(true);
    this.i.setTextSize(this.a);
    this.i.setColor(i4);
    this.n.setAntiAlias(true);
    this.n.setTextSize(this.a);
    this.n.setColor(i4);
    this.n.setAlpha(127);
    this.o.setAntiAlias(true);
    this.o.setTextSize(this.a);
    this.o.setColor(i4);
    this.o.setAlpha(51);
    this.p.setAntiAlias(true);
    this.p.setTextSize(this.a);
    this.p.setColor(i4);
    this.p.setAlpha(25);
    this.m.setAntiAlias(true);
    this.m.setTextSize(this.a);
    this.q.setAntiAlias(true);
    this.q.setTextSize(this.a);
    this.q.setColor(i4);
    this.q.setAlpha(255);
    this.r.setAntiAlias(true);
    this.r.setTextSize(f1);
    this.r.setColor(i4);
    this.r.setAlpha(255);
    this.f = this.c;
  }
  
  public void a(boolean paramBoolean) {}
  
  public int b(int paramInt)
  {
    paramInt = this.M;
    this.S = false;
    return paramInt;
  }
  
  void b()
  {
    this.Q = false;
    ThreadManager.getUIHandler().post(new LyricViewInternal.2(this));
  }
  
  public void c()
  {
    this.H = false;
    this.I = -1;
    this.J = -1;
    this.K = 0;
    this.L = 0;
    this.T = false;
  }
  
  public void c(int paramInt)
  {
    this.ab = ((paramInt - this.f - this.e) / (this.b + this.c) + 1);
    if (this.ab < 0) {
      this.ab = 2;
    }
  }
  
  protected int getAdJust()
  {
    if (this.A == -1) {
      this.A = ((int)(this.F * 43.0F));
    }
    return this.A;
  }
  
  public Lyric getLyric()
  {
    return this.t;
  }
  
  public Lyric getLyricPronounce()
  {
    return this.u;
  }
  
  Lyric getMeasuredLyric()
  {
    return this.t;
  }
  
  public int getTopScroll()
  {
    return this.O;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = (getMeasuredHeight() >> 1) - this.b;
    int i2 = this.z;
    if ((i2 != 40) && (i2 != 60))
    {
      if (i2 != 70)
      {
        if (this.w != null)
        {
          scrollTo(0, 0);
          this.y.setFinalX(0);
          a(paramCanvas, this.i, this.w, 0, i1);
        }
      }
      else {
        a(paramCanvas, 0);
      }
    }
    else if (this.v != null)
    {
      scrollTo(0, 0);
      this.y.setFinalX(0);
      a(paramCanvas, this.i, this.v, 0, i1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = (View)((View)getParent()).getParent();
    int i2 = ((View)localObject).getMeasuredWidth();
    int i3 = ((View)localObject).getMeasuredHeight();
    if (this.z == 70)
    {
      paramInt1 = i2 - (getAdJust() << 1);
      paramInt2 = 0;
      int i4 = this.b;
      int i5 = this.c;
      if (this.h) {
        this.t.a(this.j, this.i, paramInt1, false, true);
      } else {
        this.t.a(this.j, this.i, paramInt1);
      }
      if ((this.u != null) && (this.t.b() == this.u.b())) {
        if (this.h) {
          this.u.a(this.j, this.i, paramInt1, false, true);
        } else {
          this.u.a(this.j, this.i, paramInt1);
        }
      }
      int i1;
      if (this.H)
      {
        i1 = this.K;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.L) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.t.b.get(i1) != null) {
            paramInt1 = paramInt2 + ((Sentence)this.t.b.get(i1)).b();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
      }
      paramInt1 = this.t.c();
      paramInt2 = paramInt1;
      if (this.V)
      {
        localObject = this.u;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((Lyric)localObject).b != null)
          {
            if (this.H)
            {
              i1 = this.K;
              for (;;)
              {
                paramInt2 = paramInt1;
                if (i1 > this.L) {
                  break;
                }
                paramInt2 = paramInt1;
                if (i1 < this.u.b.size()) {
                  if (i1 < 0) {
                    paramInt2 = paramInt1;
                  } else {
                    paramInt2 = paramInt1 + ((Sentence)this.u.b.get(i1)).b();
                  }
                }
                i1 += 1;
                paramInt1 = paramInt2;
              }
            }
            paramInt2 = paramInt1 + this.u.c();
          }
        }
      }
      this.B = (paramInt2 * (i4 + i5));
      setMeasuredDimension(i2, this.B + i3);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void setDrawAttachInfo(boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  public void setHighlightCurrentLine(boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  public void setHighlightLineNumber(int paramInt)
  {
    this.ac = paramInt;
  }
  
  public void setIndicator(Bitmap paramBitmap) {}
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setLyricColor(int paramInt)
  {
    this.i.setColor(paramInt);
  }
  
  public void setLyricHilightColor(int paramInt)
  {
    this.l.setColor(paramInt);
    this.j.setColor(paramInt);
  }
  
  public void setScore(int[] paramArrayOfInt) {}
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      Lyric localLyric = this.t;
      if ((localLyric != null) && (!localLyric.f()))
      {
        if ((this.I == paramInt1) && (this.J == paramInt2))
        {
          Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
          return;
        }
        this.I = paramInt1;
        this.J = paramInt2;
        this.K = this.t.b(paramInt1);
        this.L = this.t.c(paramInt2);
        if ((this.K >= 0) && (this.L >= 0))
        {
          this.H = true;
          this.T = false;
          return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
        this.H = false;
        return;
      }
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      return;
    }
    Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
  }
  
  public void setState(int paramInt)
  {
    this.z = paramInt;
    this.ad.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal
 * JD-Core Version:    0.7.0.1
 */