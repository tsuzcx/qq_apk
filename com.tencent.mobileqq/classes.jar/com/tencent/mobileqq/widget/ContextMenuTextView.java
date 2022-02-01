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
  private Context jdField_a_of_type_AndroidContentContext = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ContextMenuTextView.1(this);
  ContextMenuTextView.TextViewOnlongClickListener jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView$TextViewOnlongClickListener = new ContextMenuTextView.TextViewOnlongClickListener(this, null);
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private boolean jdField_a_of_type_Boolean = false;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  
  public ContextMenuTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView$TextViewOnlongClickListener);
    setSelectAllOnFocus(true);
  }
  
  public ContextMenuTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView$TextViewOnlongClickListener);
    setSelectAllOnFocus(true);
    setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView$TextViewOnlongClickListener);
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
        this.jdField_a_of_type_Boolean = true;
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
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int i = 0;
    if (!getText().equals(paramCharSequence))
    {
      super.setText(paramCharSequence, paramBufferType);
      if ((getText() instanceof QQText))
      {
        paramCharSequence = (Spannable)getText();
        paramCharSequence = (EmoticonSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
        paramBufferType = new Drawable[paramCharSequence.length];
        while (i < paramCharSequence.length)
        {
          paramBufferType[i] = paramCharSequence[i].getDrawable();
          paramBufferType[i].setCallback(this);
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramBufferType;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView
 * JD-Core Version:    0.7.0.1
 */