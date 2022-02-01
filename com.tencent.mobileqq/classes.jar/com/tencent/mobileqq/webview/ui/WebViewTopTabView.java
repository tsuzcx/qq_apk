package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mobileqq.util.DisplayUtil;

public class WebViewTopTabView
  extends RadioGroup
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  public int[] a;
  RadioButton b;
  
  public WebViewTopTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfInt = null;
    super.setOrientation(0);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  RadioButton a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater;
    if (localObject != null)
    {
      localObject = (RadioButton)((LayoutInflater)localObject).inflate(2131563053, this, false);
    }
    else
    {
      localObject = new WebViewTopTabRadioButton(super.getContext(), null);
      ((RadioButton)localObject).setButtonDrawable(super.getContext().getResources().getDrawable(17170445));
      ((RadioButton)localObject).setTextSize(14.0F);
      ((RadioButton)localObject).setGravity(17);
    }
    ((RadioButton)localObject).setId(paramInt);
    return localObject;
  }
  
  public int[] a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:244)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setButtonBackgroundResource(int paramInt1, int paramInt2, int paramInt3)
  {
    RadioButton localRadioButton = this.jdField_a_of_type_AndroidWidgetRadioButton;
    if (localRadioButton != null) {
      localRadioButton.setBackgroundResource(paramInt1);
    }
    paramInt1 = 1;
    while (paramInt1 < super.getChildCount() - 1)
    {
      super.getChildAt(paramInt1).setBackgroundResource(paramInt2);
      paramInt1 += 1;
    }
    localRadioButton = this.b;
    if (localRadioButton != null) {
      localRadioButton.setBackgroundResource(paramInt3);
    }
  }
  
  public void setButtonNum(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 2) {
      i = 2;
    }
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < i) {}
    }
    else
    {
      paramInt1 = 0;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[i];
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt2] = paramInt2;
      paramInt2 += 1;
    }
    super.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRadioButton = a(this.jdField_a_of_type_ArrayOfInt[0]);
    if (this.jdField_a_of_type_AndroidWidgetRadioButton.getLayoutParams() == null)
    {
      localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.a(super.getContext(), 30.0F));
      super.addView(this.jdField_a_of_type_AndroidWidgetRadioButton, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      super.addView(this.jdField_a_of_type_AndroidWidgetRadioButton);
    }
    paramInt2 = 1;
    int j;
    for (;;)
    {
      j = i - 1;
      if (paramInt2 >= j) {
        break;
      }
      localObject = a(this.jdField_a_of_type_ArrayOfInt[paramInt2]);
      if (((RadioButton)localObject).getLayoutParams() == null) {
        super.addView((View)localObject, new LinearLayout.LayoutParams(-2, DisplayUtil.a(super.getContext(), 30.0F)));
      } else {
        super.addView((View)localObject);
      }
      paramInt2 += 1;
    }
    this.b = a(this.jdField_a_of_type_ArrayOfInt[j]);
    Object localObject = this.b;
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.a(super.getContext(), 30.0F));
      super.addView(this.b, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      super.addView((View)localObject);
    }
    super.setGravity(16);
    ((RadioButton)super.getChildAt(paramInt1)).setChecked(true);
  }
  
  public void setButtonText(String... paramVarArgs)
  {
    if ((super.getChildCount() > 0) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int i = 0;
      while (i < super.getChildCount())
      {
        RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
        if (i >= paramVarArgs.length) {
          break;
        }
        localRadioButton.setText(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public void setButtonTextColorStateList(int paramInt)
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      ((RadioButton)super.getChildAt(i)).setTextColor(super.getContext().getResources().getColorStateList(paramInt));
      i += 1;
    }
  }
  
  public void setLeftAndRightPaddingByDp(int paramInt)
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      View localView = super.getChildAt(i);
      Context localContext = super.getContext();
      float f = paramInt;
      localView.setPadding(DisplayUtil.a(localContext, f), super.getPaddingTop(), DisplayUtil.a(super.getContext(), f), super.getPaddingBottom());
      i += 1;
    }
  }
  
  public void setRedHotStatus(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if ((k >= 0) && (k < super.getChildCount()))
        {
          WebViewTopTabRadioButton localWebViewTopTabRadioButton = (WebViewTopTabRadioButton)super.getChildAt(k);
          if (localWebViewTopTabRadioButton.a != paramBoolean)
          {
            localWebViewTopTabRadioButton.a = paramBoolean;
            localWebViewTopTabRadioButton.invalidate();
          }
        }
        i += 1;
      }
    }
  }
  
  public void setSelectedTab(int paramInt)
  {
    if (super.getChildCount() > 0)
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < super.getChildCount()) {}
      }
      else
      {
        i = 0;
      }
      ((RadioButton)super.getChildAt(i)).setChecked(true);
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (super.getChildCount() > 0)
    {
      int i = 0;
      while (i < super.getChildCount())
      {
        ((RadioButton)super.getChildAt(i)).setTextSize(paramFloat);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabView
 * JD-Core Version:    0.7.0.1
 */