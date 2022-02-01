package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemConstants;

public class SimpleFormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  protected static boolean a;
  protected int a;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  protected Drawable a;
  protected TextView a;
  protected CharSequence a;
  protected TextView b;
  private CharSequence b;
  private int g;
  private int h;
  private int i;
  
  public SimpleFormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public SimpleFormSimpleItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 27	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: new 29	android/graphics/Rect
    //   10: dup
    //   11: invokespecial 32	android/graphics/Rect:<init>	()V
    //   14: putfield 34	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   17: aload_0
    //   18: new 36	android/graphics/Paint
    //   21: dup
    //   22: invokespecial 37	android/graphics/Paint:<init>	()V
    //   25: putfield 39	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   28: aload_0
    //   29: invokevirtual 43	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   32: ldc 44
    //   34: invokevirtual 50	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: invokevirtual 43	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   43: ldc 51
    //   45: invokevirtual 55	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   48: putfield 57	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_1
    //   54: aload_2
    //   55: getstatic 63	com/tencent/mobileqq/R$styleable:FormItem	[I
    //   58: invokevirtual 69	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   61: astore_1
    //   62: aload_1
    //   63: astore_3
    //   64: aload_0
    //   65: aload_1
    //   66: iconst_2
    //   67: aload_0
    //   68: invokevirtual 43	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   71: ldc 70
    //   73: invokevirtual 50	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   76: invokevirtual 75	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   79: putfield 77	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:i	I
    //   82: aload_1
    //   83: astore_3
    //   84: aload_0
    //   85: aload_1
    //   86: bipush 9
    //   88: invokevirtual 81	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   91: putfield 83	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   94: aload_1
    //   95: astore_3
    //   96: aload_0
    //   97: aload_1
    //   98: bipush 10
    //   100: iconst_0
    //   101: invokevirtual 86	android/content/res/TypedArray:getInt	(II)I
    //   104: putfield 88	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:g	I
    //   107: aload_1
    //   108: astore_3
    //   109: aload_0
    //   110: aload_1
    //   111: bipush 16
    //   113: invokevirtual 81	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   116: putfield 90	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   119: aload_1
    //   120: astore_3
    //   121: aload_0
    //   122: aload_1
    //   123: bipush 17
    //   125: iconst_3
    //   126: invokevirtual 86	android/content/res/TypedArray:getInt	(II)I
    //   129: putfield 92	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_Int	I
    //   132: aload_1
    //   133: astore_3
    //   134: aload_0
    //   135: aload_1
    //   136: iconst_0
    //   137: iconst_0
    //   138: invokevirtual 86	android/content/res/TypedArray:getInt	(II)I
    //   141: putfield 94	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:h	I
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: bipush 11
    //   149: iconst_1
    //   150: invokevirtual 98	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   153: putstatic 100	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_Boolean	Z
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 103	android/content/res/TypedArray:recycle	()V
    //   164: aload_0
    //   165: getfield 39	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   168: iconst_1
    //   169: invokevirtual 107	android/graphics/Paint:setAntiAlias	(Z)V
    //   172: aload_0
    //   173: getfield 39	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   176: getstatic 110	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:c	I
    //   179: invokevirtual 114	android/graphics/Paint:setColor	(I)V
    //   182: aload_0
    //   183: invokevirtual 116	com/tencent/mobileqq/settings/message/SimpleFormSimpleItem:a	()V
    //   186: return
    //   187: astore_1
    //   188: aload_3
    //   189: ifnull -25 -> 164
    //   192: aload_3
    //   193: invokevirtual 103	android/content/res/TypedArray:recycle	()V
    //   196: goto -32 -> 164
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_1
    //   203: astore_2
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 103	android/content/res/TypedArray:recycle	()V
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: astore_3
    //   217: goto -13 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	SimpleFormSimpleItem
    //   0	220	1	paramContext	Context
    //   0	220	2	paramAttributeSet	android.util.AttributeSet
    //   52	165	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   53	62	187	java/lang/Throwable
    //   64	82	187	java/lang/Throwable
    //   84	94	187	java/lang/Throwable
    //   96	107	187	java/lang/Throwable
    //   109	119	187	java/lang/Throwable
    //   121	132	187	java/lang/Throwable
    //   134	144	187	java/lang/Throwable
    //   146	156	187	java/lang/Throwable
    //   53	62	199	finally
    //   64	82	214	finally
    //   84	94	214	finally
    //   96	107	214	finally
    //   109	119	214	finally
    //   121	132	214	finally
    //   134	144	214	finally
    //   146	156	214	finally
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839575);
      }
      return paramResources.getDrawable(2130850777);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839575);
    case 0: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839575);
      }
      return paramResources.getDrawable(2130850777);
    case 1: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839585);
      }
      return paramResources.getDrawable(2130850791);
    case 2: 
      if (jdField_a_of_type_Boolean) {
        return paramResources.getDrawable(2130839585);
      }
      return paramResources.getDrawable(2130850791);
    }
    if (jdField_a_of_type_Boolean) {
      return paramResources.getDrawable(2130839582);
    }
    return paramResources.getDrawable(2130850782);
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
      return paramResources.getColorStateList(2131167033);
    case 0: 
      return paramResources.getColorStateList(2131167033);
    case 2: 
      return paramResources.getColorStateList(2131167113);
    case 1: 
      return paramResources.getColorStateList(2131167041);
    case 3: 
      return paramResources.getColorStateList(2131167127);
    }
    return paramResources.getColorStateList(2131167165);
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
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
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
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.g));
    int j = getContext().getResources().getDimensionPixelSize(2131296784);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.i;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367393);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_a_of_type_Int));
    j = getContext().getResources().getDimensionPixelSize(2131296793);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.i;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    b();
    setBackgroundDrawable(a(getResources(), this.h));
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int k;
    int j;
    if (a())
    {
      k = e;
      j = f;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
        break label160;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.jdField_a_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (!a()) {
        break label143;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k, j);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
      return;
      k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      break;
      label143:
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
    label160:
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (a())
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k, j);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.h == 1) || (this.h == 2))
    {
      if (!a()) {
        break label73;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(c);
    }
    for (;;)
    {
      int j = getMeasuredWidth();
      int k = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, k - jdField_b_of_type_Int, j, k);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label73:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    }
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.g));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.SimpleFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */