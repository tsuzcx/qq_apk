package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bioq;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FolderTextView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bioq(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  
  public FolderTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FolderTextView);
    try
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getString(2);
      this.jdField_b_of_type_Int = a(paramAttributeSet.getColorStateList(1));
      this.jdField_a_of_type_Int = paramAttributeSet.getDimensionPixelSize(0, ViewUtils.dip2px(12.0F));
      this.jdField_a_of_type_Int = ViewUtils.pxTosp(this.jdField_a_of_type_Int);
      this.c = paramAttributeSet.getInt(5, 2);
      this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(4);
      this.d = paramAttributeSet.getColor(3, paramContext.getResources().getColor(2131166331));
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("FolderTextView", 1, "Exception:", paramContext);
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = anvx.a(2131704141);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_JavaLangCharSequence = "";
    }
    this.e = 0;
    a();
  }
  
  private float a(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    return paramTextPaint.measureText(paramCharSequence.toString());
  }
  
  private int a(ColorStateList paramColorStateList)
  {
    int i = -16777216;
    if (paramColorStateList != null) {
      i = paramColorStateList.getColorForState(getDrawableState(), -16777216);
    }
    return i;
  }
  
  private int a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramFloat <= 0.0F)) {}
    int i;
    label199:
    for (;;)
    {
      return 0;
      float f = paramTextPaint.measureText("...");
      i = paramCharSequence.length();
      if (a(paramCharSequence, paramTextPaint) <= paramFloat - f) {
        break;
      }
      i = paramCharSequence.length() - 1;
      if ((paramCharSequence instanceof Spanned))
      {
        Spanned localSpanned = (Spanned)paramCharSequence;
        Object[] arrayOfObject = localSpanned.getSpans(0, paramCharSequence.length(), Object.class);
        int j = 0;
        while (j < arrayOfObject.length)
        {
          int m = localSpanned.getSpanStart(Integer.valueOf(j));
          int n = localSpanned.getSpanEnd(Integer.valueOf(j));
          int k = i;
          if (m != -1)
          {
            k = i;
            if (n != -1) {
              if (i < m)
              {
                k = i;
                if (i > n) {}
              }
              else
              {
                k = m;
              }
            }
          }
          j += 1;
          i = k;
        }
      }
      for (;;)
      {
        if (i <= 0) {
          break label199;
        }
        paramCharSequence = paramCharSequence.subSequence(0, i);
        break;
      }
    }
    return i;
  }
  
  private Layout a(int paramInt, CharSequence paramCharSequence)
  {
    if (a()) {
      return new DynamicLayout(paramCharSequence, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131379935);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.d);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    int i = ViewUtils.dip2px(10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131379935);
    localLayoutParams.addRule(7, 2131379935);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      post(new FolderTextView.1(this));
    }
  }
  
  private boolean a()
  {
    boolean bool1 = this.jdField_a_of_type_JavaLangCharSequence instanceof Spannable;
    boolean bool2 = this.jdField_a_of_type_AndroidWidgetTextView.isTextSelectable();
    return (bool1) || (bool2);
  }
  
  private void b()
  {
    int j = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    if (j <= 0)
    {
      this.e = 1;
      QLog.d("FolderTextView", 1, "updateFoldStatus, layoutWidth <= 0");
    }
    Object localObject1;
    Object localObject2;
    label297:
    int k;
    if (this.e == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getLayout() != null) {
        i = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getWidth();
      }
      Layout localLayout;
      for (;;)
      {
        localLayout = a(i, this.jdField_a_of_type_JavaLangCharSequence);
        if (localLayout.getLineCount() > this.c) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
        i = j;
        if (QLog.isDebugVersion())
        {
          QLog.d("FolderTextView", 4, "getLayout == null");
          i = j;
        }
      }
      j = localLayout.getLineStart(this.c - 1);
      i = localLayout.getLineEnd(this.c - 1);
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof QQText))
      {
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence, j, i);
        if (QLog.isDebugVersion()) {
          QLog.d("FolderTextView", 4, String.format("mText: %s, lineCount: %s, lastLineText: %s", new Object[] { this.jdField_a_of_type_JavaLangCharSequence.toString(), Integer.valueOf(localLayout.getLineCount()), localObject1 }));
        }
        localObject2 = localObject1;
        if (((CharSequence)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (((CharSequence)localObject1).toString().charAt(((CharSequence)localObject1).length() - 1) == '\n')
          {
            if (((CharSequence)localObject1).length() != 1) {
              break label411;
            }
            localObject2 = "";
          }
        }
        i = localLayout.getWidth();
        k = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
        k = a((CharSequence)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), i - k);
        if (k == ((CharSequence)localObject2).length()) {
          break label453;
        }
      }
    }
    label411:
    label453:
    for (int i = 1;; i = 0)
    {
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence, 0, k + j);
      if (i != 0) {
        ((SpannableStringBuilder)localObject1).append("...");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      localObject1 = this.jdField_a_of_type_JavaLangCharSequence.subSequence(j, i);
      break;
      localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
      break label297;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getText();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      b();
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.e = 0;
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FolderTextView
 * JD-Core Version:    0.7.0.1
 */