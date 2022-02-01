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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.data.SentenceUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DynamicSingleLineLyricView
  extends TextView
  implements Handler.Callback, ILyricView, ILyricView.LyricState
{
  protected long a;
  protected Lyric b;
  protected Handler c;
  protected Handler d;
  protected int e;
  protected int f;
  Paint.Align g = Paint.Align.CENTER;
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
  
  public DynamicSingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private int a(Sentence paramSentence, int paramInt)
  {
    int i1 = 0;
    this.p = false;
    long l1 = SystemClock.elapsedRealtime() - this.a;
    long l2 = paramSentence.b;
    long l3 = paramSentence.c;
    if (l1 > l2 + l3)
    {
      this.p = false;
      return paramInt;
    }
    int i2 = ((SentenceUI)paramSentence.c().get(0)).c;
    int i3 = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    if (i2 > i3)
    {
      this.p = true;
      i1 = (int)((float)(l1 - l2) / (float)l3 * i2) - (int)(paramInt + i3 * 0.5F);
      paramInt += i1;
      if (i1 < 0) {
        if (paramInt < 0) {
          return 0;
        }
      }
      do
      {
        return paramInt;
        if (i1 <= 0) {
          break;
        }
        i1 = i2 - i3;
      } while (paramInt <= i1);
      return i1;
      i1 = this.o;
    }
    return i1;
  }
  
  private int a(SentenceUI paramSentenceUI)
  {
    int i1 = getMeasuredWidth();
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    i1 = paramSentenceUI.c - (i1 - i2 - i3);
    if (i1 < 0)
    {
      if (this.g == Paint.Align.LEFT) {
        return 0;
      }
      if (this.g == Paint.Align.RIGHT) {
        return -i1;
      }
      return -(int)(i1 * 0.5F);
    }
    return 0;
  }
  
  private void a(Lyric paramLyric, int paramInt)
  {
    if (paramLyric == null)
    {
      this.c.removeMessages(4);
      paramLyric = this.c.obtainMessage(4, paramInt, 0, paramLyric);
      this.c.sendMessage(paramLyric);
      return;
    }
    this.d.removeMessages(3);
    paramLyric = this.d.obtainMessage(3, paramInt, 0, paramLyric);
    this.d.sendMessage(paramLyric);
  }
  
  private int b(SentenceUI paramSentenceUI)
  {
    return Math.min(getPaddingLeft() + getPaddingRight() + paramSentenceUI.c, this.q);
  }
  
  private void b(int paramInt)
  {
    this.c.removeMessages(paramInt);
    this.c.sendEmptyMessage(paramInt);
  }
  
  private String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return HardCodeUtil.a(2131901687);
          }
          return HardCodeUtil.a(2131901689);
        }
        return HardCodeUtil.a(2131901686);
      }
      return "";
    }
    return HardCodeUtil.a(2131901688);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.l = AIOUtils.b(1.0F, getResources());
    this.c = new Handler(Looper.getMainLooper(), this);
    this.d = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private boolean f()
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
  
  public void a()
  {
    try
    {
      this.k = false;
      b(5);
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
    this.a = (SystemClock.elapsedRealtime() - paramInt + 30L);
    b(5);
  }
  
  public void b()
  {
    try
    {
      this.k = true;
      b(5);
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
      b(5);
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
    if (f()) {
      return b((SentenceUI)this.r.get(this.j));
    }
    SentenceUI localSentenceUI = this.h;
    if (localSentenceUI != null) {
      return b(localSentenceUI);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    Object localObject = null;
    int i4 = 1;
    int i2 = 1;
    switch (i1)
    {
    default: 
      return false;
    case 7: 
      this.c.removeMessages(7);
      invalidate();
      return false;
    case 6: 
      this.c.removeMessages(6);
      requestLayout();
      return false;
    case 5: 
      this.c.removeMessages(5);
      this.p = false;
      paramMessage = this.h;
      if (f())
      {
        paramMessage = (SentenceUI)this.r.get(this.j);
        localObject = this.h;
        i1 = i2;
        if (localObject != null) {
          if (localObject != paramMessage) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
        this.o = 0;
        i2 = i1;
        i1 = 0;
      }
      else
      {
        if (!this.k)
        {
          i1 = (int)(SystemClock.elapsedRealtime() - this.a);
          i2 = this.b.a(i1);
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
          localObject = (Sentence)((ArrayList)localObject).get(i2);
          if (!((Sentence)localObject).c().isEmpty())
          {
            paramMessage = (SentenceUI)((Sentence)localObject).c().get(0);
            i3 = this.o;
            SentenceUI localSentenceUI = this.h;
            if ((localSentenceUI != null) && ((localSentenceUI == paramMessage) || (b(localSentenceUI) == b(paramMessage))))
            {
              i1 = 0;
              i2 = 0;
            }
            else
            {
              this.o = 0;
              i1 = 1;
              i2 = 1;
            }
            if (i1 == 0)
            {
              this.o = a((Sentence)localObject, this.o);
              if (this.o != i3) {
                i3 = 1;
              } else {
                i3 = 0;
              }
              if (b(this.h) == b(paramMessage)) {
                i4 = 0;
              }
              i1 = i3 | i1 | i4;
              break label392;
            }
            break label392;
          }
        }
        i1 = 0;
        i2 = 0;
      }
      this.h = paramMessage;
      if (i2 != 0) {
        b(6);
      } else if (i1 != 0) {
        b(7);
      }
      if ((!this.k) && (!f()))
      {
        paramMessage = this.c;
        long l1;
        if (this.p) {
          l1 = 100L;
        } else {
          l1 = 300L;
        }
        paramMessage.sendEmptyMessageDelayed(5, l1);
        return false;
      }
      break;
    case 4: 
      this.b = ((Lyric)paramMessage.obj);
      this.j = paramMessage.arg1;
      this.h = null;
      this.o = 0;
      b(5);
      return false;
    case 3: 
      localObject = (Lyric)paramMessage.obj;
      i1 = paramMessage.arg1;
      if (localObject == null) {
        return true;
      }
      paramMessage = new Lyric(2, 0, null);
      paramMessage.a((Lyric)localObject);
      paramMessage.a(getPaint(), getPaint(), 2147483647, true, false);
      this.c.removeMessages(4);
      paramMessage = this.c.obtainMessage(4, i1, 0, paramMessage);
      this.c.sendMessage(paramMessage);
      return false;
    case 2: 
      label392:
      i1 = getMeasuredWidth();
      if (this.f == i1) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE %d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
      }
      this.c.removeMessages(2);
      paramMessage = this.s;
      if (paramMessage == null) {
        paramMessage = (Message)localObject;
      } else {
        paramMessage = (OnSizeChangeListener)paramMessage.get();
      }
      if (paramMessage != null) {
        paramMessage.b(getMeasuredWidth(), getMeasuredHeight());
      }
      this.f = i1;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    SentenceUI localSentenceUI = this.h;
    if (localSentenceUI != null)
    {
      if (this.n == 0) {
        this.n = getBaselineY();
      }
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
      int i1 = getPaddingLeft();
      int i2 = this.o;
      int i3 = a(localSentenceUI);
      int i4 = this.n;
      int i5 = getPaddingTop();
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localTextPaint.setStrokeWidth(this.l);
      int i6 = getCurrentTextColor();
      localTextPaint.setColor(this.m);
      String str = localSentenceUI.a;
      float f1 = i1 - i2 + i3;
      float f2 = i4 + i5;
      paramCanvas.drawText(str, f1, f2, localTextPaint);
      localTextPaint.setColor(i6);
      localTextPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(localSentenceUI.a, f1, f2, localTextPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.e != getMeasuredWidth())
    {
      this.e = getMeasuredWidth();
      b(5);
      this.c.removeMessages(2);
      this.c.sendEmptyMessageDelayed(2, 300L);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getSuggestedMinimumWidth(), View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void setAlign(Paint.Align paramAlign)
  {
    if (this.g != paramAlign)
    {
      this.g = paramAlign;
      b(7);
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    if (this.q != paramInt)
    {
      this.q = paramInt;
      b(6);
    }
  }
  
  public void setLyric(Lyric paramLyric, int paramInt)
  {
    a(paramLyric, paramInt);
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
    this.r.clear();
    TextPaint localTextPaint = getPaint();
    paramInt = 1;
    while (paramInt <= 4)
    {
      Object localObject = c(paramInt);
      double d1 = localTextPaint.measureText((String)localObject);
      Double.isNaN(d1);
      int i1 = (int)(d1 + 0.5D);
      localObject = new SentenceUI((String)localObject, 0, 0, i1, i1, null);
      this.r.put(paramInt, localObject);
      paramInt += 1;
    }
    this.n = 0;
    a(this.b, this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.DynamicSingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */