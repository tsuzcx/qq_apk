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
  private TextView a;
  private TextView b;
  private CharSequence c;
  private int d;
  private int e;
  private int f;
  private String g;
  private int h;
  private int i;
  private boolean j;
  private View.OnClickListener k;
  
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
    //   4: invokespecial 35	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 37	com/tencent/mobileqq/widget/FolderTextView$2
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 40	com/tencent/mobileqq/widget/FolderTextView$2:<init>	(Lcom/tencent/mobileqq/widget/FolderTextView;)V
    //   16: putfield 42	com/tencent/mobileqq/widget/FolderTextView:k	Landroid/view/View$OnClickListener;
    //   19: aload_1
    //   20: aload_2
    //   21: getstatic 48	com/tencent/mobileqq/qqui/R$styleable:aJ	[I
    //   24: invokevirtual 54	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_2
    //   30: getstatic 57	com/tencent/mobileqq/qqui/R$styleable:aM	I
    //   33: invokevirtual 63	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   36: putfield 65	com/tencent/mobileqq/widget/FolderTextView:c	Ljava/lang/CharSequence;
    //   39: aload_0
    //   40: aload_0
    //   41: aload_2
    //   42: getstatic 68	com/tencent/mobileqq/qqui/R$styleable:aL	I
    //   45: invokevirtual 72	android/content/res/TypedArray:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   48: invokespecial 75	com/tencent/mobileqq/widget/FolderTextView:a	(Landroid/content/res/ColorStateList;)I
    //   51: putfield 77	com/tencent/mobileqq/widget/FolderTextView:e	I
    //   54: aload_0
    //   55: aload_2
    //   56: getstatic 80	com/tencent/mobileqq/qqui/R$styleable:aK	I
    //   59: ldc 81
    //   61: invokestatic 87	com/tencent/mobileqq/utils/ViewUtils:dip2px	(F)I
    //   64: invokevirtual 91	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   67: putfield 93	com/tencent/mobileqq/widget/FolderTextView:d	I
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 93	com/tencent/mobileqq/widget/FolderTextView:d	I
    //   75: i2f
    //   76: invokestatic 96	com/tencent/mobileqq/utils/ViewUtils:pxTosp	(F)I
    //   79: putfield 93	com/tencent/mobileqq/widget/FolderTextView:d	I
    //   82: aload_0
    //   83: aload_2
    //   84: getstatic 99	com/tencent/mobileqq/qqui/R$styleable:aP	I
    //   87: iconst_2
    //   88: invokevirtual 102	android/content/res/TypedArray:getInt	(II)I
    //   91: putfield 104	com/tencent/mobileqq/widget/FolderTextView:f	I
    //   94: aload_0
    //   95: aload_2
    //   96: getstatic 107	com/tencent/mobileqq/qqui/R$styleable:aO	I
    //   99: invokevirtual 63	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   102: putfield 109	com/tencent/mobileqq/widget/FolderTextView:g	Ljava/lang/String;
    //   105: aload_0
    //   106: aload_2
    //   107: getstatic 112	com/tencent/mobileqq/qqui/R$styleable:aN	I
    //   110: aload_1
    //   111: invokevirtual 116	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   114: ldc 117
    //   116: invokevirtual 123	android/content/res/Resources:getColor	(I)I
    //   119: invokevirtual 125	android/content/res/TypedArray:getColor	(II)I
    //   122: putfield 127	com/tencent/mobileqq/widget/FolderTextView:h	I
    //   125: goto +17 -> 142
    //   128: astore_1
    //   129: goto +62 -> 191
    //   132: astore_1
    //   133: ldc 129
    //   135: iconst_1
    //   136: ldc 131
    //   138: aload_1
    //   139: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_2
    //   143: invokevirtual 140	android/content/res/TypedArray:recycle	()V
    //   146: aload_0
    //   147: getfield 109	com/tencent/mobileqq/widget/FolderTextView:g	Ljava/lang/String;
    //   150: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +12 -> 165
    //   156: aload_0
    //   157: ldc 147
    //   159: invokestatic 151	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   162: putfield 109	com/tencent/mobileqq/widget/FolderTextView:g	Ljava/lang/String;
    //   165: aload_0
    //   166: getfield 65	com/tencent/mobileqq/widget/FolderTextView:c	Ljava/lang/CharSequence;
    //   169: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifeq +9 -> 181
    //   175: aload_0
    //   176: ldc 153
    //   178: putfield 65	com/tencent/mobileqq/widget/FolderTextView:c	Ljava/lang/CharSequence;
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 155	com/tencent/mobileqq/widget/FolderTextView:i	I
    //   186: aload_0
    //   187: invokespecial 157	com/tencent/mobileqq/widget/FolderTextView:a	()V
    //   190: return
    //   191: aload_2
    //   192: invokevirtual 140	android/content/res/TypedArray:recycle	()V
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
      float f1 = paramTextPaint.measureText("...");
      int m = paramCharSequence.length();
      while (a(paramCharSequence, paramTextPaint) > paramFloat - f1)
      {
        int n = paramCharSequence.length() - 1;
        m = n;
        if ((paramCharSequence instanceof Spanned))
        {
          Spanned localSpanned = (Spanned)paramCharSequence;
          Object[] arrayOfObject = localSpanned.getSpans(0, paramCharSequence.length(), Object.class);
          m = n;
          n = 0;
          while (n < arrayOfObject.length)
          {
            int i2 = localSpanned.getSpanStart(Integer.valueOf(n));
            int i3 = localSpanned.getSpanEnd(Integer.valueOf(n));
            int i1 = m;
            if (i2 != -1)
            {
              i1 = m;
              if (i3 != -1) {
                if (m < i2)
                {
                  i1 = m;
                  if (m > i3) {}
                }
                else
                {
                  i1 = i2;
                }
              }
            }
            n += 1;
            m = i1;
          }
        }
        if (m <= 0) {
          return 0;
        }
        paramCharSequence = paramCharSequence.subSequence(0, m);
      }
      return m;
    }
    return 0;
  }
  
  private Layout a(int paramInt, CharSequence paramCharSequence)
  {
    if (b()) {
      return new DynamicLayout(paramCharSequence, this.a.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    return new StaticLayout(paramCharSequence, this.a.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void a()
  {
    this.a = new TextView(getContext());
    this.a.setId(2131448466);
    this.a.setTextColor(this.e);
    this.a.setTextSize(this.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.a, localLayoutParams);
    this.b = new TextView(getContext());
    this.b.setTextSize(this.d);
    this.b.setOnClickListener(this.k);
    this.b.setText(this.g);
    this.b.setTextColor(this.h);
    this.b.setVisibility(4);
    int m = ViewUtils.dip2px(10.0F);
    this.b.setPadding(m, 0, m, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131448466);
    localLayoutParams.addRule(7, 2131448466);
    addView(this.b, localLayoutParams);
    if (!TextUtils.isEmpty(this.c)) {
      post(new FolderTextView.1(this));
    }
  }
  
  private boolean b()
  {
    boolean bool1 = this.c instanceof Spannable;
    boolean bool2 = this.a.isTextSelectable();
    return (bool1) || (bool2);
  }
  
  private void c()
  {
    int i1 = this.a.getMeasuredWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight();
    int n = 1;
    if (i1 <= 0)
    {
      this.i = 1;
      QLog.d("FolderTextView", 1, "updateFoldStatus, layoutWidth <= 0");
    }
    if (this.i == 0)
    {
      if (this.a.getLayout() != null)
      {
        m = this.a.getLayout().getWidth();
      }
      else
      {
        m = i1;
        if (QLog.isDebugVersion())
        {
          QLog.d("FolderTextView", 4, "getLayout == null");
          m = i1;
        }
      }
      Layout localLayout = a(m, this.c);
      int m = localLayout.getLineCount();
      i1 = this.f;
      if (m <= i1)
      {
        this.a.setText(this.c);
        this.b.setVisibility(4);
        return;
      }
      i1 = localLayout.getLineStart(i1 - 1);
      m = localLayout.getLineEnd(this.f - 1);
      Object localObject1 = this.c;
      if ((localObject1 instanceof QQText))
      {
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(this.c, i1, m);
      }
      else
      {
        localObject1 = ((CharSequence)localObject1).subSequence(i1, m);
      }
      if (QLog.isDebugVersion()) {
        QLog.d("FolderTextView", 4, String.format("mText: %s, lineCount: %s, lastLineText: %s", new Object[] { this.c.toString(), Integer.valueOf(localLayout.getLineCount()), localObject1 }));
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
      m = localLayout.getWidth();
      int i2 = this.b.getMeasuredWidth();
      i2 = a((CharSequence)localObject2, this.a.getPaint(), m - i2);
      if (i2 != ((CharSequence)localObject2).length()) {
        m = n;
      } else {
        m = 0;
      }
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(this.c, 0, i2 + i1);
      if (m != 0) {
        ((SpannableStringBuilder)localObject1).append("...");
      }
      this.a.setText((CharSequence)localObject1);
      this.b.setVisibility(0);
      return;
    }
    this.a.setText(this.c);
    this.b.setVisibility(4);
  }
  
  public CharSequence getText()
  {
    return this.a.getText();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.j)
    {
      this.j = true;
      c();
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    this.i = 0;
    if (this.j) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FolderTextView
 * JD-Core Version:    0.7.0.1
 */