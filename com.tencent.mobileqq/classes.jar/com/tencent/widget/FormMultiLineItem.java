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
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ArrayList<MultiImageTextView> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  
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
            return paramResources.getDrawable(2130839433);
          }
          return paramResources.getDrawable(2130839440);
        }
        return paramResources.getDrawable(2130839443);
      }
      return paramResources.getDrawable(2130839449);
    }
    return paramResources.getDrawable(2130839433);
  }
  
  private void a()
  {
    int j = this.b;
    if ((j < 2) && (j > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int n = getResources().getDimensionPixelSize(2131296764);
    int k = getResources().getDimensionPixelSize(2131296773);
    int m = getResources().getDimensionPixelSize(2131296762);
    if (this.b == 2) {
      j = getResources().getDimensionPixelSize(2131296747);
    } else {
      j = getResources().getDimensionPixelSize(2131296763);
    }
    this.c = m;
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
    setMinimumHeight(this.d);
    setPadding(this.g, 0, this.h, 0);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131367165);
    this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    MultiImageTextView localMultiImageTextView = new MultiImageTextView(getContext());
    localMultiImageTextView.setId(2131367163);
    localMultiImageTextView.setTextSize(0, n);
    localMultiImageTextView.setTextColor(getResources().getColor(2131167124));
    localMultiImageTextView.setSingleLine(true);
    localMultiImageTextView.setDuplicateParentStateEnabled(true);
    localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    localMultiImageTextView.setText(HardCodeUtil.a(2131704824));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131367165);
    localLayoutParams.bottomMargin = j;
    localLayoutParams.leftMargin = this.i;
    this.jdField_a_of_type_JavaUtilArrayList.add(localMultiImageTextView);
    addView(localMultiImageTextView, localLayoutParams);
    j = 1;
    while (j < this.b)
    {
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setTextSize(0, k);
      localMultiImageTextView.setTextColor(getResources().getColor(2131167144));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(HardCodeUtil.a(2131704826));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.i;
      localLayoutParams.addRule(1, 2131367165);
      if (j == 1) {
        localMultiImageTextView.setId(2131367169);
      } else if (j == 2) {
        localMultiImageTextView.setId(2131367170);
      }
      if (j != this.b - 1) {
        localLayoutParams.bottomMargin = m;
      }
      addView(localMultiImageTextView, localLayoutParams);
      this.jdField_a_of_type_JavaUtilArrayList.add(localMultiImageTextView);
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    while (paramInt2 < this.b)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2)).getLayoutParams();
      localLayoutParams.topMargin = paramInt1;
      localLayoutParams.leftMargin = this.i;
      paramInt1 += ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2)).getMeasuredHeight();
      ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2)).setLayoutParams(localLayoutParams);
      paramInt2 += 1;
    }
  }
  
  /* Error */
  private void a(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 105	com/tencent/widget/FormMultiLineItem:getContext	()Landroid/content/Context;
    //   4: aload_1
    //   5: getstatic 235	com/tencent/mobileqq/R$styleable:MultiLineItem	[I
    //   8: invokevirtual 241	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 30	com/tencent/widget/FormMultiLineItem:b	I
    //   16: ifge +13 -> 29
    //   19: aload_0
    //   20: aload_1
    //   21: iconst_5
    //   22: iconst_2
    //   23: invokevirtual 247	android/content/res/TypedArray:getInt	(II)I
    //   26: putfield 30	com/tencent/widget/FormMultiLineItem:b	I
    //   29: aload_0
    //   30: aload_1
    //   31: iconst_3
    //   32: iconst_0
    //   33: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   36: putfield 40	com/tencent/widget/FormMultiLineItem:f	I
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_2
    //   42: iconst_0
    //   43: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   46: putfield 38	com/tencent/widget/FormMultiLineItem:e	I
    //   49: aload_0
    //   50: aload_1
    //   51: bipush 6
    //   53: iconst_0
    //   54: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   57: putfield 36	com/tencent/widget/FormMultiLineItem:d	I
    //   60: aload_0
    //   61: invokevirtual 74	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   64: ldc 250
    //   66: invokevirtual 79	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   69: istore_2
    //   70: aload_0
    //   71: invokevirtual 74	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   74: ldc 251
    //   76: invokevirtual 79	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   79: istore_3
    //   80: aload_0
    //   81: invokevirtual 74	com/tencent/widget/FormMultiLineItem:getResources	()Landroid/content/res/Resources;
    //   84: ldc 252
    //   86: invokevirtual 79	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   89: istore 4
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_4
    //   94: iload_2
    //   95: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   98: putfield 42	com/tencent/widget/FormMultiLineItem:g	I
    //   101: aload_0
    //   102: aload_1
    //   103: bipush 8
    //   105: iload_3
    //   106: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   109: putfield 44	com/tencent/widget/FormMultiLineItem:h	I
    //   112: aload_0
    //   113: aload_1
    //   114: bipush 7
    //   116: iload 4
    //   118: invokevirtual 249	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   121: putfield 46	com/tencent/widget/FormMultiLineItem:i	I
    //   124: aload_0
    //   125: aload_1
    //   126: iconst_0
    //   127: iconst_0
    //   128: invokevirtual 255	android/content/res/TypedArray:getInteger	(II)I
    //   131: putfield 85	com/tencent/widget/FormMultiLineItem:jdField_a_of_type_Int	I
    //   134: goto +28 -> 162
    //   137: astore 5
    //   139: goto +28 -> 167
    //   142: astore 5
    //   144: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +15 -> 162
    //   150: ldc_w 263
    //   153: iconst_2
    //   154: aload 5
    //   156: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_1
    //   163: invokevirtual 273	android/content/res/TypedArray:recycle	()V
    //   166: return
    //   167: aload_1
    //   168: invokevirtual 273	android/content/res/TypedArray:recycle	()V
    //   171: aload 5
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	FormMultiLineItem
    //   0	174	1	paramAttributeSet	AttributeSet
    //   69	26	2	j	int
    //   79	27	3	k	int
    //   89	28	4	m	int
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
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public MultiImageTextView a(int paramInt)
  {
    if ((paramInt < this.b) && (paramInt >= 0)) {
      return (MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    throw new RuntimeException("Qui MultiLineItem array index out of range");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e == 0) {
      if (this.b == 2) {
        this.e = getResources().getDimensionPixelSize(2131296746);
      } else {
        this.e = getResources().getDimensionPixelSize(2131296761);
      }
    }
    if (this.f == 0) {
      if (this.b == 2) {
        this.f = getResources().getDimensionPixelSize(2131296746);
      } else {
        this.f = getResources().getDimensionPixelSize(2131296761);
      }
    }
    if (this.d == 0) {
      if (this.b == 2) {
        this.d = getResources().getDimensionPixelSize(2131296745);
      } else {
        this.d = getResources().getDimensionPixelSize(2131296760);
      }
    }
    setMinimumHeight(this.d);
    int j = this.g;
    int m = this.h;
    int k = 0;
    setPadding(j, 0, m, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.f, this.e);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    j = 0;
    while (k < this.b)
    {
      ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(k)).measure(paramInt1, paramInt2);
      j += ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getMeasuredHeight();
      k += 1;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.measure(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight() <= j) && (this.b > 3))
    {
      j = getResources().getDimensionPixelSize(2131296758);
      k = getResources().getDimensionPixelSize(2131296753);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.topMargin = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      a(j, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.b - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = k;
      ((MultiImageTextView)this.jdField_a_of_type_JavaUtilArrayList.get(this.b - 1)).setLayoutParams(localLayoutParams);
    }
    else
    {
      k = this.c;
      m = this.b;
      a((this.d - (j + k * (m - 1))) / 2, paramInt1, paramInt2);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAllTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextColor(localColorStateList);
    }
  }
  
  public void setAllTextSize(float paramFloat)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.e = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt >= 2)
    {
      int j = this.b;
      if (j != paramInt) {
        if (j < paramInt)
        {
          int k = getResources().getDimensionPixelSize(2131296773);
          int m = this.b;
          j = 0;
          while (j < paramInt - m)
          {
            localObject = new MultiImageTextView(getContext());
            ((MultiImageTextView)localObject).setTextSize(0, k);
            ((MultiImageTextView)localObject).setTextColor(getResources().getColor(2131167144));
            ((MultiImageTextView)localObject).setSingleLine(true);
            ((MultiImageTextView)localObject).setDuplicateParentStateEnabled(true);
            ((MultiImageTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
            ((MultiImageTextView)localObject).setText(HardCodeUtil.a(2131704825));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = this.i;
            localLayoutParams.addRule(1, 2131367165);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            addView((View)localObject, localLayoutParams);
            j += 1;
          }
          this.b = paramInt;
        }
        else if (j > paramInt)
        {
          while (j > paramInt)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.b - 1);
            j -= 1;
          }
          this.b = paramInt;
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
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void setmMinHeight(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.FormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */