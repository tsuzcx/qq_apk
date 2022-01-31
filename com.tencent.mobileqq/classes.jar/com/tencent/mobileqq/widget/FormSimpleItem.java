package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
import bclw;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.MultiImageTextView;

public class FormSimpleItem
  extends RelativeLayout
  implements bclw
{
  protected static boolean b;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  protected Drawable a;
  protected MultiImageTextView a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  protected Drawable b;
  private Drawable c;
  protected boolean c;
  protected TextView d;
  protected CharSequence d;
  private int g;
  private int h;
  private int i;
  private int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  private int p;
  private int q;
  private int r;
  
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
    //   3: invokespecial 39	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: new 41	android/graphics/Rect
    //   10: dup
    //   11: invokespecial 44	android/graphics/Rect:<init>	()V
    //   14: putfield 46	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   17: aload_0
    //   18: new 48	android/graphics/Paint
    //   21: dup
    //   22: invokespecial 49	android/graphics/Paint:<init>	()V
    //   25: putfield 51	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   28: aload_0
    //   29: invokevirtual 55	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   32: ldc 56
    //   34: invokevirtual 62	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   37: istore_3
    //   38: aload_0
    //   39: aload_0
    //   40: invokevirtual 55	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   43: invokevirtual 66	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   46: getfield 72	android/util/DisplayMetrics:density	F
    //   49: ldc 73
    //   51: fmul
    //   52: f2d
    //   53: ldc2_w 74
    //   56: dadd
    //   57: d2i
    //   58: putfield 77	com/tencent/mobileqq/widget/FormSimpleItem:q	I
    //   61: aload_0
    //   62: aload_0
    //   63: invokevirtual 55	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   66: invokevirtual 66	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   69: getfield 72	android/util/DisplayMetrics:density	F
    //   72: ldc 78
    //   74: fmul
    //   75: f2d
    //   76: ldc2_w 74
    //   79: dadd
    //   80: d2i
    //   81: putfield 80	com/tencent/mobileqq/widget/FormSimpleItem:r	I
    //   84: aload_0
    //   85: aload_0
    //   86: invokevirtual 55	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   89: ldc 81
    //   91: invokevirtual 85	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   94: putfield 87	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   97: aconst_null
    //   98: astore 4
    //   100: aload_1
    //   101: aload_2
    //   102: getstatic 93	com/tencent/mobileqq/R$styleable:FormItem	[I
    //   105: invokevirtual 99	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   108: astore_1
    //   109: aload_1
    //   110: astore 4
    //   112: aload_0
    //   113: aload_1
    //   114: iconst_3
    //   115: aload_0
    //   116: invokevirtual 55	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   119: ldc 100
    //   121: invokevirtual 62	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   124: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   127: putfield 107	com/tencent/mobileqq/widget/FormSimpleItem:p	I
    //   130: aload_1
    //   131: astore 4
    //   133: aload_0
    //   134: aload_1
    //   135: iconst_2
    //   136: iload_3
    //   137: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   140: putfield 109	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   143: aload_1
    //   144: astore 4
    //   146: aload_0
    //   147: aload_1
    //   148: bipush 10
    //   150: invokevirtual 113	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   153: putfield 115	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   156: aload_1
    //   157: astore 4
    //   159: aload_0
    //   160: aload_1
    //   161: bipush 11
    //   163: iconst_0
    //   164: invokevirtual 118	android/content/res/TypedArray:getInt	(II)I
    //   167: putfield 120	com/tencent/mobileqq/widget/FormSimpleItem:h	I
    //   170: aload_1
    //   171: astore 4
    //   173: aload_0
    //   174: aload_1
    //   175: bipush 7
    //   177: invokevirtual 121	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   180: putfield 123	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   183: aload_1
    //   184: astore 4
    //   186: aload_0
    //   187: aload_1
    //   188: bipush 9
    //   190: iconst_0
    //   191: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   194: putfield 125	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_Int	I
    //   197: aload_1
    //   198: astore 4
    //   200: aload_0
    //   201: aload_1
    //   202: bipush 8
    //   204: iconst_0
    //   205: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   208: putfield 127	com/tencent/mobileqq/widget/FormSimpleItem:g	I
    //   211: aload_1
    //   212: astore 4
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 109	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   219: aload_0
    //   220: getfield 127	com/tencent/mobileqq/widget/FormSimpleItem:g	I
    //   223: invokestatic 132	java/lang/Math:min	(II)I
    //   226: putfield 127	com/tencent/mobileqq/widget/FormSimpleItem:g	I
    //   229: aload_1
    //   230: astore 4
    //   232: aload_0
    //   233: aload_1
    //   234: bipush 17
    //   236: invokevirtual 113	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   239: putfield 134	com/tencent/mobileqq/widget/FormSimpleItem:jdField_d_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   242: aload_1
    //   243: astore 4
    //   245: aload_0
    //   246: aload_1
    //   247: bipush 18
    //   249: iconst_3
    //   250: invokevirtual 118	android/content/res/TypedArray:getInt	(II)I
    //   253: putfield 136	com/tencent/mobileqq/widget/FormSimpleItem:m	I
    //   256: aload_1
    //   257: astore 4
    //   259: aload_0
    //   260: aload_1
    //   261: bipush 14
    //   263: invokevirtual 121	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   266: putfield 138	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   269: aload_1
    //   270: astore 4
    //   272: aload_0
    //   273: aload_1
    //   274: bipush 16
    //   276: iconst_0
    //   277: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   280: putfield 140	com/tencent/mobileqq/widget/FormSimpleItem:k	I
    //   283: aload_1
    //   284: astore 4
    //   286: aload_0
    //   287: aload_1
    //   288: bipush 15
    //   290: iconst_0
    //   291: invokevirtual 105	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   294: putfield 142	com/tencent/mobileqq/widget/FormSimpleItem:l	I
    //   297: aload_1
    //   298: astore 4
    //   300: aload_0
    //   301: aload_0
    //   302: getfield 109	com/tencent/mobileqq/widget/FormSimpleItem:j	I
    //   305: aload_0
    //   306: getfield 142	com/tencent/mobileqq/widget/FormSimpleItem:l	I
    //   309: invokestatic 132	java/lang/Math:min	(II)I
    //   312: putfield 142	com/tencent/mobileqq/widget/FormSimpleItem:l	I
    //   315: aload_1
    //   316: astore 4
    //   318: aload_0
    //   319: aload_1
    //   320: bipush 20
    //   322: iconst_0
    //   323: invokevirtual 146	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   326: putfield 148	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_Boolean	Z
    //   329: aload_1
    //   330: astore 4
    //   332: aload_0
    //   333: aload_1
    //   334: iconst_1
    //   335: iconst_0
    //   336: invokevirtual 118	android/content/res/TypedArray:getInt	(II)I
    //   339: putfield 150	com/tencent/mobileqq/widget/FormSimpleItem:i	I
    //   342: aload_1
    //   343: astore 4
    //   345: aload_1
    //   346: bipush 12
    //   348: iconst_1
    //   349: invokevirtual 146	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   352: putstatic 152	com/tencent/mobileqq/widget/FormSimpleItem:jdField_b_of_type_Boolean	Z
    //   355: aload_1
    //   356: astore 4
    //   358: aload_0
    //   359: aload_1
    //   360: bipush 13
    //   362: iconst_1
    //   363: invokevirtual 146	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   366: putfield 154	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_Boolean	Z
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 157	android/content/res/TypedArray:recycle	()V
    //   377: aload_0
    //   378: getfield 51	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   381: iconst_1
    //   382: invokevirtual 161	android/graphics/Paint:setAntiAlias	(Z)V
    //   385: aload_0
    //   386: getfield 51	com/tencent/mobileqq/widget/FormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   389: getstatic 163	com/tencent/mobileqq/widget/FormSimpleItem:jdField_c_of_type_Int	I
    //   392: invokevirtual 167	android/graphics/Paint:setColor	(I)V
    //   395: aload_0
    //   396: invokevirtual 169	com/tencent/mobileqq/widget/FormSimpleItem:c	()V
    //   399: return
    //   400: astore_1
    //   401: aload 4
    //   403: ifnull -26 -> 377
    //   406: aload 4
    //   408: invokevirtual 157	android/content/res/TypedArray:recycle	()V
    //   411: goto -34 -> 377
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 4
    //   418: aload_1
    //   419: astore_2
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 157	android/content/res/TypedArray:recycle	()V
    //   430: aload_2
    //   431: athrow
    //   432: astore_2
    //   433: aload_1
    //   434: astore 4
    //   436: goto -16 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	FormSimpleItem
    //   0	439	1	paramContext	Context
    //   0	439	2	paramAttributeSet	android.util.AttributeSet
    //   37	100	3	i1	int
    //   98	337	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   100	109	400	java/lang/Throwable
    //   112	130	400	java/lang/Throwable
    //   133	143	400	java/lang/Throwable
    //   146	156	400	java/lang/Throwable
    //   159	170	400	java/lang/Throwable
    //   173	183	400	java/lang/Throwable
    //   186	197	400	java/lang/Throwable
    //   200	211	400	java/lang/Throwable
    //   214	229	400	java/lang/Throwable
    //   232	242	400	java/lang/Throwable
    //   245	256	400	java/lang/Throwable
    //   259	269	400	java/lang/Throwable
    //   272	283	400	java/lang/Throwable
    //   286	297	400	java/lang/Throwable
    //   300	315	400	java/lang/Throwable
    //   318	329	400	java/lang/Throwable
    //   332	342	400	java/lang/Throwable
    //   345	355	400	java/lang/Throwable
    //   358	369	400	java/lang/Throwable
    //   100	109	414	finally
    //   112	130	432	finally
    //   133	143	432	finally
    //   146	156	432	finally
    //   159	170	432	finally
    //   173	183	432	finally
    //   186	197	432	finally
    //   200	211	432	finally
    //   214	229	432	finally
    //   232	242	432	finally
    //   245	256	432	finally
    //   259	269	432	finally
    //   272	283	432	finally
    //   286	297	432	finally
    //   300	315	432	finally
    //   318	329	432	finally
    //   332	342	432	finally
    //   345	355	432	finally
    //   358	369	432	finally
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130839169);
      }
      return paramResources.getDrawable(2130849239);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839169);
    case 0: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130839169);
      }
      return paramResources.getDrawable(2130849239);
    case 1: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130839179);
      }
      return paramResources.getDrawable(2130849253);
    case 2: 
      if (jdField_b_of_type_Boolean) {
        return paramResources.getDrawable(2130839179);
      }
      return paramResources.getDrawable(2130849253);
    }
    if (jdField_b_of_type_Boolean) {
      return paramResources.getDrawable(2130839176);
    }
    return paramResources.getDrawable(2130849244);
  }
  
  private boolean a()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public static ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131166854);
    case 0: 
      return paramResources.getColorStateList(2131166854);
    case 2: 
      return paramResources.getColorStateList(2131166928);
    case 1: 
      return paramResources.getColorStateList(2131166862);
    }
    return paramResources.getColorStateList(2131166941);
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return b(paramResources, paramInt);
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, a());
  }
  
  public TextView a()
  {
    return this.jdField_d_of_type_AndroidWidgetTextView;
  }
  
  public MultiImageTextView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView == null) {}
    label81:
    label354:
    do
    {
      int i1;
      int i2;
      int i3;
      int i4;
      do
      {
        return;
        b();
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(this.o);
        }
        if (a()) {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
            i2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
            i3 = e;
            int i5 = f;
            i4 = i1;
            i1 = i3;
            i3 = i2;
            i2 = i1;
            i1 = i5;
            if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) {
              break;
            }
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(this.jdField_d_of_type_JavaLangCharSequence);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setContentDescription(this.jdField_d_of_type_JavaLangCharSequence);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setMaxWidth(this.n);
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_a_of_type_Boolean)) {
              break label354;
            }
            if ((this.k <= 0) || (this.l <= 0)) {
              break label284;
            }
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          i2 = 0;
          i1 = 0;
          break;
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
            i1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
            i3 = 0;
            i4 = 0;
            break label81;
          }
          i1 = 0;
          i2 = 0;
          i3 = 0;
          i4 = 0;
          break label81;
          if (a())
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i4, i3);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.k > 0) && (this.l > 0))
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
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
          if (a())
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          if (a())
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i4, i3);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
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
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    label284:
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  protected void b()
  {
    int i3 = 0;
    int i2 = getResources().getDisplayMetrics().widthPixels - this.p * 2;
    int i1;
    if (this.jdField_d_of_type_JavaLangCharSequence == null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
        i1 = this.q + this.p + this.r;
      }
      for (;;)
      {
        this.o = (i2 - i1);
        this.n = 0;
        return;
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean)) {
          i1 = this.q;
        } else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean)) {
          i1 = this.r;
        } else {
          i1 = 0;
        }
      }
    }
    int i5 = i2 - this.p;
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.jdField_a_of_type_Int == 0)
      {
        i1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i1 += this.p;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView.getPaint();
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {}
      for (i2 = i1 + (int)((Paint)localObject).measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());; i2 = 0)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          if (this.k == 0) {
            i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          }
        }
        label211:
        for (i1 = i1 + 0 + this.p;; i1 = 0)
        {
          if (this.jdField_a_of_type_Boolean) {
            i1 = i1 + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + this.p;
          }
          for (;;)
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaint();
            localObject = new StaticLayout(this.jdField_d_of_type_JavaLangCharSequence, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            int i6 = ((StaticLayout)localObject).getLineCount();
            int i4 = 0;
            for (;;)
            {
              if (i3 < i6)
              {
                i4 = (int)((StaticLayout)localObject).getLineWidth(i3) + (int)((StaticLayout)localObject).getLineWidth(i3);
                i3 += 1;
                continue;
                i1 = this.jdField_a_of_type_Int;
                break;
                i1 = this.k;
                break label211;
              }
            }
            i3 = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaddingLeft() + (i1 + i4);
            i1 = i5 / 2;
            if ((i2 >= i1) && (i3 >= i1)) {
              i2 = i1;
            }
            for (;;)
            {
              this.o = i2;
              this.n = i1;
              return;
              if ((i2 > i1) && (i3 < i1))
              {
                i2 = i5 - i3;
                i1 = i3;
              }
              else if ((i2 < i1) && (i3 > i1))
              {
                i1 = i5 - i2;
              }
              else
              {
                i1 = i3;
              }
            }
          }
        }
      }
      i1 = 0;
    }
  }
  
  protected void c()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setId(2131366625);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_d_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296637);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Int, this.g);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.p;
    if (!this.jdField_c_of_type_Boolean)
    {
      localLayoutParams.topMargin = this.p;
      localLayoutParams.bottomMargin = this.p;
      setMinimumHeight(this.j);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(this.o);
    addView(this.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = new MultiImageTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setId(2131366627);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
    i1 = getContext().getResources().getDimensionPixelSize(2131296646);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextSize(0, i1);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setGravity(19);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView, localLayoutParams);
    a();
    setBackgroundDrawable(a(getResources(), this.i));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.i == 1) || (this.i == 2))
    {
      if (!a()) {
        break label73;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
    }
    for (;;)
    {
      int i1 = getMeasuredWidth();
      int i2 = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(jdField_d_of_type_Int, i2 - jdField_b_of_type_Int, i1, i2);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label73:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
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
    this.i = paramInt;
    setBackgroundDrawable(a(getResources(), this.i));
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
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.j)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.j);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_d_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.jdField_a_of_type_Int = paramInt1;
        this.g = Math.min(this.j, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.g);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_d_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.h = paramInt;
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_d_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
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
    this.k = paramInt1;
    this.l = Math.min(this.j, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_d_of_type_JavaLangCharSequence = paramCharSequence;
    a();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView != null)
    {
      this.m = paramInt;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.m));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */