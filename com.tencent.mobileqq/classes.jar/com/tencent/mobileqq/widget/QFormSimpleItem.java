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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.QMultiImageTextView;

public class QFormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  protected static boolean b;
  protected int a;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  protected Drawable a;
  protected TextView a;
  protected QMultiImageTextView a;
  protected CharSequence a;
  protected boolean a;
  protected Drawable b;
  private CharSequence b;
  private Drawable c;
  protected boolean c;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  
  public QFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public QFormSimpleItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 38	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: new 40	android/graphics/Rect
    //   10: dup
    //   11: invokespecial 43	android/graphics/Rect:<init>	()V
    //   14: putfield 45	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   17: aload_0
    //   18: new 47	android/graphics/Paint
    //   21: dup
    //   22: invokespecial 48	android/graphics/Paint:<init>	()V
    //   25: putfield 50	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   28: aload_0
    //   29: invokevirtual 54	com/tencent/mobileqq/widget/QFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   32: ldc 55
    //   34: invokevirtual 61	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   37: istore_3
    //   38: aload_0
    //   39: aload_0
    //   40: invokevirtual 54	com/tencent/mobileqq/widget/QFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   43: invokevirtual 65	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   46: getfield 71	android/util/DisplayMetrics:density	F
    //   49: ldc 72
    //   51: fmul
    //   52: f2d
    //   53: ldc2_w 73
    //   56: dadd
    //   57: d2i
    //   58: putfield 76	com/tencent/mobileqq/widget/QFormSimpleItem:q	I
    //   61: aload_0
    //   62: aload_0
    //   63: invokevirtual 54	com/tencent/mobileqq/widget/QFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   66: invokevirtual 65	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   69: getfield 71	android/util/DisplayMetrics:density	F
    //   72: ldc 77
    //   74: fmul
    //   75: f2d
    //   76: ldc2_w 73
    //   79: dadd
    //   80: d2i
    //   81: putfield 79	com/tencent/mobileqq/widget/QFormSimpleItem:r	I
    //   84: aload_0
    //   85: aload_0
    //   86: invokevirtual 54	com/tencent/mobileqq/widget/QFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   89: ldc 80
    //   91: invokevirtual 84	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   94: putfield 86	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_b_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   97: aconst_null
    //   98: astore 4
    //   100: aload_1
    //   101: aload_2
    //   102: getstatic 92	com/tencent/mobileqq/qqui/R$styleable:G	[I
    //   105: invokevirtual 98	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   108: astore_1
    //   109: aload_1
    //   110: astore 4
    //   112: aload_0
    //   113: aload_1
    //   114: getstatic 101	com/tencent/mobileqq/qqui/R$styleable:e	I
    //   117: aload_0
    //   118: invokevirtual 54	com/tencent/mobileqq/widget/QFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   121: ldc 102
    //   123: invokevirtual 61	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   126: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   129: putfield 109	com/tencent/mobileqq/widget/QFormSimpleItem:p	I
    //   132: aload_1
    //   133: astore 4
    //   135: aload_0
    //   136: aload_1
    //   137: getstatic 112	com/tencent/mobileqq/qqui/R$styleable:d	I
    //   140: iload_3
    //   141: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   144: putfield 114	com/tencent/mobileqq/widget/QFormSimpleItem:o	I
    //   147: aload_1
    //   148: astore 4
    //   150: aload_0
    //   151: aload_1
    //   152: getstatic 116	com/tencent/mobileqq/qqui/R$styleable:k	I
    //   155: invokevirtual 120	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   158: putfield 122	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   161: aload_1
    //   162: astore 4
    //   164: aload_0
    //   165: aload_1
    //   166: getstatic 124	com/tencent/mobileqq/qqui/R$styleable:l	I
    //   169: iconst_0
    //   170: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   173: putfield 129	com/tencent/mobileqq/widget/QFormSimpleItem:m	I
    //   176: aload_1
    //   177: astore 4
    //   179: aload_0
    //   180: aload_1
    //   181: getstatic 131	com/tencent/mobileqq/qqui/R$styleable:h	I
    //   184: invokevirtual 132	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   187: putfield 134	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_c_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   190: aload_1
    //   191: astore 4
    //   193: aload_0
    //   194: aload_1
    //   195: getstatic 136	com/tencent/mobileqq/qqui/R$styleable:j	I
    //   198: iconst_0
    //   199: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   202: putfield 137	com/tencent/mobileqq/widget/QFormSimpleItem:k	I
    //   205: aload_1
    //   206: astore 4
    //   208: aload_0
    //   209: aload_1
    //   210: getstatic 139	com/tencent/mobileqq/qqui/R$styleable:i	I
    //   213: iconst_0
    //   214: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   217: putfield 140	com/tencent/mobileqq/widget/QFormSimpleItem:l	I
    //   220: aload_1
    //   221: astore 4
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 114	com/tencent/mobileqq/widget/QFormSimpleItem:o	I
    //   228: aload_0
    //   229: getfield 140	com/tencent/mobileqq/widget/QFormSimpleItem:l	I
    //   232: invokestatic 145	java/lang/Math:min	(II)I
    //   235: putfield 140	com/tencent/mobileqq/widget/QFormSimpleItem:l	I
    //   238: aload_1
    //   239: astore 4
    //   241: aload_0
    //   242: aload_1
    //   243: getstatic 146	com/tencent/mobileqq/qqui/R$styleable:r	I
    //   246: invokevirtual 120	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   249: putfield 148	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   252: aload_1
    //   253: astore 4
    //   255: aload_0
    //   256: aload_1
    //   257: getstatic 151	com/tencent/mobileqq/qqui/R$styleable:s	I
    //   260: iconst_3
    //   261: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   264: putfield 152	com/tencent/mobileqq/widget/QFormSimpleItem:h	I
    //   267: aload_1
    //   268: astore 4
    //   270: aload_0
    //   271: aload_1
    //   272: getstatic 153	com/tencent/mobileqq/qqui/R$styleable:o	I
    //   275: invokevirtual 132	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   278: putfield 155	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   281: aload_1
    //   282: astore 4
    //   284: aload_0
    //   285: aload_1
    //   286: getstatic 156	com/tencent/mobileqq/qqui/R$styleable:q	I
    //   289: iconst_0
    //   290: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   293: putfield 158	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_Int	I
    //   296: aload_1
    //   297: astore 4
    //   299: aload_0
    //   300: aload_1
    //   301: getstatic 159	com/tencent/mobileqq/qqui/R$styleable:p	I
    //   304: iconst_0
    //   305: invokevirtual 107	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   308: putfield 161	com/tencent/mobileqq/widget/QFormSimpleItem:g	I
    //   311: aload_1
    //   312: astore 4
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 114	com/tencent/mobileqq/widget/QFormSimpleItem:o	I
    //   319: aload_0
    //   320: getfield 161	com/tencent/mobileqq/widget/QFormSimpleItem:g	I
    //   323: invokestatic 145	java/lang/Math:min	(II)I
    //   326: putfield 161	com/tencent/mobileqq/widget/QFormSimpleItem:g	I
    //   329: aload_1
    //   330: astore 4
    //   332: aload_0
    //   333: aload_1
    //   334: getstatic 164	com/tencent/mobileqq/qqui/R$styleable:t	I
    //   337: iconst_0
    //   338: invokevirtual 168	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   341: putfield 170	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_Boolean	Z
    //   344: aload_1
    //   345: astore 4
    //   347: aload_0
    //   348: aload_1
    //   349: getstatic 172	com/tencent/mobileqq/qqui/R$styleable:jdField_c_of_type_Int	I
    //   352: iconst_0
    //   353: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   356: putfield 174	com/tencent/mobileqq/widget/QFormSimpleItem:n	I
    //   359: aload_1
    //   360: astore 4
    //   362: aload_1
    //   363: getstatic 175	com/tencent/mobileqq/qqui/R$styleable:m	I
    //   366: iconst_1
    //   367: invokevirtual 168	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   370: putstatic 177	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_b_of_type_Boolean	Z
    //   373: aload_1
    //   374: astore 4
    //   376: aload_0
    //   377: aload_1
    //   378: getstatic 178	com/tencent/mobileqq/qqui/R$styleable:n	I
    //   381: iconst_1
    //   382: invokevirtual 168	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   385: putfield 180	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_c_of_type_Boolean	Z
    //   388: aload_1
    //   389: astore 4
    //   391: getstatic 177	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_b_of_type_Boolean	Z
    //   394: invokestatic 185	com/tencent/mobileqq/widget/FormResHelper:a	(Z)V
    //   397: aload_1
    //   398: ifnull +7 -> 405
    //   401: aload_1
    //   402: invokevirtual 188	android/content/res/TypedArray:recycle	()V
    //   405: aload_0
    //   406: getfield 50	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   409: iconst_1
    //   410: invokevirtual 191	android/graphics/Paint:setAntiAlias	(Z)V
    //   413: aload_0
    //   414: getfield 50	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   417: getstatic 192	com/tencent/mobileqq/widget/QFormSimpleItem:jdField_c_of_type_Int	I
    //   420: invokevirtual 196	android/graphics/Paint:setColor	(I)V
    //   423: aload_0
    //   424: invokevirtual 198	com/tencent/mobileqq/widget/QFormSimpleItem:b	()V
    //   427: return
    //   428: astore_1
    //   429: aload 4
    //   431: ifnull -26 -> 405
    //   434: aload 4
    //   436: invokevirtual 188	android/content/res/TypedArray:recycle	()V
    //   439: goto -34 -> 405
    //   442: astore_1
    //   443: aconst_null
    //   444: astore 4
    //   446: aload_1
    //   447: astore_2
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 188	android/content/res/TypedArray:recycle	()V
    //   458: aload_2
    //   459: athrow
    //   460: astore_2
    //   461: aload_1
    //   462: astore 4
    //   464: goto -16 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	QFormSimpleItem
    //   0	467	1	paramContext	Context
    //   0	467	2	paramAttributeSet	android.util.AttributeSet
    //   37	104	3	i1	int
    //   98	365	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   100	109	428	java/lang/Throwable
    //   112	132	428	java/lang/Throwable
    //   135	147	428	java/lang/Throwable
    //   150	161	428	java/lang/Throwable
    //   164	176	428	java/lang/Throwable
    //   179	190	428	java/lang/Throwable
    //   193	205	428	java/lang/Throwable
    //   208	220	428	java/lang/Throwable
    //   223	238	428	java/lang/Throwable
    //   241	252	428	java/lang/Throwable
    //   255	267	428	java/lang/Throwable
    //   270	281	428	java/lang/Throwable
    //   284	296	428	java/lang/Throwable
    //   299	311	428	java/lang/Throwable
    //   314	329	428	java/lang/Throwable
    //   332	344	428	java/lang/Throwable
    //   347	359	428	java/lang/Throwable
    //   362	373	428	java/lang/Throwable
    //   376	388	428	java/lang/Throwable
    //   391	397	428	java/lang/Throwable
    //   100	109	442	finally
    //   112	132	460	finally
    //   135	147	460	finally
    //   150	161	460	finally
    //   164	176	460	finally
    //   179	190	460	finally
    //   193	205	460	finally
    //   208	220	460	finally
    //   223	238	460	finally
    //   241	252	460	finally
    //   255	267	460	finally
    //   270	281	460	finally
    //   284	296	460	finally
    //   299	311	460	finally
    //   314	329	460	finally
    //   332	344	460	finally
    //   347	359	460	finally
    //   362	373	460	finally
    //   376	388	460	finally
    //   391	397	460	finally
  }
  
  private boolean a()
  {
    return QQTheme.b();
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    FormResHelper.a(paramBoolean);
  }
  
  protected ColorStateList a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt);
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, a());
  }
  
  protected void a()
  {
    int i3 = 0;
    int i2 = getResources().getDisplayMetrics().widthPixels - this.p * 2;
    int i1;
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
        i1 = this.q + this.p + this.r;
      }
      for (;;)
      {
        this.j = (i2 - i1);
        this.i = 0;
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
      if (this.k == 0)
      {
        i1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i1 += this.p;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      if (this.jdField_b_of_type_JavaLangCharSequence != null) {}
      for (i2 = i1 + (int)((Paint)localObject).measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());; i2 = 0)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          if (this.jdField_a_of_type_Int == 0) {
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
            localObject = this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.getPaint();
            localObject = new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            int i6 = ((StaticLayout)localObject).getLineCount();
            int i4 = 0;
            for (;;)
            {
              if (i3 < i6)
              {
                i4 = (int)((StaticLayout)localObject).getLineWidth(i3) + (int)((StaticLayout)localObject).getLineWidth(i3);
                i3 += 1;
                continue;
                i1 = this.k;
                break;
                i1 = this.jdField_a_of_type_Int;
                break label211;
              }
            }
            i3 = this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.getPaddingLeft() + (i1 + i4);
            i1 = i5 / 2;
            if ((i2 >= i1) && (i3 >= i1)) {
              i2 = i1;
            }
            for (;;)
            {
              this.j = i2;
              this.i = i1;
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
  
  protected void b()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367391);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296784);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.k, this.l);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.p;
    if (!this.jdField_c_of_type_Boolean)
    {
      localLayoutParams.topMargin = this.p;
      localLayoutParams.bottomMargin = this.p;
      setMinimumHeight(this.o);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.j);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView = new QMultiImageTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setId(2131367393);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
    i1 = getContext().getResources().getDimensionPixelSize(2131296793);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextSize(0, i1);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setGravity(19);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView, localLayoutParams);
    c();
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView == null) {}
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
        a();
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.j);
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
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
              break;
            }
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setMaxWidth(this.i);
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_a_of_type_Boolean)) {
              break label354;
            }
            if ((this.jdField_a_of_type_Int <= 0) || (this.g <= 0)) {
              break label284;
            }
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.g);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
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
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.jdField_a_of_type_Int > 0) && (this.g > 0))
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.g);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          if (a())
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        if ((this.jdField_a_of_type_Int > 0) && (this.g > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.g);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          if (a())
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i4, i3);
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        if ((this.jdField_a_of_type_Int > 0) && (this.g > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.g);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
        if (a())
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i2, i1);
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawables(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    label284:
    this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(8);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.n == 1) || (this.n == 2))
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
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, i2 - jdField_b_of_type_Int, i1, i2);
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
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.o);
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
    this.n = paramInt;
    setBackgroundDrawable(a(getResources(), this.n));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_c_of_type_Boolean))
    {
      this.o = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.o)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.o);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.k = paramInt1;
        this.l = Math.min(this.o, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.l);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_b_of_type_JavaLangCharSequence != null)
    {
      this.m = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
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
    this.jdField_a_of_type_Int = paramInt1;
    this.g = Math.min(this.o, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    c();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    c();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView != null)
    {
      this.h = paramInt;
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetQMultiImageTextView.setTextColor(a(getResources(), this.h));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */