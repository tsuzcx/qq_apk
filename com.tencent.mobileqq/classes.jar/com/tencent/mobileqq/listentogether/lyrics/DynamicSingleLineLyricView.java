package com.tencent.mobileqq.listentogether.lyrics;

import afur;
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
import anni;
import avuu;
import avvf;
import awdu;
import awdw;
import awdy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DynamicSingleLineLyricView
  extends TextView
  implements Handler.Callback, avuu
{
  protected int a;
  protected long a;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  private SparseArray<awdy> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  protected awdu a;
  private awdy jdField_a_of_type_Awdy;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<avvf> jdField_a_of_type_JavaLangRefWeakReference;
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
  
  private int a(awdw paramawdw, int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    long l1 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    long l2 = paramawdw.jdField_a_of_type_Long;
    long l3 = paramawdw.b;
    if (l1 > l2 + l3)
    {
      this.jdField_b_of_type_Boolean = false;
      return paramInt;
    }
    int j = ((awdy)paramawdw.a().get(0)).jdField_b_of_type_Int;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int m;
    int i;
    if (j > k)
    {
      this.jdField_b_of_type_Boolean = true;
      m = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(paramInt + 0.5F * k);
      i = paramInt + m;
      if (m < 0)
      {
        paramInt = i;
        if (i < 0) {
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      return paramInt;
      if (m > 0)
      {
        paramInt = j - k;
        if (i <= paramInt) {
          break label164;
        }
      }
      for (;;)
      {
        break;
        paramInt = this.g;
        break;
        label164:
        paramInt = i;
      }
      paramInt = 0;
    }
  }
  
  private int a(awdy paramawdy)
  {
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    i = paramawdy.jdField_b_of_type_Int - (i - j - k);
    if ((i >= 0) || (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT)) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return -i;
    }
    return -(int)(0.5F * i);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return anni.a(2131702369);
    case 1: 
      return anni.a(2131702370);
    case 2: 
      return "";
    case 3: 
      return anni.a(2131702368);
    }
    return anni.a(2131702371);
  }
  
  private void a(awdu paramawdu, int paramInt)
  {
    if (paramawdu == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      paramawdu = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramawdu);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramawdu);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(3);
    paramawdu = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, paramInt, 0, paramawdu);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramawdu);
  }
  
  private int b()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i) * 0.5F - localFontMetrics.ascent);
  }
  
  private int b(awdy paramawdy)
  {
    return Math.min(getPaddingLeft() + getPaddingRight() + paramawdy.jdField_b_of_type_Int, this.h);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Awdu == null) || (this.jdField_a_of_type_Awdu.a == null) || (this.jdField_a_of_type_Awdu.a.isEmpty()) || (this.c != 2);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.d = afur.a(1.0F, getResources());
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
    return !this.jdField_a_of_type_Boolean;
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
      return b((awdy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.c));
    }
    if (this.jdField_a_of_type_Awdy != null) {
      return b(this.jdField_a_of_type_Awdy);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    int m = 1;
    boolean bool = true;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        bool = false;
        do
        {
          do
          {
            return bool;
            i = getMeasuredWidth();
          } while (this.jdField_b_of_type_Int == i);
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE %d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
          for (paramMessage = null;; paramMessage = (avvf)this.jdField_a_of_type_JavaLangRefWeakReference.get())
          {
            if (paramMessage != null) {
              paramMessage.b(getMeasuredWidth(), getMeasuredHeight());
            }
            this.jdField_b_of_type_Int = i;
            break;
          }
          localObject = (awdu)paramMessage.obj;
          i = paramMessage.arg1;
        } while (localObject == null);
        paramMessage = new awdu(2, 0, null);
        paramMessage.a((awdu)localObject);
        paramMessage.a(getPaint(), getPaint(), 2147483647, true, false);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, i, 0, paramMessage);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
        continue;
        this.jdField_a_of_type_Awdu = ((awdu)paramMessage.obj);
        this.c = paramMessage.arg1;
        this.jdField_a_of_type_Awdy = null;
        this.g = 0;
        b(5);
      }
    case 5: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      this.jdField_b_of_type_Boolean = false;
      paramMessage = this.jdField_a_of_type_Awdy;
      if (b())
      {
        paramMessage = (awdy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.c);
        j = i;
        if (this.jdField_a_of_type_Awdy != null) {
          if (this.jdField_a_of_type_Awdy == paramMessage) {
            break label702;
          }
        }
      }
      break;
    }
    label394:
    label688:
    label695:
    label702:
    for (int j = i;; j = 0)
    {
      this.g = 0;
      i = 0;
      for (;;)
      {
        label348:
        this.jdField_a_of_type_Awdy = paramMessage;
        label363:
        long l;
        int k;
        if (j != 0)
        {
          b(6);
          if ((this.jdField_a_of_type_Boolean) || (b())) {
            break;
          }
          paramMessage = this.jdField_a_of_type_AndroidOsHandler;
          if (!this.jdField_b_of_type_Boolean) {
            break label637;
          }
          l = 100L;
          paramMessage.sendEmptyMessageDelayed(5, l);
          break;
          if (this.jdField_a_of_type_Boolean) {
            break label695;
          }
          i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
          j = this.jdField_a_of_type_Awdu.a(i);
          localObject = this.jdField_a_of_type_Awdu.a;
          k = ((ArrayList)localObject).size();
          i = j;
          if (j < 0) {
            i = 0;
          }
          j = i;
          if (i >= k) {
            j = k - 1;
          }
          localObject = (awdw)((ArrayList)localObject).get(j);
          if (((awdw)localObject).a().isEmpty()) {
            break label695;
          }
          paramMessage = (awdy)((awdw)localObject).a().get(0);
          k = this.g;
          if ((this.jdField_a_of_type_Awdy != null) && ((this.jdField_a_of_type_Awdy == paramMessage) || (b(this.jdField_a_of_type_Awdy) == b(paramMessage)))) {
            break label688;
          }
          this.g = 0;
          i = 1;
        }
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            this.g = a((awdw)localObject, this.g);
            if (this.g != k)
            {
              k = 1;
              label579:
              if (b(this.jdField_a_of_type_Awdy) == b(paramMessage)) {
                break label618;
              }
            }
            for (;;)
            {
              k = k | j | m;
              j = i;
              i = k;
              break;
              k = 0;
              break label579;
              label618:
              m = 0;
            }
            if (i == 0) {
              break label363;
            }
            b(7);
            break label363;
            label637:
            l = 300L;
            break label394;
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
            requestLayout();
            break;
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
            invalidate();
            break;
          }
          k = i;
          i = j;
          j = k;
          break label348;
          i = 0;
        }
        j = 0;
        i = 0;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    awdy localawdy = this.jdField_a_of_type_Awdy;
    if (localawdy != null)
    {
      if (this.f == 0) {
        this.f = b();
      }
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
      int i = getPaddingLeft() - this.g + a(localawdy);
      int j = this.f + getPaddingTop();
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localTextPaint.setStrokeWidth(this.d);
      int k = getCurrentTextColor();
      localTextPaint.setColor(this.e);
      paramCanvas.drawText(localawdy.jdField_a_of_type_JavaLangString, i, j, localTextPaint);
      localTextPaint.setColor(k);
      localTextPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(localawdy.jdField_a_of_type_JavaLangString, i, j, localTextPaint);
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
  
  public void setLyric(awdu paramawdu, int paramInt)
  {
    a(paramawdu, paramInt);
  }
  
  public void setOnSizeChangeListener(avvf paramavvf)
  {
    if (paramavvf == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavvf);
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
      int i = (int)(localTextPaint.measureText((String)localObject) + 0.5D);
      localObject = new awdy((String)localObject, 0, 0, i, i, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      paramInt += 1;
    }
    this.f = 0;
    a(this.jdField_a_of_type_Awdu, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.DynamicSingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */