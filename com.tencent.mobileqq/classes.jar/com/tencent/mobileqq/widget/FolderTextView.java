package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FolderTextView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
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
  
  /* Error */
  public FolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 29	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 31	com/tencent/mobileqq/widget/FolderTextView$2
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 34	com/tencent/mobileqq/widget/FolderTextView$2:<init>	(Lcom/tencent/mobileqq/widget/FolderTextView;)V
    //   16: putfield 36	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   19: aload_1
    //   20: aload_2
    //   21: getstatic 42	com/tencent/mobileqq/qqui/R$styleable:R	[I
    //   24: invokevirtual 48	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_2
    //   30: getstatic 51	com/tencent/mobileqq/qqui/R$styleable:J	I
    //   33: invokevirtual 57	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   36: putfield 59	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   39: aload_0
    //   40: aload_0
    //   41: aload_2
    //   42: getstatic 61	com/tencent/mobileqq/qqui/R$styleable:I	I
    //   45: invokevirtual 65	android/content/res/TypedArray:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   48: invokespecial 68	com/tencent/mobileqq/widget/FolderTextView:a	(Landroid/content/res/ColorStateList;)I
    //   51: putfield 70	com/tencent/mobileqq/widget/FolderTextView:jdField_b_of_type_Int	I
    //   54: aload_0
    //   55: aload_2
    //   56: getstatic 73	com/tencent/mobileqq/qqui/R$styleable:H	I
    //   59: ldc 74
    //   61: invokestatic 79	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   64: invokevirtual 83	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   67: putfield 85	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_Int	I
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 85	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_Int	I
    //   75: i2f
    //   76: invokestatic 87	com/tencent/mobileqq/utils/ViewUtils:e	(F)I
    //   79: putfield 85	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_Int	I
    //   82: aload_0
    //   83: aload_2
    //   84: getstatic 90	com/tencent/mobileqq/qqui/R$styleable:M	I
    //   87: iconst_2
    //   88: invokevirtual 93	android/content/res/TypedArray:getInt	(II)I
    //   91: putfield 95	com/tencent/mobileqq/widget/FolderTextView:c	I
    //   94: aload_0
    //   95: aload_2
    //   96: getstatic 98	com/tencent/mobileqq/qqui/R$styleable:L	I
    //   99: invokevirtual 57	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   102: putfield 100	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: aload_0
    //   106: aload_2
    //   107: getstatic 103	com/tencent/mobileqq/qqui/R$styleable:K	I
    //   110: aload_1
    //   111: invokevirtual 107	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   114: ldc 108
    //   116: invokevirtual 114	android/content/res/Resources:getColor	(I)I
    //   119: invokevirtual 116	android/content/res/TypedArray:getColor	(II)I
    //   122: putfield 118	com/tencent/mobileqq/widget/FolderTextView:d	I
    //   125: goto +17 -> 142
    //   128: astore_1
    //   129: goto +62 -> 191
    //   132: astore_1
    //   133: ldc 120
    //   135: iconst_1
    //   136: ldc 122
    //   138: aload_1
    //   139: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_2
    //   143: invokevirtual 131	android/content/res/TypedArray:recycle	()V
    //   146: aload_0
    //   147: getfield 100	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +12 -> 165
    //   156: aload_0
    //   157: ldc 138
    //   159: invokestatic 142	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   162: putfield 100	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: aload_0
    //   166: getfield 59	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   169: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifeq +9 -> 181
    //   175: aload_0
    //   176: ldc 144
    //   178: putfield 59	com/tencent/mobileqq/widget/FolderTextView:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 146	com/tencent/mobileqq/widget/FolderTextView:e	I
    //   186: aload_0
    //   187: invokespecial 148	com/tencent/mobileqq/widget/FolderTextView:a	()V
    //   190: return
    //   191: aload_2
    //   192: invokevirtual 131	android/content/res/TypedArray:recycle	()V
    //   195: aload_1
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	FolderTextView
    //   0	197	1	paramContext	Context
    //   0	197	2	paramAttributeSet	AttributeSet
    //   0	197	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   28	125	128	finally
    //   133	142	128	finally
    //   28	125	132	java/lang/Exception
  }
  
  private float a(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    return paramTextPaint.measureText(paramCharSequence.toString());
  }
  
  private int a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      return paramColorStateList.getColorForState(getDrawableState(), -16777216);
    }
    return -16777216;
  }
  
  private int a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (paramFloat <= 0.0F) {
        return 0;
      }
      float f = paramTextPaint.measureText("...");
      int i = paramCharSequence.length();
      while (a(paramCharSequence, paramTextPaint) > paramFloat - f)
      {
        int j = paramCharSequence.length() - 1;
        i = j;
        if ((paramCharSequence instanceof Spanned))
        {
          Spanned localSpanned = (Spanned)paramCharSequence;
          Object[] arrayOfObject = localSpanned.getSpans(0, paramCharSequence.length(), Object.class);
          i = j;
          j = 0;
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
        if (i <= 0) {
          return 0;
        }
        paramCharSequence = paramCharSequence.subSequence(0, i);
      }
      return i;
    }
    return 0;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131379684);
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
    int i = ViewUtils.a(10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131379684);
    localLayoutParams.addRule(7, 2131379684);
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
    int k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    int j = 1;
    if (k <= 0)
    {
      this.e = 1;
      QLog.d("FolderTextView", 1, "updateFoldStatus, layoutWidth <= 0");
    }
    if (this.e == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getLayout() != null)
      {
        i = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getWidth();
      }
      else
      {
        i = k;
        if (QLog.isDebugVersion())
        {
          QLog.d("FolderTextView", 4, "getLayout == null");
          i = k;
        }
      }
      Layout localLayout = a(i, this.jdField_a_of_type_JavaLangCharSequence);
      int i = localLayout.getLineCount();
      k = this.c;
      if (i <= k)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      k = localLayout.getLineStart(k - 1);
      i = localLayout.getLineEnd(this.c - 1);
      Object localObject1 = this.jdField_a_of_type_JavaLangCharSequence;
      if ((localObject1 instanceof QQText))
      {
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence, k, i);
      }
      else
      {
        localObject1 = ((CharSequence)localObject1).subSequence(k, i);
      }
      if (QLog.isDebugVersion()) {
        QLog.d("FolderTextView", 4, String.format("mText: %s, lineCount: %s, lastLineText: %s", new Object[] { this.jdField_a_of_type_JavaLangCharSequence.toString(), Integer.valueOf(localLayout.getLineCount()), localObject1 }));
      }
      Object localObject2 = localObject1;
      if (((CharSequence)localObject1).length() > 0)
      {
        localObject2 = localObject1;
        if (((CharSequence)localObject1).toString().charAt(((CharSequence)localObject1).length() - 1) == '\n') {
          if (((CharSequence)localObject1).length() == 1) {
            localObject2 = "";
          } else {
            localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
          }
        }
      }
      i = localLayout.getWidth();
      int m = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
      m = a((CharSequence)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), i - m);
      if (m != ((CharSequence)localObject2).length()) {
        i = j;
      } else {
        i = 0;
      }
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence, 0, m + k);
      if (i != 0) {
        ((SpannableStringBuilder)localObject1).append("...");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FolderTextView
 * JD-Core Version:    0.7.0.1
 */