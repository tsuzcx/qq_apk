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
    //   31: iconst_5
    //   32: invokevirtual 49	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   35: putfield 51	com/tencent/mobileqq/widget/FormMutiItem:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   38: aload_1
    //   39: astore_3
    //   40: aload_0
    //   41: aload_1
    //   42: bipush 18
    //   44: invokevirtual 49	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   47: putfield 53	com/tencent/mobileqq/widget/FormMutiItem:jdField_b_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   58: aload_0
    //   59: invokespecial 25	com/tencent/mobileqq/widget/FormMutiItem:d	()V
    //   62: return
    //   63: astore_1
    //   64: aload_3
    //   65: ifnull -7 -> 58
    //   68: aload_3
    //   69: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   72: goto -14 -> 58
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 56	android/content/res/TypedArray:recycle	()V
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	FormMutiItem
    //   0	96	1	paramContext	Context
    //   0	96	2	paramAttributeSet	android.util.AttributeSet
    //   17	76	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   18	27	63	java/lang/Throwable
    //   29	38	63	java/lang/Throwable
    //   40	50	63	java/lang/Throwable
    //   18	27	75	finally
    //   29	38	90	finally
    //   40	50	90	finally
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(FormResHelper.a(getResources(), this.jdField_a_of_type_Int));
    int j = getResources().getDimensionPixelSize(2131296784);
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
      j = getResources().getDimensionPixelSize(2131296793);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(FormResHelper.a(getResources(), this.g));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, j);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131296767);
      if (!this.c) {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131296773);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131367391);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131367393);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setCustomHeight(getResources().getDimensionPixelSize(2131298368));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131296778);
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
    for (int j = getResources().getDimensionPixelSize(2131298368);; j = getResources().getDimensionPixelSize(2131298278))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */