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
  protected int a;
  protected volatile long a;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  private SparseArray<SentenceUI> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  protected Lyric a;
  private SentenceUI jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<OnSizeChangeListener> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private volatile int c = 0;
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
  
  private int a(SentenceUI paramSentenceUI)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramSentenceUI.jdField_a_of_type_Int * 2;
    }
    return paramSentenceUI.jdField_a_of_type_Int;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return HardCodeUtil.a(2131714057);
          }
          return HardCodeUtil.a(2131714058);
        }
        return HardCodeUtil.a(2131714059);
      }
      return "";
    }
    return HardCodeUtil.a(2131714060);
  }
  
  private void a(Canvas paramCanvas, SentenceUI paramSentenceUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = paramSentenceUI;
    paramCanvas.save();
    paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
    int j = getPaddingLeft();
    int k = this.h;
    int m = a(paramSentenceUI);
    if (this.g == 0) {
      this.g = b();
    }
    int n = this.g;
    int i1 = getPaddingTop();
    TextPaint localTextPaint = getPaint();
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localTextPaint.setStrokeWidth(this.e);
    int i2 = getCurrentTextColor();
    localTextPaint.setColor(this.f);
    String str = paramSentenceUI.jdField_a_of_type_JavaLangString;
    float f1 = j - k + m;
    float f2 = n + i1;
    paramCanvas.drawText(str, f1, f2, localTextPaint);
    localTextPaint.setColor(i2);
    localTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(paramSentenceUI.jdField_a_of_type_JavaLangString, f1, f2, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(Sentence paramSentence)
  {
    long l1 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    long l2 = paramSentence.jdField_a_of_type_Long;
    long l3 = paramSentence.b;
    int j = 0;
    if (l1 > l2 + l3) {
      return false;
    }
    int n = ((SentenceUI)paramSentence.a().get(0)).jdField_b_of_type_Int;
    int i1 = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    boolean bool;
    if (n > i1)
    {
      bool = true;
      int m = (int)((float)(l1 - l2) / (float)l3 * n);
      int k = this.h;
      int i2 = m - (int)(k + i1 * 0.5F);
      m = k + i2;
      if (i2 < 0)
      {
        if (m < 0) {}
      }
      else
      {
        do
        {
          j = m;
          break label169;
          if (i2 <= 0) {
            break;
          }
          j = n - i1;
        } while (m <= j);
        break label169;
        j = k;
      }
    }
    else
    {
      bool = false;
    }
    label169:
    this.h = j;
    return bool;
  }
  
  private int b()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int j = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - j) * 0.5F - localFontMetrics.ascent);
  }
  
  private boolean b()
  {
    Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
    return (localLyric == null) || (localLyric.a == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.isEmpty()) || (this.d != 2);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.e = AIOUtils.b(1.0F, getResources());
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
      double d1 = localTextPaint.measureText((String)localObject);
      Double.isNaN(d1);
      int k = (int)(d1 + 0.5D);
      localObject = new SentenceUI((String)localObject, 0, 0, k, k, null);
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
    return this.jdField_a_of_type_Boolean ^ true;
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
    int j = this.d;
    if ((j != 2) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) != null)) {
      j = ((SentenceUI)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.d)).jdField_b_of_type_Int + getPaddingLeft();
    }
    for (int k = getPaddingRight();; k = this.i)
    {
      return j + k;
      j = getPaddingLeft() + getPaddingRight();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE", new Object[0]));
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        paramMessage = this.jdField_a_of_type_JavaLangRefWeakReference;
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
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        requestLayout();
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if ((!this.jdField_a_of_type_Boolean) && (!b()))
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler;
        long l;
        if (this.jdField_b_of_type_Boolean) {
          l = 200L;
        } else {
          l = 500L;
        }
        paramMessage.sendEmptyMessageDelayed(0, l);
      }
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI != null)) {
        return false;
      }
      invalidate();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject;
    if (b())
    {
      localObject = (SentenceUI)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.d);
      this.h = 0;
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
    }
    else
    {
      int j = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Int = j;
      int k = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(j);
      localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a;
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
      Sentence localSentence = (Sentence)((ArrayList)localObject).get(k);
      if (localSentence.a().isEmpty()) {
        return;
      }
      localObject = (SentenceUI)localSentence.a().get(0);
      this.jdField_b_of_type_Boolean = a(localSentence);
    }
    if (localObject != null) {
      a(paramCanvas, (SentenceUI)localObject);
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
      if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null)
      {
        paramInt1 = getMeasuredWidth();
        paramInt2 = getPaddingRight();
        paramInt3 = getPaddingLeft();
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(getPaint(), getPaint(), paramInt1 - paramInt2 - paramInt3, true, false);
      }
      this.g = 0;
      this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = null;
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
  
  public void setLyric(Lyric paramLyric, int paramInt)
  {
    if (paramLyric != null)
    {
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.a(paramLyric);
      this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = localLyric;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
    }
    this.d = paramInt;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = null;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    if (paramOnSizeChangeListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnSizeChangeListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.SingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */