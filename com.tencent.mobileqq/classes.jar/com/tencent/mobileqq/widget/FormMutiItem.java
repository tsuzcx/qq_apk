package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class FormMutiItem
  extends FormSimpleItem
{
  protected int a;
  protected LinearLayout a;
  protected TextView a;
  protected CharSequence a;
  protected TextView b;
  protected CharSequence b;
  protected int g = 2;
  protected int h;
  protected int i;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    d();
  }
  
  /* Error */
  public FormMutiItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 31	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 19	com/tencent/mobileqq/widget/FormMutiItem:jdField_a_of_type_Int	I
    //   11: aload_0
    //   12: iconst_2
    //   13: putfield 21	com/tencent/mobileqq/widget/FormMutiItem:g	I
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 37	com/tencent/mobileqq/R$styleable:FormItem	[I
    //   23: invokevirtual 43	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_3
    //   29: aload_0
    //   30: aload_1
    //   31: bipush 6
    //   33: invokevirtual 49	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   36: putfield 51	com/tencent/mobileqq/widget/FormMutiItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   39: aload_1
    //   40: astore_3
    //   41: aload_0
    //   42: aload_1
    //   43: bipush 19
    //   45: invokevirtual 49	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   48: putfield 53	com/tencent/mobileqq/widget/FormMutiItem:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   59: aload_0
    //   60: invokespecial 25	com/tencent/mobileqq/widget/FormMutiItem:d	()V
    //   63: return
    //   64: astore_1
    //   65: aload_3
    //   66: ifnull -7 -> 59
    //   69: aload_3
    //   70: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   73: goto -14 -> 59
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: astore_3
    //   94: goto -13 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	FormMutiItem
    //   0	97	1	paramContext	Context
    //   0	97	2	paramAttributeSet	android.util.AttributeSet
    //   17	77	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   18	27	64	java/lang/Throwable
    //   29	39	64	java/lang/Throwable
    //   41	51	64	java/lang/Throwable
    //   18	27	76	finally
    //   29	39	91	finally
    //   41	51	91	finally
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(getResources(), this.jdField_a_of_type_Int));
    int j = getResources().getDimensionPixelSize(2131296637);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (this.c)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      j = getResources().getDimensionPixelSize(2131296646);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(b(getResources(), this.g));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, j);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131296621);
      if (!this.c) {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131296627);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131366625);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131366627);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setCustomHeight(getResources().getDimensionPixelSize(2131298096));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131296631);
    }
  }
  
  public void setFirstLineRightDrawalbe(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void setFirstLineText(int paramInt)
  {
    this.jdField_a_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.h);
  }
  
  public void setSecondLineText(int paramInt)
  {
    this.jdField_b_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineTextColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.g);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.i);
  }
  
  public void setSecondLineTextViewPaddingRight(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.jdField_b_of_type_AndroidWidgetTextView.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), paramInt, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      boolean bool1 = true;
      if ((bool1 ^ paramBoolean))
      {
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label63;
        }
        bool1 = bool2;
        label32:
        localTextView.setVisibility(bool1);
        if (!paramBoolean) {
          break label69;
        }
      }
    }
    label63:
    label69:
    for (int j = getResources().getDimensionPixelSize(2131298096);; j = getResources().getDimensionPixelSize(2131298013))
    {
      setCustomHeight(j);
      return;
      j = 0;
      break;
      j = 8;
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */