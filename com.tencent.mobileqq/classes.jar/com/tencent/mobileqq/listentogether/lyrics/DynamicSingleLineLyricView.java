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
  protected int a;
  protected long a;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  private SparseArray<SentenceUI> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  protected Lyric a;
  private SentenceUI jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<OnSizeChangeListener> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = true;
  protected int b;
  protected Handler b;
  private boolean b;
  private int c = 1;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public DynamicSingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private int a(Sentence paramSentence, int paramInt)
  {
    int i = 0;
    this.jdField_b_of_type_Boolean = false;
    long l1 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    long l2 = paramSentence.jdField_a_of_type_Long;
    long l3 = paramSentence.b;
    if (l1 > l2 + l3)
    {
      this.jdField_b_of_type_Boolean = false;
      return paramInt;
    }
    int j = ((SentenceUI)paramSentence.a().get(0)).jdField_b_of_type_Int;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    if (j > k)
    {
      this.jdField_b_of_type_Boolean = true;
      i = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(paramInt + k * 0.5F);
      paramInt += i;
      if (i < 0) {
        if (paramInt < 0) {
          return 0;
        }
      }
      do
      {
        return paramInt;
        if (i <= 0) {
          break;
        }
        i = j - k;
      } while (paramInt <= i);
      return i;
      i = this.g;
    }
    return i;
  }
  
  private int a(SentenceUI paramSentenceUI)
  {
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    i = paramSentenceUI.jdField_b_of_type_Int - (i - j - k);
    if (i < 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
        return 0;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
        return -i;
      }
      return -(int)(i * 0.5F);
    }
    return 0;
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
            return HardCodeUtil.a(2131703741);
          }
          return HardCodeUtil.a(2131703743);
        }
        return HardCodeUtil.a(2131703740);
      }
      return "";
    }
    return HardCodeUtil.a(2131703742);
  }
  
  private void a(Lyric paramLyric, int paramInt)
  {
    if (paramLyric == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      paramLyric = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramLyric);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramLyric);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(3);
    paramLyric = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, paramInt, 0, paramLyric);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramLyric);
  }
  
  private int b()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i) * 0.5F - localFontMetrics.ascent);
  }
  
  private int b(SentenceUI paramSentenceUI)
  {
    return Math.min(getPaddingLeft() + getPaddingRight() + paramSentenceUI.jdField_b_of_type_Int, this.h);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  private boolean b()
  {
    Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
    return (localLyric == null) || (localLyric.a == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.isEmpty()) || (this.c != 2);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.d = AIOUtils.b(1.0F, getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public int a()
  {
    return this.c;
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
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - paramInt + 30L);
    b(5);
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
      this.jdField_a_of_type_Boolean = true;
      b(5);
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
    if (b()) {
      return b((SentenceUI)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.c));
    }
    SentenceUI localSentenceUI = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
    if (localSentenceUI != null) {
      return b(localSentenceUI);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject = null;
    int m = 1;
    int j = 1;
    switch (i)
    {
    default: 
      return false;
    case 7: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      invalidate();
      return false;
    case 6: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      requestLayout();
      return false;
    case 5: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      this.jdField_b_of_type_Boolean = false;
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
      if (b())
      {
        paramMessage = (SentenceUI)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.c);
        localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
        i = j;
        if (localObject != null) {
          if (localObject != paramMessage) {
            i = j;
          } else {
            i = 0;
          }
        }
        this.g = 0;
        j = i;
        i = 0;
      }
      else
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
          j = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(i);
          localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a;
          int k = ((ArrayList)localObject).size();
          i = j;
          if (j < 0) {
            i = 0;
          }
          j = i;
          if (i >= k) {
            j = k - 1;
          }
          localObject = (Sentence)((ArrayList)localObject).get(j);
          if (!((Sentence)localObject).a().isEmpty())
          {
            paramMessage = (SentenceUI)((Sentence)localObject).a().get(0);
            k = this.g;
            SentenceUI localSentenceUI = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
            if ((localSentenceUI != null) && ((localSentenceUI == paramMessage) || (b(localSentenceUI) == b(paramMessage))))
            {
              i = 0;
              j = 0;
            }
            else
            {
              this.g = 0;
              i = 1;
              j = 1;
            }
            if (i == 0)
            {
              this.g = a((Sentence)localObject, this.g);
              if (this.g != k) {
                k = 1;
              } else {
                k = 0;
              }
              if (b(this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI) == b(paramMessage)) {
                m = 0;
              }
              i = k | i | m;
              break label392;
            }
            break label392;
          }
        }
        i = 0;
        j = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = paramMessage;
      if (j != 0) {
        b(6);
      } else if (i != 0) {
        b(7);
      }
      if ((!this.jdField_a_of_type_Boolean) && (!b()))
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler;
        long l;
        if (this.jdField_b_of_type_Boolean) {
          l = 100L;
        } else {
          l = 300L;
        }
        paramMessage.sendEmptyMessageDelayed(5, l);
        return false;
      }
      break;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = ((Lyric)paramMessage.obj);
      this.c = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = null;
      this.g = 0;
      b(5);
      return false;
    case 3: 
      localObject = (Lyric)paramMessage.obj;
      i = paramMessage.arg1;
      if (localObject == null) {
        return true;
      }
      paramMessage = new Lyric(2, 0, null);
      paramMessage.a((Lyric)localObject);
      paramMessage.a(getPaint(), getPaint(), 2147483647, true, false);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, i, 0, paramMessage);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      return false;
    case 2: 
      label392:
      i = getMeasuredWidth();
      if (this.jdField_b_of_type_Int == i) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE %d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      paramMessage = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramMessage == null) {
        paramMessage = (Message)localObject;
      } else {
        paramMessage = (OnSizeChangeListener)paramMessage.get();
      }
      if (paramMessage != null) {
        paramMessage.b(getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_b_of_type_Int = i;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    SentenceUI localSentenceUI = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
    if (localSentenceUI != null)
    {
      if (this.f == 0) {
        this.f = b();
      }
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
      int i = getPaddingLeft();
      int j = this.g;
      int k = a(localSentenceUI);
      int m = this.f;
      int n = getPaddingTop();
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localTextPaint.setStrokeWidth(this.d);
      int i1 = getCurrentTextColor();
      localTextPaint.setColor(this.e);
      String str = localSentenceUI.jdField_a_of_type_JavaLangString;
      float f1 = i - j + k;
      float f2 = m + n;
      paramCanvas.drawText(str, f1, f2, localTextPaint);
      localTextPaint.setColor(i1);
      localTextPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(localSentenceUI.jdField_a_of_type_JavaLangString, f1, f2, localTextPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Int != getMeasuredWidth())
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      b(5);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 300L);
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
      b(7);
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
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
    this.e = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    TextPaint localTextPaint = getPaint();
    paramInt = 1;
    while (paramInt <= 4)
    {
      Object localObject = a(paramInt);
      double d1 = localTextPaint.measureText((String)localObject);
      Double.isNaN(d1);
      int i = (int)(d1 + 0.5D);
      localObject = new SentenceUI((String)localObject, 0, 0, i, i, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      paramInt += 1;
    }
    this.f = 0;
    a(this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.DynamicSingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */