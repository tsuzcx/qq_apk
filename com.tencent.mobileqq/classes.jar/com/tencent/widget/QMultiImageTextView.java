package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.widget.QColorNickTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class QMultiImageTextView
  extends QColorNickTextView
{
  private StringBuilder mAppendSpanbleString = new StringBuilder();
  private ArrayList<SpanAdapter> mAppendedIcon = new ArrayList();
  public boolean mIsAppend = false;
  
  public QMultiImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QMultiImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QMultiImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QMultiImageTextView append(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    append(localDrawable, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return this;
  }
  
  public QMultiImageTextView append(int paramInt1, int paramInt2, int paramInt3)
  {
    append(getResources().getDrawable(paramInt1), paramInt2, paramInt3);
    return this;
  }
  
  public QMultiImageTextView append(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    QMultiImageTextView.IconIDString localIconIDString = new QMultiImageTextView.IconIDString(null);
    localIconIDString.drawable = paramDrawable;
    localIconIDString.drawable.setBounds(0, 0, paramInt1, paramInt2);
    append(localIconIDString);
    return this;
  }
  
  public void append(SpanAdapter paramSpanAdapter)
  {
    paramSpanAdapter.apendString = ("[" + this.mAppendedIcon.size() + "]");
    paramSpanAdapter.start = this.mAppendSpanbleString.length();
    paramSpanAdapter.end = (paramSpanAdapter.start + paramSpanAdapter.apendString.length());
    this.mAppendSpanbleString.append(paramSpanAdapter.apendString);
    this.mAppendedIcon.add(paramSpanAdapter);
  }
  
  public void append(SpanAdapter paramSpanAdapter, String paramString)
  {
    this.mAppendSpanbleString.append(paramString);
    this.mAppendedIcon.add(paramSpanAdapter);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.mAppendSpanbleString.append(paramCharSequence, paramInt1, paramInt2);
    this.mIsAppend = true;
    super.append(paramCharSequence, paramInt1, paramInt2);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QMultiImageTextView.FontStyle localFontStyle = new QMultiImageTextView.FontStyle(null);
    localFontStyle.fontColor = paramInt1;
    localFontStyle.fontSize = paramInt2;
    localFontStyle.fontBackgroundColor = paramInt3;
    localFontStyle.apendString = ("[" + this.mAppendedIcon.size() + "]");
    localFontStyle.start = this.mAppendSpanbleString.length();
    localFontStyle.end = (localFontStyle.start + paramCharSequence.length());
    this.mAppendSpanbleString.append(paramCharSequence);
    this.mAppendedIcon.add(localFontStyle);
  }
  
  public void append(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    append(paramCharSequence, Color.parseColor(paramString), paramInt, 0);
  }
  
  public void appendEnd()
  {
    SpannableString localSpannableString = new SpannableString(this.mAppendSpanbleString);
    Iterator localIterator = this.mAppendedIcon.iterator();
    while (localIterator.hasNext()) {
      ((SpanAdapter)localIterator.next()).getSpan(localSpannableString);
    }
    setText(localSpannableString);
  }
  
  public void appendEnd(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    appendEnd(localDrawable, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
  }
  
  public void appendEnd(int paramInt1, int paramInt2, int paramInt3)
  {
    appendEnd(getResources().getDrawable(paramInt1), paramInt2, paramInt3);
  }
  
  public void appendEnd(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    append(paramDrawable, paramInt1, paramInt2);
    appendEnd();
  }
  
  public QMultiImageTextView appendLabel(CharSequence paramCharSequence, int paramInt)
  {
    appendLabel(paramCharSequence, paramInt, 0);
    return this;
  }
  
  public QMultiImageTextView appendLabel(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    QMultiImageTextView.LabelStyle localLabelStyle = new QMultiImageTextView.LabelStyle(getResources());
    localLabelStyle.labelColor = paramInt1;
    localLabelStyle.labelIcon = paramInt2;
    localLabelStyle.apendString = ("[" + this.mAppendedIcon.size() + "]");
    localLabelStyle.start = this.mAppendSpanbleString.length();
    localLabelStyle.end = (localLabelStyle.start + paramCharSequence.length());
    this.mAppendSpanbleString.append(paramCharSequence);
    this.mAppendedIcon.add(localLabelStyle);
    return this;
  }
  
  public void appendMargin(float paramFloat)
  {
    appendMargin((int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F));
  }
  
  public void appendMargin(int paramInt)
  {
    QMultiImageTextView.MarginStyle localMarginStyle = new QMultiImageTextView.MarginStyle(null);
    localMarginStyle.marginPix = paramInt;
    append(localMarginStyle);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.mIsAppend)
    {
      if (this.mAppendedIcon != null) {
        this.mAppendedIcon.clear();
      }
      this.mAppendSpanbleString = new StringBuilder(paramCharSequence);
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      this.mIsAppend = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView
 * JD-Core Version:    0.7.0.1
 */