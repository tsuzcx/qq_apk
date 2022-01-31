package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.MultiImageTextView;

public class FormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  public static boolean b;
  private int jdField_a_of_type_Int;
  public Drawable a;
  public MultiImageTextView a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public boolean a;
  private int b;
  public Drawable b;
  private int jdField_c_of_type_Int;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public TextView c;
  public CharSequence c;
  protected boolean c;
  private int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public FormSimpleItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 34	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: invokevirtual 38	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   10: ldc 39
    //   12: invokevirtual 45	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   15: istore_3
    //   16: aload_0
    //   17: aload_0
    //   18: invokevirtual 38	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   21: invokevirtual 49	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   24: getfield 55	android/util/DisplayMetrics:density	F
    //   27: ldc 56
    //   29: fmul
    //   30: f2d
    //   31: ldc2_w 57
    //   34: dadd
    //   35: d2i
    //   36: putfield 60	com/tencent/mobileqq/widget/FormSimpleItem:l	I
    //   39: aload_0
    //   40: aload_0
    //   41: invokevirtual 38	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   44: invokevirtual 49	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   47: getfield 55	android/util/DisplayMetrics:density	F
    //   50: ldc 61
    //   52: fmul
    //   53: f2d
    //   54: ldc2_w 57
    //   57: dadd
    //   58: d2i
    //   59: putfield 63	com/tencent/mobileqq/widget/FormSimpleItem:m	I
    //   62: aload_0
    //   63: aload_0
    //   64: invokevirtual 38	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   67: ldc 64
    //   69: invokevirtual 68	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   72: putfield 70	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   75: aconst_null
    //   76: astore 4
    //   78: aload_1
    //   79: aload_2
    //   80: getstatic 76	com/tencent/mobileqq/R$styleable:FormItem	[I
    //   83: invokevirtual 82	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   86: astore_1
    //   87: aload_1
    //   88: astore 4
    //   90: aload_0
    //   91: aload_1
    //   92: bipush 6
    //   94: aload_0
    //   95: invokevirtual 38	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   98: ldc 83
    //   100: invokevirtual 45	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   103: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   106: putfield 90	com/tencent/mobileqq/widget/FormSimpleItem:k	I
    //   109: aload_1
    //   110: astore 4
    //   112: aload_0
    //   113: aload_1
    //   114: iconst_5
    //   115: iload_3
    //   116: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   119: putfield 92	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   122: aload_1
    //   123: astore 4
    //   125: aload_0
    //   126: aload_1
    //   127: bipush 7
    //   129: invokevirtual 96	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   132: putfield 98	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   135: aload_1
    //   136: astore 4
    //   138: aload_0
    //   139: aload_1
    //   140: bipush 9
    //   142: iconst_0
    //   143: invokevirtual 101	android/content/res/TypedArray:getInt	(II)I
    //   146: putfield 103	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_Int	I
    //   149: aload_1
    //   150: astore 4
    //   152: aload_0
    //   153: aload_1
    //   154: bipush 8
    //   156: invokevirtual 104	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   159: putfield 106	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   162: aload_1
    //   163: astore 4
    //   165: aload_0
    //   166: aload_1
    //   167: iconst_3
    //   168: iconst_0
    //   169: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   172: putfield 108	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_Int	I
    //   175: aload_1
    //   176: astore 4
    //   178: aload_0
    //   179: aload_1
    //   180: iconst_4
    //   181: iconst_0
    //   182: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   185: putfield 110	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_Int	I
    //   188: aload_1
    //   189: astore 4
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 92	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   196: aload_0
    //   197: getfield 110	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_Int	I
    //   200: invokestatic 115	java/lang/Math:min	(II)I
    //   203: putfield 110	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_Int	I
    //   206: aload_1
    //   207: astore 4
    //   209: aload_0
    //   210: aload_1
    //   211: bipush 10
    //   213: invokevirtual 96	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   216: putfield 117	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   219: aload_1
    //   220: astore 4
    //   222: aload_0
    //   223: aload_1
    //   224: bipush 14
    //   226: iconst_3
    //   227: invokevirtual 101	android/content/res/TypedArray:getInt	(II)I
    //   230: putfield 119	com/tencent/mobileqq/widget/FormSimpleItem:g	I
    //   233: aload_1
    //   234: astore 4
    //   236: aload_0
    //   237: aload_1
    //   238: bipush 11
    //   240: invokevirtual 104	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   243: putfield 121	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   246: aload_1
    //   247: astore 4
    //   249: aload_0
    //   250: aload_1
    //   251: bipush 12
    //   253: iconst_0
    //   254: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   257: putfield 123	com/tencent/mobileqq/widget/FormSimpleItem:e	I
    //   260: aload_1
    //   261: astore 4
    //   263: aload_0
    //   264: aload_1
    //   265: bipush 13
    //   267: iconst_0
    //   268: invokevirtual 88	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   271: putfield 125	com/tencent/mobileqq/widget/FormSimpleItem:f	I
    //   274: aload_1
    //   275: astore 4
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 92	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   282: aload_0
    //   283: getfield 125	com/tencent/mobileqq/widget/FormSimpleItem:f	I
    //   286: invokestatic 115	java/lang/Math:min	(II)I
    //   289: putfield 125	com/tencent/mobileqq/widget/FormSimpleItem:f	I
    //   292: aload_1
    //   293: astore 4
    //   295: aload_0
    //   296: aload_1
    //   297: bipush 15
    //   299: iconst_0
    //   300: invokevirtual 129	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   303: putfield 131	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_Boolean	Z
    //   306: aload_1
    //   307: astore 4
    //   309: aload_0
    //   310: aload_1
    //   311: iconst_0
    //   312: iconst_0
    //   313: invokevirtual 101	android/content/res/TypedArray:getInt	(II)I
    //   316: putfield 133	com/tencent/mobileqq/widget/FormSimpleItem:d	I
    //   319: aload_1
    //   320: astore 4
    //   322: aload_1
    //   323: iconst_1
    //   324: iconst_1
    //   325: invokevirtual 129	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   328: putstatic 135	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_Boolean	Z
    //   331: aload_1
    //   332: astore 4
    //   334: aload_0
    //   335: aload_1
    //   336: iconst_2
    //   337: iconst_1
    //   338: invokevirtual 129	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   341: putfield 137	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_Boolean	Z
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   352: aload_0
    //   353: invokevirtual 143	com/tencent/mobileqq/widget/FormSimpleItem:b	()V
    //   356: return
    //   357: astore_1
    //   358: aload 4
    //   360: ifnull -8 -> 352
    //   363: aload 4
    //   365: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   368: goto -16 -> 352
    //   371: astore_1
    //   372: aconst_null
    //   373: astore 4
    //   375: aload_1
    //   376: astore_2
    //   377: aload 4
    //   379: ifnull +8 -> 387
    //   382: aload 4
    //   384: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   387: aload_2
    //   388: athrow
    //   389: astore_2
    //   390: aload_1
    //   391: astore 4
    //   393: goto -16 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	FormSimpleItem
    //   0	396	1	paramContext	Context
    //   0	396	2	paramAttributeSet	android.util.AttributeSet
    //   15	101	3	n	int
    //   76	316	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   78	87	357	java/lang/Throwable
    //   90	109	357	java/lang/Throwable
    //   112	122	357	java/lang/Throwable
    //   125	135	357	java/lang/Throwable
    //   138	149	357	java/lang/Throwable
    //   152	162	357	java/lang/Throwable
    //   165	175	357	java/lang/Throwable
    //   178	188	357	java/lang/Throwable
    //   191	206	357	java/lang/Throwable
    //   209	219	357	java/lang/Throwable
    //   222	233	357	java/lang/Throwable
    //   236	246	357	java/lang/Throwable
    //   249	260	357	java/lang/Throwable
    //   263	274	357	java/lang/Throwable
    //   277	292	357	java/lang/Throwable
    //   295	306	357	java/lang/Throwable
    //   309	319	357	java/lang/Throwable
    //   322	331	357	java/lang/Throwable
    //   334	344	357	java/lang/Throwable
    //   78	87	371	finally
    //   90	109	389	finally
    //   112	122	389	finally
    //   125	135	389	finally
    //   138	149	389	finally
    //   152	162	389	finally
    //   165	175	389	finally
    //   178	188	389	finally
    //   191	206	389	finally
    //   209	219	389	finally
    //   222	233	389	finally
    //   236	246	389	finally
    //   249	260	389	finally
    //   263	274	389	finally
    //   277	292	389	finally
    //   295	306	389	finally
    //   309	319	389	finally
    //   322	331	389	finally
    //   334	344	389	finally
  }
  
  public static ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131494220);
    case 0: 
      return paramResources.getColorStateList(2131494220);
    case 2: 
      return paramResources.getColorStateList(2131494270);
    case 1: 
      return paramResources.getColorStateList(2131494226);
    }
    return paramResources.getColorStateList(2131494283);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838629);
    case 0: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130838629);
      }
      return paramResources.getDrawable(2130846083);
    case 1: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130838641);
      }
      return paramResources.getDrawable(2130846103);
    case 2: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130838639);
      }
      return paramResources.getDrawable(2130846097);
    }
    if (jdField_b_of_type_Boolean) {
      return paramResources.getDrawable(2130838636);
    }
    return paramResources.getDrawable(2130846088);
  }
  
  public ColorStateList a(Resources paramResources, int paramInt)
  {
    return b(paramResources, paramInt);
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    return b(paramResources, paramInt);
  }
  
  public TextView a()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public MultiImageTextView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView == null) {}
    do
    {
      do
      {
        return;
        c();
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(this.i);
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.g));
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setMaxWidth(this.h);
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
        {
          if ((this.e > 0) && (this.f > 0))
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.e > 0) && (this.f > 0))
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
        }
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.e > 0) && (this.f > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.e > 0) && (this.f > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  protected void b()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131362054);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_c_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_c_of_type_Int));
    int n = getContext().getResources().getDimensionPixelSize(2131559307);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(0, n);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.k;
    if (!this.jdField_c_of_type_Boolean)
    {
      localLayoutParams.topMargin = this.k;
      localLayoutParams.bottomMargin = this.k;
      setMinimumHeight(this.j);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(this.i);
    addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = new MultiImageTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setId(2131362055);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.g));
    n = getContext().getResources().getDimensionPixelSize(2131559308);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextSize(0, n);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setGravity(19);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.k;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView, localLayoutParams);
    a();
    setBackgroundDrawable(a(getResources(), this.d));
  }
  
  public void c()
  {
    int i2 = 0;
    int i1 = getResources().getDisplayMetrics().widthPixels - this.k * 2;
    int n;
    if (this.jdField_c_of_type_JavaLangCharSequence == null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
        n = this.l + this.k + this.m;
      }
      for (;;)
      {
        this.i = (i1 - n);
        this.h = 0;
        return;
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean)) {
          n = this.l;
        } else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean)) {
          n = this.m;
        } else {
          n = 0;
        }
      }
    }
    int i4 = i1 - this.k;
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.jdField_a_of_type_Int == 0)
      {
        n = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        n += this.k;
      }
    }
    for (;;)
    {
      i1 = n + (int)this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        if (this.e == 0) {
          n = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        }
      }
      label200:
      for (n = n + 0 + this.k;; n = 0)
      {
        if (this.jdField_a_of_type_Boolean) {
          n = n + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + this.k;
        }
        for (;;)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaint();
          localObject = new StaticLayout(this.jdField_c_of_type_JavaLangCharSequence, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
          int i5 = ((StaticLayout)localObject).getLineCount();
          int i3 = 0;
          for (;;)
          {
            if (i2 < i5)
            {
              i3 = (int)((StaticLayout)localObject).getLineWidth(i2) + (int)((StaticLayout)localObject).getLineWidth(i2);
              i2 += 1;
              continue;
              n = this.jdField_a_of_type_Int;
              break;
              n = this.e;
              break label200;
            }
          }
          i2 = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaddingLeft() + (n + i3);
          n = i4 / 2;
          if ((i1 >= n) && (i2 >= n)) {
            i1 = n;
          }
          for (;;)
          {
            this.i = i1;
            this.h = n;
            return;
            if ((i1 > n) && (i2 < n))
            {
              i1 = i4 - i2;
              n = i2;
            }
            else if ((i1 < n) && (i2 > n))
            {
              n = i4 - i1;
            }
            else
            {
              n = i2;
            }
          }
        }
      }
      n = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.j);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.d = paramInt;
    setBackgroundDrawable(a(getResources(), this.d));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_c_of_type_Boolean))
    {
      this.j = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.j)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.j);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.k);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = Math.min(this.j, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.jdField_b_of_type_Int);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.k);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_c_of_type_Int));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_c_of_type_Int));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    this.e = paramInt1;
    this.f = Math.min(this.j, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    a();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView != null)
    {
      this.g = paramInt;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.g));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */