package com.tencent.mobileqq.widget;

import akso;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.qphone.base.util.QLog;

public class AnimationTextView
  extends PatchedTextView
{
  public float a;
  private int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public AnimationTextView.OnDoubleClick a;
  public AnimationTextView.OnSingleClick a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public float b;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  Runnable jdField_b_of_type_JavaLangRunnable = new akso(this);
  private boolean jdField_b_of_type_Boolean;
  public boolean j = true;
  public boolean k;
  
  public AnimationTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i = 0;
    float f1 = this.jdField_a_of_type_Float;
    float f3 = TextItemBuilder.f;
    float f2 = this.jdField_b_of_type_Float - TextItemBuilder.d;
    BubbleInfo localBubbleInfo = (BubbleInfo)getTag(2131362293);
    Object localObject = (ChatMessage)getTag(2131362294);
    if (localObject != null) {}
    for (boolean bool = ((ChatMessage)localObject).isSend();; bool = false)
    {
      if (bool) {}
      for (f1 = this.jdField_a_of_type_Float - TextItemBuilder.g;; f1 -= f3)
      {
        localObject = getText();
        if ((localObject instanceof QQText))
        {
          localObject = (QQText)localObject;
          localObject = (QQText.EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.EmoticonSpan.class);
          int n;
          for (int m = 0; i < localObject.length; m = n)
          {
            QQText.SmallEmojiSpan localSmallEmojiSpan = localObject[i];
            n = m;
            if ((localSmallEmojiSpan instanceof QQText.SmallEmojiSpan))
            {
              localSmallEmojiSpan = (QQText.SmallEmojiSpan)localSmallEmojiSpan;
              f3 = localSmallEmojiSpan.jdField_a_of_type_Float;
              float f4 = localSmallEmojiSpan.jdField_b_of_type_Float;
              float f5 = localSmallEmojiSpan.c;
              float f6 = localSmallEmojiSpan.d;
              n = m;
              if (f1 >= f3)
              {
                n = m;
                if (f1 <= f5)
                {
                  n = m;
                  if (f2 >= f4)
                  {
                    n = m;
                    if (f2 <= f6)
                    {
                      n = m;
                      if (m == 0) {
                        n = 1;
                      }
                    }
                  }
                }
              }
            }
            i += 1;
          }
          if (m != 0)
          {
            localObject = getBackground();
            if ((localObject == null) || (!(localObject instanceof VipBubbleDrawable))) {
              break label277;
            }
            ((VipBubbleDrawable)localObject).jdField_a_of_type_Boolean = true;
          }
        }
        label277:
        while ((localObject == null) || (localBubbleInfo == null)) {
          return;
        }
        localObject = getResources();
        if (bool) {}
        for (i = 2130845785;; i = 2130845621)
        {
          localBubbleInfo.a(this, ((Resources)localObject).getDrawable(i));
          return;
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int m = ((Spannable)localObject).getSpanStart(paramObject);
      int n = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(m, n, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int i1 = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < i1)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, m, n, m, n);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AnimationTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > 200L) {}
    int i;
    int m;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
      m = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + m * m >= 10000);
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (QQText.EmoticonSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), QQText.EmoticonSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.jdField_a_of_type_Boolean = true;
        int m = localObject1.length;
        int i = 0;
        while (i < m)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.a() == paramDrawable) {
            a(localObject2);
          }
          i += 1;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int i = getCurrentTextColor();
      getPaint().setStyle(Paint.Style.STROKE);
      getPaint().setStrokeWidth(3.0F);
      setTextColor(this.jdField_a_of_type_Int);
      super.onDraw(paramCanvas);
      getPaint().setStyle(Paint.Style.FILL);
      setTextColor(i);
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        a();
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.j = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            this.k = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnimationTextView", 2, "DoubleClick invoked");
            }
            return true;
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label192;
        }
        this.j = true;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        a();
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "reserve to initial status");
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label192:
      if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "action up");
        }
        if (getLayout() == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.k)
        {
          this.k = false;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
        }
        postDelayed(this.jdField_b_of_type_JavaLangRunnable, 200L);
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setStrokeColor(boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int i = 0;
    CharSequence localCharSequence = getText();
    super.setText(paramCharSequence, paramBufferType);
    if ((localCharSequence != paramCharSequence) && ((getText() instanceof Spannable)))
    {
      paramCharSequence = (Spannable)getText();
      paramCharSequence = (QQText.EmoticonSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), QQText.EmoticonSpan.class);
      paramBufferType = new Drawable[paramCharSequence.length];
      while (i < paramCharSequence.length)
      {
        paramBufferType[i] = paramCharSequence[i].a();
        if (paramBufferType[i] != null) {
          paramBufferType[i].setCallback(this);
        }
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramBufferType;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView
 * JD-Core Version:    0.7.0.1
 */