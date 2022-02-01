package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.widget.BubblePopupWindow;

public class ContextMenuTextView
  extends TextView
{
  BubblePopupWindow a;
  ContextMenuTextView.TextViewOnlongClickListener b = new ContextMenuTextView.TextViewOnlongClickListener(this, null);
  View.OnClickListener c = new ContextMenuTextView.1(this);
  private Context d = null;
  private Drawable[] e;
  private boolean f = false;
  
  public ContextMenuTextView(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    setOnLongClickListener(this.b);
    setSelectAllOnFocus(true);
  }
  
  public ContextMenuTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    setOnLongClickListener(this.b);
    setSelectAllOnFocus(true);
    setOnTouchListener(this.b);
  }
  
  private void a(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        while (i < m)
        {
          arrayOfSpanWatcher[i].onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
          i += 1;
        }
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (EmoticonSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), EmoticonSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.f = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getDrawable() == paramDrawable) {
            a(localObject2);
          }
          i += 1;
        }
        this.f = false;
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.f) {
      super.requestLayout();
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!getText().equals(paramCharSequence))
    {
      super.setText(paramCharSequence, paramBufferType);
      if ((getText() instanceof QQText))
      {
        paramCharSequence = (Spannable)getText();
        int j = paramCharSequence.length();
        int i = 0;
        paramCharSequence = (EmoticonSpan[])paramCharSequence.getSpans(0, j, EmoticonSpan.class);
        paramBufferType = new Drawable[paramCharSequence.length];
        while (i < paramCharSequence.length)
        {
          paramBufferType[i] = paramCharSequence[i].getDrawable();
          paramBufferType[i].setCallback(this);
          i += 1;
        }
        this.e = paramBufferType;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView
 * JD-Core Version:    0.7.0.1
 */