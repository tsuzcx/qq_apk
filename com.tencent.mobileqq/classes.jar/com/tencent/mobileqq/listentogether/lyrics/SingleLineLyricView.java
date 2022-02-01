package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.data.SentenceUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SingleLineLyricView
  extends TextView
  implements Handler.Callback, ILyricView, ILyricView.LyricState
{
  protected volatile long a;
  protected Lyric b;
  protected Handler c;
  protected int d;
  Paint.Align e = Paint.Align.CENTER;
  private volatile int f = 0;
  private volatile int g = 0;
  private SentenceUI h;
  private String i;
  private int j = 1;
  private volatile boolean k = true;
  private int l;
  private int m;
  private int n;
  private int o;
  private boolean p;
  private int q;
  private SparseArray<SentenceUI> r = new SparseArray(4);
  private WeakReference<OnSizeChangeListener> s;
  
  public SingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private int a(SentenceUI paramSentenceUI)
  {
    if (this.e == Paint.Align.LEFT) {
      return 0;
    }
    if (this.e == Paint.Align.RIGHT) {
      return paramSentenceUI.b * 2;
    }
    return paramSentenceUI.b;
  }
  
  private void a(Canvas paramCanvas, SentenceUI paramSentenceUI)
  {
    this.h = paramSentenceUI;
    paramCanvas.save();
    paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
    int i1 = getPaddingLeft();
    int i2 = this.o;
    int i3 = a(paramSentenceUI);
    if (this.n == 0) {
      this.n = getBaselineY();
    }
    int i4 = this.n;
    int i5 = getPaddingTop();
    TextPaint localTextPaint = getPaint();
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localTextPaint.setStrokeWidth(this.l);
    int i6 = getCurrentTextColor();
    localTextPaint.setColor(this.m);
    String str = paramSentenceUI.a;
    float f1 = i1 - i2 + i3;
    float f2 = i4 + i5;
    paramCanvas.drawText(str, f1, f2, localTextPaint);
    localTextPaint.setColor(i6);
    localTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(paramSentenceUI.a, f1, f2, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(Sentence paramSentence)
  {
    long l1 = SystemClock.elapsedRealtime() - this.a;
    long l2 = paramSentence.b;
    long l3 = paramSentence.c;
    int i1 = 0;
    if (l1 > l2 + l3) {
      return false;
    }
    int i4 = ((SentenceUI)paramSentence.c().get(0)).c;
    int i5 = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    boolean bool;
    if (i4 > i5)
    {
      bool = true;
      int i3 = (int)((float)(l1 - l2) / (float)l3 * i4);
      int i2 = this.o;
      int i6 = i3 - (int)(i2 + i5 * 0.5F);
      i3 = i2 + i6;
      if (i6 < 0)
      {
        if (i3 < 0) {}
      }
      else
      {
        do
        {
          i1 = i3;
          break label169;
          if (i6 <= 0) {
            break;
          }
          i1 = i4 - i5;
        } while (i3 <= i1);
        break label169;
        i1 = i2;
      }
    }
    else
    {
      bool = false;
    }
    label169:
    this.o = i1;
    return bool;
  }
  
  private String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return HardCodeUtil.a(2131911588);
          }
          return HardCodeUtil.a(2131911589);
        }
        return HardCodeUtil.a(2131911590);
      }
      return "";
    }
    return HardCodeUtil.a(2131911591);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.l = AIOUtils.b(1.0F, getResources());
    this.c = new Handler(Looper.getMainLooper(), this);
  }
  
  private void f()
  {
    this.r.clear();
    TextPaint localTextPaint = getPaint();
    int i1 = 1;
    while (i1 <= 4)
    {
      Object localObject = b(i1);
      double d1 = localTextPaint.measureText((String)localObject);
      Double.isNaN(d1);
      int i2 = (int)(d1 + 0.5D);
      localObject = new SentenceUI((String)localObject, 0, 0, i2, i2, null);
      this.r.put(i1, localObject);
      i1 += 1;
    }
  }
  
  private boolean g()
  {
    Lyric localLyric = this.b;
    return (localLyric == null) || (localLyric.b == null) || (this.b.b.isEmpty()) || (this.j != 2);
  }
  
  private int getBaselineY()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i1 = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i1) * 0.5F - localFontMetrics.ascent);
  }
  
  private void h()
  {
    this.c.removeMessages(0);
    this.c.sendEmptyMessage(0);
  }
  
  public void a()
  {
    try
    {
      this.k = false;
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.a = (SystemClock.elapsedRealtime() - paramInt);
    h();
  }
  
  public void b()
  {
    try
    {
      this.k = true;
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.k = true;
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    return this.k ^ true;
  }
  
  public String getSongId()
  {
    return this.i;
  }
  
  public int getState()
  {
    return this.j;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    int i1 = this.j;
    if ((i1 != 2) && (this.r.get(i1) != null)) {
      i1 = ((SentenceUI)this.r.get(this.j)).c + getPaddingLeft();
    }
    for (int i2 = getPaddingRight();; i2 = this.q)
    {
      return i1 + i2;
      i1 = getPaddingLeft() + getPaddingRight();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE", new Object[0]));
        }
        this.c.removeMessages(2);
        paramMessage = this.s;
        if (paramMessage == null) {
          paramMessage = null;
        } else {
          paramMessage = (OnSizeChangeListener)paramMessage.get();
        }
        if (paramMessage != null)
        {
          paramMessage.b(getMeasuredWidth(), getMeasuredHeight());
          return false;
        }
      }
      else
      {
        this.c.removeMessages(1);
        requestLayout();
        return false;
      }
    }
    else
    {
      this.c.removeMessages(0);
      if ((!this.k) && (!g()))
      {
        paramMessage = this.c;
        long l1;
        if (this.p) {
          l1 = 200L;
        } else {
          l1 = 500L;
        }
        paramMessage.sendEmptyMessageDelayed(0, l1);
      }
      if ((g()) && (this.h != null)) {
        return false;
      }
      invalidate();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.p = false;
    Object localObject;
    if (g())
    {
      localObject = (SentenceUI)this.r.get(this.j);
      this.o = 0;
    }
    else if (this.k)
    {
      localObject = this.h;
    }
    else
    {
      int i1 = (int)(SystemClock.elapsedRealtime() - this.a);
      this.f = i1;
      int i2 = this.b.a(i1);
      localObject = this.b.b;
      int i3 = ((ArrayList)localObject).size();
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      i2 = i1;
      if (i1 >= i3) {
        i2 = i3 - 1;
      }
      this.g = i2;
      Sentence localSentence = (Sentence)((ArrayList)localObject).get(i2);
      if (localSentence.c().isEmpty()) {
        return;
      }
      localObject = (SentenceUI)localSentence.c().get(0);
      this.p = a(localSentence);
    }
    if (localObject != null) {
      a(paramCanvas, (SentenceUI)localObject);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.d != getMeasuredWidth())
    {
      this.d = getMeasuredWidth();
      this.c.removeMessages(2);
      this.c.sendEmptyMessageDelayed(2, 300L);
      if (this.b != null)
      {
        paramInt1 = getMeasuredWidth();
        paramInt2 = getPaddingRight();
        paramInt3 = getPaddingLeft();
        this.b.a(getPaint(), getPaint(), paramInt1 - paramInt2 - paramInt3, true, false);
      }
      this.n = 0;
      this.h = null;
      this.o = 0;
      h();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("onLayout w=%d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getSuggestedMinimumWidth(), View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void setAlign(Paint.Align paramAlign)
  {
    if (this.e != paramAlign)
    {
      this.e = paramAlign;
      h();
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setLyric(Lyric paramLyric, int paramInt)
  {
    if (paramLyric != null)
    {
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.a(paramLyric);
      this.b = localLyric;
    }
    else
    {
      this.b = null;
    }
    this.j = paramInt;
    this.d = -1;
    this.h = null;
    this.c.sendEmptyMessage(1);
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    if (paramOnSizeChangeListener == null)
    {
      this.s = null;
      return;
    }
    this.s = new WeakReference(paramOnSizeChangeListener);
  }
  
  public void setSongId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    f();
    this.d = -1;
    this.c.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.SingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */