package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class FormMultiLineItem
  extends RelativeLayout
{
  private ImageView a;
  private ArrayList<MultiImageTextView> b;
  private int c;
  private int d = -1;
  private boolean e = false;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  public FormMultiLineItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839622);
          }
          return paramResources.getDrawable(2130839629);
        }
        return paramResources.getDrawable(2130839632);
      }
      return paramResources.getDrawable(2130839638);
    }
    return paramResources.getDrawable(2130839622);
  }
  
  private void a()
  {
    int m = this.d;
    if ((m < 2) && (m > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int i2 = getResources().getDimensionPixelSize(2131297095);
    int n = getResources().getDimensionPixelSize(2131297104);
    int i1 = getResources().getDimensionPixelSize(2131297093);
    if (this.d == 2) {
      m = getResources().getDimensionPixelSize(2131297078);
    } else {
      m = getResources().getDimensionPixelSize(2131297094);
    }
    this.f = i1;
    setBackgroundDrawable(a(getResources(), this.c));
    setMinimumHeight(this.g);
    setPadding(this.j, 0, this.k, 0);
    this.a = new ImageView(getContext());
    this.a.setId(2131433621);
    this.a.setFocusable(false);
    this.a.setClickable(false);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.a);
    this.b = new ArrayList();
    MultiImageTextView localMultiImageTextView = new MultiImageTextView(getContext());
    localMultiImageTextView.setId(2131433618);
    localMultiImageTextView.setTextSize(0, i2);
    localMultiImageTextView.setTextColor(getResources().getColor(2131168102));
    localMultiImageTextView.setSingleLine(true);
    localMultiImageTextView.setDuplicateParentStateEnabled(true);
    localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    localMultiImageTextView.setText(HardCodeUtil.a(2131902725));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131433621);
    localLayoutParams.bottomMargin = m;
    localLayoutParams.leftMargin = this.l;
    this.b.add(localMultiImageTextView);
    addView(localMultiImageTextView, localLayoutParams);
    m = 1;
    while (m < this.d)
    {
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setTextSize(0, n);
      localMultiImageTextView.setTextColor(getResources().getColor(2131168125));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(HardCodeUtil.a(2131902727));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.l;
      localLayoutParams.addRule(1, 2131433621);
      if (m == 1) {
        localMultiImageTextView.setId(2131433625);
      } else if (m == 2) {
        localMultiImageTextView.setId(2131433626);
      }
      if (m != this.d - 1) {
        localLayoutParams.bottomMargin = i1;
      }
      addView(localMultiImageTextView, localLayoutParams);
      this.b.add(localMultiImageTextView);
      m += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    while (paramInt2 < this.d)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.b.get(paramInt2)).getLayoutParams();
      localLayoutParams.topMargin = paramInt1;
      localLayoutParams.leftMargin = this.l;
      paramInt1 += ((MultiImageTextView)this.b.get(paramInt2)).getMeasuredHeight();
      ((MultiImageTextView)this.b.get(paramInt2)).setLayoutParams(localLayoutParams);
      paramInt2 += 1;
    }
  }
  
  /* Error */
  private void a(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 108	com/tencent/widget/FormMultiLineItem:getContext	()Landroid/content/Context;
    //   4: aload_1
    //   5: getstatic 238	com/tencent/mobileqq/R$styleable:MultiLineItem	[I
    //   8: invokevirtual 244	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 33	com/tencent/widget/FormMultiLineItem:d	I
    //   16: ifge +13 -> 29
    //   19: aload_0
    //   20: aload_1
    //   21: iconst_5
    //   22: iconst_2
    //   23: invokevirtual 250	android/content/res/TypedArray:getInt	(II)I
    //   26: putfield 33	com/tencent/widget/FormMultiLineItem:d	I
    //   29: aload_0
    //   30: aload_1
    //   31: iconst_3
    //   32: iconst_0
    //   33: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   36: putfield 43	com/tencent/widget/FormMultiLineItem:i	I
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_2
    //   42: iconst_0
    //   43: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   46: putfield 41	com/tencent/widget/FormMultiLineItem:h	I
    //   49: aload_0
    //   50: aload_1
    //   51: bipush 6
    //   53: iconst_0
    //   54: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   57: putfield 39	com/tencent/widget/FormMultiLineItem:g	I
    //   60: aload_0
    //   61: invokevirtual 77	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   64: ldc 253
    //   66: invokevirtual 82	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   69: istore_2
    //   70: aload_0
    //   71: invokevirtual 77	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   74: ldc 254
    //   76: invokevirtual 82	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   79: istore_3
    //   80: aload_0
    //   81: invokevirtual 77	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   84: ldc 255
    //   86: invokevirtual 82	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   89: istore 4
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_4
    //   94: iload_2
    //   95: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   98: putfield 45	com/tencent/widget/FormMultiLineItem:j	I
    //   101: aload_0
    //   102: aload_1
    //   103: bipush 8
    //   105: iload_3
    //   106: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   109: putfield 47	com/tencent/widget/FormMultiLineItem:k	I
    //   112: aload_0
    //   113: aload_1
    //   114: bipush 7
    //   116: iload 4
    //   118: invokevirtual 252	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   121: putfield 49	com/tencent/widget/FormMultiLineItem:l	I
    //   124: aload_0
    //   125: aload_1
    //   126: iconst_0
    //   127: iconst_0
    //   128: invokevirtual 258	android/content/res/TypedArray:getInteger	(II)I
    //   131: putfield 88	com/tencent/widget/FormMultiLineItem:c	I
    //   134: goto +28 -> 162
    //   137: astore 5
    //   139: goto +28 -> 167
    //   142: astore 5
    //   144: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +15 -> 162
    //   150: ldc_w 266
    //   153: iconst_2
    //   154: aload 5
    //   156: invokevirtual 270	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_1
    //   163: invokevirtual 276	android/content/res/TypedArray:recycle	()V
    //   166: return
    //   167: aload_1
    //   168: invokevirtual 276	android/content/res/TypedArray:recycle	()V
    //   171: aload 5
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	FormMultiLineItem
    //   0	174	1	paramAttributeSet	AttributeSet
    //   69	26	2	m	int
    //   79	27	3	n	int
    //   89	28	4	i1	int
    //   137	1	5	localObject	Object
    //   142	30	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	29	137	finally
    //   29	134	137	finally
    //   144	162	137	finally
    //   12	29	142	java/lang/Exception
    //   29	134	142	java/lang/Exception
  }
  
  public MultiImageTextView a(int paramInt)
  {
    if ((paramInt < this.d) && (paramInt >= 0)) {
      return (MultiImageTextView)this.b.get(paramInt);
    }
    throw new RuntimeException("Qui MultiLineItem array index out of range");
  }
  
  public ImageView getHeaderView()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.h == 0) {
      if (this.d == 2) {
        this.h = getResources().getDimensionPixelSize(2131297077);
      } else {
        this.h = getResources().getDimensionPixelSize(2131297092);
      }
    }
    if (this.i == 0) {
      if (this.d == 2) {
        this.i = getResources().getDimensionPixelSize(2131297077);
      } else {
        this.i = getResources().getDimensionPixelSize(2131297092);
      }
    }
    if (this.g == 0) {
      if (this.d == 2) {
        this.g = getResources().getDimensionPixelSize(2131297076);
      } else {
        this.g = getResources().getDimensionPixelSize(2131297091);
      }
    }
    setMinimumHeight(this.g);
    int m = this.j;
    int i1 = this.k;
    int n = 0;
    setPadding(m, 0, i1, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.i, this.h);
    this.a.setLayoutParams(localLayoutParams);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    m = 0;
    while (n < this.d)
    {
      ((MultiImageTextView)this.b.get(n)).measure(paramInt1, paramInt2);
      m += ((MultiImageTextView)this.b.get(n)).getMeasuredHeight();
      n += 1;
    }
    this.a.measure(paramInt1, paramInt2);
    if ((this.a.getMeasuredHeight() <= m) && (this.d > 3))
    {
      m = getResources().getDimensionPixelSize(2131297089);
      n = getResources().getDimensionPixelSize(2131297084);
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.topMargin = m;
      this.a.setLayoutParams(localLayoutParams);
      a(m, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.b.get(this.d - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = n;
      ((MultiImageTextView)this.b.get(this.d - 1)).setLayoutParams(localLayoutParams);
    }
    else
    {
      n = this.f;
      i1 = this.d;
      a((this.g - (m + n * (i1 - 1))) / 2, paramInt1, paramInt2);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAllTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextColor(localColorStateList);
    }
  }
  
  public void setAllTextSize(float paramFloat)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextSize(paramFloat);
    }
  }
  
  public void setBackGroundByType(int paramInt)
  {
    setBackgroundDrawable(a(getResources(), paramInt));
  }
  
  public void setHeaderView(int paramInt)
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.h = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt >= 2)
    {
      int m = this.d;
      if (m != paramInt) {
        if (m < paramInt)
        {
          int n = getResources().getDimensionPixelSize(2131297104);
          int i1 = this.d;
          m = 0;
          while (m < paramInt - i1)
          {
            localObject = new MultiImageTextView(getContext());
            ((MultiImageTextView)localObject).setTextSize(0, n);
            ((MultiImageTextView)localObject).setTextColor(getResources().getColor(2131168125));
            ((MultiImageTextView)localObject).setSingleLine(true);
            ((MultiImageTextView)localObject).setDuplicateParentStateEnabled(true);
            ((MultiImageTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
            ((MultiImageTextView)localObject).setText(HardCodeUtil.a(2131902726));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = this.l;
            localLayoutParams.addRule(1, 2131433621);
            this.b.add(localObject);
            addView((View)localObject, localLayoutParams);
            m += 1;
          }
          this.d = paramInt;
        }
        else if (m > paramInt)
        {
          while (m > paramInt)
          {
            this.b.remove(this.d - 1);
            m -= 1;
          }
          this.d = paramInt;
        }
      }
      postInvalidate();
      return;
    }
    Object localObject = new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setMarginLeftRight(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setmMinHeight(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */