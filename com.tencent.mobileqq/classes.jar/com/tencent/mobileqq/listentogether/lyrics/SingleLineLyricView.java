package com.tencent.mobileqq.listentogether.lyrics;

import actn;
import ajyc;
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
import arsp;
import arta;
import asba;
import asbc;
import asbe;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SingleLineLyricView
  extends TextView
  implements Handler.Callback, arsp
{
  protected int a;
  protected long a;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  private SparseArray<asbe> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  protected asba a;
  private asbe jdField_a_of_type_Asbe;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<arta> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private volatile int c;
  private int d = 1;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public SingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private int a(asbe paramasbe)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramasbe.jdField_a_of_type_Int * 2;
    }
    return paramasbe.jdField_a_of_type_Int;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ajyc.a(2131714181);
    case 1: 
      return ajyc.a(2131714184);
    case 2: 
      return "";
    case 3: 
      return ajyc.a(2131714183);
    }
    return ajyc.a(2131714182);
  }
  
  private void a(Canvas paramCanvas, asbe paramasbe)
  {
    this.jdField_a_of_type_Asbe = paramasbe;
    paramCanvas.save();
    paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
    int j = getPaddingLeft() - this.h + a(paramasbe);
    if (this.g == 0) {
      this.g = b();
    }
    int k = this.g + getPaddingTop();
    TextPaint localTextPaint = getPaint();
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localTextPaint.setStrokeWidth(this.e);
    int m = getCurrentTextColor();
    localTextPaint.setColor(this.f);
    paramCanvas.drawText(paramasbe.jdField_a_of_type_JavaLangString, j, k, localTextPaint);
    localTextPaint.setColor(m);
    localTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(paramasbe.jdField_a_of_type_JavaLangString, j, k, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(asbc paramasbc)
  {
    boolean bool = false;
    long l1 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    long l2 = paramasbc.jdField_a_of_type_Long;
    long l3 = paramasbc.b;
    if (l1 > l2 + l3) {
      return false;
    }
    int k = ((asbe)paramasbc.a().get(0)).jdField_b_of_type_Int;
    int m = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int n;
    int j;
    if (k > m)
    {
      n = (int)((float)(l1 - l2) / (float)l3 * k) - (int)(this.h + 0.5F * m);
      j = this.h + n;
      if (n < 0)
      {
        if (j >= 0) {
          break label172;
        }
        j = 0;
        bool = true;
      }
    }
    for (;;)
    {
      this.h = j;
      return bool;
      if (n > 0)
      {
        k -= m;
        if (j <= k) {
          break label169;
        }
        j = k;
      }
      label169:
      for (;;)
      {
        bool = true;
        break;
        j = this.h;
        bool = true;
        break;
      }
      label172:
      bool = true;
      continue;
      j = 0;
    }
  }
  
  private int b()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int j = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - j) * 0.5F - localFontMetrics.ascent);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Asba == null) || (this.jdField_a_of_type_Asba.a == null) || (this.jdField_a_of_type_Asba.a.isEmpty()) || (this.d != 2);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.e = actn.a(1.0F, getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    TextPaint localTextPaint = getPaint();
    int j = 1;
    while (j <= 4)
    {
      Object localObject = a(j);
      int k = (int)(localTextPaint.measureText((String)localObject) + 0.5D);
      localObject = new asbe((String)localObject, 0, 0, k, k, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject);
      j += 1;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      f();
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
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - paramInt);
    f();
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      f();
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
      this.jdField_a_of_type_Boolean = true;
      f();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int getSuggestedMinimumWidth()
  {
    if ((this.d == 2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(this.d) == null)) {
      return getPaddingLeft() + getPaddingRight() + this.i;
    }
    return ((asbe)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.d)).jdField_b_of_type_Int + getPaddingLeft() + getPaddingRight();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if ((!this.jdField_a_of_type_Boolean) && (!b()))
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler;
        if (!this.jdField_b_of_type_Boolean) {
          break label99;
        }
      }
      label99:
      for (long l = 200L;; l = 500L)
      {
        paramMessage.sendEmptyMessageDelayed(0, l);
        if ((b()) && (this.jdField_a_of_type_Asbe != null)) {
          break;
        }
        invalidate();
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      requestLayout();
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE", new Object[0]));
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
      for (paramMessage = null; paramMessage != null; paramMessage = (arta)this.jdField_a_of_type_JavaLangRefWeakReference.get())
      {
        paramMessage.b(getMeasuredWidth(), getMeasuredHeight());
        return false;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject;
    if (b())
    {
      localObject = (asbe)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.d);
      this.h = 0;
    }
    for (;;)
    {
      if (localObject != null) {
        a(paramCanvas, (asbe)localObject);
      }
      asbc localasbc;
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_Asbe;
          break;
        }
        int j = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Int = j;
        int k = this.jdField_a_of_type_Asba.a(j);
        localObject = this.jdField_a_of_type_Asba.a;
        int m = ((ArrayList)localObject).size();
        j = k;
        if (k < 0) {
          j = 0;
        }
        k = j;
        if (j >= m) {
          k = m - 1;
        }
        this.c = k;
        localasbc = (asbc)((ArrayList)localObject).get(k);
      } while (localasbc.a().isEmpty());
      localObject = (asbe)localasbc.a().get(0);
      this.jdField_b_of_type_Boolean = a(localasbc);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Int != getMeasuredWidth())
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 300L);
      if (this.jdField_a_of_type_Asba != null)
      {
        paramInt1 = getMeasuredWidth();
        paramInt2 = getPaddingRight();
        paramInt3 = getPaddingLeft();
        this.jdField_a_of_type_Asba.a(getPaint(), getPaint(), paramInt1 - paramInt2 - paramInt3, true, false);
      }
      this.g = 0;
      this.jdField_a_of_type_Asbe = null;
      this.h = 0;
      f();
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
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align != paramAlign)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint$Align = paramAlign;
      f();
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setLyric(asba paramasba, int paramInt)
  {
    asba localasba;
    if (paramasba != null)
    {
      localasba = new asba(2, 0, null);
      localasba.a(paramasba);
    }
    for (this.jdField_a_of_type_Asba = localasba;; this.jdField_a_of_type_Asba = null)
    {
      this.d = paramInt;
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Asbe = null;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public void setOnSizeChangeListener(arta paramarta)
  {
    if (paramarta == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramarta);
  }
  
  public void setSongId(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    e();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.SingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */